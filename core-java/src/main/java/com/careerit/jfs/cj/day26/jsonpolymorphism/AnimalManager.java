package com.careerit.jfs.cj.day26.jsonpolymorphism;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,      // Use simple names
        include = JsonTypeInfo.As.PROPERTY, // Include type info in JSON as property
        property = "type"                // Name of the type field in JSON
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
@Getter
abstract class Animal {
    String name;
}
@Getter
class Dog extends Animal {
    double barkVolume;
}
@Getter
class Cat extends Animal {
    int lives;
}
public class AnimalManager {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Animal animal = new Dog();
        animal.name = "Fido";
        ((Dog) animal).barkVolume = 10.0;

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(animal);
        System.out.println(json);

        Animal animal1 = objectMapper.readValue(json, Animal.class);
        System.out.println(animal1.getClass().getSimpleName());

    }


}
