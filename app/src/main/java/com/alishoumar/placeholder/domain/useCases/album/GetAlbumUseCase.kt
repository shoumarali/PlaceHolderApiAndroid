package com.alishoumar.placeholder.domain.useCases.album

import com.alishoumar.placeholder.domain.models.album.Album
import com.alishoumar.placeholder.domain.repository.AlbumRepository
import com.alishoumar.placeholder.domain.util.RequestState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetAlbumUseCase @Inject constructor(private val repo: AlbumRepository) {

    operator fun invoke(userId:Int): Flow<RequestState<List<Album>>> = flow {
        emit(RequestState.Loading())
        try {
            emit(RequestState.Success(repo.getAlbumsByUserId(userId)))
        }catch (e:Exception){
            emit(RequestState.Error(e))
        }
    }
}