package com.mahesaiqbal.fakeusermanagement.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahesaiqbal.fakeusermanagement.R
import com.mahesaiqbal.fakeusermanagement.databinding.ActivityMainBinding
import com.mahesaiqbal.fakeusermanagement.view.adapter.UsersAdapter
import com.mahesaiqbal.fakeusermanagement.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), LifecycleOwner {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: UsersAdapter

    private lateinit var lifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycleRegistry.markState(Lifecycle.State.CREATED)

        setupRecyclerView()
        observeLiveData()

        viewModel.getUsers()
    }

    public override fun onStart() {
        super.onStart()
        lifecycleRegistry.markState(Lifecycle.State.STARTED)
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycleRegistry
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvUser.layoutManager = layoutManager
        adapter = UsersAdapter(this)
        binding.rvUser.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.users.observe(this, Observer {
            adapter.setData(it?.data!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {

        })
    }
}
