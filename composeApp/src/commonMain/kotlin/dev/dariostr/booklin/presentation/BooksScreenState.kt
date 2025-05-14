package dev.dariostr.booklin.presentation

import dev.dariostr.booklin.domain.Book

data class BooksScreenState(
    val books: List<Book> = emptyList()
)
