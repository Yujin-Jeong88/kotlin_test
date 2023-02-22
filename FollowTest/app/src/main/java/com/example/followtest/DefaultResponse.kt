package com.example.followtest

import com.google.gson.annotations.SerializedName

data class DefaultResponse(
    @SerializedName(value="isSuccess")val isSuccess:Boolean,
    @SerializedName(value="code")val code:Int,
    @SerializedName(value="message")val message:String,
    @SerializedName(value="result")val result:HashMap<String, List<String>>
)
