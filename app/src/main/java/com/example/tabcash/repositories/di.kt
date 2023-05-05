package com.example.tabcash.repositories

import com.example.tabcash.repositoryContract.RemoteDataSource
import com.example.tabcash.repositoryContract.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule() {
    @Binds
    abstract fun bindRepo(repositoryImp: RepositoryImp): Repository
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RemoteDataSourceModule() {
    @Binds
    abstract fun bindRemoteDataSource(remoteDataSourceImp: RemoteDataSourceImp): RemoteDataSource
}

