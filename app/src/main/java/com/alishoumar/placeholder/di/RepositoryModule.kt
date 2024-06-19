package com.alishoumar.placeholder.di

import com.alishoumar.placeholder.data.repository.AlbumRepositoryImpl
import com.alishoumar.placeholder.data.repository.CommentRepositoryImpl
import com.alishoumar.placeholder.data.repository.PhotoRepositoryImpl
import com.alishoumar.placeholder.data.repository.PostRepositoryImpl
import com.alishoumar.placeholder.data.repository.UserRepositoryImpl
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import com.alishoumar.placeholder.domain.repository.CommentRepository
import com.alishoumar.placeholder.domain.repository.PhotoRepository
import com.alishoumar.placeholder.domain.repository.PostRepository
import com.alishoumar.placeholder.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ):UserRepository


    @Binds
    @Singleton
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ):PostRepository

    @Binds
    @Singleton
    abstract fun bindCommentRepository(
        commentRepositoryImpl: CommentRepositoryImpl
    ):CommentRepository

    @Binds
    @Singleton
    abstract fun bindAlbumsRepository(
        albumRepositoryImpl: AlbumRepositoryImpl
    ):AlbumRepository

    @Binds
    @Singleton
    abstract fun bindPhotoRepository(
        albumRepositoryImpl: PhotoRepositoryImpl
    ):PhotoRepository
}