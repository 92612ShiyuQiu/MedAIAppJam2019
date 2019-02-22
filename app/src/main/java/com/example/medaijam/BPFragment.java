package com.example.medaijam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

public class BPFragment extends Fragment{

    LineChart lineChart;
    View view;
    LineGraphSeries<DataPoint> series;
    Dataset.percentageMAP pm = EnterFragment.pm;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bp, null);

        lineChart = (LineChart) view.findViewById(R.id.chart);

        Dataset.getSBP s = EnterFragment.s;
        Dataset.getDBP d = EnterFragment.d;
        Dataset.getMAP m = EnterFragment.m;

        ArrayList<String> xAES = new ArrayList<>();
        ArrayList<Entry> ySBP = new ArrayList<>();
        ArrayList<Entry> yDBP = new ArrayList<>();
        ArrayList<Entry> yMAP = new ArrayList<>();

        int x = 0;
        int numDataPoints = 24;
        for (int i=0; i<s.wantSBP().size(); i++){
            float sFunction = (float)s.wantSBP().get(i);
            float dFunction = (float)d.wantDBP().get(i);
            float mFunction = (float)(double)m.wantMAP().get(i);

            ySBP.add(new Entry(i,sFunction));
            yDBP.add(new Entry(i,dFunction));
            yMAP.add(new Entry(i,mFunction));
            xAES.add(i, String.valueOf(x));
            x = x + 1;
        }

        String[] xaxes = new String[xAES.size()];
        for(int i=0; i<xAES.size(); i++){
            xaxes[i] = xAES.get(i).toString();
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();


        LineDataSet dataSBP = new LineDataSet(ySBP, "SBP");
        dataSBP.setDrawCircles(false);
        dataSBP.setColor(Color.BLUE);

        LineDataSet dataDBP = new LineDataSet(yDBP, "DBP");
        dataDBP.setDrawCircles(false);
        dataDBP.setColor(Color.RED);

        LineDataSet dataMAP = new LineDataSet(yMAP, "MAP");
        dataMAP.setDrawCircles(false);
        dataMAP.setColor(Color.BLACK);


        lineDataSets.add(dataSBP);
        lineDataSets.add(dataDBP);
        lineDataSets.add(dataMAP);



        lineChart.setData(new LineData(lineDataSets));

        double b,a;

        GraphView graph = (GraphView) view.findViewById(R.id.chart2);

        series = new LineGraphSeries<DataPoint>();

        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(24.0);
        graph.getViewport().setMinY(-30.0);
        graph.getViewport().setMaxY(100.0);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

        for (int i = 0; i < pm.wantPMAP().size(); i++) {
            a = i * 2;
            b = pm.wantPMAP().get(i);
            series.appendData(new DataPoint(a,b), true, 100);
        }
        graph.addSeries(series);

        return view;
    }
}

