package com.example.listycity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();
    /**
     * This adds a city to the list if the city does not exist
     * @param city
     * This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This class returns a boolean for whether the list has a city
     * @return
     * Return a boolean
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }
    /**
     * This deletes a city if its in the list
     * @return
     * delets a city, or throws an exception
     */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        } else {
            throw new IllegalArgumentException("City not found in the list");
        }
    }
    /**
     * This returns a count of the city list size
     * @return
     * Return the list size
     */
    public int countCities() {
        return cities.size();
    }
}