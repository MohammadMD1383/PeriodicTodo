package ir.mmd.androidDev.periodictodo.ui.page

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mmd.androidDev.periodictodo.ui.component.TaskComponent
import ir.mmd.androidDev.periodictodo.ui.preview.sampleTaskViewModelList
import ir.mmd.androidDev.periodictodo.ui.theme.PeriodicTodoTheme
import ir.mmd.androidDev.periodictodo.viewmodel.TaskViewModel

@Composable
fun TaskListPage(
	tasks: List<TaskViewModel>,
	contentPadding: PaddingValues = PaddingValues()
) {
	LazyColumn(
		verticalArrangement = Arrangement.spacedBy(16.dp),
		contentPadding = contentPadding,
		modifier = Modifier.fillMaxSize()
	) {
		items(tasks) {
			TaskComponent(model = it)
		}
	}
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun LightPreview() {
	PeriodicTodoTheme(false) {
		TaskListPage(sampleTaskViewModelList)
	}
}

@Preview(showBackground = true, showSystemUi = true, backgroundColor = 0xFF000000)
@Composable
fun DarkPreview() {
	PeriodicTodoTheme(true) {
		TaskListPage(sampleTaskViewModelList)
	}
}