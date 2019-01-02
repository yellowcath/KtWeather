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
        val wxworkDir = getWwDir()
        //查找所有Module的目录
        findModuleDir(wxworkDir)
        wxworkDir.listFiles().forEach { findModuleDir(it) }
        //分析各个Module,填充module的内容
        moduleList.forEach {
            findJavaFile(it, File(it.modulePath))
        }

        var otherSum = 0 //其它目录包含的代码行数
        moduleList.forEach {
            if (it.name == "android_trunk") {
                totalCodeLine = it.javaCodeLines
            } else {
                otherSum += it.javaCodeLines
            }
        }
        //计算app Module的代码行数
        moduleList.filter { it.name == "app" }.map { it.javaCodeLines = totalCodeLine - otherSum }
        //根据代码行数多少进行排序
        moduleList.sortBy { it.javaCodeLines }
        //输出结果
        moduleList.forEach(::showModuleInfo)
    }

    private fun showModuleInfo(moduleInfo: ModuleInfo) {
        val str = "%30s,JavaLine:%8d,percent:%.2f%%".format(moduleInfo.name,
            moduleInfo.javaCodeLines,
            moduleInfo.javaCodeLines / totalCodeLine.toFloat() * 100)
        println(str)
    }
    private fun findModuleDir(file: File) {
        if (file.isDirectory) {
            if (file.isModuleDir()) {
                moduleList.add(ModuleInfo(file.absolutePath, 0, 0))
            } else {
                file.listFiles().filter { it.isDirectory }.forEach { findModuleDir(it) }
            }
        }
    }

    private fun File.isModuleDir(): Boolean {
        return this.listFiles().filter { it.name.equals("build.gradle") }.count() > 0
    }

    private fun findJavaFile(moduleInfo: ModuleInfo, file: File) {
        if (file.isDirectory) {
            file.listFiles().filter { it.name != "build" && it.name != "res" }.forEach {
                findJavaFile(moduleInfo, it)
            }
        } else if (file.name.endsWith(".java")) {
            moduleInfo.run {
                javaFileCount += 1
                javaCodeLines += file.readLines().size
            }

        }
    }

    data class ModuleInfo(val modulePath: String, var javaFileCount: Int, var javaCodeLines: Int){
        val name: String = File(modulePath).name
    }
}