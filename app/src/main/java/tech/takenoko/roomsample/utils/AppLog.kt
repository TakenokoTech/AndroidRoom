package tech.takenoko.roomsample.utils

import android.util.Log

object AppLog {

    val LOG_FORMAT: String = "<AppLog>%s"
    fun Boolean.toInt() = if (this) 1 else 0

    private fun isCurrent(): String {
        return ""//[${Thread.currentThread().equals(getMainLooper().getThread()).toInt()}]"
    }

    fun debug(tag: String?, msg: String) {
        Log.d(String.format(LOG_FORMAT, tag, isCurrent()), msg)
    }

    fun info(tag: String?, msg: String) {
        Log.i(String.format(LOG_FORMAT, tag, isCurrent()), msg)
    }

    fun error(tag: String?, msg: String) {
        Log.e(String.format(LOG_FORMAT, tag, isCurrent()), msg)
    }

    fun warn(tag: String?, t: Throwable) {
        Log.w(String.format(LOG_FORMAT, tag, isCurrent()), t)
    }
}