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
        List<String> uniqueRegions = new ArrayList<>();
        for (Country country : countries) {
            if (!uniqueRegions.contains(country.getRegion())) {
                uniqueRegions.add(country.getRegion());
            }
        }
        System.out.println("Unique regions list: "+uniqueRegions);

        // Get the country with maximum population
        String maxPopulationCountry = null;
        long maxPopulation = Long.MIN_VALUE;
        for (Country country : countries) {
            if (maxPopulation < country.getPopulation()) {
                maxPopulation = country.getPopulation();
                maxPopulationCountry = country.getCommonName();
            }
        }
        System.out.println("Maximum population country: "+maxPopulationCountry);

        // Get the country with minimum population
        String minPopulationCountry = null;
        long minPopulation = Long.MAX_VALUE;
        for (Country country : countries) {
            if (minPopulation > country.getPopulation()) {
                minPopulation = country.getPopulation();
                minPopulationCountry = country.getCommonName();
            }
        }
        System.out.println("Minimum population country: "+minPopulationCountry);

        // Get smallest and largest country in terms of area
        String smallAreaCountry = null;
        String largeAreaCountry = null;
        long smallArea = Long.MAX_VALUE;
        long largeArea = Long.MIN_VALUE;
        for (Country country : countries) {
            if (smallArea > country.getArea()) {
               smallArea = country.getArea();
               smallAreaCountry = country.getCommonName();
            }

            if (largeArea < country.getArea()) {
                largeArea = country.getArea();
                largeAreaCountry = country.getCommonName();
            }
        }
        System.out.println("Smallest area country: "+smallAreaCountry);
        System.out.println("Largest area country: "+largeAreaCountry);

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
