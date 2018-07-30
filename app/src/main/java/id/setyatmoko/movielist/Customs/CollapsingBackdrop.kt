package id.setyatmoko.movielist.Customs

import android.content.Context
import android.support.design.widget.CollapsingToolbarLayout
import android.util.AttributeSet
import android.widget.ImageView

class CollapsingBackdrop : CollapsingToolbarLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = measuredWidth
        setMeasuredDimension(width, (width/2) + (width/8))
    }
}