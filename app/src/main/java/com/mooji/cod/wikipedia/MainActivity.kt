package com.mooji.cod.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.mooji.cod.wikipedia.Fragments.FragmentExplore
import com.mooji.cod.wikipedia.Fragments.FragmentProfile
import com.mooji.cod.wikipedia.Fragments.FragmentTrend
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

        //موقع اجرای برنامه اینکار ها ابتدا انجام شود.
        // چون ما قرار است جایگذاری کنیم و در ابتدا فرگمنتی نداریم که Replace شود اینکار را انجام میدهیم
        firstRun()


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

        binding.bottomNavigationMain.setOnItemReselectedListener {
            //چون با هربار کلیک رو آیتم آن آیتم انتخاب شده و دوباره لود میشود برای جلوگیری ازینکار
            //این تابع را صدا زده و میگوییم موقع فراخوانی دوباره هیچ کاری نکن

        }


        binding.bottomNavigationMain.setOnItemSelectedListener {

            when(it.itemId) {

                R.id.menu_explore -> {
                    replaceFragments(FragmentExplore())

                }
                R.id.menu_trend -> {
                    replaceFragments(FragmentTrend())


                }
                R.id.menu_profile -> {
                    replaceFragments(FragmentProfile())


                }
            }

            //وقتی توابع setonitemselectedlistener و  true ، setonnavigationitemselectedlistener  برمیگرداند
            // یعنی وقتی روی آیتم مدنظر کلیک شد آیتم بصورت انتخاب شده در می‌آید و رنگش هم تغییر میکند
            // اما اگر false برگردانیم باکلیک روی آیتم عملیات ما انجام میشود اما آیتم بصورت Selected نشان داده نمیش
            true
        }



    }

    fun replaceFragments(fragment:Fragment) {
        //از replace استفاده میکنیم تا با ادد کردن حجم مموری زیاد نشود و همچنین با هربارکلیک روی ایتم فرگمنت بروز شده لود شود
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container,fragment)
        transaction.commit()
    }

    fun firstRun() {

        replaceFragments(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore // اینکار باعث میشود ایتم اکسپلور بعنوان پیش فرض انتخاب شود

    }

}