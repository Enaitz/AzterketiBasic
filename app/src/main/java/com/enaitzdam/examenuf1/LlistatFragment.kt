package com.enaitzdam.examenuf1

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.enaitzdam.examenuf1.databinding.FragmentLlistatBinding
import com.enaitzdam.examenuf1.model.AlumneDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LlistatFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentLlistatBinding

    private lateinit var adapter: AlumnesAdapter2

    private val alumnesDatabase by lazy {
        activity?.let {
            AlumneDatabase.getDatabase(it.applicationContext).alumneDao()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_llistat, container, false
        )

        val recyclerView = binding.RecyclerViewAlumnes
//        var myAdapter =activity?.let { AlumnesAdapter(it,sharedViewModel.alumnesLlistat) }
        adapter = AlumnesAdapter2()
        adapter.setItemListener(object : RecyclerClickListener {
            override fun onItemRemoveClick(position: Int) {
                TODO("Not yet implemented")
            }

            // Tap the note to edit.
            override fun onItemClick(position: Int) {
                // Get the list of notes
                val notes = adapter.currentList.toMutableList()

                Toast.makeText(
                    activity,
                    "Has triat: ${notes[position].nom} i té: ${notes[position].edat.toString()}",
                    Toast.LENGTH_SHORT
                ).show()
                sharedViewModel.triarAlumne(notes[position].nom, notes[position].edat, notes[position].adreca, notes[position].historial)
                view?.findNavController()?.navigate(R.id.action_llistatFragment_to_finalFragment)

            }
        })
        lifecycleScope.launch {
            alumnesDatabase?.getAlumnes()?.collect { alumnesList ->
                if (alumnesList.isNotEmpty()) {
                    adapter.submitList(alumnesList)
                }
            }
        }
        recyclerView.adapter = adapter

        //var myAdapter =activity?.let { AlumnesAdapter(it,alumnesDatabase.getAlumnes()) }
        // recyclerView.adapter = adapter

//        if (adapter != null) {
//            adapter.alum_click = {
//                Toast.makeText(
//                    activity,
//                    "Has triat: ${it.nom} i té: ${it.edat.toString()}",
//                    Toast.LENGTH_SHORT
//                ).show()
//                sharedViewModel.triarAlumne(it.nom, it.edat, it.adreca, it.historial)
//                view?.findNavController()?.navigate(R.id.action_llistatFragment_to_finalFragment)
//
//            }


        return binding.root
    }
}



