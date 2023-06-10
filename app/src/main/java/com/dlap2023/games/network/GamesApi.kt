package com.dlap2023.games.network

import com.dlap2023.games.model.Game
import com.dlap2023.games.model.GameDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface GamesApi {
    @GET
    fun getGames(
        @Url url: String?   //getGames("cm/games/games_list.php")
    ): Call<ArrayList<Game>>

    @GET("games/game_detail")    //getGameDetail("456884", "zeldita")   cm/game/game_detail.php?
    fun getGameDetail(
        @Query("id") id: String?/*,
        @Query("name") name: String?*/
    ): Call<GameDetail>

    @GET("games/game_detail/{id}")   //getGameDetailApiary("456884", "zeldita")     //game/game_detail/456884/zeldota
    fun getGameDetailApiary(
        @Path("id") id: String?/*,
        @Path("nombre") nombre: String?*/
    ): Call<GameDetail>
}