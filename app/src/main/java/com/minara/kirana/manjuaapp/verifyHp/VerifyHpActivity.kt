package com.minara.kirana.manjuaapp.verifyHp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minara.kirana.manjuaapp.MainActivity
import com.minara.kirana.manjuaapp.R
import kotlinx.android.synthetic.main.activity_verify_hp.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

class VerifyHpActivity : AppCompatActivity(), VerifyView {


    private lateinit var presenter: VerifyPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_hp)

        // menerima id dari intent
        var idUser = intent.getStringExtra("id")

        presenter = VerifyPresenter(this)
        btnVerify.onClick {
            presenter.verifyHp(verifyHp.text.toString(), idUser)
        }
    }

    override fun onSuccessUpdate(msg: String?) {
        startActivity<MainActivity>()
    }

    override fun onError(msg: String?) {
        alert {
            title = "Informasi"
            message = msg ?: ""
            yesButton {  }
        }.show()
    }
}
