package com.jfv.test.model

import java.util.*
import javax.persistence.Entity
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Entity
class Product(
    @field:NotBlank(message = "El campo name es requerido")
    val name: String,
    @field:NotBlank(message = "El campo sku es requerido")
    val sku: String,
    @field:NotBlank(message = "El campo description es requerido")
    val description: String,
    @field:Positive(message = "El campo price debe ser mayor a 0")
    val price: Double,
    @field:Min(value = 1, message = "El campo amount no puede ser menor a 1")
    var amount: Int,
    @field:NotNull(message = "El campo withDiscount es requerido")
    val withDiscount: Boolean,
    id: UUID? = null
) : AllocateIdBaseEntity(id)
