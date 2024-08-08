import { Component, OnInit } from '@angular/core';
import { TimeTable } from '../timeTable';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-time-table',
  templateUrl: './time-table.component.html',
  styleUrl: './time-table.component.css'
})
export class TimeTableComponent implements OnInit{


  theTimeTable : TimeTable[];


  constructor(private service : PracticalService,private router : Router){


  }


  ngOnInit(): void {

    this.service.getTimeTables().subscribe(data => {
      this.theTimeTable = data;
    })

    this.refresh();

  }

  refresh(){
    this.router.navigate(['/timetable']);
  }

  addTimeTable(){
    this.router.navigate(['timetable/create']);
  }

}
