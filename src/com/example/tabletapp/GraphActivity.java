/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.tabletapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.tabletapp.Match.Time;
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
	
	private Match match;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		this.match = Match.getInstance();
		super.onCreate(savedInstanceState);
		this.backbuttonenable();
		Intent i = ChartFactory.getLineChartIntent(this, getDataset(), getDemoRenderer(), null);
		startActivity(i);
	}
	
  private XYMultipleSeriesDataset getDataset() {
    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    final int nr = 10;
      XYSeries skater = new XYSeries(this.match.getInfo().getRacerName(),0);
	  XYSeries total = new XYSeries("Totale Tijd", 1);
	  int i = 0;
	  int totalTime = 0;
      for (Time t:this.match.getTimes()) {
        skater.add(i, t.getRoundTime());
		totalTime += t.getRoundTime();
		total.add(i, totalTime);
		i++;
      }
      dataset.addSeries(skater);
	  dataset.addSeries(total);
    return dataset;
  }
   
  private XYMultipleSeriesRenderer getDemoRenderer() {
    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(2);
    XYSeriesRenderer r = new XYSeriesRenderer();
	XYSeriesRenderer r2 = new XYSeriesRenderer();
	
	renderer.addSeriesRenderer(r);
	renderer.addSeriesRenderer(r2);
	r.setColor(Color.GREEN);
	r2.setColor(Color.RED);
	
	renderer.setYAxisMin(1000, 0);
	renderer.setYAxisMax(4000, 0);
	
	renderer.setYAxisMin(1000, 1);
	renderer.setYAxisMax(24000, 1);
	
  	renderer.addYTextLabel(1000, "00:10:00",0);
	renderer.addYTextLabel(1500, "00:15:00",0);
	renderer.addYTextLabel(2000, "00:20:00",0);
	renderer.addYTextLabel(2500, "00:25:00",0);
	renderer.addYTextLabel(3000, "00:30:00",0);
	renderer.addYTextLabel(3500, "00:35:00",0);
	renderer.addYTextLabel(4000, "00:40:00",0);

	renderer.addYTextLabel(1000, "00:10:00", 1);
	renderer.addYTextLabel(2000, "00:20:00", 1);
	renderer.addYTextLabel(3000, "00:30:00", 1);
	renderer.addYTextLabel(4000, "00:40:00", 1);
	renderer.addYTextLabel(5000, "00:50:00", 1);
	renderer.addYTextLabel(6000, "01:00:00", 1);
	renderer.addYTextLabel(7000, "01:10:00", 1);
	renderer.addYTextLabel(8000, "01:20:00", 1);
	renderer.addYTextLabel(9000, "01:30:00", 1);
	renderer.addYTextLabel(10000, "01:40:00", 1);
	renderer.addYTextLabel(11000, "01:50:00", 1);
	renderer.addYTextLabel(12000, "02:00:00", 1);
	
	if(match.getInfo().getDistance() > 1500) {
		renderer.addYTextLabel(13000, "02:10:00", 1);
		renderer.addYTextLabel(14000, "02:20:00", 1);
		renderer.addYTextLabel(15000, "02:30:00", 1);
		renderer.addYTextLabel(16000, "02:40:00", 1);
		renderer.addYTextLabel(17000, "02:50:00", 1);
		renderer.addYTextLabel(18000, "03:00:00", 1);
		renderer.addYTextLabel(19000, "03:10:00", 1);
		renderer.addYTextLabel(20000, "03:20:00", 1);
		renderer.addYTextLabel(21000, "03:30:00", 1);
		renderer.addYTextLabel(22000, "03:40:00", 1);
		renderer.addYTextLabel(23000, "03:50:00", 1);
		renderer.addYTextLabel(24000, "04:00:00", 1);
	}
	
	renderer.setYAxisAlign(Align.RIGHT, 1);
	renderer.setYLabelsAlign(Align.RIGHT, 1);
	renderer.setYLabelsColor(1, Color.RED);
	renderer.setYLabelsColor(0, Color.GREEN);
	
	renderer.setShowGrid(true);
	
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
