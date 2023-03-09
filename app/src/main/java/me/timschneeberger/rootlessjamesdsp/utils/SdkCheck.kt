package me.timschneeberger.rootlessjamesdsp.utils

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast

class SdkCheckElseBranch<T>(private val result: T?) {
    fun valueOrNull(): T? = result
    fun below(onFailure: () -> T): T = result ?: onFailure()
}

@ChecksSdkIntAtLeast(parameter = 0, lambda = 1)
inline fun <T> sdkAbove(sdk: Int, onSuccessful: () -> T): SdkCheckElseBranch<T> {
    (Build.VERSION.SDK_INT >= sdk).let {
        return SdkCheckElseBranch<T>(if(it) onSuccessful() else null)
    }
}

object SdkCheck {
    private val sdk: Int
        get() = Build.VERSION.SDK_INT

    @get:ChecksSdkIntAtLeast(api = Build.VERSION_CODES.TIRAMISU)
    val isTiramisu: Boolean
        get() = sdk >= Build.VERSION_CODES.TIRAMISU

    @get:ChecksSdkIntAtLeast(api = Build.VERSION_CODES.R)
    val isR: Boolean
        get() = sdk >= Build.VERSION_CODES.R

    @get:ChecksSdkIntAtLeast(api = Build.VERSION_CODES.P)
    val isPie: Boolean
        get() = sdk >= Build.VERSION_CODES.P

    @get:ChecksSdkIntAtLeast(api = Build.VERSION_CODES.O)
    val isOreo: Boolean
        get() = sdk >= Build.VERSION_CODES.O

    @get:ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
    val isSnowCake: Boolean
        get() = sdk >= Build.VERSION_CODES.S

    @get:ChecksSdkIntAtLeast(api = Build.VERSION_CODES.N)
    val isNougat: Boolean
        get() = sdk >= Build.VERSION_CODES.N
}