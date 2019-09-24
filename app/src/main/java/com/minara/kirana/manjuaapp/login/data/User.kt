package com.minara.kirana.manjuaapp.login.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class User(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: User? = null,

	@field:SerializedName("status")
	val status: Int? = null,

	@field:SerializedName("user_status")
	val userStatus: String? = null,

	@field:SerializedName("user_nama")
	val userNama: String? = null,

	@field:SerializedName("user_email")
	val userEmail: String? = null,

	@field:SerializedName("user_password")
	val userPassword: String? = null,

	@field:SerializedName("user_id")
	val userId: String? = null,

	@field:SerializedName("user_hp")
	val userHp: String? = null,

	@field:SerializedName("user_level")
	val userLevel: String? = null,

	@field:SerializedName("user_token")
	val userToken: Any? = null,

	@field:SerializedName("user_tanggal")
	val userTanggal: String? = null
)