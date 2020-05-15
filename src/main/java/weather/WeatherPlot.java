package weather;

import java.util.Vector;

/**
 * Created by marek an 23.10.2019.
 */
public class WeatherPlot {
    String [] Temperature= new String[40] ;
    String [] Icon;
    String [] Date= new String[40];
    Integer[] Observations =new Integer[10];
    WeatherWidget[] widgets = new WeatherWidget[10];

    public WeatherPlot(Vector<WObs> Forecast) {
        this.getTemperature(Forecast);
        this.getDate(Forecast);
    }
    private void getTemperature(Vector<WObs> Forecast){
        for(int i=0;i<Forecast.size();i++){
            Temperature[i]=Forecast.elementAt(i).getTemp();
        }
    }
    private void getDate(Vector<WObs> Forecast){
        for(int i=0;i<Forecast.size();i++){
            Date[i]=Forecast.elementAt(i).getDt_txt();
        }
    }
    public void printTemp(){
            for(int i=0;i<Temperature.length;i++){
                System.out.println("temperatura wynosi: "+Temperature[i]);
            }
    }
    public void printDate(){
        for(int i=0;i<Date.length;i++){
            try{
                System.out.println("date: "+Date[i].substring(11,13));
            }
            catch (Exception e){
                //System.out.println("date unassigned");
            }

        }
    }
    public void setObservations(){
        try {
            int i=0;
             do{
                i++;
            }while (!Date[i].substring(11, 13).equals("00") && !Date[i].substring(11, 13).equals("12"));
             int obsIndex=0;
             for(int i1=i;i1<Date.length;i1+=4){
                 Observations[obsIndex]=i1;
                 obsIndex++;

             }
        }
        catch (Exception e){
            //System.out.println("date unassigned 2");
        }


    }
    public void setWidgets(Vector<WObs> Forecast){
        try {
            for (int i = 0; i < Observations.length; i++) {
                WeatherWidget widget= new WeatherWidget();
                widget.setDate(Forecast.elementAt(Observations[i]).getDt_txt());
                widget.setTemp(Forecast.elementAt(Observations[i]).getTemp());
                widget.setIcon(Forecast.elementAt(Observations[i]).getIcon());
                widgets[i]=widget;
            }
        }
        catch (Exception e){
            //System.out.println(e.getMessage());
        }

    }
    public void printWidgets(){
        try{
        for (int i =0;i<widgets.length;i++){
            System.out.println(widgets[i].getDate()+"temperature"+widgets[i].getTemp()+widgets[i].getIcon());
        }
        }
        catch (Exception e){System.out.println("Widgets were not set");}
    }
}
