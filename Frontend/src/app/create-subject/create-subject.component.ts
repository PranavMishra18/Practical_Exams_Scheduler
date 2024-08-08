import { Component, OnInit } from '@angular/core';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { Subject } from '../subject';

@Component({
  selector: 'app-create-subject',
  templateUrl: './create-subject.component.html',
  styleUrl: './create-subject.component.css'
})
export class CreateSubjectComponent implements OnInit {






  constructor(private service : PracticalService, private router : Router){

  }

  ngOnInit(): void {
    
  }

  onSubmit(f : NgForm){

    const subjectCode = f.value.subjectCode;
    const subjectName = f.value.subjectName;
    
    
    
    
    const theSubject = new Subject(subjectCode,subjectName);

    this.service.createSubject(theSubject).subscribe(data => {
      console.log();
      
    });

    this.goBack();

  }

  goBack(){
    this.router.navigate(['/subjects']);
  }
}
