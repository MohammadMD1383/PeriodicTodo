package ir.mmd.androidDev.periodictodo.data.dao

import androidx.room.*
import ir.mmd.androidDev.periodictodo.data.entity.TaskEntity
import ir.mmd.androidDev.periodictodo.data.entity.TaskHistory

@Dao
interface TaskDao {
	@Query("SELECT * FROM tasks")
	suspend fun getTasks(): List<TaskEntity>
	
	@Insert
	suspend fun add(task: TaskEntity)
	
	@Update
	suspend fun update(task: TaskEntity)
	
	@Delete
	suspend fun remove(task: TaskEntity)
	
	@Transaction
	@Query("SELECT * FROM tasks WHERE id=:taskId")
	suspend fun historyOf(taskId: Long): TaskHistory
}