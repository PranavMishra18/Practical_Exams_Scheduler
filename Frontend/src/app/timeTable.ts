import { Subject } from "./subject";
import { Teacher } from "./teacher";
import { TimeSlot } from "./timeSlot";
import { Venue } from "./venue";

export class TimeTable{

    id : number;
    section : string;
    studentGroup : string;
    students : string;
    year : string;
    day : string;
    subject : Subject;
    teacher : Teacher;
    
    timeSlot : TimeSlot;
    venue : Venue;

    constructor( section : string, studentGroup : string,students : string, year : string,day : string,
         subject : Subject,teacher : Teacher, timeSlot : TimeSlot,venue : Venue){

            this.section = section;
            this.studentGroup = studentGroup;
            this.students = students;
            this.year = year;
            this.day = day;
            this.subject = subject;
            this.teacher = teacher;
            this.timeSlot = timeSlot;
            this.venue = venue;
    }
    




}