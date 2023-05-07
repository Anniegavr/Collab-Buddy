export class Assignment {
  id: string
  title: string
  description: string

  duedate: string
  estimatedTotalTime: number

  constructor(id: string, title: string, description: string, duedate: string, estimatedTotalTime: number) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.duedate = duedate;
    this.estimatedTotalTime = estimatedTotalTime;
  }
}