package br.com.bank.shered.config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import br.com.bank.transactions.TransactionTopicPayload;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

	private final KafkaProperties kafkaProperties;

	public KafkaConsumerConfig(KafkaProperties kafkaProperties) {
		this.kafkaProperties = kafkaProperties;
	}

	public ConsumerFactory<String, TransactionTopicPayload> transactionConsumerFactory() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
				kafkaProperties.getConsumer().getAutoOffsetReset());

		return new DefaultKafkaConsumerFactory<>(properties, new StringDeserializer(),
				new JsonDeserializer<>(TransactionTopicPayload.class, false));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TransactionTopicPayload> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, TransactionTopicPayload> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(transactionConsumerFactory());
		return factory;
	}

}
