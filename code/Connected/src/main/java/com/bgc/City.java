package com.bgc;


import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rparikh on 6/16/2017.
 */
@Getter
@RequiredArgsConstructor
@EqualsAndHashCode(exclude = {"connectedTo"})
public class City {
    private final String cityName;
    private Set<City> connectedTo = new HashSet<>();

    boolean isConnectedTo(String cityName, Set<String> visited) {
        if (this.cityName.equalsIgnoreCase(cityName)) {
            return true;
        }

        for (City city : connectedTo) {
            if (visited.contains(city.getCityName())) {
                continue;
            }

            visited.add(city.getCityName());
            if (city.isConnectedTo(cityName, visited)) {
                return true;
            }
        }
        return false;
    }
}
