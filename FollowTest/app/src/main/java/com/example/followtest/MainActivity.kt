package com.example.followtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.followtest.Follower.FollowerView
import com.example.followtest.Following.FollowingView
import com.example.followtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FollowerView, FollowingView {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getFollowerBtn.setOnClickListener {
            getFollowerList()
        }

        binding.getFollowingBtn.setOnClickListener {
            getFollowingList()
        }
    }

    private fun getFollowerList() {
        val followService = FollowService();
        followService.setFollowerView(this)
        // followService.getFollowerList(token);

    }

    private fun getFollowingList() {
        val followService = FollowService();
        followService.setFollowingView(this);
        // followService.getFollowingList(token);
    }

    override fun onFollowerSuccess(code: Int, result: HashMap<String, List<String>>) {
        when (code) {
            1000 -> {
                Toast.makeText(this@MainActivity, "팔로워 목록 조회 성공", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onFollowingSuccess(code: Int, reesult: HashMap<String, List<String>>) {
        when (code) {
            1000 -> {
                Toast.makeText(this@MainActivity, "팔로잉 목록 조회 성공", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onFollwerFailure(code: Int, msg: String) {
        Toast.makeText(this@MainActivity, "팔로워 목록 조회 실패", Toast.LENGTH_SHORT).show()
    }

    override fun onFollowingFailure(code: Int, msg: String) {
        Toast.makeText(this@MainActivity, "팔로잉 목록 조회 실패", Toast.LENGTH_SHORT).show()
    }
}