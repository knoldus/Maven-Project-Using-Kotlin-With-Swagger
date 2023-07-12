package com.knoldus.kotlinrestapi.datasource.mock

import com.knoldus.kotlinrestapi.datasource.BankDataSource
import com.knoldus.kotlinrestapi.model.Bank
import org.springframework.stereotype.Repository

/**
 * Mock implementation of the BankDataSource interface for testing purposes.
 */
@Repository("mock")
class MockBankDataSource : BankDataSource {
    // A mutable list of Bank objects representing the mock data source
    private val banks: MutableCollection<Bank> = ArrayList()

    /**
     * Constructs a new MockBankDataSource.
     * Initializes the mock data source with some sample Bank objects.
     */
    init {
        banks.add(Bank("ACC", 3.14, 500))
        banks.add(Bank("ACC2", 5.14, 1000))
        banks.add(Bank("ACC3", 6.14, 4000))
    }

    /**
     * Retrieves all banks from the mock data source.
     *
     * @return a collection of Bank objects
     */
    override fun getBanks(): Collection<Bank> {
        return banks
    }

    /**
     * Retrieves a bank with the specified account number from the mock data source.
     *
     * @param accountNum the account number of the bank to retrieve
     * @return the Bank object with the specified account number
     * @throws NoSuchElementException if no bank with the specified account number is found
     */
    @Throws(NoSuchElementException::class)
    override fun retrieveBank(accountNum: String): Bank {
        return banks.stream()
            .filter { (accountNum1): Bank -> accountNum1 == accountNum }
            .findFirst()
            .orElseThrow {
                NoSuchElementException(
                    "Could not find a bank with account $accountNum"
                )
            }
    }

    /**
     * Adds a new bank to the mock data source.
     *
     * @param bank the Bank object to be added
     * @return the added Bank object
     */
    override fun createBank(bank: Bank): Bank {
        banks.add(bank)
        return bank
    }

    /**
     * Updates an existing bank in the mock data source.
     *
     * @param bank the updated Bank object
     * @return the updated Bank object
     * @throws NoSuchElementException if the bank with the specified account number is not found
     */
    @Throws(NoSuchElementException::class)
    override fun updateBank(bank: Bank): Bank {
        val removed = banks.removeIf { (accountNum): Bank -> accountNum == bank.accountNum }
        if (!removed) {
            throw NoSuchElementException("Could not find a bank with account num " + bank.accountNum)
        }
        banks.add(bank)
        return bank
    }

    /**
     * Deletes a bank with the specified account number from the mock data source.
     *
     * @param accountNum the account number of the bank to delete
     * @throws NoSuchElementException if the bank with the specified account number is not found
     */
    @Throws(NoSuchElementException::class)
    override fun deleteBank(accountNum: String) {
        val removed = banks.removeIf { (accountNum1): Bank -> accountNum1 == accountNum }
        if (!removed) {
            throw NoSuchElementException("Could not find a bank with account num $accountNum")
        }
    }
}
