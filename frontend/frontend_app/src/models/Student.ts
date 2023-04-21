export class Student {
    constructor(id: number, name: string, email: string, year: number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.year = year;
    }
    public id: number;
    public name: string;
    public email: string;
    public year: number;
}