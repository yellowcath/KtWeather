package com.hw.ktweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showWeather()
//        showMostWeather()
    }

    /**
     * TODO 4、调用[WeatherService.loadWeather]获取并展示[CITY.SANYA]与[CITY.CHENGDU]的天气
     * 请使用协程
     */
    private fun showWeather() {

    }

    /**
     * TODO 7、从assets的city.txt里读取城市列表，展示气温最低和最高的城市
     */
    private fun showMostWeather() {
        val cityList = loadCityList()
    }

    /**
     * TODO 3、将WeatherInfo转为所需的展示信息
     */
//    private fun formatWeather(weatherInfo: WeatherInfo): String {
//    }

    private fun loadCityList(): List<Int> {
        val cityFileContentList = getCityFileContent()
        //TODO 6、将city.txt的内容转为城市id列表
        throw IllegalStateException("TODO")
    }

    //TODO 5、读取city.txt的内容
    private fun getCityFileContent(): List<String> {
        throw IllegalStateException("TODO")
    }
}
