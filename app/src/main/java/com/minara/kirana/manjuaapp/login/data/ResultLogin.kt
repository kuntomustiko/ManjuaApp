package com.minara.kirana.manjuaapp.login.data

import com.google.gson.annotations.SerializedName

class ResultLogin {

    @field:SerializedName("message")
    val message:String? = null

    @field:SerializedName("user")
    val user:User? = null

    @field:SerializedName("status")
    val status:Int? = null


}