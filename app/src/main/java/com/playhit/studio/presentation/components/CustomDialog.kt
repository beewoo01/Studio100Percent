package com.playhit.studio.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.playhit.studio.R
import com.playhit.studio.presentation.theme.Studio100PercentTheme

@Preview
@Composable
fun CustomDialog(
    modifier: Modifier = Modifier,
    title: String = "",
    content: String = "",
    buttonTitle : String = "확인",
    callback: () -> Unit = {}
) {

    Studio100PercentTheme {
        Dialog(
            onDismissRequest = {},
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {

            Card(
                shape = RoundedCornerShape(15.dp)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(color = Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = modifier.height(36.dp))
                    Text(
                        title,
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = colorResource(R.color.black)
                        )
                    )
                    Spacer(modifier = modifier.height(60.dp))
                    Text(
                        content,
                        modifier = modifier.padding(horizontal = 50.dp),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = colorResource(R.color.grey300)
                        )
                    )
                    Spacer(modifier = modifier.height(60.dp))
                    DefaultBlackButton(
                        title = buttonTitle,
                        modifier = modifier.padding(horizontal = 20.dp),
                        onClick = callback
                    )



                    Spacer(modifier = modifier.height(26.dp))
                }
            }

        }
    }

}