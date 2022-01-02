package com.jfv.test.service.impl

import com.jfv.test.model.Product
import com.jfv.test.model.CartShopp
import com.jfv.test.enum.State.COMPLETED
import com.jfv.test.repository.CartShoppRepository
import com.jfv.test.dto.CartShoppDTO
import com.jfv.test.dto.CheckoutDTO
import com.jfv.test.service.CartShoppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.*

@Service
class CartShoppServiceImpl(@Autowired private val repository: CartShoppRepository) : CartShoppService {

    @Value("\${value-divider}")
    var discountDivider: Int = 2

    override fun getProductsByCart(id: UUID): MutableList<Product> {
        return repository.findById(id)
            .map(CartShopp::products)
            .get()
    }

    override fun addProductToCart(cartShoppDTO: CartShoppDTO): CartShopp {
        var cartShopp = CartShopp(mutableListOf())
        cartShopp.products.add(cartShoppDTO.product)
        return repository.save(cartShopp)
    }

    override fun updateProductToCart(id: UUID, product: Product): CartShopp {
        val cartShopp = repository.findById(id).get()
        cartShopp.products.forEach { if (it.id == product.id) it.amount = product.amount }
        return repository.save(cartShopp)
    }

    override fun deleteProductToCart(id: UUID, idProduct: UUID): CartShopp {
        val cartShopp = repository.findById(id).get()
        cartShopp.products = cartShopp.products
            .filterNot { product -> product.id == idProduct }.toMutableList()
        return repository.save(cartShopp)
    }

    override fun checkout(id: UUID): CheckoutDTO {
        val cartShopp = repository.findById(id).get()
        val totalWithDiscount = cartShopp.products
            .filter { it.withDiscount }
            .sumOf { product -> (product.price * product.amount) / discountDivider }
        val totalWithoutDiscount = cartShopp.products
            .filterNot { it.withDiscount }
            .sumOf { product -> product.price * product.amount }
        cartShopp.state = COMPLETED
        repository.save(cartShopp)
        return CheckoutDTO(totalWithDiscount + totalWithoutDiscount)
    }

}
