package com.mtanmay.gonukkadcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CallCard(
    modifier: Modifier = Modifier,
    selected: Int = 0,
    onClick: (Int) -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(
                shape = CircleShape.copy(
                    all = CornerSize(10.dp)
                )
            )
    ) {
        Row(
            modifier = Modifier
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selected == 0) Color(0xffEF0707) else Color(0xffFDE6E6),
                    )
                    .padding(15.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { onClick(0) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "10",
                    fontWeight = FontWeight.Bold,
                    color = if (selected == 0) Color.White else Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "Total Call",
                    color = if (selected == 0) Color.White else Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selected == 1) Color(0xffEF0707) else Color(0xffFDE6E6)
                    )
                    .padding(15.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { onClick(1) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "7",
                    fontWeight = FontWeight.Bold,
                    color = if (selected == 1) Color.White else Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "Connected",
                    color = if (selected == 1) Color.White else Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .background(
                        color = if (selected == 2) Color(0xffEF0707) else Color(0xffFDE6E6),
                    )
                    .padding(15.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) { onClick(2) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "3",
                    fontWeight = FontWeight.Bold,
                    color = if (selected == 2) Color.White else Color.Black,
                    fontSize = 20.sp
                )
                Text(
                    text = "Missed",
                    color = if (selected == 2) Color.White else Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
private fun CallCardPreview() {
    CallCard()
}