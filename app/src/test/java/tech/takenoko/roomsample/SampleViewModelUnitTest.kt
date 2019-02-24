package tech.takenoko.roomsample

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import tech.takenoko.roomsample.viewmodel.ISampleViewModel
import tech.takenoko.roomsample.viewmodel.SampleViewModel
import io.reactivex.schedulers.Schedulers
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import org.junit.After
import org.junit.Before



class SampleViewModelUnitTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        //RxAndroidPlugins.setInitMainThreadSchedulerHandler {  }
    }

    @After
    fun teardown() {
        RxAndroidPlugins.reset()
    }

    @Test
    fun addition_isCorrect() {

        val viewmodel: ISampleViewModel = SampleViewModel()
        assertEquals(viewmodel.firstName.get(), viewmodel.lastName.get())
    }
}