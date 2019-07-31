import { Component, OnInit } from '@angular/core';
import { CommonserviceService } from '../commonservice.service';
import { RegisterationDetail } from '../registerationdetail';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  error: string;

  details=new RegisterationDetail();
  constructor(private service:CommonserviceService,private router: Router) { }
  register1:Object;

  ngOnInit() {
  }
  data:boolean=false;

  successMessage:boolean=true;
  registerAction(user,password,role,secureKey)
  {
  
    
    var register:RegisterationDetail=new RegisterationDetail();
register.setUserName(user);
register.setPassword(password);
register.setRole(role);
if(secureKey=='abhi#123' && role=='admin')
{
return this.service.saveRegisterationDetails(
  //this.details
  register).subscribe((data) => {console.log(data);
    
    this.data=<boolean><any>data;
    if(this.data===true)
    {
      console.log('if');
      //this.router.navigate(['/']);
      this.successMessage=false;
    }
  },
(error) => console.log(error));
}

if(role=='user')
{
return this.service.saveRegisterationDetails(
  //this.details
  register).subscribe((data) => {console.log(data)
    this.data=<boolean><any>data;
    if(this.data===true)
    {
      console.log('if');
      this.successMessage=false;
      //this.router.navigate(['/']);
    }
  },
(error) => console.log(error));
}

  }

 edited:boolean=false;
  checkRole(role)
  {
    
if(role.value=='admin')
{
  console.log('role');
  this.edited=true;
}
else
{
  this.edited=false;
}
return this.edited;
  }

  gethide()
  {
    return this.edited
  }

}
