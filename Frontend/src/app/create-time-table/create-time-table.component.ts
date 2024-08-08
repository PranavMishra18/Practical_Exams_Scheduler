import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import { Subject } from '../subject';
import { NgForm } from '@angular/forms';
import { Teacher } from '../teacher';
import { TimeSlot } from '../timeSlot';
import { Venue } from '../venue';
import { TimeTable } from '../timeTable';
import { MatSelect } from '@angular/material/select';

@Component({
  selector: 'app-create-time-table',
  templateUrl: './create-time-table.component.html',
  styleUrl: './create-time-table.component.css'
})
export class CreateTimeTableComponent implements OnInit {


  @ViewChild('year',{static: true}) year : MatSelect;
  @ViewChild('studentGroup',{static:true}) studentGroup : MatSelect;
  @ViewChild('day',{static:true}) day : MatSelect;



  subjects : Subject[];
  venues : Venue[];
  teachers : Teacher[];
  timeSlots : TimeSlot[];

  selectedSubject : Subject;
  selectedTeacher : Teacher;
  selectedVenue : Venue;
  selectedTimeSlot : TimeSlot;




  constructor(private service : PracticalService, private router : Router){

  }

  ngOnInit(): void {
    this.service.getSubjects().subscribe(data =>{
      this.subjects = data;
    })    

    this.service.getVenues().subscribe(data => {
      this.venues = data;
    })

    this.service.getTimeSlots().subscribe(data => {
      this.timeSlots = data;
    })

    this.service.getTeachers().subscribe(data => {
      this.teachers = data;
    })

  }

  onSubmit(f: NgForm) {
    const year = this.year.value;
    
    const day = this.day.value;
    const section = f.value.section;
    const studentGroup = this.studentGroup.value;
    const students = f.value.students;
    const email = f.value.email;

    

    
    const timeTable = new TimeTable(section,studentGroup,students,year,day,this.selectedSubject,this.selectedTeacher,this.selectedTimeSlot
      ,this.selectedVenue);

    
    this.service.createTimeTable(timeTable).subscribe(data => {
      console.log(data); 
      this.goBack();
    });
  }

  goBack(){
    this.router.navigate(['/timetable']);
  }


  subjectChanged(subjectId : number){

    this.service.getSubject(subjectId).subscribe(data => {
      this.selectedSubject = data;
    })

    

  }

  teacherChanged(teacherId : number){
    this.service.getTeacher(teacherId).subscribe(data => {
      this.selectedTeacher = data;
    })
  }

  venueChanged(venueId : number){

      this.service.getVenue(venueId).subscribe(data => {
        this.selectedVenue = data;
      })

  }

  timeSlotChanged(timeSlotId : number){

    this.service.getTimeSlot(timeSlotId).subscribe(data => {
      this.selectedTimeSlot = data;
    })

  }


}
