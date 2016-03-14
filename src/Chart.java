
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tomaž
 */
public class Chart extends ApplicationFrame {
/**
* 
*
* 
*/
                        public static String valuta;
                        public Chart(String izbiraValute, int izbira1, int izbira2) {
                        super(izbiraValute);
                        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        for (int i = izbira1; i < izbira2+1; i++) {
                        Element m = (Element) NewJFrame.nl1.item(i);
                        NodeList childNodes = m.getChildNodes();
                        for (int j = 0; j < childNodes.getLength(); j++) {
                            if (childNodes.item(j).getAttributes().getNamedItem("oznaka").getNodeValue().equals(izbiraValute))
                                    {
                                        valuta = childNodes.item(j).getTextContent(); 
                                    }
                            }
                        String datum = m.getAttributes().getNamedItem("datum").getNodeValue();
                        dataset.addValue(Double.parseDouble(valuta), izbiraValute, datum);
                        JFreeChart chart = ChartFactory.createLineChart(
                        "Graf "+izbiraValute, // chart title
                        "Obdobje", // domain axis label
                        "Vrednost", // range axis label
                        dataset, // data
                        PlotOrientation.VERTICAL, // orientation
                        true, // include legend
                        true, // tooltips?
                        false // URLs?
                        );
                        ChartPanel chartPanel = new ChartPanel(chart, false);
                        chartPanel.setPreferredSize(new Dimension(1000, 500));
                        setContentPane(chartPanel);
                        }
}
}

