package com.enaitzdam.examenuf1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.enaitzdam.examenuf1.model.Alumne

class SharedViewModel : ViewModel() {

    val alumnesLlistat = mutableListOf<Alumne>()
    lateinit var alumneTriat:Alumne
    lateinit var admin:String

    fun addLlistatAlumne(nom: String, edat: Int, adrec: String, historial: String) {
        alumnesLlistat.add(Alumne(nom, edat, adrec, historial))
    }

    fun triarAlumne(nom: String,edat: Int,adreca:String,historial:String){
        alumneTriat=Alumne(nom,edat,adreca,historial)
    }

    fun asignarAdmin(ad:String){
        admin=ad
    }
}