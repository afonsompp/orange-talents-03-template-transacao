package br.com.bank.transactions;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TransactionListener {

	TransactionRepository repository;

	public TransactionListener(TransactionRepository repository) {
		this.repository = repository;
	}

	@KafkaListener(topics = "${kafka.topic.transaction}")
	public void greetingListener(TransactionTopicPayload transaction) {
		repository.save(transaction.toModel());
	}
}
