package com.mypcp.cannon_auction.Login_SignUp.Login.Model

data class LoginResponse(
    var Authorization: String,
    var BidderType: String,
    var DisplayName: String,
    var FirstName: String,
    var LastName: String,
    var CompanyName: String,
    var CityName: String,
    var Zip: String,
    var StateID: String,
    var UserImage: String,
    val auth_token: String,
    var email: String,
    var Phone: String,
    val expireTime: String,
    val isemail: Int,
    val pcp_user_id: String,
    var statelist: List<Statelist>,
    val success: Int,
    val user_cizacl_role_id: String,
    val user_id: String,
    val Pass: String,
    val user_lastaccess: String,
    var BidDurationTime: Int

)

data class Statelist(
    val CountryCode: String,
    val StateCode: String,
    val StateID: String,
    val StateTitle: String

)
