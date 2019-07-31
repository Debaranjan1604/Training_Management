import { Component, OnInit, ViewChild } from '@angular/core';
import { CommonserviceService } from '../commonservice.service';
import { User } from '../user';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  data:boolean=false;;

  constructor(private service:CommonserviceService,private router: Router) { }

  ngOnInit() {
  }

  loginerror=true;
  @ViewChild('form') testFormElement:NgForm;

  gotoHome()
  {
    
  }
  validateUser(username,password,form)
  {
var user=new User();
user.setUserName(username);
user.setPassword(password);

 return this.service.validateUserForAdmin(user).subscribe((data) => {console.log(data); this.data=<boolean><any>data;
  if(this.data===true)
  {
    console.log('if');
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("role","admin");
    this.router.navigate(['/loginsuccessadmin']);
  }
  else
  {
    this.loginerror=false;
    console.log('else if');
    
  }
},
(error) => console.log(error));



  }


}
