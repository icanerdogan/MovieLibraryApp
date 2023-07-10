package com.ibrahimcanerdogan.movielibraryapp.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieSearchBar(
    modifier: Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }

    Box(modifier = modifier) {
        TextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            keyboardActions = KeyboardActions(onDone =  {
                onSearch(searchQuery)
            }),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape(3.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(2.dp, CircleShape)
                .background(Color.White, CircleShape)
                .onFocusEvent {
                    isHintDisplayed = it.isFocused == true || searchQuery.isEmpty()
                },
            placeholder = { Text(text = "Search Movie or Series!", fontSize = 13.sp) }
        )

        if (isHintDisplayed) {
            Text(text = hint, color = Color.LightGray, modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp))
        }
    }
}