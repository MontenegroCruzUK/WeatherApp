package com.montenegro.weatherapp.ui.data

import androidx.annotation.DrawableRes
import com.montenegro.weatherapp.R

data class AirQualityItem(
  @DrawableRes val icon: Int,
  val title: String,
  val value: String
)

val AirQualityData = listOf(
  AirQualityItem(
    icon = R.drawable.ic_real_feel,
    title = "Real Feel",
    value = "23.8"
  ),
  AirQualityItem(
    icon = R.drawable.ic_wind_qality,
    title = "Wind",
    value = "9kh/h"
  ),
  AirQualityItem(
    icon = R.drawable.ic_so2,
    title = "S02",
    value = "0.9"
  ),
  AirQualityItem(
    icon = R.drawable.ic_rain_chance,
    title = "Rain",
    value = "68%"
  ),
  AirQualityItem(
    icon = R.drawable.ic_uv_index,
    title = "UV Index",
    value = "3"
  ),
  AirQualityItem(
    icon = R.drawable.ic_o3,
    title = "03",
    value = "50"
  )
)