package com.hepipat.rapimo.core.data.di

import com.hepipat.rapimo.core.data.repository.CaptureRepository
import com.hepipat.rapimo.core.data.repository.OfflineFirstCaptureRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindsCaptureRepository(captureRepository: OfflineFirstCaptureRepository): CaptureRepository
}