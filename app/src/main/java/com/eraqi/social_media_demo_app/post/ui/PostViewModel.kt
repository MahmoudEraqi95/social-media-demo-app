package com.eraqi.social_media_demo_app.post.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eraqi.social_media_demo_app.post.data.PostListingResult
import com.eraqi.social_media_demo_app.post.domain.GetPostsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<PostsUiState>(PostsUiState.Loading)
    val uiState: StateFlow<PostsUiState> = _uiState

    fun fetchPosts() {
        viewModelScope.launch {

            val result = getPostsUseCase.invoke()
            when (result) {
                is PostListingResult.Success -> {
                    _uiState.value = PostsUiState.Success(result.posts)
                }

                is PostListingResult.Error -> {

                    _uiState.value = PostsUiState.Error(result.message)
                }
            }
        }
    }

    fun incrementalSync(lastVersion: Int) {
        viewModelScope.launch {
            // val changes = repository.syncSince(lastVersion)
            // merge into local DB (handle deleted = true)
        }
    }
}
