package com.mooji.cod.wikipedia.activity

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.snackbar.Snackbar
import com.mooji.cod.wikipedia.R
import com.mooji.cod.wikipedia.fragments.FragmentExplore
import com.mooji.cod.wikipedia.fragments.FragmentProfile
import com.mooji.cod.wikipedia.fragments.FragmentTrend
import com.mooji.cod.wikipedia.databinding.ActivityMainBinding
import com.mooji.cod.wikipedia.fragments.FragmentPhotographer
import soup.neumorphism.CornerFamily
import soup.neumorphism.NeumorphShapeAppearanceModel
import soup.neumorphism.NeumorphShapeDrawable

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
            R.string.openDrawer,
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

                    //بسته شدن drawer با کلیک روی ایتم مدنظر
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    //این کتابخونه بطور پیش فرض برای حالت های ساده دکمه confirm و cancel داره و نیازی به ساخت فرگمنت نداریم

                    //اگر از PROGRESS_TYPE استفاده کردیم میتوانیم با استفاده از کتابخنه handler بگوییم مثلا بعد از 3 ثانیه صفحه بسته شود
                    val dialog = SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                    dialog.titleText = "Alert"
                    dialog.confirmText = "Confirm"
                    dialog.cancelText = "Cancel"
                    dialog.contentText = "Wanna be a Writer?"

                    dialog.setCancelClickListener {

                        dialog.dismiss()
                    }

                    dialog.setConfirmClickListener {
                        dialog.dismiss()
                        Toast.makeText(this, "You can be a Writer just try", Toast.LENGTH_SHORT).show()

                    }
                    dialog.show()

                }
                R.id.menu_photograph -> {

                    if (binding.navigationViewMain.menu.getItem(1).isChecked == false) {

                        binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.add(R.id.frame_main_container, FragmentPhotographer())
                        transaction.addToBackStack(null)
                        transaction.commit()

                        // طریقه فعال کردن قابلیت چک کردن از طریق کد نویسی بدون فعال کردن از طریق attribute
                        //binding.navigationViewMain.menu.getItem(1).isCheckable = true
                        binding.navigationViewMain.menu.getItem(1).isChecked = true
                        //binding.navigationViewMain.setCheckedItem(R.id.menu_photograph) // این خط کد و خط بالا دو روش انتخابی است



                    } else {
                        binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                    }

                }
                R.id.menu_video_maker -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    Snackbar
                        .make(binding.root,"You can Create Video",Snackbar.LENGTH_LONG)
                        .setAction("Retry"){
                            Toast.makeText(this, "checked", Toast.LENGTH_SHORT).show()
                        }
                        .setActionTextColor(ContextCompat.getColor(this, R.color.white))
                        .setBackgroundTint(ContextCompat.getColor(this, R.color.blue))
                        .show()

                }
                R.id.menu_translator -> {
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)


                    val intent = Intent(this,MainActivity3::class.java)
                    startActivity(intent)

                }
             // -----------------------------------------

                R.id.menu_open_wikipedia -> {

                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    openWebsite("https://www.wikipedia.org/")

                }

                R.id.menu_openWikimedia -> {

                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    openWebsite("https://www.wikimedia.org/")
                    
                }



            }


            true
        }



        binding.bottomNavigationMain.setOnItemReselectedListener {
            //چون با هربار کلیک رو آیتم آن آیتم انتخاب شده و دوباره لود میشود برای جلوگیری ازینکار
            //این تابع را صدا زده و میگوییم موقع فراخوانی دوباره هیچ کاری نکن

            if (binding.navigationViewMain.menu.getItem(1).isChecked == true) {

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






            }
        }

        binding.bottomNavigationMain.setBackgroundColor(ContextCompat.getColor(this,R.color.white))
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

            binding.navigationViewMain.menu.getItem(1).isChecked = false

            true
        }



    }

    private fun openWebsite(url: String) {

        val intent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
        startActivity(intent)

    }

    private fun replaceFragments(fragment:Fragment) {
        //از replace استفاده میکنیم تا با ادد کردن حجم مموری زیاد نشود و همچنین با هربارکلیک روی ایتم فرگمنت بروز شده لود شود
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container,fragment)
        transaction.commit()
    }

    private fun firstRun() {

        replaceFragments(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId =
            R.id.menu_explore // اینکار باعث میشود ایتم اکسپلور بعنوان پیش فرض انتخاب شود

    }

    override fun onBackPressed() {
        super.onBackPressed()
        if(binding.drawerLayoutMain.isDrawerOpen(GravityCompat.START)) {

            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
        }
        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {


        // همان طورکه layoutinflater داشتیم برای ساخت منو اصلی هم menuinflater داریم
        // که چون در اکتویتی یک نمونه ازش رو داریم نیازی به ساخت از کلاس آن نیست
        menuInflater.inflate(R.menu.menu_main,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {

            R.id.exit -> {
                val dialog = SweetAlertDialog(this,SweetAlertDialog.WARNING_TYPE)
                dialog.titleText = "Alert"
                dialog.confirmText = "Exit"
                dialog.cancelText = "Cancel"
                dialog.contentText = "Are you sure you want to Exit?"


                dialog.setCancelClickListener {
                    dialog.dismiss()
                }

                dialog.setConfirmClickListener {
                    finish()

                }
                dialog.show()


            }



        }

        return true
    }

}