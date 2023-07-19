package com.mooji.cod.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.mooji.cod.wikipedia.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMani2)

        // این حالت Expanded میباشد یعنی رنگ title ما زمانی که صفحه collaps کاملا باز باشد را مشخض میکند
        binding.collapsingMain.setExpandedTitleColor(
            //در اینجا این تابع از ما کد int رنگ را میخواهد که ازین طریق آدرس رنگ را میدهیم و کد رابه ما میدهد

            //برای دسترسی به منابع خود اندروید مثل رنگ در قسمت کدنویسی از کلمه android استفاده میکنیم

            ContextCompat.getColor(this, android.R.color.transparent)
        )

        //فعال کردن و نمایش دکمه برگشت در Toolbar
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //تمام button هایی که در Toolbar هستند در حکم منو میباشند

        binding.extendedFab.setOnClickListener {

            // open website

        }


    }

    //این تابع مخصوص toolbar است که h'v روی هر button در toolbar کلیک شد میتوانیم عملیاتی را انجام دهیم
    //درست مثل bottom navigation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //دکمه android.R.id.home در حکم همان دکمه homebutton یا بک در toolbar میباشد
        if (item.itemId == android.R.id.home) {

            onBackPressed() //این تابع مثل دکمه بک گوشی عمل میکند
        }
        return true
    }


}