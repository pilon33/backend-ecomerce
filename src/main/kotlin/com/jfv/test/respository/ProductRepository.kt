package com.jfv.test.repository

import com.jfv.test.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProductRepository : JpaRepository<Product, UUID>