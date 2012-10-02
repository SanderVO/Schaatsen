/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tabletapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import java.util.Random;
import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

/**
 *
 * @author school
 */
public class GraphActivity extends Activity {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.backbuttonenable();
		Intent i = ChartFactory.getTimeChartIntent(this, getDemoDataset(), getDemoRenderer(), null);
	}
	
  private XYMultipleSeriesDataset getDemoDataset() {
    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    final int nr = 10;
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      XYSeries series = new XYSeries("Demo series " + (i + 1));
      for (int k = 0; k < nr; k++) {
        series.add(k, 20 + r.nextInt() % 100);
      }
      dataset.addSeries(series);
    }
    return dataset;
  }
  
  private XYMultipleSeriesRenderer getDemoRenderer() {
    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
    renderer.setAxisTitleTextSize(16);
    renderer.setChartTitleTextSize(20);
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setPointSize(5f);
    renderer.setMargins(new int[] {20, 30, 15, 0});
    XYSeriesRenderer r = new XYSeriesRenderer();
    r.setColor(Color.BLUE);
    r.setPointStyle(PointStyle.SQUARE);
    r.setFillBelowLine(true);
    r.setFillBelowLineColor(Color.WHITE);
    r.setFillPoints(true);
    renderer.addSeriesRenderer(r);
    r = new XYSeriesRenderer();
    r.setPointStyle(PointStyle.CIRCLE);
    r.setColor(Color.GREEN);
    r.setFillPoints(true);
    renderer.addSeriesRenderer(r);
    renderer.setAxesColor(Color.DKGRAY);
    renderer.setLabelsColor(Color.LTGRAY);
    return renderer;
  }
	
	public void backbuttonenable(){
		ImageButton buttonback = (ImageButton)findViewById(R.id.back);
		
		if (buttonback == null)
			return;
		
		buttonback.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent i = new Intent(GraphActivity.this, MenuActivity.class);
				startActivity(i);
			}
		});
	}
	
}
