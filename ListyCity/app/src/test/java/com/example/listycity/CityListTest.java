package com.example.listycity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }


    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
// This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
// Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testHasCityMethod() {
        CityList cityList = new CityList();
        City city = new City("Edmonton", "AB");
        cityList.add(city);

        // Check that the city is correctly recognized as present
        assertTrue(cityList.hasCity(city));
        // Check that another city not added is false
        assertFalse(cityList.hasCity(new City("Calgary", "AB"))); // this syntax's function was understood by using ChatGPT
    }

    @Test
    public void testDeleteCityMethod() {
        CityList cityList = new CityList();
        City city = new City("Vancouver", "BC");
        cityList.add(city);

        // Check that delete actually removes the city
        cityList.deleteCity(city);
        assertFalse(cityList.hasCity(city));

        // Now test that exception is thrown when deleting non-existent city
        assertThrows(IllegalArgumentException.class, () -> { // this syntax's function was understood by using ChatGPT
            cityList.deleteCity(city);
        });
    }

    @Test
    public void testCountCitiesMethod() {
        CityList cityList = new CityList();
        cityList.add(new City("Toronto", "ON"));
        cityList.add(new City("Montreal", "QC"));

        // There should be exactly 2 cities
        assertEquals(2, cityList.countCities()); // this syntax's function was understood by using ChatGPT
    }




}

