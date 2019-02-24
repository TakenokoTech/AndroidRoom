package tech.takenoko.roomsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import tech.takenoko.roomsample.repository.SampleRepository
import tech.takenoko.roomsample.usecase.SampleUsecaseImpl
import tech.takenoko.roomsample.utils.AppLog

//@RunWith(AndroidJUnit4::class)
//@RunWith(PowerMockRunner::class)
//@PrepareForTest(SampleRepository::class)
class SampleUsecaseInstrumentedTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

//    @Mock(name = "SampleRepository")
//    lateinit var sampleRepository: SampleRepository

    @InjectMocks
    lateinit var sampleUsecase: SampleUsecaseImpl

    @Before
    fun setup() {
        AppLog.debug("SampleViewModelInstrumentedTest", "setup")
        MockitoAnnotations.initMocks(this)
//        PowerMockito.mockStatic(SampleRepository::class.java)
    }

    @Test
    fun useAppContext() {
        val livedata = MutableLiveData<String>()
//        Mockito.`when`(SampleRepository.getName()).thenReturn(livedata)
        val getName = sampleUsecase.getName()

        Assert.assertEquals(getName.value, null)
    }
}