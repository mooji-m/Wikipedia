package com.mooji.cod.wikipedia.adapter

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.mooji.cod.wikipedia.data.ItemPost
import com.mooji.cod.wikipedia.databinding.ItemTrendBinding
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class TrendAdapter(private val data:ArrayList<ItemPost>) : RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding:ItemTrendBinding

    inner class TrendViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        fun bindViews(itemPost: ItemPost) {

            Glide
                .with(itemView.context)
                .load(itemPost.imgUrl)
                .transform( CenterCrop(),RoundedCornersTransformation(16 , 8) )
                .into(binding.imgTrend)

            binding.txtTrendTitle.text = itemPost.txtTitle

            binding.txtTrendSubtitle.text = itemPost.txtSubtitle

            binding.txtTrendInsight.text = itemPost.insight

            binding.txtNumber.text = (adapterPosition + 1).toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {

        binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return TrendViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) { //ست کردن مقادیر
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