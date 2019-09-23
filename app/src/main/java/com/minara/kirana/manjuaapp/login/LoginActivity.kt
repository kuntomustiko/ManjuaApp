package com.minara.kirana.manjuaapp.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minara.kirana.manjuaapp.MainActivity
import com.minara.kirana.manjuaapp.R
import com.minara.kirana.manjuaapp.login.data.User
import com.minara.kirana.manjuaapp.login.presenter.LoginPresenter
import com.minara.kirana.manjuaapp.login.presenter.LoginView
import com.minara.kirana.manjuaapp.register.RegisterActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

class LoginActivity : AppCompatActivity(), LoginView {
    //2
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //3
        presenter = LoginPresenter(this)

        //5
        btnLoginEmail.onClick {

            presenter.login(
            edt_loginEmail.text.toString(),
            edt_loginPassword.text.toString()
            )
        }
        // 1
        linkRegister.onClick {
            startActivity<RegisterActivity>()
        }
    }

    //4
    override fun onSuccessLogin(user: User?, msg: String?) {
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
