package tech.takenoko.roomsample.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import tech.takenoko.roomsample.model.database.DatabaseBuilder
import tech.takenoko.roomsample.model.database.User
import tech.takenoko.roomsample.utils.AppLog

interface ISampleRepository {
    fun getName(): LiveData<String>
    fun addName(s: String)
}

object SampleRepository: ISampleRepository {

    override fun getName(): LiveData<String> {
        AppLog.debug("SampleRepository", "getName")
        return Transformations.map(DatabaseBuilder.build().userDao.findAll()) {
            AppLog.debug("SampleRepository", it.last().name)
            return@map if(it != null && it.size > 0) it.last().name else ""
        }
    }

    override fun addName(s: String) {
        DatabaseBuilder.build().userDao.insert(User(name = s))
    }
}