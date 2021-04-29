package br.com.bank.transactions;

public class CompanyResponse {
	private String name;
	private String city;
	private String address;

	@Deprecated
	public CompanyResponse() {}

	public CompanyResponse(String name, String city, String address) {
		this.name = name;
		this.city = city;
		this.address = address;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	public String getAddress() {
		return this.address;
	}
}
