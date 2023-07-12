package com.knoldus.kotlinrestapi.model

import com.fasterxml.jackson.annotation.JsonProperty

/**
 *     Web Layer      (controller,REST mapping)
 *          |
 *     Service Layer   (Services, build business logic)
 *          |
 *     Data Source      (Data retrieval, storage)
 *          |
 *     Data Layer      (Models, serialization)
 */


/**
 * Represents a bank with account details.
 */
data class Bank(

    /**
     *  The account number of the bank
     */
    @JsonProperty("account_number")
    var accountNum: String,

    /**
     *  The trust value associated with the bank
     */
    @JsonProperty("trust")
    val trust: Double,

    /**
     * The transaction fee charged by the bank
     */
    @JsonProperty("default_transaction_fee")
    val transactionFee: Int
    )
