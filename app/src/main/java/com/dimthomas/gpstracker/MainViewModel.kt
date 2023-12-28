package com.dimthomas.gpstracker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dimthomas.gpstracker.location.LocationModel

class MainViewModel: ViewModel() {

    val locationUpdates = MutableLiveData<LocationModel>()
    val timeData = MutableLiveData<String>()

}