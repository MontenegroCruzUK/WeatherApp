package com.montenegro.weatherapp.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.montenegro.weatherapp.R
import com.montenegro.weatherapp.ui.screen.componets.customShadow
import com.montenegro.weatherapp.ui.theme.ColorGradient1
import com.montenegro.weatherapp.ui.theme.ColorGradient2
import com.montenegro.weatherapp.ui.theme.ColorGradient3
import com.montenegro.weatherapp.ui.theme.ColorImageShadow
import com.montenegro.weatherapp.ui.theme.ColorSurface
import com.montenegro.weatherapp.ui.theme.ColorTextPrimary
import com.montenegro.weatherapp.ui.theme.ColorTextSecondary

/**
 * Composable that represents an action bar with control buttons, location info, and profile button.
 *
 * @param modifier Modifier to apply to the action bar.
 */
@Composable
fun ActionBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth(), // Make the Row fill the width of the parent
        verticalAlignment = Alignment.Top, // Align children to the top
        horizontalArrangement = Arrangement.SpaceBetween // Space children evenly
    ) {
        ControlButton() // Add the control button
        LocationInfo(modifier = Modifier.padding(top = 10.dp)) // Add location info with top padding
        ProfileButton() // Add the profile button
    }
}

/**
 * Composable that represents a control button with a custom shadow.
 *
 * @param modifier Modifier to apply to the control button.
 */
@Composable
fun ControlButton(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .size(48.dp) // Set the size of the button
            .customShadow(
                color = Color.Black,
                alpha = 0.15f,
                shadowRadius = 16.dp,
                bordeRadius = 48.dp,
                offsetY = 4.dp
            ), // Apply custom shadow
        color = ColorSurface, // Set the background color
        shape = CircleShape // Set the shape to a circle
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(), // Make the Box fill the size of the Surface
            contentAlignment = Alignment.Center // Center the content
        ) {
            Image(
                modifier = Modifier
                    .size(20.dp), // Set the size of the image
                painter = painterResource(R.drawable.ic_control), // Set the image resource
                contentDescription = "Control Button Icon" // Set the content description for accessibility
            )
        }
    }
}

/**
 * Composable that represents a profile button with a custom shadow.
 *
 * @param modifier Modifier to apply to the profile button.
 */
@Composable
fun ProfileButton(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp) // Set the size of the button
            .border(
                width = 1.5.dp,
                color = ColorSurface,
                shape = CircleShape
            ) // Add a border
            .customShadow(
                color = ColorImageShadow,
                alpha = 0.7f,
                shadowRadius = 12.dp,
                bordeRadius = 48.dp,
                offsetY = 6.dp
            ) // Apply custom shadow
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile), // Set the image resource
            contentDescription = "User", // Set the content description for accessibility
            modifier = Modifier
                .fillMaxSize() // Make the Image fill the size of the Box
                .clip(CircleShape) // Clip the image to a circle
        )
    }
}

/**
 * Composable that displays location information and a progress bar.
 *
 * @param modifier Modifier to apply to the location info.
 * @param location Name of the location to display.
 */
@Composable
fun LocationInfo(
    modifier: Modifier = Modifier,
    location: String = "Stroud"
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, // Center children horizontally
        verticalArrangement = Arrangement.spacedBy(4.dp) // Space children by 4.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp), // Space children by 8.dp
            verticalAlignment = Alignment.CenterVertically // Center children vertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_location_pin), // Set the image resource
                contentDescription = "Location", // Set the content description for accessibility
                modifier = Modifier.height(18.dp), // Set the height of the image
                contentScale = ContentScale.FillHeight // Scale the image to fill the height
            )
            Text(
                text = location, // Set the text to the location
                style = MaterialTheme.typography.titleLarge, // Set the text style
                color = ColorTextPrimary, // Set the text color
                fontWeight = FontWeight.Bold // Set the text weight to bold
            )
        }
        ProgressBar() // Add the progress bar
    }
}

/**
 * Composable that displays a progress bar with a gradient color.
 *
 * @param modifier Modifier to apply to the progress bar.
 */
@Composable
fun ProgressBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.linearGradient(
                    0f to ColorGradient1,
                    0.25f to ColorGradient2,
                    1f to ColorGradient3
                ), // Apply a linear gradient background
                shape = RoundedCornerShape(8.dp) // Set the shape to a rounded corner
            )
            .padding(
                vertical = 2.dp,
                horizontal = 10.dp
            ) // Add padding
    ) {
        Text(
            text = "Updating ·", // Set the text
            style = MaterialTheme.typography.labelSmall, // Set the text style
            color = ColorTextSecondary.copy(alpha = 0.7f) // Set the text color with transparency
        )
    }
}
