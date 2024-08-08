import { Component, OnInit } from '@angular/core';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Teacher } from '../teacher';
import { Subject } from '../subject';
import { CloseScrollStrategy } from '@angular/cdk/overlay';

@Component({
  selector: 'app-create-teacher',
  templateUrl: './create-teacher.component.html',
  styleUrl: './create-teacher.component.css'
})
export class CreateTeacherComponent implements OnInit {


  subjects : Subject[];
  subjectsToAdd  : Subject[] = [];






  constructor(private service : PracticalService, private router : Router){

  }

  ngOnInit(): void {
    this.service.getSubjects().subscribe(data =>{
      this.subjects = data;
    })    
  }

  onSubmit(f: NgForm) {
    const name = f.value.name;
    const phoneNo = f.value.phoneNo;
    const email = f.value.email;

    const teacher = new Teacher(name, email, phoneNo);

    // Extract subject IDs from selected subjects
    const subjectIds = this.subjectsToAdd.map(subject => subject.id);

    // Call the service method to create teacher with subjects
    this.service.createTeacher(teacher, subjectIds).subscribe(data => {
      console.log(data); // Log the response from the backend
      this.goBack();
    });
  }

  goBack(){
    this.router.navigate(['/teachers']);
  }

  addSubject(subjectId : number){
      
    this.service.getSubject(subjectId).subscribe(data => {
      this.subjectsToAdd.push(data);
    })
    console.log(this.subjectsToAdd);    
  }

  removeSubject(subject: Subject): void {
    const index = this.subjectsToAdd.indexOf(subject);
    if (index !== -1) {
        this.subjectsToAdd.splice(index, 1);
    }
}






}
