package com.minara.kirana.manjuaapp.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
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


    private var googleSignInClient : GoogleSignInClient? = null

    //2
    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Configure Google Sign In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

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

        btnLoginGoogle.onClick {
            signIn()
        }
    }

    private fun signIn() {
        val signInIntent = googleSignInClient?.signInIntent
        startActivityForResult(signInIntent, 1)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == 1) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)

            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                            Log.d("signin email", account?.email.toString())

            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e)
                Log.d("sign in email", e.statusCode.toString())
                // ...

            }
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

    //hari k2
    override fun onSuccessLoginGmail(user: User?, msg: String?) {
        if (msg == "login gmail"){
            startActivity<MainActivity>()
            finish()
        }
    }
}
