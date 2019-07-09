package com.mahesaiqbal.fakeusermanagement.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mahesaiqbal.fakeusermanagement.R
import com.mahesaiqbal.fakeusermanagement.databinding.UserItemBinding
import com.mahesaiqbal.fakeusermanagement.model.Data

import com.mahesaiqbal.fakeusermanagement.view.adapter.UsersAdapter.UserViewHolder
import com.mahesaiqbal.fakeusermanagement.viewmodel.UserViewModel

class UsersAdapter(val context: Context) : RecyclerView.Adapter<UserViewHolder>() {

    private var data: MutableList<Data> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding: UserItemBinding = DataBindingUtil
            .inflate(LayoutInflater.from(context), R.layout.user_item, parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) = holder.bindData(data[holder.adapterPosition])

    override fun getItemCount(): Int = data.size

    fun setData(list: MutableList<Data>) {
        data = list
    }

    class UserViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(model: Data) {
            val viewModel = UserViewModel(model)
            binding.user = viewModel
        }
    }
}