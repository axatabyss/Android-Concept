package com.axat.androidconcept.features.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PlaygroundScreen(
    navController: NavController
) {

    Scaffold {
        CanvasDraw()
    }

}


@Composable
@Preview(showBackground = true)
fun CanvasDraw() {


    Box(
        contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {

            val canvasWidth = size.width
            val canvasHeight = size.height


            translate(left = 500f) {
                drawCircle(Color.Blue, radius = 200.dp.toPx())
            }

            drawArc(
                color = Color.Yellow,
                topLeft = Offset((canvasWidth - 100f) / 2, (canvasHeight - 100f) / 2),
                size = Size(400f, 400f),
                startAngle = 0f,
                sweepAngle = 50f,
                useCenter = true
            )

            drawLine(
                start = Offset(x = canvasWidth, y = 0f),
                end = Offset(x = 0f, y = canvasHeight),
                strokeWidth = 10f,
                color = Color.Green
            )

        }


        Spacer(
            modifier = Modifier
                .drawWithCache {
                    val path = Path()
                    path.moveTo(0f, 0f)
                    path.lineTo(size.width / 2f, size.height / 2f)
                    path.lineTo(size.width, 0f)
                    path.close()
                    onDrawBehind {
                        drawPath(path = path, Color.Magenta, style = Stroke(width = 10f))
                    }
                }
                .fillMaxSize()
        )


    }


}