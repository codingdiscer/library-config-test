package com.dowma.library.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.ConfigFileApplicationContextInitializer
import org.springframework.boot.test.IntegrationTest
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Simple test class that is attempting to autowire a java declared config-file-initialized bean,
 * and test for expected property values.
 *
 * Update - 2/1/2016, 10:55am - problem solved.
 *
 * The solution is to point the @ContextConfiguration to an actual @Configuration annotated class, and
 * that @Configuration annotated class has the @EnableConfigurationProperties annotation, which ties
 * the referenced component (DanCarProperties) to the properties.
 *
 * This test case now passes.
 *
 */
@ContextConfiguration(classes = TestClassConfig, initializers = ConfigFileApplicationContextInitializer)
@Slf4j
class CarPropertiesSpec extends Specification {

    // should be autowired from the declared component
    @Autowired DanCarProperties danCarProperties


    def 'test that loading the dan car properties works as expected'() {
        when:   'nothing useful to test here'
        log.info "danCarProperties=${danCarProperties}"

        then:   'the properties from the application.yml should have been loaded'
        danCarProperties != null            // the autowired component is loaded correctly
        danCarProperties.make == 'nissan'   // this property is now set properly from the config file
    }

    /**
     * This configuration class must point to the @Component for the component to
     * be properly associated to the configuration properties.  Basically, the missing
     * annotation in this whole mess was @EnableConfigurationProperties()
     */
    @Configuration
    @EnableConfigurationProperties(DanCarProperties)
    static class TestClassConfig {
        // does nothing but enables the DanCarProperties class to be loaded from the configuration file
    }

}
