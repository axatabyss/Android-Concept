package com.axat.androidconcept.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ParticleAnimationScreen() {

    val particles = listOf<Particle>(
        Particle(Offset(100f, 1820f), Offset(1f, -2f)),
        Particle(Offset(200f, 1680f), Offset(-0.5f, -1.5f)),
        Particle(Offset(300f, 1700f), Offset(0.2f, -1.8f)),
        Particle(Offset(400f, 1850f), Offset(-0.8f, -2f)),
        Particle(Offset(500f, 1800f), Offset(0.4f, -1.2f)),
        Particle(Offset(600f, 1960f), Offset(1f, -2f)),
        Particle(Offset(700f, 1980f), Offset(-0.5f, -1.5f)),
        Particle(Offset(800f, 2010f), Offset(0.2f, -1.8f)),
        Particle(Offset(900f, 1950f), Offset(-0.8f, -2f)),
        Particle(Offset(750f, 2000f), Offset(0.4f, -1.2f)),
        Particle(Offset(100f, 1780f), Offset(1f, -2f)),
        Particle(Offset(200f, 1790f), Offset(-0.5f, -1.5f)),
        Particle(Offset(300f, 1805f), Offset(0.2f, -1.8f)),
        Particle(Offset(400f, 1815f), Offset(-0.8f, -2f)),
        Particle(Offset(500f, 1825f), Offset(0.4f, -1.2f)),
        Particle(Offset(600f, 1915f), Offset(1f, -2f)),
        Particle(Offset(700f, 1922f), Offset(-0.5f, -1.5f)),
        Particle(Offset(800f, 2014f), Offset(0.2f, -1.8f)),
        Particle(Offset(900f, 2012f), Offset(-0.8f, -2f)),
        Particle(Offset(750f, 2004f), Offset(0.4f, -1.2f))
    )


    Scaffold {

        ParticleSystem(particles)

    }

}

@Composable
fun ParticleSystem(
    particles: List<Particle>,
    modifier: Modifier = Modifier
) {

    val mutableParticles = remember { mutableStateListOf<Particle>() }
    mutableParticles.addAll(particles)

    var counter = 0

    LaunchedEffect(Unit) {
        while (true) {
            val particlesCopy = ArrayList(mutableParticles.map { it.copy() })
            particlesCopy.forEachIndexed { index, particle ->
                mutableParticles[index] = particle.copy(position = particle.position + particle.velocity)
            }
            delay(16L)
            counter += 1

            if (counter > 3000) {
                break
            }
        }
    }

    Canvas(
        modifier = modifier.fillMaxSize()
    ) {
        mutableParticles.forEach { particle ->
            drawCircle(color = Color.Blue, alpha = 0.6F, center = particle.position, radius = 10f)
        }
    }
}




data class Particle(
    val position: Offset,
    val velocity: Offset
)