import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { Subject } from "./subject";
import { TimeSlot } from "./timeSlot";
import { Venue } from "./venue";
import { TimeTable } from "./timeTable";
import { Examination } from "./examination";
import { External } from "./external";
import { Observable } from "rxjs";
import { Teacher } from "./teacher";

@Injectable({
    providedIn:'root'
})
export class PracticalService{

    private baseUrl = 'http://localhost:8080';


    constructor(private http : HttpClient){

    }

//-----------------------------------------------------------------------------------------------------------------------------------    

    // TEACHERS

    getTeachers(){
        return this.http.get<Teacher[]>(`${this.baseUrl}/teachers`);
    }

    getTeacher(id : number){
        return this.http.get<Teacher>(`${this.baseUrl}/teachers/${id}`);
    }

    getTeachersBySubjectId(subjectId : number){
        return this.http.get<Teacher[]>(`${this.baseUrl}/teachers/subject/${subjectId}`);
    }

    createTeacher(teacher: Teacher, subjectIds: number[]) {
        return this.http.post(`${this.baseUrl}/teachers/create?subjectIds=${subjectIds.join(',')}`, teacher);
      }

     
    
    deleteTeacher(id : number){
        return this.http.delete(`${this.baseUrl}/teachers/delete/${id}`);
    }

//-----------------------------------------------------------------------------------------------------------------------------------

    // SUBJECTS

    getSubjects(){
        return this.http.get<Subject[]>(`${this.baseUrl}/subjects`);
    }

    getSubject(id : number){
        return this.http.get<Subject>(`${this.baseUrl}/subjects/${id}`);
    }

    createSubject(subject : Subject){
        return this.http.post(`${this.baseUrl}/subjects/create`,subject);
    }

    deleteSubject(id : number){
        return this.http.delete(`${this.baseUrl}/subjects/delete/${id}`);
    }

//-----------------------------------------------------------------------------------------------------------------------------------
    
    // TIMESLOTS


    getTimeSlots(){
        return this.http.get<TimeSlot[]>(`${this.baseUrl}/timeslots`);
    }

    getTimeSlot(id : number){
        return this.http.get<TimeSlot>(`${this.baseUrl}/timeslots/${id}`);
    }

    createTimeSlot(timeSlot : TimeSlot){

        return this.http.post(`${this.baseUrl}/timeslots/create`,timeSlot);

    }

    deleteTimeSlot(id : number){
        return this.http.delete(`${this.baseUrl}/timeslots/delete/${id}`);
    }

//-----------------------------------------------------------------------------------------------------------------------------------
    
    // VENUES


    getVenues(){
        return this.http.get<Venue[]>(`${this.baseUrl}/venues`);
    }

    getVenue(id : number){
        return this.http.get<Venue>(`${this.baseUrl}/venues/${id}`);
    }

    createVenue(venue : Venue){
        return this.http.post(`${this.baseUrl}/venues/create`,venue);
    }

    deleteVenue(id : number){
        return this.http.delete(`${this.baseUrl}/venues/delete/${id}`);
    }

//-----------------------------------------------------------------------------------------------------------------------------------

    // TIMETABLES

    getTimeTables(){
        return this.http.get<TimeTable[]>(`${this.baseUrl}/timetables`);
    }

    getTimeTable(id : number){
        return this.http.get<TimeTable>(`${this.baseUrl}/timetables/${id}`);
    }

    createTimeTable(timeTable : TimeTable){
        return this.http.post(`${this.baseUrl}/timetables/create`,timeTable);
    }

    deleteTimeTable(id : number){
        return this.http.delete(`${this.baseUrl}/timetables/delete/${id}`);
    }

//-----------------------------------------------------------------------------------------------------------------------------------
    
    // EXAMINATIONS


    getExaminations(){
        return this.http.get<Examination[]>(`${this.baseUrl}/examinations`);
    }

    getExamination(id : number){
        return this.http.get<Examination>(`${this.baseUrl}/examinations/${id}`);
    }

    createExamination(examination : Examination){
        return this.http.post(`${this.baseUrl}/examinations/create`,examination);
    }

    deleteExamination(id : number){
        return this.http.delete(`${this.baseUrl}/examinations/delete/${id}`);
    }

//-----------------------------------------------------------------------------------------------------------------------------------
    // EXTERNALS    

    getExternals(){
        return this.http.get<External[]>(`${this.baseUrl}/externals`);
    }

    getExternal(id : number){
        return this.http.get<External>(`${this.baseUrl}/externals/${id}`);
    }

    createExternal(external : External){
        return this.http.post(`${this.baseUrl}/externals/create`,external);
    }

    deleteExternal(id : number){
        return this.http.delete(`${this.baseUrl}/externals/delete/${id}`);
    }




    // SETTING EXAM LOGIC CODE

    getTimeTableByDay(day : string){
        return this.http.get<TimeTable[]>(`${this.baseUrl}/timetables/by/${day}`);
    }

    getTimeTableByDayExcludingTeacher(day : string, teacherId : number){

        return this.http.get<TimeTable[]>(`${this.baseUrl}/timetables/exclude/${day}/${teacherId}`);

    }

    getCountOfExternal(teacherId : number){

        return this.http.get<number>(`${this.baseUrl}/externals/count/${teacherId}`);

    }

    checkExternalExists(teacherId : number,date : string, day : string, timeSlotId : number){
        return this.http.get<boolean>(`${this.baseUrl}/externals/exists/${teacherId}/${date}/${day}/${timeSlotId}`);
    }





}
