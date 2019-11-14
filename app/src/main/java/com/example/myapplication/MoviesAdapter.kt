package com.example.myapplication


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RecyclerviewMovieBinding

class MoviesAdapter (
    private val movies: List<Movie>,
    private val lister : RecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>(){

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.recyclerviewMovieBinding.movie = movies[position]

        holder.recyclerviewMovieBinding.buttonBook.setOnClickListener {
            lister.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.buttonBook,movies[position])
        }
        holder.recyclerviewMovieBinding.likebtn.setOnClickListener {
            lister.onRecyclerViewItemClick(holder.recyclerviewMovieBinding.likebtn,movies[position])
        }
    }


    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)

}