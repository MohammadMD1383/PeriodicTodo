package ir.mmd.androidDev.periodictodo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity("delayed_tasks")
data class DelayedTaskEntity(
	@PrimaryKey(true) val id: Long = 0,
	@ColumnInfo("task_id") val taskId: Long,
	@ColumnInfo("scheduled_time") val scheduledTime: Date
)