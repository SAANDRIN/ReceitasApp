package com.example.minhasreceitas

import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.MenuProvider
import com.example.minhasreceitas.databinding.ActivityDetalhesBinding


class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        inicializarActionBar()

        with(binding) {

            val bundle = intent.extras

            if (bundle != null) {

                val receita = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    bundle.getParcelable("receita", Receita::class.java)
                } else {
                    bundle.getParcelable("receita")
                }

                if (receita != null) {

                    imgDetalhe.setImageDrawable(
                        ContextCompat.getDrawable(applicationContext, receita.resIdImagem)
                    )

                    textTituloDetalhe.text = receita.titulo
                    textTempoDetalhe.text = receita.tempo

                    val listaIngredientes = receita.ingredientes
                    var textoIngredientes = ""

                    for (ingrediente in listaIngredientes) {

                        textoIngredientes += "- $ingrediente \n"

                    }

                    textIngredientes.text = textoIngredientes

                    val listaPreparo = receita.preparo
                    var textoPreparo = ""
                    var contador = 1

                    for (item in listaPreparo) {

                        textoPreparo += "$contador - $item \n" + "\n"
                        contador++

                    }

                    textPreparo.text = textoPreparo

                }
            }

        }


    }



    private fun inicializarActionBar() {

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

                    menuInflater.inflate(R.menu.menu_principal, menu)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return when (menuItem.itemId) {
                        android.R.id.home -> {
                            onBackPressedDispatcher.onBackPressed()
                            // finish()
                            true
                        }
                        else -> false
                    }
                }

            }
        )
    }

}