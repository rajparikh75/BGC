package com.bgc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by rparikh on 6/16/2017.
 */
public class CityConnections {
    private Map<String, City> cityMap = new HashMap<>();

    public void addCityConnection(String cityName1, String cityName2){
        City city1 = cityMap.getOrDefault(cityName1, new City(cityName1));
        City city2 = cityMap.getOrDefault(cityName2, new City(cityName2));
        city1.getConnectedTo().add(city2);
        city2.getConnectedTo().add(city1);

        cityMap.putIfAbsent(cityName1, city1);
        cityMap.putIfAbsent(cityName2, city2);
    }

    public boolean isConnected(final String cityName1, String cityName2) {
        return cityMap.containsKey(cityName1) && cityMap.get(cityName1).isConnectedTo(cityName2, new HashSet<String>() {{
            add(cityName1);
        }});
    }

}
