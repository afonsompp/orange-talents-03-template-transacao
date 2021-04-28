package br.com.bank.transactions;

public class CardTopicPayload {

	private String id;
	private String email;

	@Deprecated
	public CardTopicPayload() {}

	public CardTopicPayload(String id, String email) {
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
