package com.example.minhasreceitas

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdImagem: Int,
    val ingredientes: List<String>,
    val preparo: List<String>
) : Parcelable


/*
data class Receita(
    val titulo: String,
    val tempo: String,
    val resIdImagem: Int
) : Serializable
*/
