package com.jfv.test.repository

import com.jfv.test.model.CartShopp
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CartShoppRepository : JpaRepository<CartShopp, UUID>