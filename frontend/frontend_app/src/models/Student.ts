import {User} from "./User";

export class Student extends User{
    public year: number

    constructor(firstName: string, lastName: string, email: string, year: number) {
        super(firstName, lastName, email);
        this.year = year;
    }

}