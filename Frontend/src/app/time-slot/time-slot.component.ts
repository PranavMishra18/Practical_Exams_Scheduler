import { Component, OnInit } from '@angular/core';
import { TimeSlot } from '../timeSlot';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-time-slot',
  templateUrl: './time-slot.component.html',
  styleUrl: './time-slot.component.css'
})
export class TimeSlotComponent implements OnInit{


  theTimeSlots : TimeSlot[];


  constructor(private service : PracticalService,private router : Router){


  }


  ngOnInit(): void {

    this.service.getTimeSlots().subscribe(data => {
      this.theTimeSlots = data;
    })

    this.refresh();

  }

  refresh(){
    this.router.navigate(['/timeslot']);
  }

  addTimeSlot(){
    this.router.navigate(['timeslot/create']);
  }

}
