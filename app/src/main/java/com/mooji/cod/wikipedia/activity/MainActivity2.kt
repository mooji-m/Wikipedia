package com.mooji.cod.wikipedia.activity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.mooji.cod.wikipedia.data.ItemPost
import com.mooji.cod.wikipedia.databinding.ActivityMain2Binding
import com.mooji.cod.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY

class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMani2)
        //فعال کردن و نمایش دکمه برگشت در Toolbar
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //تمام button هایی که در Toolbar هستند در حکم منو میباشند


        // این حالت Expanded میباشد یعنی رنگ title ما زمانی که صفحه collaps کاملا باز باشد را مشخض میکند
        binding.collapsingMain.setExpandedTitleColor(
            //در اینجا این تابع از ما کد int رنگ را میخواهد که ازین طریق آدرس رنگ را میدهیم و کد رابه ما میدهد

            //برای دسترسی به منابع خود اندروید مثل رنگ در قسمت کدنویسی از کلمه android استفاده میکنیم

            ContextCompat.getColor(this,android.R.color.transparent)
        )


        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)

        if(dataPost != null) {  //دیتا پست null پذیر است یعنی ممکن است از اکتویتی دیگری آمده باشیم و داخل intent اطلاعاتی نداشته باشیم null شود

            showData(dataPost)

        }









    }



    //این تابع مخصوص toolbar است که h'v روی هر button در toolbar کلیک شد میتوانیم عملیاتی را انجام دهیم
    //درست مثل bottom navigation
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //دکمه android.R.id.home در حکم همان دکمه homebutton یا بک در toolbar میباشد
        if(item.itemId == android.R.id.home ) {

            onBackPressed() //این تابع مثل دکمه بک گوشی عمل میکند
        }
        return true
    }



    private fun showData(itemPost: ItemPost) {

        Glide
            .with(this)
            .load(itemPost.imgUrl)
            .into(binding.imgDetail)

        binding.txtDetailTitle.text = itemPost.txtTitle

        binding.txtDetailSubtitle.text = itemPost.txtSubtitle

        binding.txtDetailText.text = itemPost.txtDetail

        binding.fabDetailOpenWikipedia.setOnClickListener {

            val url = "https://en.wikipedia.org/wiki/Main_Page"

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))

            startActivity(intent)

        }

    }


}