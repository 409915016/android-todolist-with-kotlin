package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter: TodoAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener{
            val todoTitle = etTodoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                etTodoTitle.text.clear()
            }
        }

        btnADeleteDoneTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }


        // data binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.user = User("Test", "User")

        // view binding
        val _ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = _ActivityMainBinding.root
        setContentView(view)

//        _ActivityMainBinding.showMyNameBtn.setOnClickListener {
//
//        }



    }


}