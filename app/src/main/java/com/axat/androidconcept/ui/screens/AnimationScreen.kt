package com.axat.androidconcept.ui.screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AnimationScreen() {

    val position = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        while (true) {
            val myRandomValue = Random.nextFloat() * (900f - 100f) + 100f
            position.animateTo(
                targetValue = myRandomValue,
                animationSpec = tween(durationMillis = 3000)
            ).apply {
                val myRandomValue1 = Random.nextFloat() * (900f - 100f) + 100f
                position.animateTo(
                    targetValue = myRandomValue1,
                    animationSpec = tween(durationMillis = 3000)
                ).apply {
                    val myRandomValue2 = Random.nextFloat() * (900f - 100f) + 100f
                    position.animateTo(
                        targetValue = myRandomValue2,
                        animationSpec = tween(durationMillis = 3000)
                    )
                }
            }
        }
    }

    Scaffold {

        Canvas(
            modifier = Modifier.fillMaxSize().background(Color.White)
        ) {
            drawCircle(color = Color.Red, center = Offset(position.value, 500f), radius = 50f)
            drawCircle(color = Color.Blue, center = Offset(position.value, 700f), radius = 80f)
            drawCircle(color = Color.Magenta, center = Offset(position.value, 1000f), radius = 150f)
            drawCircle(color = Color.Yellow, center = Offset(position.value, 1400f), radius = 190f)
        }

    }

}


