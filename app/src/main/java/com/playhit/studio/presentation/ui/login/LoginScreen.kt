package com.playhit.studio.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.playhit.studio.R
import com.playhit.studio.presentation.components.DefaultBlackButton
import com.playhit.studio.presentation.components.RoundedTextField
import com.playhit.studio.presentation.router.LocalNavScreenController
import com.playhit.studio.presentation.router.NavRoutes

@Composable
fun LoginScreen() {

    LoginView()

}

@Composable
private fun LoginView(modifier: Modifier = Modifier) {

    var idState by remember { mutableStateOf("") }
    var pwState by remember { mutableStateOf("") }

    val navController = LocalNavScreenController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.textGrey))
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.login_logo),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(0.4f)
                .aspectRatio(145f / 107f)

        )

        Spacer(modifier = Modifier.height(35.dp))

        RoundedTextField(
            value = idState,
            onValueChange = { idState = it },
            hint = "아이디 입력",
        )

        Spacer(modifier = Modifier.height(10.dp))

        RoundedTextField(
            value = pwState,
            onValueChange = { pwState = it },
            hint = "비밀번호 입력",
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            TextButton(
                onClick = {
                    navController.navigate(NavRoutes.Find.route + "/0")
                    //navController.navigate(NavRoutes.PokemonDetail.route + "/${pokemonCardInfo.pokedexId}")
                },
            ) {
                Text(
                    text = "아이디 찾기",
                    style = TextStyle(color = Color.Black)
                )
            }

            VerticalDivider(
                modifier = Modifier.height(17.dp),
                color = Color.Black
            )

            TextButton(
                onClick = {
                    navController.navigate(NavRoutes.Find.route + "/1")
                },
            ) {
                Text(
                    text = "비밀번호 찾기",
                    style = TextStyle(color = Color.Black)
                )
            }
        }

        Spacer(modifier = Modifier.height(17.dp))

        DefaultBlackButton(
            onClick = {},
            title = "로그인"
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_instar),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(54.dp)
                )
            }

            Spacer(modifier = Modifier.width(42.dp))

            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_apple),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(54.dp)
                )
            }
            Spacer(modifier = Modifier.width(42.dp))
            IconButton(
                onClick = {},
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_google),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier.size(54.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(17.dp))

        Button(
            onClick = {
                navController.navigate(NavRoutes.Terms.route)
            },
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text("회원가입",
                style = MaterialTheme.typography.labelLarge,
                color = Color.Black
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
private fun LoginScreenPreview() {
    LoginView()
}