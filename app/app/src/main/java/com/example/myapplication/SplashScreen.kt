package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.Activities.MainActivity

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide();
    }

    override fun onResume() {
        Handler().postDelayed({
          val mainActivity = Intent(this, MainActivity::class.java)
            startActivity(mainActivity)
        },2000);
        super.onResume()
    }
}
