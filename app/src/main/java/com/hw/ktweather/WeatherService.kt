package com.hw.ktweather

import kotlinx.serialization.Optional
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JSON
import java.net.URL

/**
 * Created by waylonhuang on 2019/1/1.
 */

fun main() {
    val loadWeather = WeatherService.loadWeather(CITY.CHENGDU.id)
    println(loadWeather)
}

object WeatherService {
    private const val WEATHER_URL = "http://www.weather.com.cn/data/sk/%d.html"
    fun loadWeather(cityId:Int): WeatherInfo {
        val url = WEATHER_URL.format(cityId)
        val resp = URL(url).readText()
        val weather = JSON.parse(Weather.serializer(),resp)
        return weather.weatherinfo
    }
}

enum class CITY(val id: Int) {
    SANYA(101310201),
    CHENGDU(101270101)

}
@Serializable
data class Weather(
    val weatherinfo: WeatherInfo
)
@Serializable
data class WeatherInfo(
    val AP: String,
    val Radar: String,
    val SD: String,
    val WD: String,
    val WS: String,
    val WSE: String,
    val city: String,
    val cityid: String,
    val isRadar: String,
    @Optional val njd: String = "",
    val sm: String,
    val temp: String,
    val time: String
)