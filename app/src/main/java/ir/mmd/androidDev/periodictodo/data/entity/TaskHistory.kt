package ir.mmd.androidDev.periodictodo.data.entity

import androidx.room.Embedded
import androidx.room.Relation


data class TaskHistory(
	@Embedded val task: TaskEntity,
	@Relation(
		parentColumn = "id",
		entityColumn = "task_id"
	) val delayedTasks: List<DelayedTaskEntity>
)