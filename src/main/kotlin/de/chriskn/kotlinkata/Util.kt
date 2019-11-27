package de.chriskn.kotlinkata

class Util {

    inline fun <T> measureTimeMillis(loggingFunction: (Long) -> Unit,
                                     function: () -> T): T {
        return function.invoke()
    }


}