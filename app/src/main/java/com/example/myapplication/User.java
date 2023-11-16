package com.example.myapplication;

public class User {
    public String cfname;
    public String clname;
    public String cphone;
    public String cuser;
    public String cpass;

    public User(){

    }
    public User(String cfname, String clname, String cpass, String cphone, String cuser){
        this.cfname = cfname;
        this.clname  =clname;
        this.cpass = cpass;
        this.cphone = cphone;
        this.cuser = cuser;
    }
}
