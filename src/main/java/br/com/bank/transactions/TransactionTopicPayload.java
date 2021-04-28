package br.com.bank.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionTopicPayload {

	private String id;
	private BigDecimal valor;
	private EstablishmentTopicPayload estabelecimento;
	private CardTopicPayload cartao;
	private LocalDateTime efetivadaEm;

	@Deprecated
	public TransactionTopicPayload() {}

	public TransactionTopicPayload(String id, BigDecimal valor,
			EstablishmentTopicPayload estabelecimento, CardTopicPayload cartao,
			LocalDateTime efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public String getId() {
		return this.id;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public EstablishmentTopicPayload getEstabelecimento() {
		return this.estabelecimento;
	}

	public CardTopicPayload getCartao() {
		return this.cartao;
	}

	public LocalDateTime getEfetivadaEm() {
		return this.efetivadaEm;
	}

	public Transaction toModel() {
		return new Transaction(valor, efetivadaEm, cartao.getId(), cartao.getEmail(),
				estabelecimento.getNome(), estabelecimento.getCidade(), estabelecimento.getEndereco());
	}

}
