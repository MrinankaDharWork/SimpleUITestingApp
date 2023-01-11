package com.example.myapplication1.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import android.view.KeyEvent.KEYCODE_ENTER
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication1.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen(modifier: Modifier = Modifier){
    Scaffold() {
        SignInScreenDesign(modifier.padding(it))
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreenDesign(modifier: Modifier = Modifier){

    var enteredEmail by rememberSaveable { mutableStateOf("")}
    var enteredPass by rememberSaveable { mutableStateOf("")}

    Box() {

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 20.dp, horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom) {


            Box() {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight(.3f)
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth()
                        .size(300.dp),
                    alignment = Alignment.Center
                )
            }

            val focusRequester = remember { FocusRequester() }
            val focusManager = LocalFocusManager.current
            val checkedState = rememberSaveable {
                mutableStateOf(false)
            }


            OutlinedTextField( modifier = modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onKeyEvent {
                    if (it.nativeKeyEvent.keyCode == KEYCODE_ENTER) {
                        focusManager.clearFocus()
                    }
                    false
                },
                value = enteredEmail,
                onValueChange = { enteredEmail = it },
                label = { Text("Email")},
                singleLine = true,
                maxLines = 1,
                shape = RoundedCornerShape(50),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions( onNext = { focusManager.moveFocus(FocusDirection.Next) })
            )

            //Spacer
            Spacer(modifier = modifier.padding(2.dp))

            OutlinedTextField( modifier = modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onKeyEvent {
                    if (it.nativeKeyEvent.keyCode == KEYCODE_ENTER) {
                        focusManager.clearFocus()
                    }
                    false
                },
                value = enteredPass,
                onValueChange = { enteredPass = it },
                label = { Text("Password") },
                singleLine = true,
                maxLines = 1,
                shape = RoundedCornerShape(50),
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions( onDone = { focusManager.clearFocus() })
            )

            //Spacer
            Spacer(modifier = modifier.padding(2.dp))

            Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = checkedState.value, onCheckedChange = {
                        checkedState.value = it }, colors = CheckboxDefaults.colors(Color.Blue)
                    )
                    Text(
                        text = "Remember me",
                        textAlign = TextAlign.Left
                    )
                }
                Text(
                    text = "Forgot Password",
                    textAlign = TextAlign.Right

                )
            }

            //Spacer
            Spacer(modifier = modifier.padding(2.dp))

            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                modifier= modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.White.copy(.1f),
                        shape = RoundedCornerShape(50)
                    )
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Blue,
                                Color.White.copy(.8f),
                                Color.Blue
                            ), startY = 30f, endY = 100f
                        ),
                        shape = RoundedCornerShape(50)
                    )
                    .clip(RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(Color.Blue.copy(.6f))

            ) {

                Text(text = "Sign In")
            }


            //Spacer
            Spacer(modifier = modifier.padding(64.dp))


            Text(
                text = "Dont have an account",
                textAlign = TextAlign.Center
            )

            //Spacer
            Spacer(modifier = modifier.padding(8.dp))


            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                modifier= modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .border(
                        width = 1.dp,
                        color = Color.White.copy(.1f),
                        shape = RoundedCornerShape(50)
                    )
                    .clip(RoundedCornerShape(50)),
                colors = ButtonDefaults.buttonColors(Color.White.copy(.1f))

            ) {

                Text(text = "SIgn Up")
            }

        }
    }


}

@Preview
@Composable
fun PreviewSignIn(){
    SignInScreen()
}



@Composable
fun LogInScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LoginScreenTopView()
    }
}


@Composable
fun LoginScreenTopView() {
    TODO("Not yet implemented")
}
