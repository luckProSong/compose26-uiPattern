package com.example.uipatternstudy

object DrawableUtil {
    private val drawableMap = mapOf(
        "ac_unit_24" to R.drawable.ac_unit_24,
        "access_alarm_24" to R.drawable.access_alarm_24,
        "bairplanemode_active_24" to R.drawable.airplanemode_active_24,
        "airport_shuttle_24" to R.drawable.airport_shuttle_24,
        "auto_awesome_24" to R.drawable.auto_awesome_24,
        "auto_stories_24" to R.drawable.auto_stories_24,
        "bedtime_24" to R.drawable.bedtime_24,
        "chair_24" to R.drawable.chair_24,
    )

    fun getDrawableId(name: String): Int {
        return drawableMap[name] ?: R.drawable.chair_24
    }
}