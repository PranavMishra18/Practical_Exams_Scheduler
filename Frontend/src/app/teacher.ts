import { Subject } from "./subject";

export class Teacher{

    id : number;
    name : string;
    email : string;
    phoneNo : number;
    subject : Subject[];

    constructor(name : string, email : string, phoneNo : number){

        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

}