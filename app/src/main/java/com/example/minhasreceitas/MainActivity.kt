package com.example.minhasreceitas

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var rvReceitas: RecyclerView
    private lateinit var receitasAdapter: ReceitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        rvReceitas = findViewById( R.id.rvReceitas )

        val list = listOf(
            Receita("Escondidinho de Camarão", "35min", R.drawable.carne1,
                listOf(
                    "1 kg de aipim (mandioca) cozido e escorrido",
                    "2 latas de creme de leite",
                    "1 copo de requeijão cremoso",
                    "2 ovos",
                    "Sal a gosto",
                    "Pimenta-do-reino a gosto",
                    "3 colheres (sopa) de queijo parmesão ralado"),
                listOf(
                    "Em uma panela coloque o azeite e frite o alho e a cebola.",
                    "Coloque o tomate picadinho e refoque-o.",
                    "Coloque os camarões (bem sequinhos) cozinhe por cerca de 3 minutos.",
                    "Coloque as azeitonas, sal e pimenta a gosto.",
                    "Desligue o fogo e coloque a salsinha e o coentro.",
                    "Reserve.",
                    "Pegue o aipim bem cozidinho, misture nele o creme de leite, requeijão cremoso, ovos, queijo parmesão e sal a gosto. Amasse bem para que fique sem nenhum pedacinho de aipim.",
                    "Para a montagem, em um pirex bem untado com azeite, coloque a metade do aipim amassado (purê), coloque a moquequinha de camarão e cubra com o restante do purê. ",
                    "Decore ao seu gosto e leve ao forno médio por aproximadamente 20 minutos, até gratinar."
                )
            ),

            Receita("Panqueca de Carne Moída", "45min", R.drawable.carne2,
                listOf(
                    "1 xícara (chá) de leite",
                    "1 xícara (chá) de farinha de trigo",
                    "1 ovo",
                    "1 colher (sopa) de óleo",
                    "Sal a gosto",
                    "300g de carne moída",
                    "1/2 cebola picada",
                    "2 dentes de alho picados",
                    "1 tomate picado",
                    "Cheiro-verde a gosto",
                    "Molho de tomate para cobrir",
                    "Queijo ralado a gosto"
                ),
                listOf(
                    "Bata no liquidificador o leite, a farinha, o ovo, o óleo e o sal até formar uma massa homogênea.",
                    "Aqueça uma frigideira antiaderente e prepare as panquecas dos dois lados.",
                    "Refogue a cebola e o alho em um fio de óleo, adicione a carne moída e deixe dourar.",
                    "Acrescente o tomate, sal, pimenta e finalize com cheiro-verde.",
                    "Recheie as panquecas com a carne e enrole.",
                    "Coloque em um refratário, cubra com molho de tomate e queijo ralado.",
                    "Leve ao forno por 15 minutos para gratinar."
                )
            ),

            Receita("Rocambole de Carne Moída", "25min", R.drawable.carne3,
                listOf(
                    "500g de carne moída",
                    "1 ovo",
                    "1/2 xícara de farinha de rosca",
                    "1/2 cebola picada",
                    "2 dentes de alho picados",
                    "Sal e pimenta a gosto",
                    "200g de presunto",
                    "200g de mussarela",
                    "Salsinha picada"
                ),
                listOf(
                    "Misture a carne com ovo, farinha, cebola, alho, sal e pimenta até formar uma massa.",
                    "Sobre um papel alumínio, espalhe a carne formando um retângulo.",
                    "Coloque o presunto e a mussarela por cima.",
                    "Enrole com cuidado como um rocambole.",
                    "Leve ao forno preaquecido a 200°C por cerca de 40 minutos.",
                    "Retire o papel nos últimos 10 minutos para dourar."
                )
            ),

            Receita("Escondidinho de Carne Seca", "60min", R.drawable.carne4,
                listOf(
                    "500g de carne seca dessalgada e desfiada",
                    "1kg de mandioca cozida e amassada",
                    "1/2 xícara de leite",
                    "2 colheres (sopa) de manteiga",
                    "1 cebola picada",
                    "2 dentes de alho picados",
                    "Sal e pimenta a gosto",
                    "Cheiro-verde a gosto",
                    "200g de queijo coalho ou mussarela"
                ),
                listOf(
                    "Refogue a cebola e o alho na manteiga, adicione a carne seca e os temperos.",
                    "Misture o leite e mais manteiga à mandioca para fazer um purê.",
                    "Em um refratário, coloque metade do purê de mandioca.",
                    "Adicione a carne seca refogada por cima.",
                    "Cubra com o restante do purê e finalize com queijo ralado.",
                    "Leve ao forno para gratinar por cerca de 20 minutos."
                )
            ),

            Receita("Bolinho de Chuva com Banana", "35min", R.drawable.bolinho1,
                listOf(
                    "2 ovos",
                    "1 xícara (chá) de açúcar",
                    "1 xícara (chá) de leite",
                    "2 xícaras (chá) de farinha de trigo",
                    "1 colher (sopa) de fermento em pó",
                    "2 bananas maduras picadas",
                    "Canela e açúcar para polvilhar",
                    "Óleo para fritar"
                ),
                listOf(
                    "Misture os ovos, o açúcar, o leite e a farinha até formar uma massa homogênea.",
                    "Adicione o fermento e as bananas picadas.",
                    "Aqueça o óleo e frite colheradas da massa até dourarem.",
                    "Retire e escorra em papel-toalha.",
                    "Polvilhe com açúcar e canela a gosto."
                )
            ),

            Receita("Empanada Colombiana - Carne Seca", "55min", R.drawable.empanada1,
                listOf(
                    "2 xícaras (chá) de fubá pré-cozido",
                    "1 1/2 xícara (chá) de água morna",
                    "1 colher (chá) de sal",
                    "2 colheres (sopa) de óleo",
                    "300g de carne seca desfiada",
                    "1/2 cebola picada",
                    "1 dente de alho picado",
                    "1 tomate sem sementes picado",
                    "Colorau e cheiro-verde a gosto",
                    "Óleo para fritar"
                ),
                listOf(
                    "Misture o fubá com a água, o óleo e o sal até formar uma massa maleável.",
                    "Refogue a carne seca com a cebola, alho, tomate e temperos.",
                    "Abra porções da massa na mão, recheie com a carne e feche em formato de meia-lua.",
                    "Frite em óleo quente até dourar.",
                    "Escorra em papel-toalha antes de servir."
                )
            ),

            Receita("Torta de Liquidificador", "40min", R.drawable.torta1,
                listOf(
                    "3 ovos",
                    "2 xícaras (chá) de leite",
                    "1/2 xícara (chá) de óleo",
                    "2 xícaras (chá) de farinha de trigo",
                    "1 colher (sopa) de fermento em pó",
                    "Sal a gosto",
                    "Recheio de sua preferência (frango, carne moída, legumes, etc.)",
                    "Queijo ralado para cobrir"
                ),
                listOf(
                    "Bata no liquidificador os ovos, leite, óleo, farinha e sal.",
                    "Adicione o fermento e bata rapidamente.",
                    "Despeje metade da massa em uma forma untada.",
                    "Coloque o recheio e cubra com o restante da massa.",
                    "Polvilhe queijo ralado por cima.",
                    "Asse em forno preaquecido a 180°C por cerca de 35 a 40 minutos, ou até dourar."
                )
            )

        )

        receitasAdapter = ReceitasAdapter{ receita ->
            val intent = Intent(this, DetalhesActivity::class.java)
            intent.putExtra("receita", receita)
            startActivity( intent )
        }
        rvReceitas.adapter = receitasAdapter
        receitasAdapter.configurarLista(list)



        rvReceitas.layoutManager = LinearLayoutManager(this)

        rvReceitas.addItemDecoration(
            DividerItemDecoration(this, RecyclerView.VERTICAL)
        )

    }
}