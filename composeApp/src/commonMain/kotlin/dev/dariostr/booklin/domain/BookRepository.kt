package dev.dariostr.booklin.domain

import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getBooks(): Flow<List<Book>>        // reactive stream of books
    suspend fun addBook(book: Book)
    suspend fun updateBook(book: Book)
    suspend fun deleteBook(bookId: Int)
    suspend fun getBookById(bookId: Int): Book?
}