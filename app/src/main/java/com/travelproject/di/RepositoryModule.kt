package com.travelproject.di

import com.travelproject.data.remote.api.TravelApi
import com.travelproject.data.remote.api.UserApi
import com.travelproject.data.repository.TravelRepositoryImpl
import com.travelproject.data.repository.UserRepositoryImpl
import com.travelproject.data.util.SessionManager
import com.travelproject.domain.repository.TravelRepository
import com.travelproject.domain.repository.UserRepository
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
    fun provideTravelRepository(travelApi: TravelApi): TravelRepository = TravelRepositoryImpl(travelApi)

    @Provides
    @Singleton
    fun provideUserRepository(userApi: UserApi, sessionManager: SessionManager): UserRepository = UserRepositoryImpl(userApi, sessionManager)
}