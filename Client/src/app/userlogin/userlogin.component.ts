import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { CommonserviceService } from '../commonservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {

  constructor(private service:CommonserviceService,private router: Router) { }
data:boolean=true;
  ngOnInit() {
  }

loginerror=true;

  validateUser(username,password)
  {
var user=new User();
user.setUserName(username);
user.setPassword(password);

return this.service.validateUserForUser(user).subscribe((data) => {console.log(data);this.data=<boolean><any>data;
  if(this.data==true)
  {
    console.log('if');
    sessionStorage.setItem("username", username);
    sessionStorage.setItem("role","user");
    this.router.navigate(['/loginsuccessuser']);
  }
  else
  {
    this.loginerror=false;
    console.log('else if');
    
  }
  
  
},
(error) => console.log(error));



  }

  getloginerror()
  {
    return this.loginerror;
  }

}
