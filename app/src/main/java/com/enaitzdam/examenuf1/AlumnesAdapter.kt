package com.enaitzdam.examenuf1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.enaitzdam.examenuf1.model.Alumne


class AlumnesAdapter(
    private val context: Context,
    private val dataset: List<Alumne>
) : RecyclerView.Adapter<AlumnesAdapter.ItemViewHolder>() {

    var alum_click: ((Alumne)-> Unit)?=null
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder.
    // Each data item is just an Affirmation object.
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nomAlumne: TextView = view.findViewById(R.id.nomAlumne)
        val edatAlumne: TextView = view.findViewById(R.id.edatAlumne)
        val adrecaAlumne: TextView = view.findViewById(R.id.adrecaAlumne)
        val historialAlumne: TextView = view.findViewById(R.id.historialAlumne)
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_alumne, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        //val item = dataset[position]
        val item= dataset[position]
        if (item != null) {
            holder.nomAlumne.text = item.nom
        }
        if (item != null) {
            holder.edatAlumne.text=item.edat.toString()
        }
        if (item != null) {
            holder.adrecaAlumne.text=item.adreca
        }
        if (item != null) {
            holder.historialAlumne.text=item.historial
        }
        holder.itemView.setOnClickListener{
            if (item != null) {
                alum_click?.invoke(item)
            }
        }
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() =  dataset.size

}