package gpixel.navigationtester.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import gpixel.navigationtester.viewmodel.SetupV1ViewModel

class SetupV1() : AndroidScreen() {

    @Composable
    override fun Content() {
        val viewModel = viewModel<SetupV1ViewModel>()
        val navigator = LocalNavigator.currentOrThrow

        Column {
            Button(onClick = { navigator.push(SetupV2(10)) }) {
                Text(text = "SetupV2")
            }
        }
    }
}