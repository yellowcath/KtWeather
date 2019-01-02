package com.hw.ktexercise

import java.io.File

/**
 * Created by waylonhuang on 2019/1/2.
 */
fun main() {
    Exercise.doExercise()
}

object Exercise {
    val moduleList = ArrayList<ModuleInfo>()
    //总包含的代码行数
    var totalCodeLine = 0

    fun doExercise() {
        val wxworkDir = getWwDir() //如果当前工程和wxwork工程不在同一个目录，请自行修改该函数
        //TODO 1、查找所有Module的目录，根目录android_trunk也视为一个Module

        //TODO 2、分析各个Module,填充module的内容

        //TODO 3、计算app工程代码行数（android_trunk的代码行数减去所有其它Module之和，并写入对应的ModuleInfo

        //TODO 4、根据代码行数多少进行排序

        //TODO 5、输出所有结果
    }


    data class ModuleInfo(val modulePath: String, var javaFileCount: Int, var javaCodeLines: Int){
        val name: String = File(modulePath).name
    }
}