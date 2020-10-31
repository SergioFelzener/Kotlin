package com.example.lojaretrofit.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.lojaretrofit.R
import com.example.lojaretrofit.model.Product
import com.example.lojaretrofit.service.ProductService
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_product_list.*
import kotlinx.android.synthetic.main.card_item.view.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.NumberFormat
import java.util.concurrent.TimeUnit

class ProductListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
    }

    override fun onResume() {
        super.onResume()
        getProducts()
    }

    fun getProducts(){
        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

        val retrofit =  Retrofit
                            .Builder()
                            .baseUrl("https://oficinacordova.azurewebsites.net")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(client)
                            .build()

        val service = retrofit.create(ProductService::class.java)
        val call = service.list()

        val callback = object: Callback<List<Product>> {
            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                if(response.isSuccessful){
                    val products = response.body()
                    refreshUI(products)
                }else{
                    Toast.makeText(this@ProductListActivity, "Erro na busca de produtos", Toast.LENGTH_LONG).show()
                    Log.e(response.code().toString(), response.errorBody().toString())
                }

                shimmer.stopShimmer()
                shimmer.visibility = View.GONE
                scrollView.visibility = View.VISIBLE
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Toast.makeText(this@ProductListActivity, "Não foi possível conectar a API", Toast.LENGTH_LONG).show()
                Log.e("ProductListActivity", "getProducts", t)

                shimmer.stopShimmer()
                shimmer.visibility = View.GONE
                scrollView.visibility = View.VISIBLE
            }

        }

        call.enqueue(callback)

        shimmer.visibility = View.VISIBLE
        shimmer.startShimmer()
        scrollView.visibility = View.GONE
    }

    fun refreshUI(products: List<Product>?){

        val formatter = NumberFormat.getCurrencyInstance()

        products?.let{
            for (product in it){

                val card = layoutInflater.inflate(R.layout.card_item, container, false)

                card.txtName.text = product.nomeProduto
                card.txtPrice.text = formatter.format(product.precProduto)

                val shimmer = Shimmer.AlphaHighlightBuilder()
                    .setBaseAlpha(0.9f)
                    .setHighlightAlpha(0.7f)
                    .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
                    .setAutoStart(true)
                    .build()

                val shimmerDrawable = ShimmerDrawable()
                shimmerDrawable.setShimmer(shimmer)

                val url = "https://oficinacordova.azurewebsites.net/android/rest/produto/image/${product.idProduto}"

                Picasso
                    .get()
                    .load(url)
                    .placeholder(shimmerDrawable)
                    .error(R.drawable.ic_baseline_broken_image_24)
                    .into(card.image)

                container.addView(card)
                }
            }
        }
}