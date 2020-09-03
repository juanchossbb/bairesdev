package com.guapiston.bairesdev.model

import com.google.gson.annotations.SerializedName

class Owner (val login : String,
             @SerializedName("avatar_url") val avatarUrl : String)