import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import  { HttpClientModule } from '@angular/common/http';
import  { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { RegisterComponent } from './register/register.component';
import { LoginsuccessadminComponent } from './loginsuccessadmin/loginsuccessadmin.component';
import { LoginsuccessuserComponent } from './loginsuccessuser/loginsuccessuser.component';
import { AdminloginauthGuard } from './adminloginauth.guard';
import { UserloginauthGuard } from './userloginauth.guard';
import { CoursestatusComponent } from './coursestatus/coursestatus.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UserloginComponent,
    AdminloginComponent,
    RegisterComponent,
    LoginsuccessadminComponent,
    LoginsuccessuserComponent,
    CoursestatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
    
  ],
  providers: [AdminloginauthGuard,
    UserloginauthGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
