package com.mooji.cod.wikipedia.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mooji.cod.wikipedia.data.ItemPost
import com.mooji.cod.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(private val data:ArrayList<ItemPost>,val itemEvents: ItemEvents) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    lateinit var binding:ItemExploreBinding

    inner class ExploreViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) { // ایتم پست مشخص میکند در حال حاضر کدوم آیتم انتخاب شده

            val glide = Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgExploreMain)

            binding.txtExploreDetail
            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetail.text = itemPost.txtDetail

            // در این جا میتوانیم SetOnClickListener برای آیتم های recycler خود ست کنیم
            //در اکتیویتی به دیتابیس دسترسی داریم برای همین عملیات کلیک شدن باید در اکتویتی مدیریت شود و وظیفه Recycler فقط نمایش اطلاعات است
            itemView.setOnClickListener {

                itemEvents.onItemCLicked(itemPost)

            }



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {

        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ExploreViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) { //ست کردن مقادیر
        holder.bindViews(data[position])
        //در اینجااز لیستی که داریم آیتم مورد نظر را مشخص کرده و به تابع بالا میدهیم

    }

    override fun getItemCount(): Int {
        return data.size
    }


}


//توضیحات قسمت annotationProcessor در Gradle
//یک پیکربندی وابستگی است که برای تعیین پردازنده های حاشیه نویسی مورد نیاز
// برای پردازش حاشیه نویسی در پروژه Android شما استفاده می شود. پردازشگرهای حاشیه نویسی ابزارهایی هستند
// که می توانند کد یا منابعی را بر اساس حاشیه نویسی در کد منبع شما تولید کنند.
//به عنوان مثال، اگر از ButterKnife برای پیوند دادن نماها با حاشیه نویسی استفاده می کنید، باید وابستگی زیر را به فایل build.gradle در سطح ماژول خود اضافه کنید:
//annotationProcessor 'com.jakewharton:butterknife-compiler:10.2.3'
//این به Gradle می گوید که از کامپایلر ButterKnife به عنوان یک پردازشگر حاشیه نویسی برای پروژه خود استفاده کند.