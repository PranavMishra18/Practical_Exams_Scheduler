import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import { MatDatepicker } from '@angular/material/datepicker';
import { NgForm } from '@angular/forms';
import { MatCardLgImage } from '@angular/material/card';
import { firstValueFrom } from 'rxjs';
import { External } from '../external';
import { Examination } from '../examination';
import { DaySelected } from '../daySelected';

@Component({
  selector: 'app-set-examinations',
  templateUrl: './set-examinations.component.html',
  styleUrl: './set-examinations.component.css'
})
export class SetExaminationsComponent implements OnInit {

  

  workingDays : string[] = ['Monday','Tuesday','Wednesday','Thursday','Friday'];

  daysSelected : DaySelected[] = [];

  constructor(private service : PracticalService, private router : Router){

  }

  ngOnInit(): void {
    
  }

  

  async onSubmit(f: NgForm) {
    try {
        let value = new Date(f.value.date);
        let dayName = this.getDayName(value.getDay());
        let formattedDate = this.formatDate(value);
        let alternateDate = this.convertDateFormat(formattedDate);

        const selectedDay = new DaySelected(dayName,alternateDate);

        this.daysSelected.push(selectedDay);

    
        
                

        const timeTableValues = await firstValueFrom(this.service.getTimeTableByDay(dayName));
        console.log('INITIAL TIMETABLE VALUES BY DAY SELECTED');
        console.log(timeTableValues);

        for (const timeTable of timeTableValues) {
            const students = timeTable.students;
            const section = timeTable.section;
            const studentGroup = timeTable.studentGroup;
            const year = timeTable.year;
            const examDay = timeTable.day;
            const internalExaminer = timeTable.teacher;
            const subject = timeTable.subject;
            const timeSlot = timeTable.timeSlot;
            const venue = timeTable.venue;

            let shouldBreak = false;

            for (const day of this.workingDays) {
                if (day === examDay) {
                    continue;
                }

                const timeTableExcludingTeachers = await firstValueFrom(this.service.getTimeTableByDayExcludingTeacher(day, internalExaminer.id));
                console.log('TIMETABLE INCLUDING DIFFERENT DAY AND DIFFERENT TEACHER');
                console.log(timeTableExcludingTeachers);

                for (const record of timeTableExcludingTeachers) {
                    const count = await firstValueFrom(this.service.getCountOfExternal(record.teacher.id));
                    console.log('COUNT IN EXTERNAL TABLE');
                    console.log(count);

                    if (count < 2) {
                        const exists = await firstValueFrom(this.service.checkExternalExists(record.teacher.id, alternateDate, examDay, record.timeSlot.id));
                        console.log('EXISTENCE CHECK');
                        console.log(exists);

                        if (!exists) {
                            const theExternal = new External(record.teacher, alternateDate, examDay, record.timeSlot);

                            const theExam = new Examination(examDay, alternateDate, record.teacher.phoneNo,
                                record.teacher.email, section, studentGroup, students, year, subject,
                                internalExaminer, record.teacher, timeSlot, venue);

                            const externalResponse = await firstValueFrom(this.service.createExternal(theExternal));
                            console.log('External examiner record saved:', externalResponse);

                            const examinationResponse = await firstValueFrom(this.service.createExamination(theExam));
                            console.log('Examination record saved:', examinationResponse);

                            shouldBreak = true; // Set flag to break out of outer loop
                            break; // Break out of inner loop
                        }
                    }
                }

                if (shouldBreak) {
                    break; // Break out of outer loop if flag is set
                }
            }
        }
    } catch (error) {
        console.error('An error occurred:', error);
    }
}

getDayName(day: number): string {
  const daysOfWeek = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
  return daysOfWeek[day];
}

formatDate(date: Date): string {
  // Example format: YYYY-MM-DD
  const year = date.getFullYear();
  const month = ('0' + (date.getMonth() + 1)).slice(-2); // Adding 1 to month as it's zero-based
  const day = ('0' + date.getDate()).slice(-2);
  return `${year}-${month}-${day}`;
}

convertDateFormat(dateString: string): string {
  // Assuming dateString is in YYYY-MM-DD format
  const parts = dateString.split('-');
  return `${parts[2]}-${parts[1]}-${parts[0]}`; // Assuming the desired format is DD/MM/YYYY
}


}
