package no.fintlabs.orgunit;

import no.novari.kafka.consuming.ErrorHandlerConfiguration;
import no.novari.kafka.consuming.ErrorHandlerFactory;
import no.novari.kafka.consuming.ListenerConfiguration;
import no.novari.kafka.consuming.ParameterizedListenerContainerFactoryService;
import no.novari.kafka.topic.name.EntityTopicNameParameters;
import no.novari.kafka.topic.name.TopicNamePrefixParameters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
public class OrgUnitConsumerConfiguration {
    private final ParameterizedListenerContainerFactoryService parameterizedListenerContainerFactoryService;
    private final ErrorHandlerFactory errorHandlerFactory;
    public OrgUnitConsumerConfiguration(
            ParameterizedListenerContainerFactoryService parameterizedListenerContainerFactoryService,
            ErrorHandlerFactory errorHandlerFactory) {
        this.parameterizedListenerContainerFactoryService = parameterizedListenerContainerFactoryService;
        this.errorHandlerFactory = errorHandlerFactory;
    }

    @Bean
    public ConcurrentMessageListenerContainer<String, OrgUnit> orgUnitConsumer(
            OrgUnitService orgUnitService
    ){
        ListenerConfiguration listenerConfiguration = ListenerConfiguration
                .stepBuilder()
                .groupIdApplicationDefault()
                .maxPollRecordsKafkaDefault()
                .maxPollIntervalKafkaDefault()
                .continueFromPreviousOffsetOnAssignment()
                .build();


        ConcurrentMessageListenerContainer<String, OrgUnit> listenerContainer = parameterizedListenerContainerFactoryService.createRecordListenerContainerFactory(
                        OrgUnit.class,
                       consumerRecord -> {
                            OrgUnit orgUnit = consumerRecord.value();
                            orgUnitService.save(orgUnit);
                        },
                listenerConfiguration,
                errorHandlerFactory.createErrorHandler(ErrorHandlerConfiguration
                        .stepBuilder()
                        .noRetries()
                        .skipFailedRecords()
                        .build())
        ).createContainer(EntityTopicNameParameters
                        .builder()
                        .topicNamePrefixParameters(TopicNamePrefixParameters
                                .stepBuilder()
                                .orgIdApplicationDefault()
                                .domainContextApplicationDefault()
                                .build())
                        .resourceName("orgunit")
                        .build());

        return listenerContainer;
    }
}
