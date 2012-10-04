package com.example.tabletapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import org.achartengine.ChartFactory;
import org.achartengine.chart.AbstractChart;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.chartdemo.demo.chart.AbstractDemoChart;
import org.achartengine.model.RangeCategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author school
 */
public class MatchChart extends AbstractDemoChart {
	
	public String getName()
	{
		return "Match chart";
	}
	
	public String getDesc()
	{
		return "wedstrijdtijden";
	}
	
	public Intent execute(Context context)
	{
		double[] minValues = new double[] { -24, -19, -10, -1, 7, 12, 15, 14, 9, 1, -11, -16 };
    double[] maxValues = new double[] { 7, 12, 24, 28, 33, 35, 37, 36, 28, 19, 11, 4 };

    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    RangeCategorySeries series = new RangeCategorySeries("Temperature");
    int length = minValues.length;
    for (int k = 0; k < length; k++) {
      series.add(minValues[k], maxValues[k]);
    }
    dataset.addSeries(series.toXYSeries());
    int[] colors = new int[] { Color.CYAN };
    XYMultipleSeriesRenderer renderer = buildBarRenderer(colors);
    setChartSettings(renderer, "Monthly temperature range", "Month", "Celsius degrees", 0.5, 12.5,
        -30, 45, Color.GRAY, Color.LTGRAY);
    renderer.setBarSpacing(0.5);
    renderer.setXLabels(0);
    renderer.setYLabels(10);
    renderer.addXTextLabel(1, "1");
    renderer.addXTextLabel(2, "2");
    renderer.addXTextLabel(3, "3");
    renderer.addXTextLabel(4, "4");
    renderer.addXTextLabel(5, "5");
    renderer.addXTextLabel(6, "6");
    renderer.addYTextLabel(6000, "1:00:00");
    renderer.addYTextLabel(12000, "2:00:00");
    renderer.addYTextLabel(18000, "3:00:00");
    renderer.setMargins(new int[] {30, 70, 10, 0});
    renderer.setYLabelsAlign(Align.RIGHT);
    SimpleSeriesRenderer r = renderer.getSeriesRendererAt(0);
    r.setDisplayChartValues(true);
    r.setChartValuesTextSize(12);
    r.setChartValuesSpacing(3);
    r.setGradientEnabled(true);
    r.setGradientStart(-20, Color.BLUE);
    r.setGradientStop(20, Color.GREEN);
    return ChartFactory.getRangeBarChartIntent(context, dataset, renderer, Type.DEFAULT,
        "Temperature range");
	}
	
}
