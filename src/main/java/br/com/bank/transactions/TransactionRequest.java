package br.com.bank.transactions;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class TransactionRequest {

	@NotBlank
	private String id;
	@NotBlank
	@Email
	private String email;

	@Deprecated
	public TransactionRequest() {}

	public TransactionRequest(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

}
