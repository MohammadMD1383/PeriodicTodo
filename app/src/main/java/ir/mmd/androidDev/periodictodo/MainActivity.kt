package ir.mmd.androidDev.periodictodo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ir.mmd.androidDev.periodictodo.ui.page.TaskListPage
import ir.mmd.androidDev.periodictodo.ui.preview.sampleTaskViewModelList
import ir.mmd.androidDev.periodictodo.ui.theme.PeriodicTodoTheme
import ir.mmd.androidDev.periodictodo.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PeriodicTodoTheme {
				MainComponent(listOf())
			}
		}
	}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainComponent(
	tasks: List<TaskViewModel>,
	preview: Boolean = false,
	page: String = "tasks"
) {
	val navController = rememberNavController()
	
	Scaffold(
		bottomBar = {
			BottomAppBar(
				actions = {
					IconButton(onClick = { navController.navigate("tasks") { launchSingleTop = true } }) {
						Icon(Icons.TwoTone.FormatListBulleted, "Tasks")
					}
					
					IconButton(onClick = { navController.navigate("delayedTasks") { launchSingleTop = true } }) {
						Icon(Icons.TwoTone.History, "Delayed Tasks")
					}
				},
				floatingActionButton = {
					FloatingActionButton(onClick = { navController.navigate("createTask") { launchSingleTop = true } }) {
						Icon(Icons.TwoTone.Add, "Add a Task")
					}
				}
			)
		}
	) { paddingValues ->
		if (preview) {
			Box(
				modifier = Modifier
					.fillMaxSize()
					.padding(paddingValues)
			) {
				when (page) {
					"tasks" -> TaskListPage(tasks = tasks, contentPadding = PaddingValues(16.dp))
					"delayedTasks" -> {}
					"createTask" -> {}
				}
			}
		} else {
			NavHost(
				navController = navController,
				startDestination = "tasks",
				modifier = Modifier.padding(paddingValues)
			) {
				composable("tasks") {
					TaskListPage(
						tasks = tasks,
						contentPadding = PaddingValues(16.dp)
					)
				}
			}
		}
	}
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LightPreview() {
	PeriodicTodoTheme(false) {
		MainComponent(sampleTaskViewModelList, true)
	}
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF000000)
@Composable
private fun DarkPreview() {
	PeriodicTodoTheme(true) {
		MainComponent(sampleTaskViewModelList, true)
	}
}
