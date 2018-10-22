package com.photonInfotech.citiBankPOC.controller;

import javax.validation.Valid;

import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.photonInfotech.citiBankPOC.exception.Response;
import com.photonInfotech.citiBankPOC.model.Account;
import com.photonInfotech.citiBankPOC.service.AccountService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Account", description = "Operations pertaining to Business Accounts")
public class AccountController {

	// Service class is the class that contains all the logic related to the
	// necessary
	// requirements
	@Autowired
	private AccountService accountService;

	@SuppressWarnings({ "unchecked" })
	@ApiOperation(value = "Get operation to List all the accounts that are enabled")
	@GetMapping(value = "/account", produces = { "application/json" })
	public Resources<Account> getAllAccount() throws Exception {
		return accountService.getAllAccount();
	}

	@SuppressWarnings({ "unchecked" })
	@ApiOperation(value = "Get operation to List an account by accountId ")
	@GetMapping(value = "/account/{id}", produces = { "application/json" })
	public Resources<Account> getAccountById(@PathVariable long id) throws Exception {
		return accountService.getAccountById(id);
	}

	/*
	 * Create new business acct. In conjuction with REST Entity best practice, we
	 * will utilize POST to create it. Upon creation of the account, we return the
	 * object itself and Spring wil serialize it to JSON for the client consumption
	 */

	@ApiOperation(value = "Post operation to Create a new account")
	@PostMapping(value = "/account", produces = { "application/json" })
	public Response<Account> addAccount(@Valid @RequestBody Account account) throws Exception {
		return accountService.addAccount(account);
	}
	


	@ApiOperation(value = "Update the account by id ")
	@PutMapping(value = "/account")
	public Response<Account> updateAccount(@Valid @RequestBody Account account) throws Exception {
		return accountService.updateAccount(account);
	}

	@ApiOperation(value = "disabled the account")
	@DeleteMapping("/account/{id}")
	public Response<Account> deleteAccount(@PathVariable long id) {
		return accountService.deleteAccount(id);
	}
}
