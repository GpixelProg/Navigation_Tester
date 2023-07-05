package gpixel.navigationtester

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.navigator.bottomSheet.BottomSheetNavigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import gpixel.navigationtester.screen.HomeTab
import gpixel.navigationtester.screen.SettingsTab
import gpixel.navigationtester.ui.theme.NavigationTesterTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTesterTheme {
                TabNavigator(tab = HomeTab()) {
                    Scaffold(
                        content = {
                            CurrentTab()
                        },

                        bottomBar = {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                TabNavigationItem(tab = HomeTab())
                                TabNavigationItem(tab = SettingsTab())
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun TabNavigationItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    TextButton(onClick = { tabNavigator.current = tab }) {
        Icon(painter = tab.options.icon!!, contentDescription = null, tint = if (tabNavigator.current == tab) Color.Red else Color.Gray)
    }
}