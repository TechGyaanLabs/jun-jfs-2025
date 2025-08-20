package com.careerit.jfs.cj.day26.country;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Data
class Pair{
    double max;
    double min;
}
public class CountryManager {

    public static void main(String[] args) {

        List<Country> countries = getAllCountryDetails();
        System.out.println("Total countries: " + countries.size());

        // Get the unique regions

        List<String> uniqueRegions = countries
                .stream()
                .map(Country::getRegion)
                .distinct()
                .toList();
        System.out.println("Unique regions: " + uniqueRegions);

        // Get the country with maximum population

         Pair pair = getMaxAndMinPopulation(countries);

         List<Country> maxPopulationCountries = getMaxPopulationCountries(countries, pair.getMax());
         List<Country> minPopulationCountries = getMinPopulationCountries(countries, pair.getMin());

        System.out.println("Max population is :"+pair.getMax());
        for(Country country : maxPopulationCountries){
            System.out.println(country.getCommonName()+" "+country.getArea()+" "+country.getPopulation());
        }

        System.out.println("Min population is :"+pair.getMin());
        for(Country country : minPopulationCountries){
            System.out.println(country.getCommonName()+" "+country.getArea()+" "+country.getPopulation());
        }
        // Get smallest and largest country in terms of area
        Pair areaPair = getMaxAndMinArea(countries);

        List<Country> maxAreaCountries = getMaxAreaCountries(countries, areaPair.getMax());
        List<Country> minAreaCountries = getMinAreaCountries(countries, areaPair.getMin());

        System.out.println("Largest area: " + areaPair.getMax());
        for (Country country : maxAreaCountries) {
            System.out.println(country.getCommonName() + " " + country.getArea());
        }

        System.out.println("Smallest area: " + areaPair.getMin());
        for (Country country : minAreaCountries) {
            System.out.println(country.getCommonName() + " " + country.getArea());
        }


    }

    private static List<Country> getMaxPopulationCountries(List<Country> countries, double maxPopulation) {
        return
                countries
                .stream()
                .filter(country -> country.getPopulation() == maxPopulation)
                .toList();
    }

    private static List<Country> getMinPopulationCountries(List<Country> countries, double minPopulation) {
        return
                countries
                .stream()
                .filter(country -> country.getPopulation() == minPopulation)
                .toList();
    }

    private static Pair getMaxAndMinPopulation(List<Country> countries) {
        double maxPopulation = countries.get(0).getPopulation();
        double minPopulation = countries.get(0).getPopulation();

        for (Country country : countries) {
            if (country.getPopulation() > maxPopulation) {
                maxPopulation = country.getPopulation();
            }
            if (country.getPopulation() < minPopulation) {
                minPopulation = country.getPopulation();
            }
        }
        Pair pair = new Pair();
        pair.setMax(maxPopulation);
        return pair;
    }
    private static Pair getMaxAndMinArea(List<Country> countries) {
        double maxArea = countries.get(0).getArea();
        double minArea = countries.get(0).getArea();

        for (Country country : countries) {
            if (country.getArea() > maxArea) {
                maxArea = country.getArea();
            }
            if (country.getArea() < minArea) {
                minArea = country.getArea();
            }
        }

        Pair pair = new Pair();
        pair.setMax(maxArea);
        pair.setMin(minArea);
        return pair;
    }

    private static List<Country> getMaxAreaCountries(List<Country> countries, double maxArea) {
        return countries.stream()
                .filter(country -> country.getArea() == maxArea)
                .toList();
    }

    private static List<Country> getMinAreaCountries(List<Country> countries, double minArea) {
        return countries.stream()
                .filter(country -> country.getArea() == minArea)
                .toList();
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
