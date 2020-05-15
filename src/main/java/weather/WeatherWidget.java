package weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by marek an 24.10.2019.
 */
public class WeatherWidget {
    private String temp;
    private String date;
    private String icon;


    public WeatherWidget() {
        this.temp = "temp";
        this.date = "2019-10-27 12:00:00";
        this.icon = "icon";
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    public String getPrettyDate() throws ParseException {
        final String OLD_FORMAT = "yyyy-M-dd HH:mm:ss";
        final String NEW_FORMAT = "EEEE dd MMMM kk";

        String oldDateString = date;
        String newDateString;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(oldDateString);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);

            return newDateString+":00 hr";
        }catch (ParseException e){
            return date;
        }

    }
}
