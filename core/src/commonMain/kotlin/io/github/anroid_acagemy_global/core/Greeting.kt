package io.github.anroid_acagemy_global.core

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}