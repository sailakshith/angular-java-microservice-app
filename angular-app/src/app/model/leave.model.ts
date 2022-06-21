export class Leave{
  constructor(public employeeId: string,
    public fromDate:Date,
    public toDate:Date,
    public reason:string,
    public status:string,
    public comments:string
    ){}
}
