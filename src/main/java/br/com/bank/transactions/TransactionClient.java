package br.com.bank.transactions;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "transaction", url = "http://${transaction.host}:${transaction.port}")
public interface TransactionClient {
	@RequestMapping(method = RequestMethod.POST, value = "/api/cartoes",
			consumes = "application/json")
	void startTransactions(@RequestBody TransactionClientRequest dto);

	@RequestMapping(method = RequestMethod.DELETE, value = "/api/cartoes/{id}")
	void stopTransaction(@PathVariable("id") String id);
}
