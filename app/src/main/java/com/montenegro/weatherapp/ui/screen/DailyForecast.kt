package com.montenegro.weatherapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.montenegro.weatherapp.R
import com.montenegro.weatherapp.ui.theme.ColorGradient1
import com.montenegro.weatherapp.ui.theme.ColorGradient2
import com.montenegro.weatherapp.ui.theme.ColorGradient3
import com.montenegro.weatherapp.ui.theme.ColorTextSecondary
import com.montenegro.weatherapp.ui.theme.ColorTextSecondaryVariant
import com.montenegro.weatherapp.ui.theme.ColorWindForecast

/**
 * Composable that displays the daily weather forecast.
 *
 * @param modifier Modifier to adjust the layout of the component.
 * @param forecast The weather forecast (default is "Rain showers").
 * @param date The date of the forecast (default is "Monday, 08 Dec").
 */
@Composable
fun DailyForecast(
  modifier: Modifier = Modifier,
  forecast: String = "Rain showers",
  date: String = "Monday, 08 Dec"
) {
  // ConstraintLayout allows for flexible positioning of elements.
  ConstraintLayout(
    modifier = modifier.fillMaxWidth()
  ) {
    // References for the elements within the ConstraintLayout.
    val (forecastImage, forecastValue, windImage, title, description, background) = createRefs()
    
    // Background card with a gradient.
    CardBackground(
      modifier = Modifier.constrainAs(background) {
        linkTo(
          start = parent.start,
          end = parent.end,
          top = parent.top,
          bottom = description.bottom,
          topMargin = 24.dp
        )
        height = Dimension.fillToConstraints
      }
    )
    
    // Weather forecast image.
    Image(
      painter = painterResource(R.drawable.img_sub_rain),
      contentDescription = null,
      contentScale = ContentScale.FillHeight,
      modifier = Modifier
        .height(175.dp)
        .constrainAs(forecastImage) {
          start.linkTo(anchor = parent.start, margin = 4.dp)
          top.linkTo(parent.top)
        }
    )
    
    // Title with the weather forecast.
    Text(
      text = forecast,
      style = MaterialTheme.typography.titleLarge,
      color = ColorTextSecondary,
      fontWeight = FontWeight.Medium,
      modifier = Modifier.constrainAs(title) {
        start.linkTo(anchor = parent.start, margin = 24.dp)
        top.linkTo(anchor = forecastImage.bottom)
      }
    )
    
    // Description with the date of the forecast.
    Text(
      text = date,
      style = MaterialTheme.typography.bodyMedium,
      color = ColorTextSecondaryVariant,
      modifier = Modifier
        .constrainAs(description) {
          start.linkTo(anchor = title.start)
          top.linkTo(anchor = title.bottom)
        }
        .padding(bottom = 24.dp)
    )
    
    // Weather forecast value.
    ForecastValue(
      modifier = Modifier.constrainAs(forecastValue) {
        end.linkTo(anchor = parent.end, margin = 24.dp)
        top.linkTo(forecastImage.top)
        bottom.linkTo(forecastImage.bottom)
      }
    )
    
    // Wind forecast icons.
    WindForecastImage(
      modifier = Modifier.constrainAs(windImage) {
        linkTo(
          top = title.top,
          bottom = title.bottom
        )
        end.linkTo(
          anchor = parent.end,
          margin = 24.dp
        )
      }
    )
  }
}

/**
 * Composable that displays the background card with a gradient.
 *
 * @param modifier Modifier to adjust the layout of the component.
 */
@Composable
private fun CardBackground(
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .background(
        brush = Brush.linearGradient(
          0f to ColorGradient1,
          0.5f to ColorGradient2,
          1f to ColorGradient3
        ), shape = RoundedCornerShape(32.dp)
      )
  )
}

/**
 * Composable that displays the weather forecast value.
 *
 * @param modifier Modifier to adjust the layout of the component.
 * @param degree The temperature in degrees (default is "21").
 * @param description The description of the perceived temperature (default is "Feels like 26°").
 */
@Composable
private fun ForecastValue(
  modifier: Modifier = Modifier,
  degree: String = "21",
  description: String = "Feels like 26°"
) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.Start
  ) {
    // Box containing the temperature value.
    Box(contentAlignment = Alignment.TopEnd) {
      Text(
        text = degree,
        letterSpacing = 0.sp,
        style = TextStyle(
          brush = Brush.verticalGradient(
            0f to Color.White,
            1f to Color.White.copy(alpha = 0.3f)
          ),
          fontSize = 80.sp,
          fontWeight = FontWeight.Black
        ),
        modifier = Modifier.padding(end = 16.dp)
      )
      Text(
        text = "°",
        style = TextStyle(
          brush = Brush.verticalGradient(
            0f to Color.White,
            1f to Color.White.copy(alpha = 0.3f)
          ),
          fontSize = 70.sp,
          fontWeight = FontWeight.Light,
        ),
        modifier = Modifier.padding(top = 2.dp)
      )
    }
    
    // Description of the perceived temperature.
    Text(
      text = description,
      style = MaterialTheme.typography.bodyMedium,
      color = ColorTextSecondaryVariant
    )
  }
}

/**
 * Composable that displays the wind forecast icons.
 *
 * @param modifier Modifier to adjust the layout of the component.
 */
@Composable
private fun WindForecastImage(
  modifier: Modifier = Modifier
) {
  Row(
    modifier = modifier,
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(
      painter = painterResource(R.drawable.ic_frosty),
      contentDescription = null,
      modifier = Modifier.size(60.dp),
      tint = ColorWindForecast
    )
    Icon(
      painter = painterResource(R.drawable.ic_wind),
      contentDescription = null,
      modifier = Modifier.size(60.dp),
      tint = ColorWindForecast
    )
  }
}

/**
 * Preview of the DailyForecast composable.
 */
@Preview(
  showBackground = true,
  showSystemUi = true,
  device = "spec:width=412dp,height=915dp,dpi=480"
)
@Composable
fun PreviewDailyForecast() {
  WeatherScreen()
}
