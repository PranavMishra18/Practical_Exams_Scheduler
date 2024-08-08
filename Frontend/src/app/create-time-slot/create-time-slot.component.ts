import { Component, OnInit } from '@angular/core';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { TimeSlot } from '../timeSlot';

@Component({
  selector: 'app-create-time-slot',
  templateUrl: './create-time-slot.component.html',
  styleUrl: './create-time-slot.component.css'
})
export class CreateTimeSlotComponent implements OnInit {






  constructor(private service : PracticalService, private router : Router){

  }

  ngOnInit(): void {
    
  }

  onSubmit(f : NgForm){

    const timeSlot = f.value.timeSlot;
    
    
    
    
    
    const theTimeSlot = new TimeSlot(timeSlot);

    this.service.createTimeSlot(theTimeSlot).subscribe(data => {
      console.log();
      
    });

    this.goBack();

  }

  goBack(){
    this.router.navigate(['/timeslot']);
  }

}
