package com.knoldus.kotlinrestapi.datasource.network

import com.knoldus.kotlinrestapi.datasource.BankDataSource
import com.knoldus.kotlinrestapi.datasource.network.dto.BankList
import com.knoldus.kotlinrestapi.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

/**
 * NetworkDataSource is an implementation of the BankDataSource interface
 *
 * that interacts with a remote bank API over the network using RESTful calls.
 *
 * It uses RestTemplate to make HTTP requests and retrieve data from the remote API.
 */
@Repository("network")
class NetworkDataSource(

@Autowired private val restTemplate: RestTemplate,
@Value("\${bank.api.url}") private val bankApiUrl: String

) : BankDataSource {

    /**
     * Retrieves a collection of Bank objects from the remote bank API.
     *
     * @return The collection of Bank objects.
     *
     * @throws IOException if there is an error fetching banks from the network.
     */
    override fun getBanks(): Collection<Bank> {
        val response: ResponseEntity<BankList> =
                restTemplate.getForEntity<BankList>("$bankApiUrl")
        return response.body?.results
                ?: throw IOException("Could not fetch banks from the network")
    }

    /**
     * Retrieves a Bank object from the remote bank API based on the account number.
     *
     * @param accountNum The account number of the bank to retrieve.
     *
     * @return The retrieved Bank object.
     *
     * @throws IOException if there is an error retrieving the bank from the network.
     */
    override fun retrieveBank(accountNum: String): Bank {
        val response: ResponseEntity<Bank> =
                restTemplate.getForEntity("$bankApiUrl/$accountNum", Bank::class.java)
        return response.body
                ?: throw IOException("Could not retrieve bank with account number $accountNum from the network")
    }

    /**
     * Creates a new Bank object in the remote bank API.
     *
     * @param bank The Bank object to create.
     *
     * @return The created Bank object.
     *
     * @throws IOException if there is an error creating the bank in the network.
     */
    override fun createBank(bank: Bank): Bank {
        restTemplate.postForObject<Unit>("$bankApiUrl", bank, Unit::class.java)
        return bank
    }

    /**
     * Updates an existing Bank object in the remote bank API.
     *
     * @param bank The Bank object to update.
     *
     * @return The updated Bank object.
     *
     */
    override fun updateBank(bank: Bank): Bank {
        restTemplate.put("$bankApiUrl/${bank.accountNum}", bank)
        return bank
    }

    /**
     * Deletes a Bank object from the remote bank API based on the account number.
     *
     * @param accountNum The account number of the bank to delete.
     */
    override fun deleteBank(accountNum: String) {
        restTemplate.delete("$bankApiUrl/$accountNum")
    }
}
