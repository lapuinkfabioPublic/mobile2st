package com.fll.myapplication.business

public class UserBusiness {

    public fun checkCredencials(email: String, password: String): Boolean{
        return (!email.isEmpty() && !password.isEmpty())
    }
}