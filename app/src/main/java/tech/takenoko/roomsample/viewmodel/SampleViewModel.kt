package tech.takenoko.roomsample.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.takenoko.roomsample.usecase.SampleUsecase
import tech.takenoko.roomsample.usecase.SampleUsecaseImpl
import tech.takenoko.roomsample.utils.AppLog

interface ISampleViewModel {
    val firstName: ObservableField<String>
    val lastName: ObservableField<String>
}

class SampleViewModel(): ViewModel(), ISampleViewModel {
    override val firstName: ObservableField<String> = ObservableField("")
    override val lastName: ObservableField<String> = ObservableField("")

    private var usecase: SampleUsecaseImpl = SampleUsecaseImpl()

    init {
        firstName.set("")
    }

    fun load() {
        usecase.getName().observeForever {
            AppLog.debug("SampleViewModel", "${it.first} ${it.last}")
            this.firstName.set(it.first)
            this.lastName.set(it.last)
        }
    }

    fun onClickButton() {
        usecase.regist()
    }
}