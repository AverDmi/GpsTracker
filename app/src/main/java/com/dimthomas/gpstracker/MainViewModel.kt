package com.dimthomas.gpstracker

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.dimthomas.gpstracker.db.MainDb
import com.dimthomas.gpstracker.db.TrackItem
import com.dimthomas.gpstracker.location.LocationModel
import kotlinx.coroutines.launch

@Suppress("UNCHECKED_CAST")
class MainViewModel(db: MainDb): ViewModel() {

    val dao = db.getDao()
    val locationUpdates = MutableLiveData<LocationModel>()
    val timeData = MutableLiveData<String>()
    val tracks = dao.getAllTracks().asLiveData()

    fun insertTrack(trackItem: TrackItem) = viewModelScope.launch {
        dao.insertTrack(trackItem)
    }

    class ViewModelFactory(private val db: MainDb): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(db) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}