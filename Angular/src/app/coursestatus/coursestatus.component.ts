import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-coursestatus',
  templateUrl: './coursestatus.component.html',
  styleUrls: ['./coursestatus.component.css']
})
export class CoursestatusComponent implements OnInit {

  coursestatusdata;
  constructor(private http:HttpClient,private router:Router) 
  { 
    console.log(sessionStorage.getItem("username"));
this.http.post('http://localhost:7076/coursestatus',sessionStorage.getItem("username")).subscribe((data) => 
{
  console.log(data)
  this.coursestatusdata=data;
}
  ,(error) => console.log(error));

  }

  ngOnInit() {
  }


  logout()
{
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("role");
    this.router.navigate(['/']);
  }


}
