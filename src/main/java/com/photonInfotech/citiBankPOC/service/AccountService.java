package com.photonInfotech.citiBankPOC.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.photonInfotech.citiBankPOC.controller.AccountController;
import com.photonInfotech.citiBankPOC.exception.Response;
import com.photonInfotech.citiBankPOC.model.Account;
import com.photonInfotech.citiBankPOC.model.Address;
import com.photonInfotech.citiBankPOC.repository.AccountDAL;

@Service
public class AccountService {
	@Autowired
	private AccountDAL accountDAL;
	@Autowired
	private EmailNotification emailNotification;

	// Listing All Accounts
	public Resources<Account> getAllAccount() throws Exception {
		List<Account> accounts = this.accountDAL.getAllAccountsInfo();
		Link selfLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).getAllAccount()).withSelfRel();
		Resources<Account> result = new Resources<Account>(accounts, selfLink);
		Account account = new Account();
		Link updateLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).updateAccount(account))
				.withRel("update-account");
		result.add(updateLink);
		Link postLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).addAccount(account))
				.withRel("create-account");
		result.add(postLink);
		return result;
	}

	// List Account by an account id
	public Response<Account> getAccountById(long id) throws Exception {
		Account account = this.accountDAL.getAccountById(id);
		Response<Account> resp;
		if (account != null) {
			Link selfLink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).getAllAccount()).withSelfRel();
			Resource<Account> result = new Resource<Account>(account, selfLink);
			Link updateLink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).updateAccount(account))
					.withRel("update-account");
			result.add(updateLink);
			Link postLink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).addAccount(account))
					.withRel("create-account");
			result.add(postLink);
			resp = new Response("Account found", true, new Date(), HttpStatus.FOUND, result);
			return resp;
		} else {
			resp = new Response("Account not found", false, new Date(), HttpStatus.NOT_FOUND);
			return resp;
		}
	}

	// Create Account
	public Response<Account> addAccount(Account account) throws Exception {
		Response<Account> resp = new Response<Account>();
		if (accountDAL.save(account) != null) {
			try {
				emailNotification.createNotification(account);
			} catch (Exception e) {

				e.printStackTrace();
			}
			Link selfLink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).addAccount(account)).withSelfRel();
			Resource<Account> result = new Resource<Account>(account, selfLink);
			Link allLink = ControllerLinkBuilder
					.linkTo(ControllerLinkBuilder.methodOn(AccountController.class).getAllAccount())
					.withRel("all-accounts");
			result.add(allLink);
			resp = new Response("Account created", true, new Date(), HttpStatus.CREATED, result);
			return resp;

		} else {
			resp = new Response("Account creation failed", false, new Date(), HttpStatus.CONFLICT);
			return resp;
		}
	}

	// Soft Delete using id as a parameter in URL
	public Response deleteAccount(long id) {
		Response resp = new Response();
		Account userId = accountDAL.findById(id);
		if (userId != null) {
			if (userId.isEnabled() == false) {
				// resp.setTimeStamp(new Date());
				// resp.setStatus(false);
				// resp.setHttpStatus(HttpStatus.ALREADY_REPORTED);
				resp = new Response("Account has been previously deleted", false, new Date(),
						HttpStatus.ALREADY_REPORTED);
				return resp;
			} else {
				userId.setEnabled(false);
				Set<Address> address = new HashSet<Address>();
				address = userId.getAddress();

				for (Address s : address) {
					s.setEnabled(false);
				}
				accountDAL.save(userId);
				try {
					emailNotification.deleteNotification(userId);
				} catch (Exception e) {

					e.printStackTrace();
				}

				resp = new Response("Account is successfully deleted", true, new Date(), HttpStatus.OK);
				return resp;
			}
		} else {
			resp = new Response("Account is not found", false, new Date(), HttpStatus.NOT_FOUND);

			return resp;
		}
	}

	public Response<Account> updateAccount(Account account) throws Exception {
		Response<Account> resp = new Response<Account>();
		long id = account.getId();
		Account userId = accountDAL.findById(id);
		if (userId == null) {
			resp = new Response("Account is not found", false, new Date(), HttpStatus.NOT_FOUND);
			return resp;
		}
		if (accountDAL.save(account) != null) {
			accountDAL.save(account);
			emailNotification.updateNotification(userId);
			resp = new Response("Update Successful!", true, new Date(), HttpStatus.ACCEPTED);
			return resp;
		} else {
			resp = new Response("Update  not Successful!", false, new Date(), HttpStatus.BAD_REQUEST);
			return resp;
		}
	}
}
