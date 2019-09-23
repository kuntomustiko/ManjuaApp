package com.minara.kirana.manjuaapp.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minara.kirana.manjuaapp.R
import com.minara.kirana.manjuaapp.register.presenter.RegisterPresenter
import com.minara.kirana.manjuaapp.register.presenter.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.yesButton

class RegisterActivity : AppCompatActivity(),RegisterView {

    // 2
    // late init -> initialnya di dalam oncreate
    private lateinit var presenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //3
        presenter = RegisterPresenter(this)

        // 1
        btnRegister.onClick {
            val nama = registerName.text.toString()
            val email = registerEmail.text.toString()
            val password = registerPassword.text.toString()
            val hp = registerHp.text.toString()

            // 5
            presenter.register(nama, email,hp, password)
        }
    }

    // 4
    override fun onSuccessRegister(msg: String?) {

        //6
        alert {
            title = "Informasi"
            message = msg ?: ""
            yesButton {  }
        }.show()

    }

    override fun onError(msg: String?) {
       // 7
        alert {
            title = "Informasi"
            message = msg ?: ""
            yesButton {  }
        }.show()
    }

}
