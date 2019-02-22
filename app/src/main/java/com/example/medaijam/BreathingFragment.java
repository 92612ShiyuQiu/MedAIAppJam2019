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
import com.jjoe64.graphview.series.PointsGraphSeries;

public class BreathingFragment extends Fragment{

    PointsGraphSeries<DataPoint> xySeries;
    GraphView mScatterPlot;
    View view;

    Dataset.getIR i = EnterFragment.i;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breathing, null);

        mScatterPlot = (GraphView) view.findViewById(R.id.scatterPlot);
        createScatterPlot();

        mScatterPlot.getViewport().setMinX(0.0);
        mScatterPlot.getViewport().setMaxX(24.0);
        mScatterPlot.getViewport().setMinY(0.0);
        mScatterPlot.getViewport().setMaxY(2.0);

        mScatterPlot.getViewport().setYAxisBoundsManual(true);
        mScatterPlot.getViewport().setXAxisBoundsManual(true);

        return view;
    }

    private void createScatterPlot() {
        xySeries = new PointsGraphSeries();

        for (int j = 0; j < i.wantIR().size(); j++) {
            double x = j * 2;
            double y = i.wantIR().get(j);
            xySeries.appendData(new DataPoint(x,y), true, 100);
        }
        mScatterPlot.addSeries(xySeries);
        xySeries.setShape(PointsGraphSeries.Shape.POINT);
    }
}
