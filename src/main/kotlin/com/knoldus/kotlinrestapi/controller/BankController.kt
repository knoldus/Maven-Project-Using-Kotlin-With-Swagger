package com.knoldus.kotlinrestapi.controller

import com.knoldus.kotlinrestapi.model.Bank
import com.knoldus.kotlinrestapi.service.BankService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

/**
 * Controller class for handling REST API requests related to banks.
 */
@RestController
@RequestMapping("api/banks")
class BankController
/**
 * Constructs a new BankController with the given BankService.
 *
 * @param service the BankService to be used by the controller
 */(private val service: BankService) {
    /**
     * Exception handler for NoSuchElementException.
     *
     * @param e the NoSuchElementException to be handled
     * @return a ResponseEntity with the error message and HTTP status NOT_FOUND
     */
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
    }

    /**
     * Exception handler for IllegalArgumentException.
     *
     * @param e the IllegalArgumentException to be handled
     * @return a ResponseEntity with the error message and HTTP status NOT_FOUND
     */
    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.message)
    }

    @get:GetMapping
    val banks: Collection<Bank>
        /**
         * Retrieves all banks.
         *
         * @return a collection of Bank objects
         */
        get() = service.getBanks()

    /**
     * Retrieves a bank with the specified account number.
     *
     * @param accountNum the account number of the bank to retrieve
     * @return the Bank object with the specified account number
     */
    @GetMapping("/{accountNum}")
    fun getBank(@PathVariable accountNum: String?): Bank {
        return service.getBank(accountNum!!)
    }

    /**
     * Adds a new bank.
     *
     * @param bank the Bank object to be added
     * @return the added Bank object
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addBank(@RequestBody bank: Bank?): Bank {
        return service.addBank(bank!!)
    }

    /**
     * Updates an existing bank.
     *
     * @param bank the updated Bank object
     * @return the updated Bank object
     */
    @PatchMapping
    fun updateBank(@RequestBody bank: Bank?): Bank {
        return service.updateBank(bank!!)
    }

    /**
     * Deletes a bank with the specified account number.
     *
     * @param accountNum the account number of the bank to delete
     */
    @DeleteMapping("/{accountNum}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBank(@PathVariable accountNum: String?) {
        service.deleteBank(accountNum!!)
    }
}
