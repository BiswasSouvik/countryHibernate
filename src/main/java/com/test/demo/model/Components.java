package com.test.demo.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonSubTypes({
        @JsonSubTypes.Type(value = City.class, name = "City"),

        @JsonSubTypes.Type(value = Nationality.class, name = "Nationality")}
)
interface Components {
}
