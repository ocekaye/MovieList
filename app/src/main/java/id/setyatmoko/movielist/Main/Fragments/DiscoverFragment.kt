package id.setyatmoko.movielist.Main.Fragments

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wang.avi.AVLoadingIndicatorView
import id.setyatmoko.movielist.R
import id.setyatmoko.movielist.Main.Adapters.DiscoverAdapter
import id.setyatmoko.movielist.API.Models.Discover
import id.setyatmoko.movielist.API.ServiceGenerator
import id.setyatmoko.movielist.API.Services.DiscoverService
import id.setyatmoko.movielist.BaseActivity
import id.setyatmoko.movielist.BaseFragment
import jp.wasabeef.recyclerview.animators.FadeInUpAnimator
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverFragment : BaseFragment() {
    override var title: String
        get() = "Discover"
        set(value) {title = value}
    private lateinit var rvContent : RecyclerView
    private lateinit var adapter : DiscoverAdapter
    private var callDiscover : Call<Discover>? = null
    private lateinit var loading : AVLoadingIndicatorView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_discover, container, false)
        rvContent = v.findViewById(R.id.rv_content)
        loading = v.findViewById(R.id.loading)
        rvContent.layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        adapter = DiscoverAdapter(activity as BaseActivity)
        rvContent.adapter = adapter
        rvContent.itemAnimator = FadeInUpAnimator()
        rvContent.itemAnimator.addDuration = 500
        rvContent.isNestedScrollingEnabled = false
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val discover = ServiceGenerator.createService(context!!, DiscoverService::class.java)
        callDiscover = discover.getDiscoverYear(2018)
        callDiscover!!.enqueue(object : Callback<Discover> {
            override fun onResponse(call: Call<Discover>, response: Response<Discover>) {
                adapter.add(response.body()?.results!!)
                loading.hide()
            }
            override fun onFailure(call: Call<Discover>, t: Throwable) {
                Log.e("error", t.message)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.clear()
    }

    override fun onPause() {
        super.onPause()
        callDiscover!!.cancel()
    }
}
