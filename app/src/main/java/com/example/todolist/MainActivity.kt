package com.example.todolist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import com.example.todolist.BtnClickHandlers
import com.example.todolist.data.DataViewModel

class MainActivity : AppCompatActivity(){

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


        val viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(DataViewModel::class.java)

        // data binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)

        binding.user = User("Test", "User")
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this



        // view binding
        val _ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = _ActivityMainBinding.root
        setContentView(view)

    }


}