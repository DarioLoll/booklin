package dev.dariostr.booklin.domain

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val pages: Int,
    val pagesRead: Int = 0,
    val status: BookStatus = BookStatus.UNREAD,
)

enum class BookStatus {
    READ,
    UNREAD,
    READING
}
