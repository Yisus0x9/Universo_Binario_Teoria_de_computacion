import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.*;
import java.util.ArrayList;

/*
* Clase que usa la libreria de JFreeChart para poder mostrar las graficas que procesan los datos producidos
* */

public class Grafica {
    DefaultCategoryDataset coord=new DefaultCategoryDataset();
    ArrayList <Integer>nUnos;
    String nombreG;

    public Grafica(String nombreG,ArrayList <Integer>nUnos) {
        this.nombreG = nombreG;
        this.nUnos=nUnos;
    }

    public ChartPanel graficarUnos(){
        XYSeries series = new XYSeries("Numero de 1´s");
        System.out.println(nUnos.size());
        for (int i = 0; i < nUnos.size(); i++) {
            series.add(i+1,nUnos.get(i));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "#1´s",
                "cadena",
                "numero  de unos",
                dataset
        );

        return new ChartPanel(chart);
    }


    public ChartPanel graficarLog(){
        XYSeries series = new XYSeries("Log Base 10");
        nUnos.removeIf(val->val<=0);
        for (int i = 0; i < nUnos.size(); i++) {
            series.add(i+1,Math.log10(nUnos.get(i)));
        }

        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Gráfico donde muestra los #1's con logaritmo",
                "cadena",
                "Log Base 10",
                dataset

        );
        chart.getXYPlot().setDomainZeroBaselineVisible(true);
        return new ChartPanel(chart);
    }

}
