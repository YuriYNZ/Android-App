package com.calcados51.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.calcados51.app.databinding.ActivityMainBinding

/**
 * Main activity for the Calçados 51 shoe store app.
 * Displays a catalog of 10 shoes with the option to mark items as "fora de estoque".
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val shoes = buildShoeCatalog()
        val adapter = ShoeAdapter(shoes)

        binding.recyclerViewShoes.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewShoes.adapter = adapter
    }

    /**
     * Builds the catalog of 10 shoe products for Calçados 51.
     */
    private fun buildShoeCatalog(): List<Shoe> = listOf(
        Shoe(
            id = 1,
            name = "Tênis Air Max Evolution",
            brand = "SportFlex",
            description = "Tênis esportivo com amortecimento de alta performance para corrida e treino.",
            price = 399.99,
            imageResId = R.drawable.ic_shoe_sneaker
        ),
        Shoe(
            id = 2,
            name = "Sandália Conforto Slim",
            brand = "BrazilStep",
            description = "Sandália feminina de couro sintético com palmilha anatômica macia.",
            price = 89.99,
            imageResId = R.drawable.ic_shoe_sandal
        ),
        Shoe(
            id = 3,
            name = "Bota Coturno Adventure",
            brand = "TerraForce",
            description = "Bota masculina de couro resistente, ideal para trilhas e uso no dia a dia.",
            price = 259.99,
            imageResId = R.drawable.ic_shoe_boot
        ),
        Shoe(
            id = 4,
            name = "Sapatilha Ballet Chic",
            brand = "FemStyle",
            description = "Sapatilha feminina elegante em couro legítimo, perfeita para o trabalho.",
            price = 129.99,
            imageResId = R.drawable.ic_shoe_flat
        ),
        Shoe(
            id = 5,
            name = "Sapato Social Premium",
            brand = "ClassicMan",
            description = "Sapato masculino de couro envernizado, acabamento refinado para ocasiões formais.",
            price = 299.99,
            imageResId = R.drawable.ic_shoe_formal
        ),
        Shoe(
            id = 6,
            name = "Chinelo Slide Relax",
            brand = "ComfortWear",
            description = "Chinelo slide unissex com tira larga e solado antiderrapante para uso casual.",
            price = 59.99,
            imageResId = R.drawable.ic_shoe_slide
        ),
        Shoe(
            id = 7,
            name = "Tênis Retrô Classic",
            brand = "UrbanKick",
            description = "Tênis lifestyle de cano baixo com design retrô, combinando estilo e conforto.",
            price = 449.99,
            imageResId = R.drawable.ic_shoe_sneaker
        ),
        Shoe(
            id = 8,
            name = "Bota Feminina Cano Alto",
            brand = "FemStyle",
            description = "Bota cano longo com salto bloco, perfeita para looks outono/inverno.",
            price = 349.99,
            imageResId = R.drawable.ic_shoe_boot
        ),
        Shoe(
            id = 9,
            name = "Mocassim Executivo",
            brand = "ClassicMan",
            description = "Mocassim masculino sem cadarço em couro legítimo, confortável e elegante.",
            price = 199.99,
            imageResId = R.drawable.ic_shoe_loafer
        ),
        Shoe(
            id = 10,
            name = "Tênis Running Ultra",
            brand = "SportFlex",
            description = "Tênis de corrida com tecnologia de absorção de impacto e solado de borracha.",
            price = 379.99,
            imageResId = R.drawable.ic_shoe_sneaker
        )
    )
}
