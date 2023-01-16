package ir.mmd.androidDev.periodictodo.ui.component

import android.text.format.DateFormat
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Check
import androidx.compose.material.icons.twotone.CheckCircle
import androidx.compose.material.icons.twotone.Circle
import androidx.compose.material.icons.twotone.Restore
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
			.clip(CardDefaults.shape)
			.background(cardColor)
			.padding(16.dp)
			.animateContentSize()
	) {
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

private val sampleTaskViewModel = TaskViewModel(
	title = "Clean Out the Garage",
	description = """
		Cleaning out the garage can be a daunting task, but it is an important part of home maintenance. Taking the time to organize and declutter your garage can help you save time, money, and energy in the long run.
		Before you start, it’s important to make sure you have the right supplies. You’ll need garbage bags, boxes, and a few tools like a broom and dustpan. You may also want to invest in a few storage containers or shelves to help you organize the items that you keep.
		Once you have the supplies, the first step is to remove all the items from the garage and sort them into piles. Discard any items that are broken, outdated, or no longer needed. You can also donate items that are still in good condition or consider selling them in a yard sale or online.
		Next, you’ll want to sweep and mop the floor to get rid of any dirt and debris. Vacuuming can help if you have carpets. After the floor is clean, you can start putting the items back in the garage.
		If you have a lot of items, it’s best to group them together by type. For example, you could store all your gardening supplies in one area and all your sporting goods in another. If possible, use storage containers or shelves to keep everything organized.
		Finally, you’ll want to take some time to maintain your garage. Make sure to sweep and mop the floor regularly and dust the shelves. You should also check for any signs of pest infestations and take steps to prevent them from occurring.
		Cleaning out the garage is a big job but it’s worth it in the end. Taking the time to organize and declutter your space will help you save time and money and keep your home in tip-top shape.
	""".trimIndent(),
	Date(1678200535066),
	mutableStateOf(false)
)

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
