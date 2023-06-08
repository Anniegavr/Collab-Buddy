export class Group {
    id: bigint
    name: string
    year: string
    email: string
    specialty: string

    constructor(id: bigint, name: string, year: string, email: string, specialty: string) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.email = email;
        this.specialty = specialty;
    }
}