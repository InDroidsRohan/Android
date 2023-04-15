package com.example.userprofile

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.userprofile.ui.theme.UserProfileTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UserProfileTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    profileScreen()
                }
            }
        }
    }
}

@Composable
fun profileScreen() {

    val notification= rememberSaveable{ mutableStateOf(value = "")}
    if (notification.value.isNotEmpty()){
        Toast.makeText(LocalContext.current,notification.value,Toast.LENGTH_LONG).show()
        notification.value=""
    }
    var name by rememberSaveable{
        mutableStateOf(value="Default name")}
    var userId by rememberSaveable{
        mutableStateOf(value="UserId")}
    var email by rememberSaveable{
        mutableStateOf(value="Email")}
    var phone by rememberSaveable{
        mutableStateOf(value="Phone Number")}

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(8.dp)) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween)
        {
            Text(text="Cancel",modifier=Modifier.clickable{notification.value="Cancelled !"})
            Text(text="Save",modifier=Modifier.clickable{notification.value="Profile Updated !"})
        }
        profileImage()
        Row(modifier = Modifier .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Text(text="Name", modifier = Modifier.width(100.dp))
            TextField(value="Name", onValueChange ={name=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ) )
        }

        Row(modifier = Modifier .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Text(text="UserId", modifier = Modifier.width(100.dp))
            TextField(value="UserId", onValueChange ={userId=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ) )
        }

        Row(modifier = Modifier .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Text(text="Email", modifier = Modifier.width(100.dp))
            TextField(value="Email", onValueChange ={email=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ) )
        }

        Row(modifier = Modifier .fillMaxWidth()
            .padding(start = 4.dp, end = 4.dp), verticalAlignment = Alignment.CenterVertically)
        {
            Text(text="Contact", modifier = Modifier.width(100.dp))
            TextField(value="Contact Number", onValueChange ={phone=it}, colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.Black
            ) )
        }
    }
}
@Composable
fun profileImage() {
        val imageUri= rememberSaveable{
            mutableStateOf(value="")}
        val painter= rememberImagePainter(
            if (imageUri.value.isEmpty())
                R.drawable.user
            else
                imageUri.value
    )
    val launcher= rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent())
    {
        uri: Uri? ->
        uri?.let{imageUri.value=it.toString()}
    }
        Column(modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally)
        {
         Card (shape= CircleShape,
             modifier = Modifier
                 .padding(8.dp)
                 .size(100.dp))
         {
             Image(painter = painter, contentDescription = null, modifier = Modifier.wrapContentSize()
                 .clickable{launcher.launch("image/*" )},
                 contentScale = ContentScale.Crop)
         }
            Text(text = "Change Profile Picture")
        }
}

@Preview(showBackground = true)

@Composable
fun DefaultPreview() {
    UserProfileTheme {
        profileScreen()
    }
}