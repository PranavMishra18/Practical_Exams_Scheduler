import { Component, OnInit } from '@angular/core';
import { Subject } from '../subject';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrl: './subject.component.css'
})
export class SubjectComponent implements OnInit{


  theSubjects : Subject[];



  constructor(private service : PracticalService,private router : Router){

  }

  ngOnInit(): void {
    
    this.service.getSubjects().subscribe(data => {
      this.theSubjects = data;
    })
    this.refresh();
  }

  refresh(){
    this.router.navigate(['/subjects'])
  }

  addSubject(){
    this.router.navigate(['/subjects/create']);
  }


}
