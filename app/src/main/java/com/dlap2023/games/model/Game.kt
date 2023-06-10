package com.dlap2023.games.model

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("id")
    var id: String?,

    @SerializedName("thumbnail")
    var thumbnail: String?,

    @SerializedName("title")
    var title: String?

    //Si tenemos nombres de variables del JSON con guion medio
    //@SerializedName("official-artwork")
    //var official_artwork: String?
)
