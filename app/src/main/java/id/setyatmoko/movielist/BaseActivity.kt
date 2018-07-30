package id.setyatmoko.movielist

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

abstract class BaseActivity : AppCompatActivity() {
    lateinit var toolbar : Toolbar
}