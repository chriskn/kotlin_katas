package de.chriskn.kotlinkata

class Util {

    inline fun <T> measureTimeMillis(loggingFunction: (Long) -> Unit,
                                     function: () -> T): T {
        val before = System.currentTimeMillis()
        val result = function.invoke()
        loggingFunction.invoke(System.currentTimeMillis() - before)
        return result
    }


}