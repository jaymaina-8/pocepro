package com.jaytech.pacepro.model

class User {
      var fname: String=""
    var lname: String=""
    var email: String=""
    var pass: String=""
    var userid: String=""

    constructor(fname: String,
                lname: String,
                email: String,
                pass: String,
                userid: String,
    ){
        this.fname=fname
        this.lname=lname
        this.email=email
        this.pass=pass
        this.userid=userid
    }
    constructor()
}