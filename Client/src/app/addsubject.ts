export class Addsubject 
{
    private  id:number;
    
    private  courseStatus:string;
	
	private userName:string;
	
	private subjectName:string;
	

	public  getId():number {
		return this.id;
	}

	public setId( id:number):void {
		this.id = id;
	}

	

	public  getUserName():string {
		return this.userName;
	}

	public  setUserName( userName:string):void {
		this.userName = userName;
	}

	public  getSubjectName():string {
		return this.subjectName ;
	}

	public  setSubjectName( subjectname:string):void {
		this.subjectName = subjectname;
	}
	
	public  getCourseStatus():string {
		return this.courseStatus;
	}

	public  setCourseStatus( courseStatus:string):void {
		this.courseStatus = courseStatus;
	}
    

}
