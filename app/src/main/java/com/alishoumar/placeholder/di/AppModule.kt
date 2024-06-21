package com.alishoumar.placeholder.di

import com.alishoumar.placeholder.data.remote.album.AlbumApi
import com.alishoumar.placeholder.data.remote.comment.CommentApi
import com.alishoumar.placeholder.data.remote.photo.PhotoApi
import com.alishoumar.placeholder.data.remote.post.PostApi
import com.alishoumar.placeholder.data.remote.user.UserApi
import com.alishoumar.placeholder.domain.repository.UserRepository
import com.alishoumar.placeholder.domain.useCases.GetAllUsersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Flow
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
    fun provideUserUseCase(userRepository: UserRepository):GetAllUsersUseCase{
        return GetAllUsersUseCase(
            userRepository
        )
    }
}