package com.data.production.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PathVariable
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDateTime.now
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@SpringBootApplication
class DataProductionDemoApplication

fun main(args: Array<String>) {
	runApplication<DataProductionDemoApplication>(*args)
}

@RestController
class RestController() {
	@GetMapping(value = ["/streamdata"],
				produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
	fun prices(): Flux<StockPrices> {
		return Flux.interval(Duration.ofSeconds(1))
			.map { StockPrices(randomSymbol(), randomStockPrice(), now(), randomStockQuantity(),
				randomStockSubTotal(), randomStockTotal(), randomStockOrder())}
	}

	private fun randomStockPrice(): Double {
		return ThreadLocalRandom.current().nextDouble(100.0)
	}

	private fun randomStockQuantity(): Double {
		return ThreadLocalRandom.current().nextDouble(100.0)
	}

	private fun randomStockSubTotal(): Double {
		return ThreadLocalRandom.current().nextDouble(100.0)
	}

	private fun randomStockTotal(): Double {
		return ThreadLocalRandom.current().nextDouble(100.0)
	}

	private fun randomStockOrder(): Double {
		return ThreadLocalRandom.current().nextDouble(100.0)
	}

	private  fun randomSymbol(): String {
		val arr = arrayOf("AB", "CD", "EF", "GH", "IJ", "KL", "MN", "OP", "QR")
		val r = Random()
		val randomNumber = r.nextInt(arr.size)
		return arr[randomNumber]
	}
}
