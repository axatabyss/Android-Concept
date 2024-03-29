package com.axat.androidconcept.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.axat.androidconcept.navigation.NavigationRoute
import com.axat.androidconcept.ui.component.PulsateButton
import com.axat.androidconcept.ui.component.bounceClick

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {

    Scaffold() {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(vertical = 10.dp)
            ) {
                Text(
                    text = "Canvas",
                    style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.W500)
                )
                HorizontalDivider(
                    modifier = modifier.padding(vertical = 10.dp),
                    color = Color.Black
                )
            }


            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .weight(1f)
            ) {

                PulsateButton("Canvas Shapes") {
                    navController.navigate(NavigationRoute.SHAPES_SCREEN)
                }

                Spacer(modifier = modifier.height(20.dp))

                PulsateButton("BarChart") {
                    navController.navigate(NavigationRoute.CHARTBAR_SCREEN)
                }

                Spacer(modifier = modifier.height(20.dp))

                PulsateButton("Moving Animation") {
                    navController.navigate(NavigationRoute.ANIMATION_SCREEN)
                }

                Spacer(modifier = modifier.height(20.dp))

                PulsateButton("Particles Animation") {
                    navController.navigate(NavigationRoute.PARTICLE_ANIMATION_SCREEN)
                }

            }

        }
    }

}