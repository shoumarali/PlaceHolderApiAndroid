package com.alishoumar.placeholder.presentation.screens.comments

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.alishoumar.placeholder.domain.models.comment.Comment

@Composable
fun CommentContent(
    comments:List<Comment>,
    paddingValues: PaddingValues
) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = paddingValues.calculateTopPadding())
            .background(MaterialTheme.colorScheme.surface)
    ){
        comments.forEachIndexed{ i: Int, comment: Comment ->

            item(key = i){
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    horizontalArrangement = Arrangement.Start
                ){
                    Column (
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.surfaceVariant)
                            .padding(start = 12.dp)
                    ){
                        Text(text = "Name: ${comment.name}",
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(all = 12.dp))
                        Spacer(modifier = Modifier.size(12.dp))
                        Text(text = "Comment: ${comment.body}",
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(all = 12.dp))
                    }
                }
                Spacer(modifier = Modifier.size(12.dp))
            }
        }
    }
}