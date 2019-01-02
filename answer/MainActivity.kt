package com.hw.ktweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        showWeather()
        showMostWeather()
    }

    private fun showWeather() {
        GlobalScope.launch {
            val cdDeferred = async { WeatherService.loadWeather(CITY.CHENGDU.id) }
            launch(Dispatchers.Main) { leftTxt.text = formatWeather(cdDeferred.await()) }

            val sanyaDeferred = async { WeatherService.loadWeather(CITY.SANYA.id) }
            launch(Dispatchers.Main) { rightTxt.text = formatWeather(sanyaDeferred.await()) }
        }
    }

    private fun showMostWeather() {
        val cityList = loadCityList()
        GlobalScope.launch {
            val weatherDeferredList = cityList.map {
                async {
                    WeatherService.loadWeather(it)
                }
            }
            val weatherInfoList = weatherDeferredList.map { it.await() }.filterNot { it.temp.equals("暂无实况") }.map { Log.i("hwLog",it.toString());it }
            val sortedList = weatherInfoList.sortedBy { it.temp.toFloatOrNull() }
            launch(Dispatchers.Main) {
                leftTxt.text = formatWeather(sortedList[0])
                rightTxt.text = formatWeather(sortedList[sortedList.size-1])
            }
        }
    }

    private fun formatWeather(weatherInfo: WeatherInfo): String {
        return "${weatherInfo.city}\n温度:${weatherInfo.temp}\n湿度:${weatherInfo.SD}\n${weatherInfo.WD}:${weatherInfo.WS}"
    }

    private fun loadCityList(): List<Int> {
        return getCityFileContent().map { it.split('=')[0].toInt() }
    }

    private fun getCityFileContent(): List<String> {
        return resources.assets.open("city.txt").use {
              InputStreamReader(it).readLines()
        }
    }
}
