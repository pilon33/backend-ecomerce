package com.jfv.test.dto

import com.jfv.test.model.Product
import java.util.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

data class CartShoppDTO(
    val idShoppingCart: UUID?,
    @field:Valid @field:NotNull val product: Product)