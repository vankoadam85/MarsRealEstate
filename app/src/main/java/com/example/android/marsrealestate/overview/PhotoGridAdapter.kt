/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.marsrealestate.databinding.GridViewItemBinding
import com.example.android.marsrealestate.network.MarsProperty


class PhotoGridAdapter : ListAdapter<MarsProperty, PhotoGridAdapter.MarsPropertyViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPropertyViewHolder {
        return MarsPropertyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MarsPropertyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MarsProperty>() {

        override fun areItemsTheSame(oldItem: MarsProperty, newItem: MarsProperty) =
                oldItem === newItem

        override fun areContentsTheSame(oldItem: MarsProperty, newItem: MarsProperty) =
                oldItem.id == newItem.id
    }

    class MarsPropertyViewHolder(private val binding: GridViewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(property: MarsProperty) {
            binding.property = property
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MarsPropertyViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = GridViewItemBinding.inflate(inflater)
                return MarsPropertyViewHolder(binding)
            }
        }
    }

}