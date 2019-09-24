package com.minara.kirana.manjuaapp.login.presenter

import com.minara.kirana.manjuaapp.login.data.User

interface LoginView {
    fun onSuccessLogin(user: User?, msg:String?)
    fun onError(msg: String?)

    fun onSuccessLoginGmail(user: User?, msg:String?, userid: String?)
}