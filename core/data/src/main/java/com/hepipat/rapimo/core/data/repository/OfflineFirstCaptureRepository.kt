package com.hepipat.rapimo.core.data.repository

import com.hepipat.rapimo.core.database.dao.CaptureDao
import javax.inject.Inject

class OfflineFirstCaptureRepository @Inject constructor(
    private val captureDao: CaptureDao
) {
}