package com.jfv.test.model

import com.jfv.test.enum.State
import com.jfv.test.enum.State.PENDING
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany

@Entity
class CartShopp(
    @OneToMany var products: MutableList<Product>,
    var state: State = PENDING,
    id: UUID? = null
) : AllocateIdBaseEntity(id)
