package com.example.githubmvvm.Network_Stuff

interface OnFinishedListner {
    fun onSuccess(body: Any?)
    fun onError()
    fun onFailure(t: Throwable)
}
