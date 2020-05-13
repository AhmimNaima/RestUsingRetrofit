package com.example.restusingretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private val url = "https://jsonplaceholder.typicode.com/"
    private var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        GetData()
    }

    private fun GetData(){
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ToDoServices::class.java)
        val TodoRequest = service.listTodo()
        TodoRequest.enqueue(object : Callback<List<ToDO>> {
            override fun onResponse(call: Call<List<ToDO>>, response: Response<List<ToDO>>) {
                val allToDO = response.body()
                val adapter = ToDoAdapter(this@MainActivity,allToDO!!)
                recyclerView!!.adapter = adapter
                Toast.makeText(this@MainActivity, "Succès", Toast.LENGTH_LONG).show()
            }
            override fun onFailure(call: Call<List<ToDO>>, t: Throwable) {
                error("KO")
                Toast.makeText(this@MainActivity, "Echec", Toast.LENGTH_LONG).show()
            }
        })
    }
}
