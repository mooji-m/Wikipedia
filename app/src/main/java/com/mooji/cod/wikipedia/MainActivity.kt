package com.mooji.cod.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.mooji.cod.wikipedia.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setSupportActionBar(binding.toolBarMain) //تولبار را بطور پیش فرض بعنوان actionbar در نظر میگیرد

        //ساخت drawer toggle که سه خط را روی toolbar ایجاد میکند تا navigation drawer باز شود
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolBarMain ,
            R.string.openDrawer ,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState() //فعال کردن انیمیشن ایکون سه خط


        binding.navigationViewMain.setNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.menu_writer -> {
                    Toast.makeText(this, "menu writer clicked!", Toast.LENGTH_SHORT).show()

                    //بسته شدن drawer با کلیک روی ایتم مدنظر
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_photograph -> {


                }
                R.id.menu_video_maker -> {


                }
             // -----------------------------------------

                R.id.menu_open_wikipedia -> {


                }

                R.id.menu_openWikimedia -> {

                    
                }



            }
            true
        }


    }
}