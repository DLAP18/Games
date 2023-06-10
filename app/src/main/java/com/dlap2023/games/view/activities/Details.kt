package com.dlap2023.games.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.dlap2023.games.R
import com.dlap2023.games.databinding.ActivityDetailsBinding
import com.dlap2023.games.model.Game
import com.dlap2023.games.model.GameDetail
import com.dlap2023.games.network.GamesApi
import com.dlap2023.games.network.RetrofitService
import com.dlap2023.games.utils.Constants
import com.dlap2023.games.view.adapters.GamesAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Details : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        val id = bundle?.getString("id", "")

        val call = RetrofitService.getRetrofit().create(GamesApi::class.java)
            .getGameDetailApiary(id) //Con Apiary
            //.getGameDetail(id) //Para el servidor www.serverbpw.com

        call.enqueue(object: Callback<GameDetail>{
            override fun onResponse(
                call: Call<GameDetail>,
                response: Response<GameDetail>
            ){
                binding.pbConexion.visibility = View.GONE
                binding.tvTitle.text = response.body()!!.title
                binding.tvLongDesc.text = response.body()!!.longDesc

                Glide.with(this@Details)
                    .load(response.body()!!.image)
                    .into(binding.ivImage)
            }

            override fun onFailure(call: Call<GameDetail>, t: Throwable) {
                binding.pbConexion.visibility = View.GONE
                Toast.makeText(this@Details, "No hay conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}