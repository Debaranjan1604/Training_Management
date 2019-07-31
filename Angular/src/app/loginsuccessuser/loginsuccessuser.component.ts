import { Component, OnInit } from '@angular/core';
import { CommonserviceService } from '../commonservice.service';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Subscribeuser } from '../subscribeuser';



@Component({
  selector: 'app-loginsuccessuser',
  templateUrl: './loginsuccessuser.component.html',
  styleUrls: ['./loginsuccessuser.component.css']
})
export class LoginsuccessuserComponent implements OnInit {

  constructor(private service:CommonserviceService,private router: Router,private http: HttpClient) 
  { 
    this.http.get('http://localhost:7076/allSubject').subscribe((data) =>{this.data=data; console.log(this.data);},(error) => console.log(error) );
  this.http.post('http://localhost:7076/checkRegister',sessionStorage.getItem("username")).subscribe((data)=>{this.subscribeData=data},(error)=> console.log(error));
  }

data;
subscribeData;

  ngOnInit() {
  }


  subscribeSubject(id)
  {
    console.log(id);
    var user=new Subscribeuser();
    user.setId(id);
    user.setUsername(sessionStorage.getItem("username"));
this.http.post('http://localhost:7076/addSubject',user).subscribe((data) =>console.log(this.subscribeData),(error) => console.log(error));
this.http.get('http://localhost:7076/allSubject').subscribe((data) =>{this.data=data; console.log(this.data);},(error) => console.log(error) );
this.http.post('http://localhost:7076/checkRegister',sessionStorage.getItem("username")).subscribe((data)=>{this.subscribeData=data},(error)=> console.log(error));  
//this.router.navigate(['/loginsuccessuser']);
}

  unsubscribeSubject(id)
  {
this.http.post('http://localhost:7076/deleteSubject',id).subscribe((data) => console.log(data),(error) =>console.log(error));

this.http.post('http://localhost:7076/checkRegister',sessionStorage.getItem("username")).subscribe((data)=>{console.log(data); this.subscribeData=data},(error)=> console.log(error)); 
this.router.navigate(['/loginsuccessuser']);
}

  checkRegister(subjectName)
  {
    var k=1;
for(var i=0;i<((this.subscribeData).length);i++)
{

  if(this.subscribeData[i].subjectName==subjectName)
  {
    k=3;
    break;
  }
}
if(k==1)
{
  return false;
}
else
{
  return true;
}
  }

  logout()
{
  sessionStorage.removeItem("username");
  sessionStorage.removeItem("role");
  this.router.navigate(['/']);
}

subsSubject=[];
unsubsSubject=[];

onCheckboxChagen(event,id,issubscribe)
{
  
if(issubscribe=='subscribe')
{
  
  if (event.target.checked) {
    console.log('oncheckbox');
    this.subsSubject.push(id);
  } 
  if (!event.target.checked) {

    let index = this.subsSubject.indexOf(id);

    if (index > -1) {

      this.subsSubject.splice(index, 1);
    }
  }
}

if(issubscribe=='unsubscribe')
{
  
  if (event.target.checked) {
    console.log('oncheckbox');
    this.unsubsSubject.push(id);
  } 
  if (!event.target.checked) {

    let index = this.unsubsSubject.indexOf(id);

    if (index > -1) {

      this.unsubsSubject.splice(index, 1);
    }
  }
}
}


subscribeMultipleSubject()
  {
    console.log(this.subsSubject.length); 
    for(var i=0;i<this.subsSubject.length;i++)
    {
    console.log(this.subsSubject[i]);
    var user=new Subscribeuser();
    user.setId(this.subsSubject[i]);
    user.setUsername(sessionStorage.getItem("username"));
this.http.post('http://localhost:7076/addSubject',user).subscribe((data) =>
{
  console.log('log:'+this.data);
}
  ,(error) => console.log(error));
this.http.get('http://localhost:7076/allSubject').subscribe((data) =>{this.data=data; console.log(this.data);},(error) => console.log(error) );
this.http.post('http://localhost:7076/checkRegister',sessionStorage.getItem("username")).subscribe((data)=>{this.subscribeData=data},(error)=> console.log(error));  
//this.router.navigate(['/loginsuccessuser']);
}
window.location.reload();
  }


  unSubscribeMultipleSubject()
{
  console.log(this.subsSubject.length); 
  for(var i=0;i<this.unsubsSubject.length;i++)
  {
  console.log(this.unsubsSubject[i]);
  this.http.post('http://localhost:7076/deleteSubject',this.unsubsSubject[i]).subscribe((data) => console.log(data),(error) =>console.log(error));

this.http.post('http://localhost:7076/checkRegister',sessionStorage.getItem("username")).subscribe((data)=>{console.log(data); this.subscribeData=data},(error)=> console.log(error)); 
this.router.navigate(['/loginsuccessuser']);
  }
  window.location.reload();
}

}
