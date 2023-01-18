package com.enaitzdam.examenuf1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.enaitzdam.examenuf1.model.Alumne

class AlumnesAdapter2: ListAdapter<Alumne, AlumnesAdapter2.AlumneHolder>(DiffCallback()) {

    class AlumneHolder(view: View) : RecyclerView.ViewHolder(view)

    private lateinit var listener: RecyclerClickListener
    fun setItemListener(listener: RecyclerClickListener) {
        this.listener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumneHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.item_alumne, parent, false)
        val alumHolder = AlumneHolder(v)

//        val noteDelete = noteHolder.itemView.findViewById<ImageView>(R.id.note_delete)
//        noteDelete.setOnClickListener {
//            listener.onItemRemoveClick(noteHolder.adapterPosition)
//        }

        val alum = alumHolder.itemView.findViewById<CardView>(R.id.cardView1)
        alum.setOnClickListener {
            listener.onItemClick(alumHolder.adapterPosition)
        }

        return alumHolder
    }

    override fun onBindViewHolder(holder: AlumneHolder, position: Int) {
        val currentItem = getItem(position)
        holder.itemView.findViewById<TextView>(R.id.nomAlumne).text= currentItem.nom
        holder.itemView.findViewById<TextView>(R.id.edatAlumne).text= currentItem.edat.toString()
        holder.itemView.findViewById<TextView>(R.id.adrecaAlumne).text= currentItem.adreca
        holder.itemView.findViewById<TextView>(R.id.historialAlumne).text= currentItem.historial

    }

    class DiffCallback : DiffUtil.ItemCallback<Alumne>() {
        override fun areItemsTheSame(oldItem: Alumne, newItem: Alumne) =
            oldItem.nom == newItem.nom

        override fun areContentsTheSame(oldItem: Alumne, newItem: Alumne) =
            oldItem == newItem
    }
}