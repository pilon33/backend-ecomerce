package com.jfv.test.service.impl

import com.jfv.test.model.Product
import com.jfv.test.repository.ProductRepository
import com.jfv.test.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductServiceImpl(@Autowired private val repository: ProductRepository) : ProductService {

    override fun getProducts(): List<Product> = repository.findAll()

    override fun createProduct(product: Product): Product = repository.save(product)

    override fun deleteProduct(id: UUID): Unit = repository.deleteById(id)

    override fun updateProduct(id: UUID, product: Product): Product {
        val updateProduct = Product(
            product.name, product.sku, product.description,
            product.price, product.amount, product.withDiscount, id
        )
        return repository.save(updateProduct)
    }

}
