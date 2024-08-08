import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TeacherComponent } from './teacher/teacher.component';
import { SubjectComponent } from './subject/subject.component';
import { VenueComponent } from './venue/venue.component';
import { TimeSlotComponent } from './time-slot/time-slot.component';
import { TimeTableComponent } from './time-table/time-table.component';
import { ExaminationComponent } from './examination/examination.component';
import { ExternalComponent } from './external/external.component';
import { SetExaminationsComponent } from './set-examinations/set-examinations.component';
import { CreateVenueComponent } from './create-venue/create-venue.component';
import { CreateSubjectComponent } from './create-subject/create-subject.component';
import { CreateTeacherComponent } from './create-teacher/create-teacher.component';
import { CreateTimeSlotComponent } from './create-time-slot/create-time-slot.component';
import { CreateTimeTableComponent } from './create-time-table/create-time-table.component';

const routes: Routes = [

  {path : 'teachers',component:TeacherComponent},
  {path : 'teachers/create',component:CreateTeacherComponent},
  {path:'subjects',component:SubjectComponent},
  {path:'subjects/create',component:CreateSubjectComponent},
  {path:'venue',component:VenueComponent},
  {path:'venue/create',component:CreateVenueComponent},
  {path:'timeslot',component:TimeSlotComponent},
  {path:'timeslot/create',component:CreateTimeSlotComponent},
  {path:'timetable',component:TimeTableComponent},
  {path:'timetable/create',component:CreateTimeTableComponent},
  {path:'examinations',component:ExaminationComponent},
  {path:'setexaminations',component:SetExaminationsComponent},
  {path:'externals',component:ExternalComponent},
  

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
