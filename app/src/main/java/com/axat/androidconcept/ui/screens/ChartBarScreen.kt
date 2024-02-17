package com.axat.androidconcept.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
@Preview(showBackground = true)
fun ChartBarScreen() {

    val chartList = listOf(
        20f, 45f, 15f, 75f, 55f
    )
    val colorList = listOf(
        Color.Cyan, Color.Magenta, Color.Gray, Color.Red, Color.Blue, Color.Green, Color.Yellow
    )


    Scaffold {

        Box(
            contentAlignment = Alignment.Center
        ) {
            ChartBar(data = chartList, colorList = colorList)
        }

    }

}




@Composable
fun ChartBar(
    data: List<Float>,
    colorList: List<Color>,
    modifier: Modifier = Modifier
) {

    val maxBarValue = data.maxOf { it }

    Canvas(
        modifier = modifier.fillMaxSize().padding(top = 20.dp, start = 20.dp, end = 20.dp)
    ) {

        val maxBarHeight = size.height
        val barWidth = size.width / data.size

        data.forEachIndexed { index, fl ->

            val barHeight = (fl / maxBarValue) * maxBarHeight

            drawRect(
                color = colorList.random(),
                topLeft = Offset(index * barWidth, size.height - barHeight),
                size = Size(barWidth, barHeight)
            )

        }


    }

}