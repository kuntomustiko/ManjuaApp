package com.minara.kirana.manjuaapp.listProduk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.minara.kirana.manjuaapp.R
import com.minara.kirana.manjuaapp.listProduk.adapter.ProdukAdapter
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ProdukItem
import kotlinx.android.synthetic.main.activity_list_produk.*

class ListProdukActivity : AppCompatActivity(), ProdukView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_produk)

        var presenter = ProdukPresenter(this)
        var status = intent.getIntExtra("status", 0)

        if (status == 1){
            presenter.getPromot()

        } else if (status == 2){
            presenter.getPopuler()
        }
    }

    override fun onSuccessProduk(data: List<ProdukItem?>?) {
        listProduk.adapter = ProdukAdapter(data)
    }

    override fun onErrorProduk(msg: String?) {
    }
}
