package ir.mmd.androidDev.periodictodo.data.dao

import androidx.room.*
import ir.mmd.androidDev.periodictodo.data.entity.TaskEntity

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
}