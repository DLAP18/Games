package com.dlap2023.games.network

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GamesApi {
    @GET
    fun getGames(
        @Url url: String?   //getGames("cm/games/games_list.php")
    )

    @GET("cm/games/game_detail.php")    //getGameDetail("456884", "zeldita")   cm/game/game_detail.php?
    fun getGameDetail(
        @Query("id") id: String?/*,
        @Query("name") name: String?*/
    )

    @GET("game/game_detail/{id}")   //getGameDetailApiary("456884", "zeldita")     //game/game_detail/456884/zeldota
    fun getGAmeDetailApiary(
        @Path("id") id: String?/*,
        @Path("nombre") nombre: String?*/
    )
}