package br.com.bank.transactions;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import feign.FeignException.FeignClientException;
import feign.FeignException.FeignServerException;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

	private final TransactionClient client;

	public TransactionController(TransactionClient client) {
		this.client = client;

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
}
