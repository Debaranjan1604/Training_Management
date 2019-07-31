import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { RegisterationDetail } from './registerationdetail';
import { Observable } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { User } from './user';


@Injectable({
  providedIn: 'root'
})
export class CommonserviceService {

  temp:number;

  
  /*
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };  
*/
  constructor(private client:HttpClient) { }


   saveRegisterationDetails(details:RegisterationDetail)
  {

    return this.client.post<RegisterationDetail>('http://localhost:7076/register',details,
    //this.httpOptions
    ).pipe(
      catchError(this.handleError)
    );
    console.log('success'); 
  }


  validateUserForAdmin(user:User)
  {
    console.log(user.getUserName());
return this.client.post<User>('http://localhost:7076/adminlogin',user).pipe(catchError(this.handleError)
);

 }

 validateUserForUser(user:User)
  {
    console.log(user.getUserName());
return this.client.post<User>('http://localhost:7076/userlogin',user).pipe(catchError(this.handleError)
);

 }


  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(`Backend returned code ${error.status}, ` + `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError('Something bad happened; please try again later.');
  }

}
