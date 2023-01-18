package ir.mmd.androidDev.periodictodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ir.mmd.androidDev.periodictodo.data.dao.TaskDao
import ir.mmd.androidDev.periodictodo.data.entity.DelayedTaskEntity
import ir.mmd.androidDev.periodictodo.data.entity.TaskEntity

@Database(
	entities = [TaskEntity::class, DelayedTaskEntity::class],
	version = 1
)
@TypeConverters(Converter::class)
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