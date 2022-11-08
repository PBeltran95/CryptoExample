package com.example.cryptoapppablo.data.model

data class CryptoMetadataResponse(
    val id: Int? = null,
    val name: String? = null,
    val slug: String? = null,
    val symbol: String? = null,
    val circulating_supply: Double? = null,
    val cmc_rank: Int? = null,
    val date_added: String? = null,
    val last_updated: String? = null,
    val max_supply: Double? = null,
    val num_market_pairs: Int? = null,
    val quote: Quote? = null,
    val tags: List<String?>? = null,
    val total_supply: Double? = null,
)