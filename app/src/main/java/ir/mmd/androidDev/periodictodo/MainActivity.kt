package ir.mmd.androidDev.periodictodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.mmd.androidDev.periodictodo.ui.theme.PeriodicTodoTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PeriodicTodoTheme {
				MainComponent()
			}
		}
	}
}

@Composable
private fun MainComponent() {
	Surface(
		modifier = Modifier.fillMaxSize(),
		color = MaterialTheme.colorScheme.background
	) {
	
	}
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LightPreview() {
	PeriodicTodoTheme(false) {
		MainComponent()
	}
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0x000000FF)
@Composable
private fun DarkPreview() {
	PeriodicTodoTheme(true) {
		MainComponent()
	}
}
