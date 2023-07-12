package com.knoldus.kotlinrestapi.datasource.network.dto

import com.knoldus.kotlinrestapi.model.Bank

data class BankList(
    val results: Collection<Bank>
)
