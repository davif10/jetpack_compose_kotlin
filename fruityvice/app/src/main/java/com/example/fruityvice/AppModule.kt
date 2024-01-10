package com.example.fruityvice

import com.example.fruityvice.interfaces.FruityviceService
import com.example.fruityvice.repository.MainRepository
import com.example.fruityvice.services.RetrofitClient
import com.example.fruityvice.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ServiceComponent
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFruityviceService(): FruityviceService {
        return RetrofitClient.retrofit.create(FruityviceService::class.java)
    }

    @Provides
    @Singleton
    fun provideMainRepository(fruityviceService: FruityviceService) : MainRepository {
        return MainRepository(fruityviceService)
    }

}