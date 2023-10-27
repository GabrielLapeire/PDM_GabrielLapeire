package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity2 : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val value = intent.extras?.getString("key")
        Log.i("some", value.toString())

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(generateUser())
        recyclerView.adapter = adapter
    }

    private fun generarNombres(): List<String> {
        val nameList = mutableListOf<String>()
        for (i in 1..100) {
            nameList.add("name $i")
        }
        return nameList
    }

    private fun generateUser(): List<User> {
        val userList = mutableListOf<User>()
        for (i in 1..100) {
            val user = User(
                "name $i",
                i,
                "url"
            )
            userList.add(user)
        }
        return userList
    }

    override fun onStart() {
        super.onStart()
        Log.i("MainA2", "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("MainA2", "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("MainA2", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("MainA2", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("MainA2", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("MainA2", "onDestroy")
    }
}

class User(
    val name: String,
    val age: Int,
    val imageURL: String
    )

class UserAdapter(private val userList: List<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)

        fun bind(name: String) {
            nameTextView.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewTitle: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user.name)
    }
}