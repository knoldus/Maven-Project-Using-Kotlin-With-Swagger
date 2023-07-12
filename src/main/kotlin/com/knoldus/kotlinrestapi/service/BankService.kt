package com.knoldus.kotlinrestapi.service

import com.knoldus.kotlinrestapi.datasource.BankDataSource
import com.knoldus.kotlinrestapi.model.Bank
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

/**
 * Service class for performing bank-related operations.
 *
 *  Constructs a new BankService with the specified BankDataSource.
 *
 *  @param dataSource the BankDataSource to be used by the service
 *
 */
@Service
class BankService( @Qualifier("mock") private val dataSource: BankDataSource) {
   // class BankService(private val dataSource: BankDataSource) {


        /**
     * Retrieves all banks.
     *
     * @return a collection of Bank objects
     *
     */
    fun getBanks(): Collection<Bank> = dataSource.getBanks()

    /**
     * Retrieves a bank with the specified account number.
     *
     * @param accountNum the account number of the bank to retrieve
     * @return the Bank object with the specified account number
     */
    fun getBank( accountNum: String): Bank = dataSource.retrieveBank(accountNum)

    /**
     * Adds a new bank.
     *
     * @param bank the Bank object to be added
     * @return the added Bank object
     */
    fun addBank(bank: Bank): Bank = dataSource.createBank(bank)


    /**
     * Updates an existing bank.
     *
     * @param bank the updated Bank object
     * @return the updated Bank object
     */
    fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)

    /**
     * Deletes a bank with the specified account number.
     *
     * @param accountNum the account number of the bank to delete
     */
    fun deleteBank(accountNum: String):Unit = dataSource.deleteBank(accountNum)


}