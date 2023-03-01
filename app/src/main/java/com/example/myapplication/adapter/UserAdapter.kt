package com.example.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.moodle.User

class UserAdapter(var context: Context, var data: Array<User>):RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(var binding: com.example.myapplication.databinding.UserItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var binding=UserItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return UserViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.itemView.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.underline));

        var user:User = data[position]
     holder.binding.txtName.text = user.name
        holder.binding.txtAddress.text = user.address
        holder.binding.txtNumber.text =user.number.toString()


    }
}