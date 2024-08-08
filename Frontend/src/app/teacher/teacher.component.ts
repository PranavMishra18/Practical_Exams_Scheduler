import { Component, OnInit } from '@angular/core';
import { Teacher } from '../teacher';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrl: './teacher.component.css'
})
export class TeacherComponent implements OnInit{


  teachers : Teacher[];


  constructor(private service : PracticalService,private router : Router){


  }


  ngOnInit(): void {

    this.service.getTeachers().subscribe(data => {
      this.teachers = data;
      console.log(this.teachers);
      
    })

    this.refresh();

  }

  refresh(){
    this.router.navigate(['/teachers']);
  }

  addTeacher(){
    this.router.navigate(['teachers/create']);
  }

}
