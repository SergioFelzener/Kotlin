package com.example.lojaretrofit.model

data class Product (
    var idProduto: Int,
    var nomeProduto: String,
    var precProduto: Double,
    var descProduto: String,
    var descontoPromocao: Double,
    var qtdMinEstoque: Int,
    var idCategoria: Int,
    var ativoProduto: Boolean

)