package ir.mmd.androidDev.periodictodo.ui.component

import android.text.format.DateFormat
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material.icons.twotone.Circle
import androidx.compose.material.icons.twotone.Restore
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ir.mmd.androidDev.periodictodo.ui.preview.sampleTaskViewModel
import ir.mmd.androidDev.periodictodo.ui.theme.PeriodicTodoTheme
import ir.mmd.androidDev.periodictodo.viewmodel.TaskViewModel
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskComponent(model: TaskViewModel) {
	val cardColor by animateColorAsState(
		if (model.isDone.value)
			MaterialTheme.colorScheme.surfaceVariant
		else
			MaterialTheme.colorScheme.secondaryContainer
	)
	
	Card(
		colors = CardDefaults.cardColors(containerColor = cardColor),
		onClick = { model.isExpanded.value = !model.isExpanded.value },
		modifier = Modifier
			.fillMaxWidth()
			.animateContentSize()
	) {
		Column(modifier = Modifier.padding(16.dp)) {
			Row(
				horizontalArrangement = Arrangement.spacedBy(8.dp),
				verticalAlignment = Alignment.CenterVertically
			) {
				Icon(if (model.isDone.value) Icons.TwoTone.CheckCircle else Icons.TwoTone.Circle, "Bullet")
				
				Text(
					text = model.title,
					style = MaterialTheme.typography.titleMedium
				)
			}
			
			if (model.description != null) {
				Spacer(modifier = Modifier.height(8.dp))
				
				Crossfade(targetState = model.isExpanded.value) { expanded ->
					if (expanded) {
						Text(
							text = model.description,
							style = MaterialTheme.typography.bodySmall
						)
					} else {
						Text(
							text = model.getShortDescription(30)!!,
							style = MaterialTheme.typography.bodySmall
						)
					}
				}
			}
			
			Spacer(modifier = Modifier.height(8.dp))
			
			Row(
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically,
				modifier = Modifier.fillMaxWidth()
			) {
				Crossfade(targetState = model.isDone.value) { done ->
					TextButton(onClick = { /*TODO*/ }) {
						if (done) {
							Icon(Icons.TwoTone.Restore, "Done")
							Spacer(modifier = Modifier.width(4.dp))
							Text(text = "MARK UNDONE")
						} else {
							Icon(Icons.TwoTone.Check, "Done")
							Spacer(modifier = Modifier.width(4.dp))
							Text(text = "MARK DONE")
						}
					}
				}
				
				Text(
					text = DateFormat.getLongDateFormat(LocalContext.current).format(model.deadLine),
					style = MaterialTheme.typography.labelSmall
				)
			}
		}
	}
}

@Preview
@Composable
private fun LightPreview() {
	PeriodicTodoTheme(false) {
		TaskComponent(model = sampleTaskViewModel)
	}
}

@Preview
@Composable
private fun DarkPreview() {
	PeriodicTodoTheme(true) {
		TaskComponent(model = sampleTaskViewModel)
	}
}
