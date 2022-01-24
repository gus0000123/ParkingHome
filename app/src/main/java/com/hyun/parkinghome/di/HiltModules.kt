package com.hyun.parkinghome.di

import android.content.Context
import com.hyun.parkinghome.db.AppDatabase
import com.hyun.parkinghome.db.CarDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModules {
    @Provides
    fun provideAppDatabase(
        @ApplicationContext
        context: Context
    ): AppDatabase = AppDatabase.getInstance(context)

    @Provides
    fun provideCarDao(appDatabase: AppDatabase): CarDao = appDatabase.carDao()
}