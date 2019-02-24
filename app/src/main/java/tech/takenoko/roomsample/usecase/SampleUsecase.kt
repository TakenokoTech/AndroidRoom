package tech.takenoko.roomsample.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import tech.takenoko.roomsample.repository.SampleRepository
import tech.takenoko.roomsample.utils.AppLog
import java.util.*

class GetNameRes(var first: String, var last: String)

interface SampleUsecase {
    fun getName(): LiveData<GetNameRes>
    fun regist()
}

open class SampleUsecaseImpl : SampleUsecase {

    private var num = 0

    override fun getName(): LiveData<GetNameRes> {
        AppLog.debug("SampleUsecaseImpl", "getName")
        return Transformations.map(SampleRepository.getName()) {
            val first = it
            val last = "$num"
            AppLog.debug("SampleUsecaseImpl", "${first} ${last}")
            return@map GetNameRes(first = first, last = last)
        }
    }

    override fun regist() {
        SampleRepository.addName(UUID.randomUUID().toString())
        num++
    }
}
