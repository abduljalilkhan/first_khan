package com.example.githubmvvm.ViewModelFst

data class BidsRegisteredResponse(
    val success: Int,
    val message: String,
    val fucntion: String,
    val total: Int,
    val vehicles: List<Vehicle>
)

data class Vehicle(
    val Address: Any,
    val BidAmount: Any,
    val BidDateTime: Any,
    val BidExpiryDate: String,
    val BidderID: String,
    val DealerTitle: String,
    val Make: String,
    val Model: String,
    val VIN: String,
    val CityName: String,
    val CompanyName: String,
    val Rating: String,
    val FirstName: String,
    val LastName: String,
    val ReBidAmount: String,
    val ReBidDateTime: Any,
    val StateCode: String,
    val Status: String,
    val UserImage: String,
    val VehicleBidderID: String,
    val VehicleID: String,
    val Zip: String,
    val vehicle_dropdown: List<VehicleDropdown>,
    val Name: String,
    val ApprovedBid: String,
    val AddedDate: String,
    val EngineSize: String,
    val GroupID: String,
    val IsDeleted: Any,
    val MakeID: String,
    val Mileage: String,
    val ModelID: String,
    val OverAllVehicle: String,
    val TestDrive: String,
    val VehYear: String,
    var VehicleStatus: String,
    val thumnail: String,
    val HighestBid: String

)

data class VehicleDropdown(
    val FieldValue: String,
    val ID: String,
    val LabelText: String,
    val VehicleID: String,
    val LabelIcon: String
)
