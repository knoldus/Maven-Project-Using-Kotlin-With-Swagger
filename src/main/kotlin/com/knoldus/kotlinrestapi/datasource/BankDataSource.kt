package com.knoldus.kotlinrestapi.datasource

import com.knoldus.kotlinrestapi.model.Bank

/**
 * Interface for accessing the data source related to banks.
 */
interface  BankDataSource {

    /**
     * Retrieves all banks.
     *
     * @return a collection of Bank objects
     */
    fun getBanks(): Collection<Bank>

    /**
     * Retrieves a bank with the specified account number.
     *
     * @param accountNum the account number of the bank to retrieve
     * @return the Bank object with the specified account number
     */
    fun retrieveBank(accountNum: String): Bank

    /**
     * Creates a new bank.
     *
     * @param bank the Bank object to be created
     * @return the created Bank object
     */
    fun createBank(bank: Bank): Bank

    /**
     * Updates an existing bank.
     *
     * @param bank the updated Bank object
     * @return the updated Bank object
     */
    fun updateBank(bank: Bank): Bank

    /**
     * Deletes a bank with the specified account number.
     *
     * @param accountNum the account number of the bank to delete
     */
    fun deleteBank(accountNum: String)

}


