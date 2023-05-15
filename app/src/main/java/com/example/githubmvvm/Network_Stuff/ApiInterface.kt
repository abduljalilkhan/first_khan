package com.mypcp.cannon_auction.Network_Stuff

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @FormUrlEncoded
    @POST("bid/login/signin")
    fun getLoginb(@FieldMap hashMap: HashMap<String, String>): Call<Any>

    // @POST("bid/vehicles/uploadedvehiclemedia")
    @FormUrlEncoded
    @POST
    fun getAnyResponse(@HeaderMap headers: HashMap<String, String>, @Url url: String, @FieldMap hashMap: HashMap<String, String>): Call<Any>

    @Multipart
    @POST("bid/groupchat/addgroup")
    fun createGroup(
        @HeaderMap headers: HashMap<String, String>,
        @PartMap params: MutableMap<String, RequestBody>,
        @PartMap files: MutableMap<String, RequestBody>
    ): Call<Any>

    @Multipart
    @POST("bid/vehicles/vehiclemediauploaded")
    fun uploadMedia(@PartMap params: MutableMap<String, RequestBody>, @PartMap files: MutableMap<String, RequestBody>): Call<Any>
}
