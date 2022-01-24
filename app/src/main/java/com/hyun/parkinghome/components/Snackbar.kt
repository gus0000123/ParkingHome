package com.hyun.parkinghome.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextSnackbar(content: @Composable () -> Unit) {
    Snackbar(modifier = Modifier.padding(16.dp), actionOnNewLine = true, action = { content }) {
        Text(text = "등록이 완료되었습니다.")
    }
}

@Preview
@Composable
fun previewTextSnackBar() {
    TextSnackbar({})
}