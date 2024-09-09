package com.samplejetpeckcompose.presenter.main

import android.annotation.SuppressLint
import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.samplejetpeckcompose.common.toDomain
import com.samplejetpeckcompose.data.network.ApiService
import com.samplejetpeckcompose.data.user.UserDTO
import com.samplejetpeckcompose.data.user.UserResponse
import com.samplejetpeckcompose.domain.entity.user.User
import com.samplejetpeckcompose.domain.use_case.user.GetAllUser
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject
import io.reactivex.observers.DisposableSingleObserver

import io.reactivex.android.schedulers.AndroidSchedulers

import io.reactivex.schedulers.Schedulers


@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllUser: GetAllUser,
    application: Application,
) : AndroidViewModel(application) {

    private val disposable = CompositeDisposable()


    @SuppressLint("MutableCollectionMutableState")
    private val _users = mutableStateOf(ArrayList<User>())
    val users: State<ArrayList<User>> = _users


    private val repoLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()


    fun aaa() {
        viewModelScope.launch {
            disposable.add(
                getAllUser.invoke().subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(
                        object : DisposableSingleObserver<ArrayList<User>>() {
                            override fun onSuccess(value: ArrayList<User>) {
                                _users.value = value
                            }

                            override fun onError(e: Throwable) {
                                Log.i("error", e.message.toString())
                            }
                        })
            )
        }
    }


}