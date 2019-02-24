package tech.takenoko.roomsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import tech.takenoko.roomsample.usecase.GetNameRes
import tech.takenoko.roomsample.usecase.SampleUsecaseImpl
import tech.takenoko.roomsample.utils.AppLog
import tech.takenoko.roomsample.viewmodel.SampleViewModel


@RunWith(AndroidJUnit4::class)
class SampleViewModelInstrumentedTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock(name = "usecase")
    lateinit var sampleUsecase: SampleUsecaseImpl

    @InjectMocks
    lateinit var sampleViewModel: SampleViewModel

    @Before
    fun setup() {
        AppLog.debug("SampleViewModelInstrumentedTest", "setup")
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun useAppContext() {
        Assert.assertEquals(sampleViewModel.firstName.get(), "")
        Assert.assertEquals(sampleViewModel.lastName.get(), "")

        val livedata = MutableLiveData<GetNameRes>()
        Mockito.`when`(sampleUsecase.getName()).thenReturn(livedata)
        sampleViewModel.load()

        Assert.assertEquals(sampleViewModel.firstName.get(), "")
        Assert.assertEquals(sampleViewModel.lastName.get(), "")

        livedata.postValue(GetNameRes("first", "last"))

        Assert.assertEquals(sampleViewModel.firstName.get(), "first")
        Assert.assertEquals(sampleViewModel.lastName.get(), "last")
    }
}