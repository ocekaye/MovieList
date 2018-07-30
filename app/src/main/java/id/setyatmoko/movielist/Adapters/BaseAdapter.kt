package id.setyatmoko.movielist.Adapters

import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder?>() : RecyclerView.Adapter<VH>() {
    private val list = ArrayList<T>()
    constructor(_list : ArrayList<T>) : this() {
        list.addAll(_list)
    }

    fun add(item : T){
        list.add(item)
        notifyDataSetChanged()
    }

    fun add(item : T, pos : Int){
        list.add(pos, item)
        notifyItemInserted(pos)
    }

    fun add(items : List<T>){
        val l = list.size
        list.addAll(items)
        notifyItemRangeChanged(l, list.size-1)
//        notifyDataSetChanged()
    }

    fun get(pos : Int) : T{
        return list[pos]
    }

    fun remove(pos: Int){
        list.removeAt(pos)
        notifyItemRemoved(pos)
    }

    fun clear(){
        list.clear()
        notifyDataSetChanged()
    }

    fun getAll() : List<T>{
        return list
    }

    override fun getItemCount(): Int {
        return list.size
    }
}