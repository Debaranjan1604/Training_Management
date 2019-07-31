import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { RegisterComponent } from './register/register.component';
import { LoginsuccessadminComponent } from './loginsuccessadmin/loginsuccessadmin.component';
import { LoginsuccessuserComponent } from './loginsuccessuser/loginsuccessuser.component';
import { AdminloginauthGuard } from './adminloginauth.guard';
import { UserloginauthGuard } from './userloginauth.guard';
import { CoursestatusComponent } from './coursestatus/coursestatus.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'userlogin',component:UserloginComponent},
  {path:'adminlogin',component:AdminloginComponent},
  {path:'register',component:RegisterComponent},
  {path:'loginsuccessuser',canActivate : [UserloginauthGuard],component:LoginsuccessuserComponent},
  {path:'loginsuccessadmin',canActivate : [AdminloginauthGuard],component:LoginsuccessadminComponent}
  ,{path:'coursestatus',component:CoursestatusComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
