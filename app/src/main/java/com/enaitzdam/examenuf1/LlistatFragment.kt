package com.enaitzdam.examenuf1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.enaitzdam.examenuf1.databinding.FragmentFormulariBinding
import com.enaitzdam.examenuf1.databinding.FragmentLlistatBinding


class LlistatFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentLlistatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_llistat, container, false
        )

        val recyclerView = binding.RecyclerViewAlumnes
        var myAdapter =activity?.let { AlumnesAdapter(it,sharedViewModel.alumnesLlistat) }
        recyclerView.adapter= myAdapter

        if (myAdapter != null) {
            myAdapter.alum_click={
                Toast.makeText(activity,"Has triat: ${it.nom} i té: ${it.edat.toString()}", Toast.LENGTH_SHORT).show()
                sharedViewModel.triarAlumne(it.nom,it.edat,it.adreca,it.Historial)
                view?.findNavController()?.navigate(R.id.action_llistatFragment_to_finalFragment)

            }
        }

        return binding.root
    }


}