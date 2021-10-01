package com.gb.codingchalleng

import com.google.gson.annotations.SerializedName
import java.util.*
data class Guides(
    @SerializedName("data") var guidesList: List<Guide>)

data class Guide(
    @SerializedName("startDate")
    var startDate: String?,
    @SerializedName("endDate")
    var endDate: String?,
    @SerializedName("name")
    var name: String?,
    @SerializedName("url")
    var url: String?,
    @SerializedName("venue")
    var venue: Venue?,
    @SerializedName("icon")
    var icon: String // Use GLide to convert
)


data class Venue(var city: String?, var state: String?) {
}
/**
 * {
"data": [
{
"startDate": "<date>",
"endDate": "<date>",
"name": "<name>",
"url": "<url>",
"venue": {"city": "<city>", "state": "<state>"},
"icon": "<url to png image>"
},
… <more objects>
]
}
        */