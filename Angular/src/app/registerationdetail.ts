

export class RegisterationDetail {

    constructor() { }

      username:string;
     password:string;
     role:string;

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
public  setRole(role:string):void
{
this.role=role;
}

public getRole():string
{
return this.role;
}

  
}