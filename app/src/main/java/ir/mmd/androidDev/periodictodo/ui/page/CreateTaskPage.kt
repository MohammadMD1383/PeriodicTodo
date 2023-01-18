package ir.mmd.androidDev.periodictodo.ui.page

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mmd.androidDev.periodictodo.data.entity.TaskEntity
import ir.mmd.androidDev.periodictodo.ui.theme.PeriodicTodoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTaskPage(
	onCreate: (task: TaskEntity) -> Unit,
	contentPadding: PaddingValues = PaddingValues()
) {
	var title by remember { mutableStateOf("") }
	var description by remember { mutableStateOf("") }
	
	// title, description, repeatMode, scheduledTime
	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(16.dp),
		modifier = Modifier
			.padding(
				start = contentPadding.calculateStartPadding(LocalLayoutDirection.current),
				end = contentPadding.calculateEndPadding(LocalLayoutDirection.current)
			)
			.fillMaxSize()
	) {
		Spacer(modifier = Modifier.height(contentPadding.calculateTopPadding()))
		
		Text(
			text = "Create a New Task",
			style = MaterialTheme.typography.titleLarge
		)
		
		OutlinedTextField(
			value = title,
			onValueChange = { title = it },
			label = { Text(text = "Title") },
			placeholder = { Text(text = "Title (Required)") },
			modifier = Modifier.fillMaxWidth()
		)
		
		OutlinedTextField(
			value = description,
			onValueChange = { description = it },
			label = { Text(text = "Description") },
			placeholder = { Text(text = "Description (Optional)") },
			singleLine = false,
			maxLines = 7,
			modifier = Modifier.fillMaxWidth()
		)
		
		
		
		Spacer(modifier = Modifier.height(contentPadding.calculateBottomPadding()))
	}
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun LightPreview() {
	PeriodicTodoTheme(false) {
		CreateTaskPage({})
	}
}

@Preview(showSystemUi = true, showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun DarkPreview() {
	PeriodicTodoTheme(false) {
		CreateTaskPage({})
	}
}