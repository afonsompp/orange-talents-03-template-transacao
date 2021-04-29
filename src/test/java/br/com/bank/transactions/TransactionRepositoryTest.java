package br.com.bank.transactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
class TransactionRepositoryTest {

	@Autowired
	TransactionRepository repository;

	@BeforeEach
	public void setUp() {
		var date = LocalDateTime.now();
		repository.save(new Transaction(new BigDecimal(1), date, "123", "", "", "", ""));
		repository.save(new Transaction(new BigDecimal(1), date, "431", "", "", "", ""));
		repository.save(new Transaction(new BigDecimal(1), date, "123", "", "", "", ""));
		repository.save(new Transaction(new BigDecimal(1), date, "123", "", "", "", ""));
	}

	@DisplayName("Should return every transactions of a card")
	@ParameterizedTest
	@MethodSource("provideParams")
	void test1(String value, Integer size) {

		var response = repository.findByCardId(value, PageRequest.of(0, 4));

		assertEquals(size, response.getNumberOfElements());
		if (!response.isEmpty()) {
			assertEquals(value, response.getContent().get(0).getCardId());
		}
	}

	private static Stream<Arguments> provideParams() {
		return Stream.of(
				Arguments.of("123", 3),
				Arguments.of("124", 0));
	}

}
