package com.example.retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast

import java.util.ArrayList

import com.example.retrofit.R
import com.example.retrofit.api.UmoriliApi
import com.example.retrofit.controller.Controller
import com.example.retrofit.model.AnekdotModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    internal lateinit var recyclerView: RecyclerView
    internal lateinit var posts: MutableList<AnekdotModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        umoriliApi = Controller.api

        posts = ArrayList()

        recyclerView = findViewById(R.id.posts_recycle_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = PostsAdapter(posts)
        recyclerView.adapter = adapter

        /* Пример вызова синхронного запроса. В главном потоке ТАБУ!
        try {
            Response response = umoriliApi.getData("bash", 50).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        umoriliApi!!.getData("new anekdot", 50).enqueue(object : Callback<List<AnekdotModel>> {
            override fun onResponse(call: Call<List<AnekdotModel>>, response: Response<List<AnekdotModel>>) {
                posts.addAll(response.body())
                recyclerView.adapter!!.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<AnekdotModel>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "An error occurred during networking", Toast.LENGTH_SHORT).show()
            }
        })
    }

    companion object {

        private var umoriliApi: UmoriliApi? = null
    }
}
