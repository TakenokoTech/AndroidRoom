package tech.takenoko.roomsample.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import tech.takenoko.roomsample.App

@Entity
class User (
    @PrimaryKey var name: String
)

@Dao
interface UserDao {
    @Query("select * from user")
    fun findAll(): LiveData<List<User>>
    @Insert
    fun insert(user1: User)
}

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}

class DatabaseBuilder {
    companion object {
        private var appDatabase = Room
                .databaseBuilder(App.getContext().applicationContext, AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()

        fun build(): AppDatabase {
            return appDatabase
        }
    }
}


