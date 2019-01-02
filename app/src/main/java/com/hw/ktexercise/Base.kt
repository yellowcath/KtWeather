package com.hw.ktexercise

import java.io.File

/**
 * Created by waylonhuang on 2019/1/2.
 */

fun getRootDir(): File {
    return File("").canonicalFile
}

fun getWwDir(): File {
    return File(getRootDir().absolutePath+"/../wxwork/src/android_trunk").canonicalFile
}