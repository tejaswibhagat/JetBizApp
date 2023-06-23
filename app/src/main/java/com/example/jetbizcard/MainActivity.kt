package com.example.jetbizcard

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun CreateBizCard() {
    val buttonClickedState= remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier.fillMaxSize(), color = Color(0xFFF8F9EC)
    ) {

        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            backgroundColor = Color(0xFF89CFF0),
            elevation = 4.dp

        ) {
            Column(
                modifier = Modifier.height(300.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                `Create image profile`()
                Divider()
                CreateInfo()
                Button(onClick = {
                    buttonClickedState.value = !buttonClickedState.value
                }) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.button
                    )
                }
                if(buttonClickedState.value){
                    Content()
                }else{
                    Box{}
                }
            }

        }
    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxSize(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = Color.LightGray),
            color = Color(0xFFC19A6B)
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
        LazyColumn{
            items(data){
                    item ->
                Card(modifier = Modifier
                    .padding(13.dp)
                    .fillParentMaxWidth(),
                    shape = RectangleShape,
                    elevation = 4.dp
                ) {
                    Row(modifier = Modifier
                        .padding(8.dp)
                        .background(MaterialTheme.colors.surface)
                        .padding(7.dp)) {
                        `Create image profile`(modifier = Modifier.size(100.dp))
                        Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {

                            Text(text = item, fontWeight = FontWeight.Bold)
                            Text(text = "A great project", style = MaterialTheme.typography.body2)
                        }
                    }
                }
            }
        }
}

@Composable
private fun CreateInfo() {
    Column(
        modifier = Modifier
            .padding(5.dp),
    ) {
        Text(
            text = "Tejaswi Bhagat",
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFC19A6B),
            fontSize = 27.sp,
            textAlign = TextAlign.Center

        )
        Text(
            text = "Android composer Programmer",
            modifier = Modifier.padding(3.dp),
            color = Color(0xFFC19A6B)
        )

        Text(
            text = "tejaswibhagat2002@yahoo.com",
            modifier = Modifier.padding(3.dp),
            color = Color(0xFFC19A6B)
        )
    }
}

@Composable
private fun `Create image profile`(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(154.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, color = Color.LightGray),
        elevation = 4.dp,
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Profile Image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}