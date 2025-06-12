package com.playhit.studio.presentation.ui.terms

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R
import com.playhit.studio.presentation.components.DefaultBlackButton
import com.playhit.studio.presentation.router.LocalNavScreenController
import com.playhit.studio.presentation.router.NavRoutes
import com.playhit.studio.presentation.theme.Studio100PercentTheme

@Composable
fun TermsScreen() {
    Studio100PercentTheme {
        TermsView()
    }
}

@Composable
private fun TermsView(modifier: Modifier = Modifier) {
    val navController = LocalNavScreenController.current
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

        Spacer(modifier = Modifier.height(53.dp))

        val termsCheckState = remember { mutableStateOf(false) }
        val personalCheckState = remember { mutableStateOf(false) }
        val eventCheckState = remember { mutableStateOf(false) }
        val allCheckState = remember {
            derivedStateOf {
                termsCheckState.value && personalCheckState.value && eventCheckState.value
            }
        }



        AllCheckBox(
            checked = allCheckState.value,
            value = "모두 동의합니다.",
            onClick = {
                termsCheckState.value = it
                personalCheckState.value = it
                eventCheckState.value = it
            })

        Box(modifier = Modifier.padding(horizontal = 20.dp)) {
            Row {
                Spacer(modifier = modifier.width(20.dp))
                Text(
                    text = "전체동의는 필수 및 선택정보에 대한 동의도 포함되어 있으며, 개별적으로도 동의를 선택하실 수 있습니다. 선택항목에 대한 동의를 거부하시는 경우에도 서비스는 이용이 가능합니다.",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(R.color.grey500)
                )
            }

        }

        Spacer(modifier = modifier.height(34.dp))

        HorizontalDivider(color = colorResource(R.color.grey100))

        Spacer(modifier = modifier.height(10.dp))

        CheckBox(
            checked = termsCheckState.value,
            value = "[필수] 스튜디오백퍼센트 약관",
            onClick = {
                termsCheckState.value = it
            },
            onMoreClick = {

            }
        )

        CheckBox(
            checked = personalCheckState.value,
            value = "[필수] 개인정보 수집 및 이용 동의",
            onClick = {
                personalCheckState.value = it
            },
            onMoreClick = {

            }
        )

        CheckBox(
            checked = eventCheckState.value,
            value = "[선택] 이벤트 알림 수신에 동의합니다.",
            onClick = {
                eventCheckState.value = it
            },
            onMoreClick = {

            }
        )

        Spacer(modifier = Modifier.height(height = 20.dp))

        val context = LocalContext.current

        DefaultBlackButton(
            onClick = {

                if (!termsCheckState.value && !personalCheckState.value) {
                    Toast.makeText(context, "필수항목에 동의를 해주세요.", Toast.LENGTH_SHORT).show()
                    return@DefaultBlackButton
                }

                navController.navigate(NavRoutes.Join.route)

                return@DefaultBlackButton
            },
            title = "동의"
        )

    }
}


@Composable
@Preview(showBackground = true)
fun TermsScreenPreview() {
    TermsView()
}

@Composable
fun CheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    value: String = "",
    onClick: (Boolean) -> Unit = {},
    onMoreClick: () -> Unit
) {

    val iconTint by animateColorAsState(
        targetValue = if (checked) Color.Black else Color.Gray,
        animationSpec = tween(durationMillis = 600),
        label = "checkBoxColor"
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(modifier = Modifier, onClick = {
            onClick(!checked)
        }) {
            Icon(
                modifier = modifier.size(20.dp),
                painter = painterResource(R.drawable.icon_checkbox_unchecked),
                tint = iconTint,
                contentDescription = if (checked) "checked" else "Unchecked",

                )
        }

        Text(value, style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.weight(1f))

        IconButton(onClick = onMoreClick) {
            Icon(
                modifier = modifier.size(12.dp),
                painter = painterResource(R.drawable.icon_arrow_forward),
                contentDescription = "more"
            )
        }


    }
}

@Composable
fun AllCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    value: String = "",
    onClick: (Boolean) -> Unit = {}
) {

    val iconTint by animateColorAsState(
        targetValue = if (checked) Color.Black else Color.Gray,
        animationSpec = tween(durationMillis = 600),
        label = "checkBoxColor"
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
        IconButton(modifier = Modifier, onClick = {
            onClick(!checked)
        }) {
            Icon(
                modifier = modifier.size(20.dp),
                painter = painterResource(R.drawable.icon_checkbox_unchecked),
                tint = iconTint,
                contentDescription = if (checked) "checked" else "Unchecked",

                )
        }

        Text(value, style = MaterialTheme.typography.titleMedium)
    }
}