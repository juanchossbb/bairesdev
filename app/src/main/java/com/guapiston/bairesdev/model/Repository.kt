package com.guapiston.bairesdev.model

import com.google.gson.annotations.SerializedName

class Repository (val id : Long,
                  @SerializedName("node_id") val nodeId : String,
                  val name : String,
                  @SerializedName("full_name") val fullname: String,
                  @SerializedName("html_url") val htmlUrl : String,
                  val size : Int, val language : Language,
                  @SerializedName("default_branch")val defaultBranch : String,
                  val owner : Owner)

enum class Language{
    Kotlin, Java
}