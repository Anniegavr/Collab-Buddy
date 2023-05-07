import {User} from "./User";

export class Teacher extends User{
    specialty: string

    constructor(id: bigint, firstName: string, lastName: string, email: string, role: string, specialty: string) {
        super(id, firstName, lastName, email, role);
        this.specialty = specialty
    }
}