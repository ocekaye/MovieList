package id.setyatmoko.movielist.Main

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.util.Log
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import id.setyatmoko.movielist.BaseActivity
import id.setyatmoko.movielist.BaseFragment
import id.setyatmoko.movielist.Main.Fragments.DiscoverFragment
import id.setyatmoko.movielist.Main.Fragments.MovieListFragment
import id.setyatmoko.movielist.Main.Fragments.NowPlayingFragment
import id.setyatmoko.movielist.R

class MainActivity : BaseActivity() {
    private lateinit var bottomNavigation : AHBottomNavigation
    private val bottomItems = ArrayList<AHBottomNavigationItem>()
    private val fragmentItems = ArrayList<BaseFragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        initBottomNavigation()

    }

    private fun initBottomNavigation(){
        bottomItems.add(AHBottomNavigationItem("Discover", R.drawable.theatre))
        fragmentItems.add(DiscoverFragment())
        bottomItems.add(AHBottomNavigationItem("List", R.drawable.film))
        fragmentItems.add(MovieListFragment())
        bottomItems.add(AHBottomNavigationItem("Now Playing", R.drawable.now_playing))
        fragmentItems.add(NowPlayingFragment())
        bottomNavigation.defaultBackgroundColor = ContextCompat.getColor(this, R.color.colorPrimary)
        bottomNavigation.addItems(bottomItems)
        bottomNavigation.setOnTabSelectedListener(onTabSelected)
        bottomNavigation.accentColor = Color.WHITE
        bottomNavigation.inactiveColor = Color.parseColor("#9E9E9E")
        bottomNavigation.currentItem = 0
    }

    private val onTabSelected : AHBottomNavigation.OnTabSelectedListener = AHBottomNavigation.OnTabSelectedListener { position, wasSelected ->
        onPageTabChange(position)
        true
    }

    private fun onPageTabChange(pos: Int){
        title = fragmentItems[pos].title
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_layout, fragmentItems[pos])
            commit()
        }
    }
}