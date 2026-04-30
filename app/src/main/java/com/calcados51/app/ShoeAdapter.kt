package com.calcados51.app

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.calcados51.app.databinding.ItemShoeBinding
import java.text.NumberFormat
import java.util.Locale

/**
 * RecyclerView adapter for displaying the shoe catalog.
 * Each item shows the shoe details and a toggle to mark it as "fora de estoque" (out of stock).
 */
class ShoeAdapter(private val shoes: List<Shoe>) :
    RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder>() {

    private val currencyFormat: NumberFormat =
        NumberFormat.getCurrencyInstance(Locale("pt", "BR"))

    inner class ShoeViewHolder(private val binding: ItemShoeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(shoe: Shoe) {
            binding.textShoeName.text = shoe.name
            binding.textShoeBrand.text = shoe.brand
            binding.textShoeDescription.text = shoe.description
            binding.textShoePrice.text = currencyFormat.format(shoe.price)
            binding.imageShoe.setImageResource(shoe.imageResId)
            binding.switchOutOfStock.isChecked = shoe.isOutOfStock

            applyOutOfStockStyle(shoe.isOutOfStock)

            binding.switchOutOfStock.setOnCheckedChangeListener { _, isChecked ->
                shoe.isOutOfStock = isChecked
                applyOutOfStockStyle(isChecked)
            }
        }

        private fun applyOutOfStockStyle(outOfStock: Boolean) {
            val context = binding.root.context
            if (outOfStock) {
                binding.badgeOutOfStock.visibility = View.VISIBLE
                binding.textShoeName.paintFlags =
                    binding.textShoeName.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.textShoePrice.paintFlags =
                    binding.textShoePrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                binding.root.alpha = 0.6f
                binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.card_out_of_stock)
                )
            } else {
                binding.badgeOutOfStock.visibility = View.GONE
                binding.textShoeName.paintFlags =
                    binding.textShoeName.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                binding.textShoePrice.paintFlags =
                    binding.textShoePrice.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                binding.root.alpha = 1.0f
                binding.root.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.card_in_stock)
                )
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val binding = ItemShoeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ShoeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        holder.bind(shoes[position])
    }

    override fun getItemCount(): Int = shoes.size
}
