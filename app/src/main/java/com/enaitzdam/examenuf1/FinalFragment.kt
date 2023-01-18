package com.enaitzdam.examenuf1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.enaitzdam.examenuf1.databinding.FragmentFinalBinding
import com.enaitzdam.examenuf1.databinding.FragmentFormulariBinding
import com.enaitzdam.examenuf1.model.AlumneDatabase
import kotlinx.coroutines.launch


class FinalFragment : Fragment() {
    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentFinalBinding

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
            R.layout.fragment_final, container, false
        )



        lifecycleScope.launch {
            alumnesDatabase?.getAlumneNom(sharedViewModel.alumneTriat.nom)?.collect { alumnesList ->
                if (alumnesList.isNotEmpty()) {
                    binding.tvnomAlumne.text=alumnesList[0].nom
                    binding.tvedatAlumne.text=alumnesList[0].edat.toString()
                    binding.tvadrecaAlumne.text=alumnesList[0].adreca
                    binding.tvhistorialAlumne.text=alumnesList[0].historial

                }
            }
        }



//        binding.tvnomAlumne.text=sharedViewModel.alumneTriat.nom
//        binding.tvedatAlumne.text=sharedViewModel.alumneTriat.edat.toString()
//        binding.tvadrecaAlumne.text=sharedViewModel.alumneTriat.adreca
//        binding.tvhistorialAlumne.text=sharedViewModel.alumneTriat.historial
//        binding.tvnomAdmin.text=sharedViewModel.admin


        return binding.root
    }

}