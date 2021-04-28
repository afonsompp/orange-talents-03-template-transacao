package br.com.bank.transactions;

public class EstablishmentTopicPayload {

	private String nome;
	private String cidade;
	private String endereco;

	@Deprecated
	public EstablishmentTopicPayload() {}

	public EstablishmentTopicPayload(String nome, String cidade, String endereco) {
		this.nome = nome;
		this.cidade = cidade;
		this.endereco = endereco;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCidade() {
		return this.cidade;
	}

	public String getEndereco() {
		return this.endereco;
	}

}
