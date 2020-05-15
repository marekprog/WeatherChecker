package weather;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by marek an 15.05.2020.
 */
public class CityHandlerTest{


    @Test
    public void checkIfGetCityListReturnsVectorWhenEmptyStringIsPassed() {
        //given
        CityHandler cityHandler = new CityHandler("");
        //when
        Vector<City> cities = cityHandler.getCityList();
        //then
        assertThat(cities,is(empty()));
    }

    @Test
    public void checkIfGetCityListReturnsNotEmptyVector(){
        //given
        CityHandler cityHandler = new CityHandler("Nowy Sacz");
        //when
        Vector<City> cities = cityHandler.getCityList();
        //then
        assertFalse(cities.isEmpty(),cities.toString());
    }
}