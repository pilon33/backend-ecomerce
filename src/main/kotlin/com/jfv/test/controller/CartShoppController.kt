package com.jfv.test.controller

import  com.jfv.test.model.Product
import  com.jfv.test.model.CartShopp
import  com.jfv.test.dto.CartShoppDTO
import  com.jfv.test.dto.CheckoutDTO
import com.jfv.test.exception.HttpValidateException
import  com.jfv.test.service.CartShoppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/carts-shopps")
class CartShoppController(@Autowired private val service: CartShoppService) : HttpValidateException() {

    @DeleteMapping("/{id}/{idProduct}")
    fun deleteProductToCart(
        @PathVariable id: UUID,
        @PathVariable idProduct: UUID
    ): CartShopp = service.deleteProductToCart(id, idProduct)

    @GetMapping("/{id}/checkout")
    fun checkout(
        @PathVariable id: UUID
    ): CheckoutDTO = service.checkout(id)
    @GetMapping("/{id}")
    fun getProductsByCart(
        @PathVariable id: UUID
    ): MutableList<Product> = service.getProductsByCart(id)

    @PostMapping
    fun addProductToCart(
        @Validated @RequestBody shoppingCartRequest: CartShoppDTO
    ): CartShopp = service.addProductToCart(shoppingCartRequest)

    @PutMapping("/{id}")
    fun updateProductToCart(
        @PathVariable id: UUID,
        @Valid @RequestBody product: Product
    ): CartShopp = service.updateProductToCart(id, product)



}
