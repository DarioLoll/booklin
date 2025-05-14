package dev.dariostr.booklin.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.dariostr.booklin.domain.Book

@Composable
fun BooksScreen() {
    val testState: BooksScreenState by remember {
        mutableStateOf(BooksScreenState(listOf(
            Book(500, "Test Book", "dario", 200, 20),
            Book(501, "ABCs", "test", 100, 50),
            Book(502, "Harry Potter", "J. K. Rowling", 200, 188)
        )))
    }
    BooksScreenCore(testState)
}

@Composable
fun BooksScreenCore(
    state: BooksScreenState = BooksScreenState(),
    onAction: (BooksScreenAction) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onAction(BooksScreenAction.AddBook) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Add Book")
        }
        Spacer(Modifier.padding(8.dp))
        LazyColumn {
            items(state.books) { book ->
                BookItem(book = book)
            }
        }
    }
}