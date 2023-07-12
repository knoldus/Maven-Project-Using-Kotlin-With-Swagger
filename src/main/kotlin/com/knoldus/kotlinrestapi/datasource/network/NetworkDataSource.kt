package com.knoldus.kotlinrestapi.datasource.network

import com.knoldus.kotlinrestapi.datasource.BankDataSource
import com.knoldus.kotlinrestapi.datasource.network.dto.BankList
import com.knoldus.kotlinrestapi.model.Bank
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : BankDataSource {

    override fun getBanks(): Collection<Bank> {

       val response: ResponseEntity<BankList> =
           restTemplate.getForEntity<BankList>("http://54.193.31.159/banks")
       return  response.body?.results
            ?: throw IOException(" Could not fetch banks from the network")
    }

    override fun retrieveBank(accountNum: String): Bank {
        val response: ResponseEntity<Bank> =
                restTemplate.getForEntity("http://54.193.31.159/banks/$accountNum", Bank::class.java)
        return response.body
                ?: throw IOException("Could not retrieve bank with account number $accountNum from the network")
    }

    override fun createBank(bank: Bank): Bank {
        restTemplate.postForObject<Unit>("http://54.193.31.159/banks", bank, Unit::class.java)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        restTemplate.put("http://54.193.31.159/banks/${bank.accountNum}", bank)
        return bank
    }
    override fun deleteBank(accountNum: String) {
        restTemplate.delete("http://54.193.31.159/banks/$accountNum")
    }
}






