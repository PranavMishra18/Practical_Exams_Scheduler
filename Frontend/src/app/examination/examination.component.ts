import { Component, OnInit } from '@angular/core';
import { Examination } from '../examination';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import * as XLSX from 'xlsx';


@Component({
  selector: 'app-examination',
  templateUrl: './examination.component.html',
  styleUrl: './examination.component.css'
})
export class ExaminationComponent implements OnInit{


  theExaminations : Examination[];


  constructor(private service : PracticalService,private router : Router){


  }


  ngOnInit(): void {

    this.service.getExaminations().subscribe(data => {
      this.theExaminations = data;
    })

    this.refresh();

  }

  generateExcel(): void {
    const data: any[] = this.theExaminations.map((exam) => ({
      'Subject Code': exam.subject.subjectCode,
      'Subject (Lab)': exam.subject.subjectName,
      'Year': exam.year,
      'Section': exam.section,
      'Student Group': exam.studentGroup,
      'No of Students': exam.students,
      'Internal Examiner': exam.internalExaminer.name,
      'External Examiner': exam.externalExaminer.name,
      'M. No': exam.externalExaminer.phoneNo,
      'Email': exam.externalExaminer.email,
      'Time': exam.timeSlot.timeSlot,
      'Date': exam.date,
      'Venue': exam.venue.venue,
      'Day': exam.day,
      
    }));

    const worksheet: XLSX.WorkSheet = XLSX.utils.json_to_sheet(data);
    const workbook: XLSX.WorkBook = { Sheets: { 'data': worksheet }, SheetNames: ['data'] };
    XLSX.writeFile(workbook, 'examinations.xlsx');
  }

  refresh(){
    this.router.navigate(['/examinations']);
  }
}
