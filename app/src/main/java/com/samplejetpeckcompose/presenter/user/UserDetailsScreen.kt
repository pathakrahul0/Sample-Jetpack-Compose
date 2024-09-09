package com.samplejetpeckcompose.presenter.user

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.samplejetpeckcompose.R
import com.samplejetpeckcompose.domain.entity.user.User

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserDetailsScreen(user: User) {
    val context = LocalContext.current
    var name by remember { mutableStateOf(user.first_name) }
    var avatar by remember { mutableStateOf(user.avatar) }
    var email by remember { mutableStateOf(user.email) }
    var mobileNo by remember { mutableStateOf(user.mobileNo) }
    var dob by remember { mutableStateOf(user.dob) }
    var gender by remember { mutableStateOf(user.gender) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .scrollable(rememberScrollState(), Orientation.Vertical)
            .padding(all = 16.dp)
            .fillMaxSize()

    ) {

        GlideImage(
            model = avatar,
            contentDescription = "Contact profile picture",
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center,
            modifier = Modifier
                .size(110.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                .padding(all = 8.dp),
        )


        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text(text = "Name")
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )


        OutlinedTextField(
            value = email.toString(),
            onValueChange = { email = it },
            label = {
                Text(text = "Email Id")
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = mobileNo.toString(),
            onValueChange = { mobileNo = it },
            label = {
                Text(text = "Mobile No.")
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )

        OutlinedTextField(
            value = dob.toString(),
            onValueChange = { dob = it },
            label = {
                Text(text = "Date of Birth")
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clickable {

                },
            enabled = false
        )


        OutlinedTextField(
            value = gender.toString(),
            onValueChange = { gender = it },
            label = {
                Text(text = "Gender")
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clickable {

                },
            enabled = false

        )

        Button(
            // below line is use to add onclick
            // parameter for our button onclick
            onClick = {
                // when user is clicking the button
                // we are displaying a toast message.
                Toast.makeText(context, "User added", Toast.LENGTH_LONG).show()

            },
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = Color.Red
            ),


                    // in below line we are using modifier
            // which is use to add padding to our button
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .clip(RectangleShape)
                .size(width = 0.dp, height = 50.dp),


            // below line is use to set or
            // button as enable or disable.
            enabled = true,

            // below line is use to
            // add border to our button.
            border = BorderStroke(width = 1.dp, brush = SolidColor(Color.Red)),

            // below line is use to add shape for our button.
            shape = MaterialTheme.shapes.medium,
        )
        // below line is use to
        // add text on our button
        {
            Text(
                text = "Submit",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        }

    }


}