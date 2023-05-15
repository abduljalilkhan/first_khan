package com.example.githubmvvm.Network_Stuff

import com.example.githubmvvm.Utils.Prefs_Operation
import com.mypcp.cannon_auction.Login_SignUp.Login.LoginConstant
import com.mypcp.cannon_auction.Login_SignUp.Login.Model.LoginResponse
import java.io.File
import okhttp3.MediaType
import okhttp3.RequestBody

class CommanWebApiParams {

    // for live app use group id=7
    // for testing purpose use group id=14
    val strGroupId = "14"

    // /for sending params with image
    fun commanParams(params: MutableMap<String, RequestBody>): MutableMap<String, RequestBody> {
        val loginPrefsData =
            Prefs_Operation.getModelPref(LoginConstant.LOGIN_RESPONSE, LoginResponse::class.java)
        params["pcp_user_id"] = createRequestBody(loginPrefsData.pcp_user_id)
        params["role_id"] = createRequestBody(loginPrefsData.user_cizacl_role_id)
        params["user_id"] = createRequestBody(loginPrefsData.user_id)
        params["BidderType"] = createRequestBody(loginPrefsData.BidderType)
        params["GroupID"] = createRequestBody(strGroupId)
        // params["deviceid"]= createRequestBody( Prefs_Operation.readString(FIREBASE_TOKEN,"")+"")
        params["os"] = createRequestBody("Android")

        return params
    }

    // /for sending params without image
    fun commanParams(params: HashMap<String, String>): HashMap<String, String> {
        val loginPrefsData =
            Prefs_Operation.getModelPref(LoginConstant.LOGIN_RESPONSE, LoginResponse::class.java)
        params["pcp_user_id"] = loginPrefsData.pcp_user_id
        params["role_id"] = loginPrefsData.user_cizacl_role_id
        params["user_id"] = loginPrefsData.user_id
        params["BidderType"] = loginPrefsData.BidderType
        params["GroupID"] = strGroupId
        // params["deviceid"]= Prefs_Operation.readString(FIREBASE_TOKEN,"")+""
        params["os"] = "Android"

        return params
    }

    // /for sending params without image
    fun commanParamsHardCore(params: HashMap<String, String>): HashMap<String, String> {
        params["pcp_user_id"] = "50"
        params["role_id"] = "18"
        params["user_id"] = "50"
        params["BidderType"] = "3"
        params["GroupID"] = strGroupId
        params["deviceid"] = "f1C_dy6qQsmGVWNerTBipj:APA91bHJ-Pjw8djAeKUx7rVklafQ-PCJZSXvvshZC52jBes2gwKlNwOD0XCH9zYGLPeoKzAcyJSZnivbvCu8VkC16PbM1afR2aVzqPqglwt0TxUoFnHX4d77_Tx4kJRqSVcCmUJ3b46W"

        params["os"] = "Android"

        return params
    }

    fun createRequestBody(s: String): RequestBody {
        val name: RequestBody = RequestBody.create(MediaType.parse("text/plain"), s)
        return name
    }

    fun createRequestBody(file: File): RequestBody {
        // params.put("newProfilePicture" + "\"; filename=\"" + FilenameUtils.getName(file.getAbsolutePath()), RequestBody.create(MediaType.parse("image/jpg"), file));

        val fbody = RequestBody.create(MediaType.parse("image/*"), file)
        return fbody
    }
}
