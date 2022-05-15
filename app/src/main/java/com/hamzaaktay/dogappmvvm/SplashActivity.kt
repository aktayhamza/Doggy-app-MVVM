package com.hamzaaktay.dogappmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import com.hamzaaktay.dogappmvvm.databinding.ActivitySplashBinding
import com.hamzaaktay.dogappmvvm.ui.activity.MainActivity
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)

    val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)



    //lifecycleScope.launchWhenCreated {
            //val intent= Intent(this@SplashActivity,MainActivity::class.java)
            //startActivity(intent)
            //finish()
            //delay(4000)

        //}



    }
}