package com.lari.composebusinesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lari.composebusinesscard.ui.theme.ComposebusinesscardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposebusinesscardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard()
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val logoImagePainter = painterResource(id = R.drawable.android_logo)
    Box(
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.green_500)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .width(125.dp)
                    .background(
                        color = colorResource(id = R.color.grey_900)
                    ),
                painter = logoImagePainter,
                contentDescription = "A profile phote",
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = modifier.padding(top = 16.dp),
                text = stringResource(id = R.string.person_name),
                fontSize = 48.sp,
            )
            Text(
                text = stringResource(id = R.string.job_title),
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.green_900)
            )
        }

        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(bottom = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            Column(
                modifier = modifier.padding(bottom = 10.dp)
            ) {

                ListItemView(
                    iconImagePainter = painterResource(id = R.drawable.ic_call),
                    itemText = stringResource(id = R.string.phone_number)
                )
                ListItemView(
                    iconImagePainter = painterResource(id = R.drawable.ic_share),
                    itemText = stringResource(id = R.string.share_text)
                )
                ListItemView(
                    iconImagePainter = painterResource(id = R.drawable.ic_email),
                    itemText = stringResource(id = R.string.contact_email)
                )
            }
        }
    }
}

@Composable
fun ListItemView(iconImagePainter: Painter, itemText: String) {
    Row(
        modifier = Modifier.padding(top = 6.dp, bottom = 6.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = iconImagePainter,
            contentDescription = null,
            tint = colorResource(id = R.color.green_900),
        )
        Text(
            text = itemText,
            modifier = Modifier.padding(start = 24.dp),
            fontWeight = FontWeight.SemiBold
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposebusinesscardTheme {
        BusinessCardApp()
    }
}