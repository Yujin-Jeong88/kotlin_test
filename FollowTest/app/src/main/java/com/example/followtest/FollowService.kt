package com.example.followtest

import android.util.Log
import com.example.followtest.Follower.FollowerView
import com.example.followtest.Following.FollowingView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class FollowService {

    private lateinit var followerView: FollowerView
    private lateinit var followingView: FollowingView

    fun setFollowerView(followerView: FollowerView){
        this.followerView = followerView
    }
    fun setFollowingView(followingView: FollowingView){
        this.followingView = followingView
    }

    fun getFollowerList(token:String) {
        val followService = getRetrofit().create(FollowRetrofitInterface::class.java)
        followService.getFollowerList(token).enqueue(object: Callback<DefaultResponse> {

            override fun onResponse(
                call: Call<DefaultResponse>,
                response: Response<DefaultResponse>
            ) {
                Log.d("FOLLOWER/SUCCESS",response.toString())
                val resp: DefaultResponse = response.body()!!
                Log.d("FOLLOWER/SUCCESS", resp.toString())
                when(val code = resp.code){
                    1000-> followerView.onFollowerSuccess(code, resp.result)
                    else-> followerView.onFollwerFailure(code, resp.message)

                }
            }

            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                Log.d("FOLLOWER/FAILURE", t.message.toString())
            }
        })

    }

    fun getFollowingList(token: String) {
        val followingService = getRetrofit().create(FollowRetrofitInterface::class.java)
        followingService.getFollowingList(token).enqueue(object: Callback<DefaultResponse> {

            override fun onResponse(
                call: Call<DefaultResponse>,
                response: Response<DefaultResponse>
            ) {
                Log.d("FOLLOWING/SUCCESS", response.toString())
                val resp: DefaultResponse = response.body()!!
                Log.d("FOLLOWING/SUCCESS", resp.toString())
                when(val code = resp.code){
                    1000-> followingView.onFollowingSuccess(code, resp.result)
                    else-> followingView.onFollowingFailure(code, resp.message)
                }
            }

            override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {
                Log.d("FOLLOWING/FAILURE", t.message.toString())
            }
        })
    }

}