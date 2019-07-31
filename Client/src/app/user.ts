

export class User {
    username:string;
    password:string;

public  setUserName(username:string):void
{
this.username=username;
}

public getUserName():string
{
return this.username;
}

public  setPassword(password:string):void
{
this.password=password;
}

public getPassword():string
{
return this.password;
}

}
