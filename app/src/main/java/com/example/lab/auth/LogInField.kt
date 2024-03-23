package com.example.lab.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import com.example.lab.R

@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    placeholder: String
) {
    val focusManager = LocalFocusManager.current

    TextField(
        value = value,
        colors = TextFieldDefaults.colors(),
        shape = MaterialTheme.shapes.large,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = {
            Icon(
                Icons.Filled.Person,
                contentDescription = null,
//                tint = MaterialTheme.colorScheme.primary
            )
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),

        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall
            )
        },
        placeholder = {
            Text(
                text = placeholder,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
}

@PreviewDynamicColors
@Composable
fun PreviewLoginField() {
    LoginField(
        value = "from cache",
        onChange = {},
        label = R.string.login.toString(),
        placeholder = R.string.enter_login.toString()
    )
}