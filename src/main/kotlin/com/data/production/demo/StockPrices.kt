package com.data.production.demo

import java.time.LocalDateTime

data class StockPrices(val symbol: String,
                       val price: Double,
                       val time: LocalDateTime,
                       val quantity: Double,
                       val subTotal: Double,
                       val Total: Double,
                       val order: Double
) {

}
