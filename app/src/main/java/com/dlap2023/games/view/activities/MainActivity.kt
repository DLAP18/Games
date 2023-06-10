package com.dlap2023.games.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.dlap2023.games.databinding.ActivityMainBinding
import com.dlap2023.games.model.Game
import com.dlap2023.games.network.GamesApi
import com.dlap2023.games.network.RetrofitService
import com.dlap2023.games.utils.Constants
import com.dlap2023.games.view.adapters.GamesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val call = RetrofitService.getRetrofit().create(GamesApi::class.java)
            .getGames("games/games_list") //Para Apiary
        //.gteGames("cm/games_list.php") //Para www.serverbpw.com

        call.enqueue(object: Callback<ArrayList<Game>>{
            override fun onResponse(
                call: Call<ArrayList<Game>>,
                response: Response<ArrayList<Game>>
            ) {
                binding.pbConexion.visibility = View.GONE

                Log.d(Constants.LOGTAG, "Respuesta el servidor: ${response.toString()}")
                Log.d(Constants.LOGTAG, "Datos: ${response.body().toString()}")

                binding.rvMenu.layoutManager = LinearLayoutManager(this@MainActivity)
                binding.rvMenu.adapter = GamesAdapter(this@MainActivity, response.body()!!) {selectedGame: Game ->
                    gameClicked(selectedGame)
                }
            }

            override fun onFailure(call: Call<ArrayList<Game>>, t: Throwable){
                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@MainActivity, "No hay conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun gameClicked(game: Game){
        /*Toast.makeText(this, "Click en el elemento con título ${game.title}", Toast.LENGTH_SHORT).show()*/

        val bundle = Bundle()
        bundle.putString("id", game.id)

        val intent = Intent(this, Details::class.java)
        intent.putExtras(bundle)

        startActivity(intent)
    }
}