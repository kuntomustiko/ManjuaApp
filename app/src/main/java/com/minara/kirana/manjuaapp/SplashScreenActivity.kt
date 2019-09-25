package com.minara.kirana.manjuaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.minara.kirana.manjuaapp.utama.MainActivity
import com.minara.kirana.manjuaapp.login.LoginActivity
import com.minara.kirana.manjuaapp.utils.SessionManager
import org.jetbrains.anko.startActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var sesi = SessionManager(this)

        Handler().postDelayed(Runnable {
            if (sesi.isLogin){
                startActivity<MainActivity>()
            } else{
                startActivity<LoginActivity>()
            }
        }, 4000)
    }
}
