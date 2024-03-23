package com.example.lab.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.unit.dp
import com.example.lab.R
import com.example.lab.auth.state.Credentials
import com.example.lab.auth.state.checkCredentials

@Composable
fun LogIn() {
    Surface {
        var credentials by remember {
            mutableStateOf(Credentials())
        }
        val context = LocalContext.current

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            LoginField(
                value = credentials.login,
                onChange = {
                    data -> credentials = credentials.copy(login = data)
                },
                label = R.string.login.toString(),
                placeholder = R.string.enter_login.toString(),
                modifier = Modifier.fillMaxWidth()
            )
            PasswordField(
                value = credentials.pwd,
                onChange = {
                    data -> credentials = credentials.copy(pwd = data)
                },
                submit = {
                    if (!checkCredentials(credentials, context)){
                        credentials = Credentials()
                    }
                },
                label = R.string.password.toString(),
                placeholder = R.string.enter_password.toString(),
                modifier = Modifier.fillMaxWidth()
            )
            LabeledCheckbox(
                label = "asd",
                onCheckChanged = {
                    credentials = credentials.copy(remember = !credentials.remember)
                },
                isChecked = false
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    if (!checkCredentials(credentials, context)){
                        credentials = Credentials()
                    }
                },
                enabled = credentials.isNotEmpty(),
                colors = ButtonDefaults.buttonColors(),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(R.string.login.toString())
            }
        }
    }
}

@Composable
@PreviewDynamicColors
fun LogInPreview() {
    LogIn()
}