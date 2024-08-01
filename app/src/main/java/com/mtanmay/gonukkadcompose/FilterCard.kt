package com.mtanmay.gonukkadcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilterCard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = Color(0xffF3F3F3),
                shape = CircleShape.copy(all = CornerSize(10.dp))
            )
            .padding(10.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DropdownCard(
                    title = "All",
                    modifier = Modifier.weight(1f)
                )
                DropdownCard(
                    title = "All Agent",
                    modifier = Modifier.weight(1f)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DatePickerCard(
                    date = "19/06/24",
                    modifier = Modifier.weight(1f)
                )
                DatePickerCard(
                    date = "20/06/24",
                    modifier = Modifier.weight(1f)
                )
            }

            DropdownCard(
                title = "K00419 Sale (Active)"
            )
        }
    }
}

@Composable
fun DatePickerCard(
    date: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = Color.White,
                shape = CircleShape.copy(all = CornerSize(10.dp))
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = date,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Outlined.DateRange,
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 5.dp),
                contentDescription = null
            )
        }
    }
}

@Composable
fun DropdownCard(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .background(
                color = Color.White,
                shape = CircleShape.copy(all = CornerSize(10.dp))
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = title,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                modifier = Modifier.size(30.dp),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun FilterCardPreview() {
    FilterCard()
}