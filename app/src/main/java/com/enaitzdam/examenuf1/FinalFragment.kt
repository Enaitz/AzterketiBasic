package com.enaitzdam.examenuf1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.enaitzdam.examenuf1.databinding.FragmentFinalBinding
import com.enaitzdam.examenuf1.databinding.FragmentFormulariBinding


class FinalFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentFinalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_final, container, false
        )
        binding.tvnomAlumne.text=sharedViewModel.alumneTriat.nom
        binding.tvedatAlumne.text=sharedViewModel.alumneTriat.edat.toString()
        binding.tvadrecaAlumne.text=sharedViewModel.alumneTriat.adreca
        binding.tvhistorialAlumne.text=sharedViewModel.alumneTriat.Historial
        binding.tvnomAdmin.text=sharedViewModel.admin


        return binding.root
    }

}