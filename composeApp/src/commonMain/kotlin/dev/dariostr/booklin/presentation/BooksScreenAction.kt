package dev.dariostr.booklin.presentation

sealed interface BooksScreenAction {
    data object AddBook : BooksScreenAction
    data object CancelAddBook : BooksScreenAction
    data class ConfirmAddBook(
        val bookTitle: String,
        val bookAuthor: String,
        val pages: Int
    ) : BooksScreenAction
}