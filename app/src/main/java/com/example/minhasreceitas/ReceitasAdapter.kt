package com.example.minhasreceitas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.minhasreceitas.databinding.ItemReceitasBinding

class ReceitasAdapter(
    val cliqueBotao: (Receita) -> Unit
) : RecyclerView.Adapter<ReceitasAdapter.ReceitasViewHolder>() {

    private var listaReceitas = listOf<Receita>()

    fun configurarLista(lista: List<Receita>) {
        listaReceitas = lista
        notifyDataSetChanged()
    }

    inner class ReceitasViewHolder(
        private val binding: ItemReceitasBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(receita: Receita) {
            binding.textTitulo.text = receita.titulo
            binding.textTempo.text = receita.tempo

            binding.imgReceita.setImageDrawable(
                ContextCompat.getDrawable(binding.root.context, receita.resIdImagem)
            )

            binding.clItem.setOnClickListener {
                cliqueBotao(receita)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceitasViewHolder {
        val binding = ItemReceitasBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ReceitasViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ReceitasViewHolder, position: Int) {
        holder.bind(listaReceitas[position])
    }

    override fun getItemCount(): Int = listaReceitas.size
}
