package br.com.bank.transactions;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import feign.FeignException.FeignClientException;
import feign.FeignException.FeignServerException;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	private final TransactionClient client;
	private final TransactionRepository repository;

	public TransactionController(TransactionClient client, TransactionRepository repository) {
		this.client = client;
		this.repository = repository;

	}

	@PostMapping("/start")
	public ResponseEntity<?> startTransaction(@RequestBody @Valid TransactionRequest dto) {
		try {
			client.startTransactions(new TransactionClientRequest(dto));
		} catch (FeignClientException | FeignServerException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping("/stop/{id}")
	public ResponseEntity<?> stopTransaction(@PathVariable("id") String id) {
		try {
			client.stopTransaction(id);
		} catch (FeignClientException | FeignServerException e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<LatestTransactionsResponse>> tenLatestTransactions(
			@PathVariable("id") @Validated @NotBlank String id) {
		var pageable = PageRequest.of(0, 10, Sort.by("confirmedAt").descending());
		var transactions = repository.findByCardId(id, pageable);
		if (transactions == null || transactions.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(transactions.map(LatestTransactionsResponse::new).toList());
	}
}
