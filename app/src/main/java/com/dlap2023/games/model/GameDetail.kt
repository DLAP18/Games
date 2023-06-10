package com.dlap2023.games.model

import com.google.gson.annotations.SerializedName

data class GameDetail(
    @SerializedName("title")
    var title: String?,

    @SerializedName("image")
    var image: String?,

    @SerializedName("long_desc")
    var LongDesc: String?

    //Si tenemos nombres de variables del JSON con guion medio
    //@SerializedName("official-artwork")
    //var official_artwork: String?
)
