package dev.dariostr.booklin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform