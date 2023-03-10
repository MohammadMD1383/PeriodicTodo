package ir.mmd.androidDev.periodictodo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.mmd.androidDev.periodictodo.data.TaskRepeatMode
import java.util.Date

@Entity("tasks")
data class TaskEntity(
	@PrimaryKey(true) val id: Long = 0,
	@ColumnInfo val title: String,
	@ColumnInfo val description: String?,
	@ColumnInfo("repeat_mode") val repeatMode: TaskRepeatMode,
	@ColumnInfo("scheduled_time") val scheduledTime: Date
)