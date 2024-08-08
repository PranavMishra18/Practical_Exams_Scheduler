import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { PracticalService } from '../practical.service';
import { Router } from '@angular/router';
import { Venue } from '../venue';

@Component({
  selector: 'app-create-venue',
  templateUrl: './create-venue.component.html',
  styleUrl: './create-venue.component.css'
})
export class CreateVenueComponent implements OnInit {






  constructor(private service : PracticalService, private router : Router){

  }

  ngOnInit(): void {
    
  }

  onSubmit(f : NgForm){

    const venue = f.value.venue;
    
    
    
    
    const theVenue = new Venue(venue);

    this.service.createVenue(theVenue).subscribe(data => {
      console.log();
      
    });

    this.goBack();

  }

  goBack(){
    this.router.navigate(['/venue']);
  }

}
