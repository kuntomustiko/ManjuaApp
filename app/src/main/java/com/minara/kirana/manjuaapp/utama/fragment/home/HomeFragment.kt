package com.minara.kirana.manjuaapp.utama.fragment.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_home.*
import com.synnapps.carouselview.ImageListener
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.minara.kirana.manjuaapp.listProduk.ListProdukActivity
import com.minara.kirana.manjuaapp.utama.fragment.home.adapter.KategoriAdapter
import com.minara.kirana.manjuaapp.utama.fragment.home.data.KategoriItem
import com.minara.kirana.manjuaapp.utama.fragment.home.data.ProdukItem
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.support.v4.startActivity


/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment(), HomeView {


    private var image = arrayOf(
        com.minara.kirana.manjuaapp.R.drawable.gambar1,
        com.minara.kirana.manjuaapp.R.drawable.gambar2,
        com.minara.kirana.manjuaapp.R.drawable.gambar3,
        com.minara.kirana.manjuaapp.R.drawable.gambar4
    )

    private lateinit var presenter: HomePresenter

    private var dataProduk : List<ProdukItem?>? = null

//    private var dataKategori: List<KategoriItem?>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            com.minara.kirana.manjuaapp.R.layout.fragment_home,
            container,
            false
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenter(this)
        presenter.getProduk()
        presenter.getKategori()

        promosi.onClick {
            startActivity<ListProdukActivity>("status" to 1)
        }
        populer.onClick {
            startActivity<ListProdukActivity>("status" to 2)
        }



    }

    var imageListener: ImageListener = object : ImageListener {
        override fun setImageForPosition(position: Int, imageView: ImageView) {
//            imageView.setImageResource(image[position])

            activity?.let {
                Glide.with(it)
                    .load("http://192.168.1.100/server_commerce/image_growback/"+
                            dataProduk?.get(position)?.produkGambar).into(imageView)
            }
        }
    }

    override fun onSuccessProduk(data: List<ProdukItem?>?) {
        dataProduk = data

        carouselView.setImageListener(imageListener)
        carouselView.pageCount = dataProduk?.size?:0
    }

    override fun onErrorProduk(msg: String?) {
    }

    override fun onSuccessKategori(data: List<KategoriItem?>?) {
        listKategori.adapter = KategoriAdapter(data)

    }

    override fun onErrorKategori(msg: String?) {
    }

}
