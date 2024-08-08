import { Component, OnInit } from '@angular/core';
import { PracticalService } from '../practical.service';
import { Venue } from '../venue';
import { Route, Router } from '@angular/router';

@Component({
  selector: 'app-venue',
  templateUrl: './venue.component.html',
  styleUrl: './venue.component.css'
})
export class VenueComponent implements OnInit{


  theVenues : Venue[];


  constructor(private service : PracticalService,private router : Router){


  }


  ngOnInit(): void {

    this.service.getVenues().subscribe(data => {
      this.theVenues = data;
    })
    
    this.refresh();

  }

  refresh(){
    this.router.navigate(['venue']);
  }

  addVenue(){
    this.router.navigate(['venue/create']);
  }

}
