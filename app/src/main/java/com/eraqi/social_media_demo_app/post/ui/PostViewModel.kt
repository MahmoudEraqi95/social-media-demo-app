package com.eraqi.social_media_demo_app.post.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eraqi.social_media_demo_app.post.data.Post
import com.eraqi.social_media_demo_app.post.data.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    private val repository: PostRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<PostsUiState>(PostsUiState.Loading)
    val uiState: StateFlow<PostsUiState> = _uiState

    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _uiState.value = PostsUiState.Success(repository.getPosts())
            } catch (e: Exception) {
                _uiState.value = PostsUiState.Error(e.message.toString())
            }
        }
    }
}
