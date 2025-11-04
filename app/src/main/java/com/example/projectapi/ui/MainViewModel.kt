package com.example.projectapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectapi.Model.Post
import com.example.projectapi.data.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel  : ViewModel(
){
    private val repository = Repository()
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts: StateFlow<List<Post>> = _posts

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    // Load posts from repository
    fun fetchPosts() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _error.value = null

                val response = repository.getPosts()
                _posts.value = response

            } catch (e: Exception) {
                _error.value = "Failed to load posts: ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}