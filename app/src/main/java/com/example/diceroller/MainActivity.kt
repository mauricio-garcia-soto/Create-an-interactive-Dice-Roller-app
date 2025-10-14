package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage()
}

@Preview(showBackground = true)
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(2) }
    var total by remember { mutableStateOf(0) }
    fun getDiceImage(value: Int): Int {
        return when (value) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = getDiceImage(result1)),
            contentDescription = result1.toString()
        )


        Image(
            painter = painterResource(id = getDiceImage(result2)),
            contentDescription = result2.toString()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = ("Tu puntacion es de $total")
        )
        Button(onClick = {
            result1 = (1..6).random()
            total=result1
        }) {
            Text(stringResource(R.string.roll))
        }


        Button(onClick = {
            result1 = (1..6).random()
            result2 = (1..6).random()
            total=result1+result2
        }) {
            Text(stringResource(R.string.rollTwo))
        }
    }
}


