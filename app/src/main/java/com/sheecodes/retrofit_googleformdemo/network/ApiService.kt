package com.sheecodes.retrofit_googleformdemo.network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @POST("1FAIpQLSfY8nzs8rqyBBv4slBUxu8RLKNTe6yYu4lCgmRPY_mrnee0vw/formResponse")
    @FormUrlEncoded
    fun submitResponse(
        @Field("entry.167627252") emailAddress: String,
        @Field("entry.1487586230") fullName: String,
        @Field("entry.1673881430") github: String,
        @Field("entry.2059565087") gender: String,
        @Field("entry.124829766") kotlin: String?,
        @Field("entry.124829766") java: String?,
        @Field("entry.124829766") dart: String?,
        @Field("entry.124829766") swift: String?,
    ): Call<Void>
}