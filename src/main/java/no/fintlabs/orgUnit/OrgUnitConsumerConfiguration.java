package no.fintlabs.orgUnit;

import no.fintlabs.kafka.entity.EntityConsumerFactoryService;
import no.fintlabs.kafka.entity.topic.EntityTopicNameParameters;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class OrgUnitConsumerConfiguration {
    @Bean
    public ConcurrentMessageListenerContainer<String, OrgUnit> orgUnitConsumer(
            OrgUnitService orgUnitService,
            EntityConsumerFactoryService entityConsumerFactoryService
    ){
        EntityTopicNameParameters entityTopicNameParameters = EntityTopicNameParameters
                .builder()
                .resource("orgunit")
                .build();

        ConcurrentMessageListenerContainer container = entityConsumerFactoryService.createFactory(
                        OrgUnit.class,
                        (ConsumerRecord<String,OrgUnit> consumerRecord)
                                -> orgUnitService.save(consumerRecord.value()))
                .createContainer(entityTopicNameParameters);

        return container;

    }
}
