package com.enaitzdam.examenuf1

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.enaitzdam.examenuf1.databinding.FragmentFormulariBinding
import com.enaitzdam.examenuf1.model.Alumne
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class FormulariFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private lateinit var binding: FragmentFormulariBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_formulari, container, false
        )
        val alertDialogBuilder = activity?.let { AlertDialog.Builder(it) }
        binding.buttonAfegir.setOnClickListener {
            showFinalScoreDialog()
        }
        binding.buttonLlistat.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_formulariFragment_to_llistatFragment)
        }

        return binding.root
    }

    /*
* Creates and shows an AlertDialog with the final score.
*/
    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Confirmació afegir alumne")
            .setMessage("Estàs segur/a d'afegir aquest/a alumne/a?")
            .setCancelable(false)
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(activity,"Introducció cancel·lada",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Sí") { _, _ ->
                afegirAlumne()
            }
            .show()
    }

    fun afegirAlumne(){
        sharedViewModel.addLlistatAlumne(
            binding.editTextNomAlumne.text.toString(),
            binding.editTextEdat.text.toString().toInt(),
            binding.editTextAdrecaPostal.text.toString(),
            binding.editTextHistoral.text.toString()
        )
    }


}