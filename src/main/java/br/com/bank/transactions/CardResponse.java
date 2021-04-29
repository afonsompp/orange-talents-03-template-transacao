package br.com.bank.transactions;

public class CardResponse {

	private String id;
	private String email;

	@Deprecated
	public CardResponse() {

	}

	public CardResponse(String id, String email) {
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
