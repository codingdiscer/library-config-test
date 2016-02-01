package com.dowma.library.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Properties;

/**
 * Has properties that describe the basic attributes of someone's car,
 * with a Properties object for other arbitrary features of the car
 */
@Data
@NoArgsConstructor
public class CarProperties {

    private String make;
    private String model;
    private String color;
    private Properties otherProperties;

}
