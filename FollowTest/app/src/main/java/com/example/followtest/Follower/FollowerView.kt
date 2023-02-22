package com.example.followtest.Follower

interface FollowerView {
    fun onFollowerSuccess(code:Int, result:HashMap<String, List<String>>)
    fun onFollwerFailure(code:Int, msg: String)
}