package com.paawk4.harrypotterapp.presentation.guide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.paawk4.harrypotterapp.R
import com.paawk4.harrypotterapp.databinding.ItemGuideBinding
import com.paawk4.harrypotterapp.domain.guide.Guide


class GuideAdapter(private val context: Context, private val list: List<Guide>) :
    BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var guideTextView: TextView
    private lateinit var guideImageView: ImageView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any? {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if(layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if(view == null) {
            view = layoutInflater!!.inflate(R.layout.item_guide, null)
        }
        guideTextView = view!!.findViewById(R.id.guide_item_title)
        guideImageView = view.findViewById(R.id.guide_item_image)
        guideTextView.text = list[position].title
        guideImageView.setImageResource(list[position].image)
        return view
    }
}