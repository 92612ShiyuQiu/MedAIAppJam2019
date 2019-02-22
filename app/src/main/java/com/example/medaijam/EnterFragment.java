package com.example.medaijam;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class EnterFragment extends Fragment{

    Button button, closeButton;
    View view;
    Dialog dialog;
    EditText sbp, dbp, hr, ir;

    static Dataset.getSBP s = new Dataset.getSBP();
    static Dataset.getDBP d = new Dataset.getDBP();
    static Dataset.getMAP m = new Dataset.getMAP();
    static Dataset.getHR h = new Dataset.getHR();
    static Dataset.getIR i = new Dataset.getIR();
    static Dataset.percentageMAP pm = new Dataset.percentageMAP();
    static Dataset.percentageHR ph = new Dataset.percentageHR();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_enter, null);

        dialog = new Dialog(getActivity());
        button = (Button) view.findViewById(R.id.button4);

        sbp = (EditText) view.findViewById(R.id.editText2);
        dbp = (EditText) view.findViewById(R.id.editText3);
        hr = (EditText) view.findViewById(R.id.editText4);
        ir = (EditText) view.findViewById(R.id.editText6);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendNewData(v);
            }
        });

        return view;
    }

    public void ShowPopup() {
        dialog.setContentView(R.layout.popup);
        closeButton = (Button) dialog.findViewById(R.id.button);

        closeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    public void sendNewData(View view) {
        String sBP = sbp.getText().toString();
        s.addSBP(Integer.parseInt(sBP));
        String dBP = dbp.getText().toString();
        d.addDBP(Integer.parseInt(dBP));
        String hR = hr.getText().toString();
        h.addHR(Integer.parseInt(hR));
        String iR = ir.getText().toString();
        char temp = iR.charAt(0);
        int int_iR;
        if(temp == 'y' | temp == 'Y'){
            int_iR = 1;
        }else{
            int_iR = 0;
        }
        i.addIR(int_iR);
        m.addMAP(Integer.parseInt(sBP), Integer.parseInt(dBP));
        pm.addPMAP(m.wantMAP().get(0), m.wantMAP().get(m.wantMAP().size()-1));
        ph.addPHR(h.wantHR().get(0), h.wantHR().get(h.wantHR().size()-1));

        System.out.println(EnterFragment.s.wantSBP());
        System.out.println(EnterFragment.d.wantDBP());
        System.out.println(EnterFragment.h.wantHR());
        System.out.println(EnterFragment.i.wantIR());
        System.out.println(EnterFragment.m.wantMAP());

        double[] input_data = {Double.parseDouble(sBP),
                                Double.parseDouble(dBP),
                                pm.wantPMAP().get(pm.wantPMAP().size()-1),
                                ph.wantPHR().get(ph.wantPHR().size()-1),
                                (double)(int_iR)};

        int result = RandomForestClassifier.predict(input_data);

        if (result == 1) {
            ShowPopup();
        }

    }
}
