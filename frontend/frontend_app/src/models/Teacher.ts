import {User} from "./User";

export class Teacher extends User{
    specialty: string

    constructor(firstName: string, lastName: string, email: string, specialty: string) {
        super(firstName, lastName, email);
        this.specialty = specialty
    }
}