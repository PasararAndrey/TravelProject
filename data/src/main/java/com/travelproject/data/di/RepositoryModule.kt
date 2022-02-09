package com.travelproject.data.di

import com.travelproject.data.remote.TravelApi
import com.travelproject.data.repository.TravelRepositoryImpl
import com.travelproject.domain.repository.TravelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTravelRepository(travelApi: TravelApi): TravelRepository {
        return TravelRepositoryImpl(travelApi)
    }
}