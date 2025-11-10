package com.example.uipatternstudy

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class IconItem(val image: String, val label: String)

data class BannerItem(val text: String, val image: String)

data class MainData(
    val icons: List<IconItem>,
    val banners: List<BannerItem>
)

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    private val _mainData = MutableStateFlow<MainData?>(null)
    val mainData: StateFlow<MainData?> = _mainData

    init {
        loadJsonData()
    }

    private fun loadJsonData() {
        val json = """
            {
                "icons":[
                    {"image": "ac_unit_24", "label": "아이콘1"},
                    {"image": "access_alarm_24", "label": "아이콘2"},
                    {"image": "airplanemode_active_24", "label": "아이콘3"},
                    {"image": "airport_shuttle_24", "label": "아이콘4"},
                    {"image": "auto_awesome_24", "label": "아이콘5"},
                    {"image": "auto_stories_24", "label": "아이콘6"},
                    {"image": "bedtime_24", "label": "아이콘7"},
                    {"image": "chair_24", "label": "아이콘8"}
                ],
                "banners":[
                    {"text": "아이콘8", "image": "chair_24"},
                    {"text": "아이콘7", "image": "bedtime_24"},
                    {"text": "아이콘6", "image": "auto_stories_24"}
                ]
            }
        """.trimIndent()
        _mainData.value = Gson().fromJson(json, MainData::class.java)
    }
}