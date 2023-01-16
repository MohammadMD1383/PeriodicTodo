package ir.mmd.androidDev.periodictodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Add
import androidx.compose.material.icons.twotone.History
import androidx.compose.material.icons.twotone.Task
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainComponent() {
	Scaffold(
		bottomBar = {
			BottomAppBar(
				actions = {
					IconButton(onClick = { /*TODO*/ }) {
						Icon(Icons.TwoTone.Task, "Tasks")
					}
					
					IconButton(onClick = { /*TODO*/ }) {
						Icon(Icons.TwoTone.History, "Delayed Tasks")
					}
				},
				floatingActionButton = {
					FloatingActionButton(onClick = { /*TODO*/ }) {
						Icon(Icons.TwoTone.Add, "Add a task")
					}
				}
			)
		}
	) { paddingValues ->
		paddingValues
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
