package com.knoldus.kotlinrestapi.mock

import com.knoldus.kotlinrestapi.datasource.mock.MockBankDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankDataSourceTest{

 private val mockDataSource = MockBankDataSource()  // obj.  create
 @Test
 fun `should provide a collection of bank`(){

  //when
  val banks = mockDataSource.getBanks()
  //then
  assertThat(banks).isNotEmpty()

 }

 @Test
 fun `should provide some mock data`(){

   val bank = mockDataSource.getBanks()

   assertThat(bank).allMatch { it.accountNum.isNotEmpty() }
   assertThat(bank).anyMatch { it.trust != 0.0 }
   assertThat(bank).anyMatch { it.transactionFee != 0 }

 }


}





