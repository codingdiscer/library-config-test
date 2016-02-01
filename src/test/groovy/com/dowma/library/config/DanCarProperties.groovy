package com.dowma.library.config

import lombok.Data
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

/**
 * This class exists to be configured from a properties (or yaml) file.  This would represent an
 * instance in another project that imports this library as a dependency.  There could be multiple
 * instances of CarProperties in the dependent project with their configuration values, so this
 * class is attempting to mock that behavior.
 *
 * No properties need to be declared because in this scenario, we only want to inherit and configure
 * the declared properties from the superclass.
 */
@Component
@ConfigurationProperties(prefix = 'car.dan')
class DanCarProperties extends CarProperties {
    // just inherit all the properties from CarProperties
}
