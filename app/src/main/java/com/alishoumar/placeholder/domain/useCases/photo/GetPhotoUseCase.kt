package com.alishoumar.placeholder.domain.useCases.photo

import com.alishoumar.placeholder.domain.models.photo.Photo
import com.alishoumar.placeholder.domain.repository.PhotoRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPhotoUseCase @Inject constructor(private val repo:PhotoRepository) {

    operator fun invoke(albumId:Int):Flow<RequestState<List<Photo>>> = flow {
        emit(RequestState.Loading())
        try {
            emit(RequestState.Success(repo.getPhotosByAlbumId(albumId)))
        }catch (e:Exception){
            emit(RequestState.Error(e))
        }
    }

}