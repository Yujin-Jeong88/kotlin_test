package com.example.followtest.Following

interface FollowingView {
    fun onFollowingSuccess(code:Int, result: HashMap<String, List<String>>)
    fun onFollowingFailure(code:Int, msg:String)
}