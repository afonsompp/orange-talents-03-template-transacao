package br.com.bank.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LatestTransactionsResponse {
	private Long id;
	private BigDecimal amount;
	private CardResponse card;
	private CompanyResponse company;
	private LocalDateTime confirmedAt;

	public LatestTransactionsResponse(Transaction transaction) {
		this.id = transaction.getId();
		this.amount = transaction.getAmount();
		this.card = new CardResponse(transaction.getCardId(), transaction.getEmail());
		this.company = new CompanyResponse(transaction.getCompanyName(), transaction.getCompanyCity(),
				transaction.getCompanyAddress());
		this.confirmedAt = transaction.getConfirmedAt();
	}

	@Deprecated
	public LatestTransactionsResponse() {}

	public Long getId() {
		return this.id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public CardResponse getCard() {
		return this.card;
	}

	public CompanyResponse getCompany() {
		return this.company;
	}

	public LocalDateTime getConfirmedAt() {
		return this.confirmedAt;
	}

}
