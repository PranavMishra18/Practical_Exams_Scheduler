import { Subject } from "./subject";
import { Teacher } from "./teacher";
import { TimeSlot } from "./timeSlot";
import { Venue } from "./venue";

export class Examination{


    id : number;
    subject : Subject;
    year : string;
    section : string;
    day: string;
    studentGroup : string;
    students : string;
    internalExaminer : Teacher;
    externalExaminer : Teacher;
    phoneNo : number;
    email : string;
    timeSlot : TimeSlot;
    date : string;
    venue : Venue;

    constructor(day : string, date: string, phoneNo : number,email : string,section : string, studentGroup : string,
         students : string,year : string,
        subject : Subject,
        internalExaminer : Teacher,externalExaminer : Teacher,
        timeSlot : TimeSlot,venue : Venue){
            
            this.day = day;
            this.subject = subject;
            this.year = year;
            this.section = section;
            this.studentGroup = studentGroup;
            this.students = students;
            this.internalExaminer = internalExaminer;
            this.externalExaminer = externalExaminer;
            this.phoneNo = phoneNo;
            this.email = email;
            this.timeSlot = timeSlot;
            this.date = date;
            this.venue = venue;
    }


}