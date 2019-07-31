import { Component, OnInit } from '@angular/core';
import { CommonserviceService } from '../commonservice.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Addsubject } from '../addsubject';

@Component({
  selector: 'app-loginsuccessadmin',
  templateUrl: './loginsuccessadmin.component.html',
  styleUrls: ['./loginsuccessadmin.component.css']
})
export class LoginsuccessadminComponent implements OnInit {

  tablestatus;
  nodataintable;
  sno:number=0;
  registeredUserData;
  constructor(private service:CommonserviceService,private router: Router,private http: HttpClient) 
  { 
    this.http.get('http://localhost:7076/listRegisteredSubject').subscribe((data)=> 
    { 
      if((<Object[]>(<any>data)).length!=0)
      {
      this.registeredUserData=data;
      this.nodataintable=true;
      this.tablestatus=false;
      }
      else
      {
        this.tablestatus=true;
        this.nodataintable=false;

      }
  console.log(data);
  }, (error) => console.log(error));
  }

  removeUser(id)
  {
this.http.post('http://localhost:7076/deleteUserByAdmin',id).subscribe((data) => console.log(data),(error) => console.log(error));
this.http.get('http://localhost:7076/listRegisteredSubject').subscribe((data)=> 
{
  if((<Object[]>(<any>data)).length!=0)
  {
  this.registeredUserData=data;
  this.nodataintable=true;
  this.tablestatus=false;
  }
  else
  {
    this.tablestatus=true;
    this.nodataintable=false;

  }
console.log(data);
}
, (error) => console.log(error));
//this.nodataintable=false;  
//new LoginsuccessadminComponent(this.service,this.router,this.http);
//this.router.navigateByUrl("/loginsuccessadmin")

}

  ngOnInit() {
  }
 
logout()
{
  sessionStorage.removeItem("username");
  sessionStorage.removeItem("role");
  this.router.navigate(['/']);
}

updateCourseStatus(item,CourseStatus)
{
  console.log(CourseStatus);
  if(CourseStatus=='Pending')
  {
    CourseStatus='Completed';
  }
  
  console.log(CourseStatus);
  var course:Addsubject=new Addsubject();
  course.setId(item.id);
  course.setSubjectName(item.subjectName);
  course.setCourseStatus(CourseStatus);
  course.setUserName(item.userName);

  console.log(course.getCourseStatus());

  this.http.put("http://localhost:7076/updateCourseStatus",course).subscribe((data) => {console.log(data)},(error) => {console.log(error)});
}

check(item)
{
  console.log(item);
}

}
