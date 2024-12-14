package com.montenegro.weatherapp.ui.screen.componets

import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Extensión de Modifier para agregar una sombra personalizada a un componente.
 *
 * @param color El color de la sombra. Por defecto es negro.
 * @param alpha La opacidad de la sombra. Por defecto es 0.5.
 * @param bordeRadius El radio de los bordes redondeados. Por defecto es 0.dp.
 * @param shadowRadius El radio de la sombra. Por defecto es 0.dp.
 * @param offsetY El desplazamiento vertical de la sombra. Por defecto es 0.dp.
 * @param offsetX El desplazamiento horizontal de la sombra. Por defecto es 0.dp.
 * @return Un Modifier con la sombra personalizada aplicada.
 */
@Stable
fun Modifier.customShadow(
    color: Color = Color.Black,
    alpha: Float = 0.5f,
    bordeRadius: Dp = 0.dp,
    shadowRadius: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
) = drawBehind {
    // Convertir el color de la sombra a ARGB con la opacidad especificada
    val shadowColor = color.copy(alpha = alpha).toArgb()
    // Crear un color transparente para el fondo
    val transparent = color.copy(alpha = 0f).toArgb()

    // Dibujar en el lienzo
    this.drawIntoCanvas {
        val paint = Paint()
        val framePaint = paint.asFrameworkPaint()
        framePaint.color = transparent

        // Configurar la capa de sombra
        framePaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )

        // Dibujar un rectángulo redondeado con la sombra aplicada
        it.drawRoundRect(
            0f,
            0f,
            this.size.width,
            this.size.height,
            bordeRadius.toPx(),
            bordeRadius.toPx(),
            paint
        )
    }
}
