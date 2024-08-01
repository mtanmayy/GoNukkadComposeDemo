package com.mtanmay.gonukkadcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    username: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFEF0707),
                        Color(0xFFFE9A2C)
                    )
                )
            )
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(
                    horizontal = 20.dp
                )
                .padding(
                    top = 35.dp,
                    bottom = 25.dp
                )
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        color = Color.White,
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = username[0].toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column {
                Text(
                    text = "Welcome",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight(400),
                    modifier = Modifier.padding(start = 15.dp)
                )
                Row {
                    Text(
                        text = "Jeffrey S. Nash",
                        color = Color.White,
                        fontSize = 25.sp,
                        fontWeight = FontWeight(700),
                        modifier = Modifier.padding(start = 15.dp)
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.Add,
                tint = Color.White,
                contentDescription = null,
            )
            Icon(
                imageVector = Icons.Outlined.Add,
                tint = Color.White,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header(username = "Ashley")
}