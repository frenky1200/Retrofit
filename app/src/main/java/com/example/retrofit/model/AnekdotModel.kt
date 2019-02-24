package com.example.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AnekdotModel {

    @SerializedName("site")
    @Expose
    var site: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("desc")
    @Expose
    var desc: String? = null
    @SerializedName("link")
    @Expose
    var link: Any? = null
    @SerializedName("elementPureHtml")
    @Expose
    var elementPureHtml: String? = null
}

