package com.sbw.weatherapp.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.sbw.weatherapp.R

@Composable
fun WeatherCardInfo(
    value: Int,
    unit: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(),
    iconTint: Color = Color.Red
){
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = iconTint,
//            modifier = Modifier.size(with(LocalDensity.current) { LocalContext.current.resources.getDimension(
//                R.dimen.my25dp).toDp()})
            modifier = Modifier.size(25.dp)
        )

//        Spacer(modifier = Modifier.width(with(LocalDensity.current) { LocalContext.current.resources.getDimension(R.dimen.my4dp).toDp()}))
        Spacer(modifier = Modifier.width(4.dp))

        Text(
            text = "$value$unit",
            style = textStyle
        )
    }
}
