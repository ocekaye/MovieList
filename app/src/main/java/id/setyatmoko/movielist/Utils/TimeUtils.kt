package id.setyatmoko.movielist.Utils

import kotlin.math.min

class TimeUtils {
    companion object {
        fun minutesToHours(_sec: Int) : IntArray{
            val sec = _sec * 60
            val hours = (sec / 3600)
            val remainder = sec - hours * 3600
            val mins = remainder / 60
            return intArrayOf(hours, mins)
        }

    }
}