package com.dowma.library.config

import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.ConfigFileApplicationContextInitializer
import org.springframework.boot.test.IntegrationTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Simple test class that is attempting to autowire a java declared config-file-initialized bean,
 * and test for expected property values
 */
@ContextConfiguration(classes = DanCarProperties, initializers = ConfigFileApplicationContextInitializer)
@ActiveProfiles('ci')
@IntegrationTest
@Slf4j
class CarPropertiesSpec extends Specification {

    // should be autowired from the declared component
    @Autowired DanCarProperties danCarProperties


    def 'test that loading the dan car properties works as expected'() {
        when:   'nothing useful to test here'
        log.info "danCarProperties=${danCarProperties}"

        then:   'the properties from the application.yml should have been loaded'
        danCarProperties != null            // <-- this line always passes the test, so what is getting autowired?
        danCarProperties.make == 'nissan'   // <-- all properties come up null, so the test fails.  why?
    }

}
