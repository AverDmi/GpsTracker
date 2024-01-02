package com.dimthomas.gpstracker

import android.app.Application
import com.dimthomas.gpstracker.db.MainDb

class MainApp: Application() {

    val database by lazy { MainDb.getDatabase(this) }
}