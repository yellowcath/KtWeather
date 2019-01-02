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
//如果嫌手动写麻烦，可以下载Android Studio的插件,"JSON TO Kotlin Class",装好按option+K（或alt+K）,下面json拷进去可以自动生成
//data class Weather()
//data class WeatherInfo()


//{"weatherinfo":{"city":"鍖椾含","cityid":"101010100","temp":"27.9","WD":"鍗楅","WS":"灏忎簬3绾�","SD":"28%",
// "AP":"1002hPa","njd":"鏆傛棤瀹炲喌","WSE":"<3","time":"17:55","sm":"2.1","isRadar":"1","Radar":"JC_RADAR_AZ9010_JB"}}