package com.jfv.test.service

import com.jfv.test.model.Product
import com.jfv.test.model.CartShopp
import com.jfv.test.dto.CartShoppDTO
import com.jfv.test.dto.CheckoutDTO
import java.util.*

interface CartShoppService {

    fun getProductsByCart(id: UUID): MutableList<Product>

    fun addProductToCart(shoppingCartRequest: CartShoppDTO): CartShopp

    fun updateProductToCart(id: UUID, product: Product): CartShopp

    fun deleteProductToCart(id: UUID, idProduct: UUID): CartShopp

    fun checkout(id: UUID): CheckoutDTO

}
