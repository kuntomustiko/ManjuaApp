package com.minara.kirana.manjuaapp.register.presenter

interface RegisterView {

    fun onSuccessRegister(msg: String?)
    fun onError(msg: String?)
}