package com.montenegro.weatherapp.ui.screen.componets

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.montenegro.weatherapp.ui.screen.WeatherScreen

@Composable
fun AirQuality() {
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