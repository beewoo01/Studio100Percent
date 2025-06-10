package com.playhit.android.presentation.ui.terms

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.android.R
import com.playhit.android.presentation.theme.Studio100PercentTheme

@Composable
fun TermsScreen() {
    Studio100PercentTheme {
        TermsView()
    }
}

@Composable
private fun TermsView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.textGrey))
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = null,
            modifier = Modifier
                .width(51.dp)
                .height(37.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "스튜디오백퍼센트 \n서비스약관에 동의해주세요.",
            style = MaterialTheme.typography.titleLarge
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = true, onCheckedChange = { state ->
                {

                }
            })

            Text("모두 동의합니다.", style = TextStyle())
        }
        Box(
            modifier = Modifier
                .width(51.dp)
                .height(37.dp)
                .background(color = Color.Blue)
        )
    }


    /*Image(
        painter = painterResource(id = R.drawable.login_logo),
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(0.4f)
            .aspectRatio(145f / 107f)

    )*/

}


@Composable
@Preview(showBackground = true)
fun TermsScreenPreview() {
    TermsView()
}