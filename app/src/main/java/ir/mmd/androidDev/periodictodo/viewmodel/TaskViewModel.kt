package ir.mmd.androidDev.periodictodo.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.util.Date

data class TaskViewModel(
	val title: String,
	val description: String?,
	val deadLine: Date,
	val isDone: MutableState<Boolean>,
	val isExpanded: MutableState<Boolean> = mutableStateOf(false)
) {
	fun getShortDescription(maxWords: Int): String? {
		description ?: return null
		
		var i = 0
		var ti = 0
		var words = 0
		
		while (i < description.length) {
			if (description[i] == ' ') {
				ti = i
				
				do {
					i++
				} while (i < description.length && description[i] == ' ')
				
				if (++words == maxWords) {
					break
				}
			} else {
				i++
			}
		}
		
		return description.take(ti) + "..."
	}
}
