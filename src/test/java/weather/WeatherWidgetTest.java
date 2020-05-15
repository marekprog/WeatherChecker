package weather;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by marek an 15.05.2020.
 */
public class WeatherWidgetTest{

    @Test
    public void testIfGetPrettyDateHandlesException() throws ParseException {
        //given
        WeatherWidget widget = new WeatherWidget();
        //when
        widget.setDate("2000000");
        //then
        assertThat(widget.getPrettyDate(),is(widget.getDate()));
    }
}