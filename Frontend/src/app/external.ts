import { Teacher } from "./teacher";
import { TimeSlot } from "./timeSlot";

export class External{

    id : number;
    externalExaminer : Teacher;
    date : string;
    day : string;
    timeSlot : TimeSlot;


    constructor(externalExaminer : Teacher, date : string, day : string, timeSlot : TimeSlot){

        this.externalExaminer = externalExaminer;
        this.date = date;
        this.day = day;
        this.timeSlot = timeSlot;
    }

}