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
        TODO("Not yet implemented")
    }

    override fun createBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun updateBank(bank: Bank): Bank {
        TODO("Not yet implemented")
    }

    override fun deleteBank(accountNum: String) {
        TODO("Not yet implemented")
    }
}