package com.example.minhasreceitas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ReceitasAdapter(
    val cliqueBotao: ( Receita ) -> Unit
) : Adapter<ReceitasAdapter.ReceitasViewHolder>() {

    private var listaReceitas = listOf<Receita>()

    fun configurarLista( lista: List<Receita> ){
        listaReceitas = lista
        notifyDataSetChanged()
    }

    inner class ReceitasViewHolder( itemView: View ) : ViewHolder(itemView){

        private var view: View
        private var textTitulo: TextView
        private var textTempo: TextView
        private var imgReceita: ImageView
        private var clItem: ConstraintLayout

        init {
            view = itemView
            textTitulo = view.findViewById( R.id.textTitulo )
            textTempo = view.findViewById( R.id.textTempo )
            imgReceita = view.findViewById( R.id.imgReceita )
            clItem = view.findViewById( R.id.clItem )
        }

        fun bind( receita: Receita ){

            textTitulo.text = receita.titulo
            textTempo.text = receita.tempo

            imgReceita.setImageDrawable(
                ContextCompat.getDrawable(view.context, receita.resIdImagem)
            )

            // Evento de clique
            clItem.setOnClickListener {
                cliqueBotao( receita )
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitasViewHolder {

        val view = LayoutInflater
            .from( parent.context )
            .inflate(R.layout.item_receitas, parent, false)

        return ReceitasViewHolder( view )

    }

    override fun onBindViewHolder(holder: ReceitasViewHolder, position: Int) {

        val receita = listaReceitas[position]
        holder.bind( receita )

    }

    override fun getItemCount(): Int {
        return listaReceitas.size
    }

}