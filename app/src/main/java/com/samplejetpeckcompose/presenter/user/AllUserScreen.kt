package com.samplejetpeckcompose.presenter.user

import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.samplejetpeckcompose.domain.entity.user.User
import com.samplejetpeckcompose.R
import com.samplejetpeckcompose.presenter.main.MainViewModel
import com.samplejetpeckcompose.presenter.main.TopBar
import kotlinx.coroutines.launch

@Composable
fun AllUserScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.aaa()


    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp) // margin

        ) {
            viewModel.users.value.map { it ->
                item {
                    User(it) {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            "user", it
                        )
                        navController.navigate("user_details")
                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun User(user: User, onClick: (User) -> Unit) {
    val openDialog = remember { mutableStateOf(false) }
    Card(shape = RoundedCornerShape(8.dp), modifier = Modifier
        .padding(all = 4.dp) // margin
        .fillMaxWidth()
        .clickable {
            onClick.invoke(user)
        }) {
        Box() {
            Row(
                modifier = Modifier
                    .padding(all = 16.dp) // margin
                    .fillMaxSize()
            ) {
                GlideImage(
                    model = user.avatar,
                    contentDescription = "Contact profile picture",
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                        .padding(all = 8.dp)
                )

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(horizontal = 16.dp) // margin
                        .weight(1f)
                ) {
                    Text(
                        text = "${user.first_name} ${user.last_name}",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxSize()
                    )
                    Text(
                        text = user.email,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Image(painter = painterResource(R.drawable.ic_baseline_delete_24),
                    contentDescription = "Contact profile picture",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(24.dp)
                        .fillMaxSize()
                        .clickable {
                            openDialog.value = true
                        })

                if (openDialog.value) {

                    AlertDialog(onDismissRequest = {
                        openDialog.value = false
                    }, title = {
                        Text(text = "Alert!!")
                    }, text = {
                        Text("Are you sure want to delete this user?")
                    }, confirmButton = {
                        Text("Confirm", modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                openDialog.value = false
                            })
                    }, dismissButton = {
                        Text("Decline", modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                openDialog.value = false
                            })
                    })
                }
            }
        }
    }

}


