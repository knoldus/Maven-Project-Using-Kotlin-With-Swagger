package com.knoldus.kotlinrestapi.service

import com.knoldus.kotlinrestapi.datasource.BankDataSource
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

class BankServiceTest{

    private val dataSource : BankDataSource = mockk(relaxed = true)
    private val bankService = BankService(dataSource)


    @Test
    fun `should call its data source to retrieve banks`(){

        every { dataSource.getBanks() }returns emptyList()
        bankService.getBanks()

        verify(exactly = 1) { dataSource.getBanks() }
    }
}