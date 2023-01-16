package ir.mmd.androidDev.periodictodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.mmd.androidDev.periodictodo.data.dao.TaskDao
import ir.mmd.androidDev.periodictodo.data.entity.TaskEntity

@Database(
	entities = [TaskEntity::class],
	version = 1
)
abstract class AppDatabase : RoomDatabase() {
	companion object {
		private lateinit var instance: AppDatabase
		
		fun init(context: Context) {
			instance = Room.databaseBuilder(
				context,
				AppDatabase::class.java,
				"app.db"
			).build()
		}
	}
	
	abstract fun taskDao(): TaskDao
}