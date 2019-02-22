package com.example.medaijam;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

import static com.example.medaijam.EnterFragment.h;

public class HRFragment extends Fragment{

    View view;
    LineGraphSeries<DataPoint> series;
    Dataset.getHR h = EnterFragment.h;
    Dataset.percentageHR ph = EnterFragment.ph;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hr, null);

        double y,x;

        GraphView graph = (GraphView) view.findViewById(R.id.chart1);

        series = new LineGraphSeries<DataPoint>();

        graph.getViewport().setMinX(0.0);
        graph.getViewport().setMaxX(24.0);
        graph.getViewport().setMinY(20.0);
        graph.getViewport().setMaxY(180.0);

        graph.getViewport().setYAxisBoundsManual(true);
        graph.getViewport().setXAxisBoundsManual(true);

        for (int i = 0; i < h.wantHR().size(); i++) {
            x = i * 2;
            y = h.wantHR().get(i);
            series.appendData(new DataPoint(x,y), true, 100);
        }
        graph.addSeries(series);

        double b,a;
        GraphView graph2 = (GraphView) view.findViewById(R.id.chart2);

        series = new LineGraphSeries<DataPoint>();

        graph2.getViewport().setMinX(0.0);
        graph2.getViewport().setMaxX(24.0);
        graph2.getViewport().setMinY(-100.0);
        graph2.getViewport().setMaxY(100.0);

        graph2.getViewport().setYAxisBoundsManual(true);
        graph2.getViewport().setXAxisBoundsManual(true);

        for (int i = 0; i < ph.wantPHR().size(); i++) {
            a = i * 2;
            b = ph.wantPHR().get(i);
            series.appendData(new DataPoint(a,b), true, 100);
        }
        graph2.addSeries(series);

        //ArrayList<View> result = new ArrayList<View>();
        //result.add(view1, view2);
        return view;
    }
}