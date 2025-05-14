package dev.dariostr.booklin.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.dariostr.booklin.domain.Book

@Composable
fun BookItem(
    modifier: Modifier = Modifier,
    book: Book,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = modifier.clickable(onClick = onClick)
            .height(IntrinsicSize.Min)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Surface(
            modifier = Modifier.height(100.dp)
                .border(
                    1.dp,
                    MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(10.dp)
                )
                .weight(1f)
        ) {
            Icon(
                Icons.Default.Menu,
                "Book image",
                modifier = Modifier.padding(16.dp)
            )
        }
        Column(
            modifier = Modifier.weight(3f)
                .padding(horizontal = 16.dp, vertical = 8.dp),

            ) {
            Text(
                text = book.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = book.author,
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "${book.pagesRead}/${book.pages} Pages",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        val progress = book.pagesRead.toFloat() / book.pages
        CircularProgress(
            modifier = Modifier.weight(1f),
            progress = progress
        ) {
            Text(
                text = "${progress*100}%",
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
        }
    }
}