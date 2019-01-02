package com.hw.ktweather

/**
 * Created by waylonhuang on 2019/1/1.
 */
//可点左边三角直接运行进行测试
fun main() {
    val loadWeather = WeatherService.loadWeather(CITY.CHENGDU.id)
    println(loadWeather)
}

object WeatherService {
    private const val WEATHER_URL = "http://www.weather.com.cn/data/sk/%d.html"
    //TODO 2、根据url，获取返回数据并反序列化为WeatherInfo对象
    fun loadWeather(cityId:Int){//: WeatherInfo {
        val url = WEATHER_URL.format(cityId)

        throw IllegalStateException("TODO")
    }
}

enum class CITY(val id: Int) {
    SANYA(101310201),
    CHENGDU(101270101)

}

//TODO 1、Weather及WeatherInfo数据类
//data class Weather()
//data class WeatherInfo()