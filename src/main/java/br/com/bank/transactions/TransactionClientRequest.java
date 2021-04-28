package br.com.bank.transactions;

public class TransactionClientRequest {
	private String id;
	private String email;

	@Deprecated
	public TransactionClientRequest() {}

	public TransactionClientRequest(TransactionRequest request) {
		this.id = request.getId();
		this.email = request.getEmail();
	}

	public String getId() {
		return this.id;
	}

	public String getEmail() {
		return this.email;
	}

}
