package org.wso2.carbon.event.publisher.core.internal.type.tenantText;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.wso2.carbon.databridge.commons.StreamDefinition;
import org.wso2.carbon.event.publisher.core.config.EventPublisherConfiguration;
import org.wso2.carbon.event.publisher.core.config.OutputMapping;
import org.wso2.carbon.event.publisher.core.exception.EventPublisherConfigurationException;
import org.wso2.carbon.event.publisher.core.internal.OutputMapper;
import org.wso2.carbon.event.publisher.core.internal.type.text.TextOutputMapper;
import org.wso2.carbon.event.publisher.core.internal.type.text.TextOutputMapperConfigurationBuilder;
import org.wso2.carbon.event.publisher.core.internal.type.text.TextOutputMapperFactory;

import java.util.Map;

public class TenantAwareTextOutputMapperFactory extends TextOutputMapperFactory {

    public OutputMapper constructOutputMapper(
            EventPublisherConfiguration eventPublisherConfiguration,
            Map<String, Integer> propositionMap, int tenantId, StreamDefinition streamDefinition)
            throws EventPublisherConfigurationException {
        return new TenantAwareTextOutputMapper(eventPublisherConfiguration, propositionMap, tenantId, streamDefinition);
    }

    @Override
    public OutputMapping constructOutputMapping(OMElement omElement)
            throws EventPublisherConfigurationException {
        return TenantAwareTextOutputMapperConfigurationBuilder.fromOM(omElement);
    }

    @Override
    public OMElement constructOMFromOutputMapping(
            OutputMapping outputMapping, OMFactory factory) {
        return TenantAwareTextOutputMapperConfigurationBuilder.outputMappingToOM(outputMapping, factory);
    }
}
