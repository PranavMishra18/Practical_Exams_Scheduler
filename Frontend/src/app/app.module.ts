import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from './material.module';
import { TeacherComponent } from './teacher/teacher.component';
import { HttpClientModule } from '@angular/common/http';
import { NavbarComponent } from './navbar/navbar.component';
import { SetExaminationsComponent } from './set-examinations/set-examinations.component';
import { VenueComponent } from './venue/venue.component';
import { SubjectComponent } from './subject/subject.component';
import { TimeSlotComponent } from './time-slot/time-slot.component';
import { TimeTableComponent } from './time-table/time-table.component';
import { ExternalComponent } from './external/external.component';
import { CreateVenueComponent } from './create-venue/create-venue.component';
import { CreateSubjectComponent } from './create-subject/create-subject.component';
import { CreateTimeSlotComponent } from './create-time-slot/create-time-slot.component';
import { CreateTeacherComponent } from './create-teacher/create-teacher.component';
import { CreateTimeTableComponent } from './create-time-table/create-time-table.component';
import { ExaminationComponent } from './examination/examination.component';


@NgModule({
  declarations: [
    AppComponent,
    TeacherComponent,
    VenueComponent,
    SubjectComponent,
    TimeSlotComponent,
    TimeTableComponent,
    ExternalComponent,
    ExaminationComponent,
    NavbarComponent,
    SetExaminationsComponent,
    CreateVenueComponent,
    CreateSubjectComponent,
    CreateTimeSlotComponent,
    CreateTeacherComponent,
    CreateTimeTableComponent
  ],
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MaterialModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
