package com.example.loto.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loto.viewModels.LoteriaViewModels

@Composable
fun LoteriaView(viewModels: LoteriaViewModels) {
    val lottonNumbers = viewModels.lotoNumbers.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (lottonNumbers.isEmpty()) {
            Text(text = "Loteria",
                fontSize = 30.sp)
        } else {
            LotteryNumbers(lottonNumbers, viewModels)
            if(viewModels.isLoading){
                CircularProgressIndicator()
                Text(
                    text = viewModels.indiceNum.toString(),
                    fontSize = 25.sp,
                    modifier = Modifier
                        .padding(10.dp)
                    )
                }
            }
            Button(onClick = {viewModels.fetchData()}) {
                Text(text = "Generar Números", fontSize = 25.sp)
            }
            
        }

}

@Composable
fun LotteryNumbers(lottonNumbers: List<Int>, viewModel: LoteriaViewModels){
    LazyRow (contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 8.dp
        )
    ){
        items(lottonNumbers){number ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
                    .background(Color.Green, CircleShape))
            {
                Text(text = number.toString(),
                     color = Color.White,
                     fontSize = 24.sp
                )
            }
        }
    }
}