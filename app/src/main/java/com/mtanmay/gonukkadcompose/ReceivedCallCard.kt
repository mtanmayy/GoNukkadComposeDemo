package com.mtanmay.gonukkadcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ReceivedCallCard(
    modifier: Modifier = Modifier,
    callList: List<Call> = calls,
) {
    var selected by remember { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        CallCard(
            onClick = { selectedIdx ->
                selected = selectedIdx
            },
            selected = selected
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = CircleShape.copy(all = CornerSize(10.dp))
                )
                .clip(shape = CircleShape.copy(all = CornerSize(10.dp)))
        ) {
            itemsIndexed(items = getFilteredCallList(callList, selected)) { idx, call ->
                ReceivedCallCardItem(call = call, key = idx)
            }
        }
    }
}

fun getFilteredCallList(callList: List<Call>, selected: Int): List<Call> {
    return when(selected) {
        1 -> callList.filter { !it.missed }
        2 -> callList.filter { it.missed }
        else -> callList
    }
}

@Composable
fun ReceivedCallCardItem(
    modifier: Modifier = Modifier,
    call: Call,
    key: Int = 1
) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(if (key % 2 == 0) Color.White else Color(0xffF7F7F7))
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(
                id =
                if (call.missed)
                    R.drawable.ic_missed_call
                else R.drawable.ic_call
            ),
            contentDescription = null,
            modifier = Modifier.size(14.dp)
        )
        Spacer(modifier = Modifier.width(5.dp))
        Image(
            painter = painterResource(id = R.drawable.ic_chat),
            contentDescription = null,
            modifier = Modifier.size(14.dp)
        )

        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = "Phone",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff7F7F7F)
            )
            Text(
                text = call.phone,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff32363B)
            )

            if (isExpanded) {
                Text(
                    text = "Call Duration",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff7F7F7F),
                    modifier = Modifier.padding(top = 5.dp)
                )
                Text(
                    text = call.duration,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff32363B)
                )
            }
        }

        Column(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Text(
                text = if (call.missed) "Agent Missed" else "Agent Received",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = if (call.missed) Color(0xffFF0000) else Color(0xff7F7F7F)
            )

            Text(
                text = call.agentName,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xff32363B)
            )

            if (isExpanded) {
                Row(
                    modifier = Modifier.padding(top = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_play),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Play",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xff7F7F7F),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(start = 5.dp)
                    )
                }
            }

        }

        Row(
            modifier = Modifier.padding(start = 10.dp)
        ) {
            Column {
                Text(
                    text = "Date & Time",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff7F7F7F)
                )

                Text(
                    text = call.time,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xff32363B)
                )
            }

            Spacer(Modifier.weight(1f))

            Image(
                painter = painterResource(id = if (isExpanded) R.drawable.ic_collapse else R.drawable.ic_expand),
                contentDescription = null,
                modifier = Modifier
                    .size(15.dp)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null
                    ) {
                        isExpanded = !isExpanded
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReceivedCallCardPreview() {
    ReceivedCallCard()
}

data class Call(
    val phone: String,
    val duration: String,
    val agentName: String,
    val time: String,
    val missed: Boolean = false
)

val calls = listOf(
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
        missed = true
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
        missed = true
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
        missed = true
    ),
    Call(
        phone = "+1-555-611-4078",
        duration = "1 min 43 sec",
        agentName = "James",
        time = "17-07-2024 19:07:12",
    ),
)
