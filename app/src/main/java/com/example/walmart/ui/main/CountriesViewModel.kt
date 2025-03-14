package com.example.walmart.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmart.data.model.Countries
import com.example.walmart.data.network.RetrofitInstace
import kotlinx.coroutines.launch

class CountriesViewModel:ViewModel() {

    private val _posts= MutableLiveData<List<Countries>>()
    val posts: LiveData<List<Countries>> get() = _posts

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    fun fetchPosts(){

        viewModelScope.launch {
            _isLoading.value=true
            try{
                _posts.value=RetrofitInstace.api.getPosts()

                _errorMessage.value=""
            }
            catch (e:Exception){
                _errorMessage.value="Failed to Load Posts"
            }
            finally {
                _isLoading.value=false
            }

        }


    }

}