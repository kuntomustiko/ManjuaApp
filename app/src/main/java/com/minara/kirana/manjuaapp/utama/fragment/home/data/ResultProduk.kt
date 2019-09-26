package com.minara.kirana.manjuaapp.utama.fragment.home.data

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class ResultProduk(

    @field:SerializedName("kategori")
	val kategori: List<ProdukItem?>? = null,

    @field:SerializedName("message")
	val message: String? = null,

    @field:SerializedName("status")
	val status: Int? = null
)