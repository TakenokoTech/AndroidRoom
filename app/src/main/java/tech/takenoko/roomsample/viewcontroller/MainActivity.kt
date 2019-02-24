package tech.takenoko.roomsample.viewcontroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import tech.takenoko.roomsample.R
import tech.takenoko.roomsample.databinding.ActivityMainBinding
import tech.takenoko.roomsample.viewmodel.SampleViewModel

class MainActivity : AppCompatActivity() {

    private var viewmodel = SampleViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewmodel = viewmodel
        viewmodel.load()
    }
}
