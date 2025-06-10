package com.playhit.android.presentation.ui.splash

import android.widget.Space
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.android.R
import com.playhit.android.presentation.theme.Studio100PercentTheme
import kotlinx.coroutines.delay

@Composable
fun CustomSplashScreen() {
    Scaffold(
        content = {
            CustomSplashView(modifier = Modifier.padding(it))
        }
    )
}

@Composable
fun CustomSplashView(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.white)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val rotation = remember { Animatable(0f) }

        LaunchedEffect(Unit) {
            rotation.animateTo(
                targetValue = 360f,
                animationSpec = keyframes {
                    durationMillis = 1200
                    360f at 800 // 회전 완료 시점
                    340f at 900
                    350f at 1000
                    360f at 1200
                    // at 기준으로 앞은 물체의 각도 뒤는 시간이다.
                    //durationMillis = 1200 로 설정했으니 1200은 최종적으로 완료 되었을 때의 모습이 될 것이다.
                }
            )
        }

        Spacer(modifier = Modifier.height(1.dp))

        Image(
            painter = painterResource(id = R.drawable.splash_logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .aspectRatio(114f / 82f)
                //.align(Alignment.Center)
                .graphicsLayer {
                    rotationZ = rotation.value
                }
        )

        Column {
            Image(
                painter = painterResource(id = R.drawable.splash_logo_bottom),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(0.3f)
                    .aspectRatio(4f / 1f)
            )
            Spacer(modifier = Modifier.height(42.dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CustomSplashScreenPreview() {
    Studio100PercentTheme {
        CustomSplashView()
    }

}