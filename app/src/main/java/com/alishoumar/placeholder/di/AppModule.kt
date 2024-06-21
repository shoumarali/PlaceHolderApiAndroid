package com.alishoumar.placeholder.di

import com.alishoumar.placeholder.data.remote.album.AlbumApi
import com.alishoumar.placeholder.data.remote.comment.CommentApi
import com.alishoumar.placeholder.data.remote.photo.PhotoApi
import com.alishoumar.placeholder.data.remote.post.PostApi
import com.alishoumar.placeholder.data.remote.user.UserApi
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import com.alishoumar.placeholder.domain.repository.CommentRepository
import com.alishoumar.placeholder.domain.repository.PhotoRepository
import com.alishoumar.placeholder.domain.repository.PostRepository
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.useCases.album.GetAlbumUseCase
import com.alishoumar.placeholder.domain.useCases.comments.GetAllCommentsUseCase
import com.alishoumar.placeholder.domain.useCases.photo.GetPhotoUseCase
import com.alishoumar.placeholder.domain.useCases.post.GetAllPostsUseCase
import com.alishoumar.placeholder.domain.useCases.user.GetAllUsersUseCase
import com.alishoumar.placeholder.domain.useCases.user.GetUserByNameUseCase
import com.alishoumar.placeholder.domain.useCases.user.GetUserInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  AppModule{
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideUserApi(retrofit: Retrofit):UserApi{
        return retrofit.create(UserApi::class.java)
    }

    @Provides
    @Singleton
    fun providePostApi(retrofit: Retrofit):PostApi{
        return retrofit.create(PostApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCommentsApi(retrofit: Retrofit):CommentApi{
        return retrofit.create(CommentApi::class.java)
    }

    @Provides
    @Singleton
    fun provideAlbumsAPi(retrofit: Retrofit):AlbumApi{
        return retrofit.create(AlbumApi::class.java)
    }

    @Provides
    @Singleton
    fun providePhotosApi(retrofit: Retrofit):PhotoApi{
        return retrofit.create(PhotoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideUserUseCase(userRepository: UserRepository): GetAllUsersUseCase {
        return GetAllUsersUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetUserByNameUseCase(userRepository: UserRepository): GetUserByNameUseCase{
        return GetUserByNameUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun provideGetUserInfoUseCase(userRepository: UserRepository): GetUserInfoUseCase{
        return GetUserInfoUseCase(userRepository)
    }

    @Provides
    @Singleton
    fun providesGetAllPostsUseCase(postRepository: PostRepository):GetAllPostsUseCase{
        return GetAllPostsUseCase(postRepository)
    }

    @Provides
    @Singleton
    fun provideGetAllCommentsUseCase(commentsRepository: CommentRepository): GetAllCommentsUseCase{
        return GetAllCommentsUseCase(commentsRepository)
    }

    @Provides
    @Singleton
    fun provideGetPhotoUseCase(photoRepository: PhotoRepository):GetPhotoUseCase{
        return GetPhotoUseCase(photoRepository)
    }

    @Provides
    @Singleton
    fun provideGetAlbumUseCase(albumRepository: AlbumRepository):GetAlbumUseCase{
        return GetAlbumUseCase(albumRepository)
    }
}