package br.com.bank.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private BigDecimal amount;
	@Column(nullable = false, name = "confirmed_at")
	private LocalDateTime confirmedAt;
	@Column(nullable = false, name = "card_id")
	private String cardId;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false, name = "company_name")
	private String companyName;
	@Column(nullable = false, name = "company_city")
	private String companyCity;
	@Column(nullable = false, name = "company_address")
	private String companyAddress;

	@Deprecated
	public Transaction() {

	}

	public Transaction(BigDecimal amount, LocalDateTime confirmedAt, String cardId, String email,
			String companyName, String companyCity, String companyAddress) {
		this.amount = amount;
		this.confirmedAt = confirmedAt;
		this.cardId = cardId;
		this.email = email;
		this.companyName = companyName;
		this.companyCity = companyCity;
		this.companyAddress = companyAddress;
	}

	public Long getId() {
		return this.id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public LocalDateTime getConfirmedAt() {
		return this.confirmedAt;
	}

	public String getCardId() {
		return this.cardId;
	}

	public String getEmail() {
		return this.email;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public String getCompanyCity() {
		return this.companyCity;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

}
