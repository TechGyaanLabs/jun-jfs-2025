package com.careerit.jfs.cj.day26.country;

import com.careerit.jfs.cj.day13.one.A;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CountryManager {

    public static void main(String[] args) {

        List<Country> countries = getAllCountryDetails();
        System.out.println("Total countries: " + countries.size());

        // Get the unique regions


        // Get the country with maximum population


        // Get the country with minimum population


        // Get smallest and largest country in terms of area


    }

    private static List<Country> getAllCountryDetails() {
        List<Country> countries = new ArrayList<>();
        try {
            InputStream inputStream = CountryManager.class.getClassLoader()
                    .getResourceAsStream("country.json");
            ObjectMapper mapper = new ObjectMapper();
            JsonNode countryNode = mapper.readTree(inputStream);

            for (JsonNode node : countryNode) {
                JsonNode nameNode = node.get("name");
                String commonName = nameNode.get("common").asText();
                String officialName = nameNode.get("official").asText();
                long area = node.get("area").asLong();
                long population = node.get("population").asLong();
                String region = node.get("region").asText();
                List<String> capital = new ArrayList<>();
                for (JsonNode capitalNode : node.get("capital")) {
                    capital.add(capitalNode.asText());
                }
                String flagSvgUrl = node.get("flags").get("svg").asText();

                Country country = Country.builder()
                        .commonName(commonName)
                        .officialName(officialName)
                        .area(area)
                        .population(population)
                        .capital(capital)
                        .flagSvgUrl(flagSvgUrl)
                        .region(region)
                        .build();
                countries.add(country);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return countries;
    }
}
