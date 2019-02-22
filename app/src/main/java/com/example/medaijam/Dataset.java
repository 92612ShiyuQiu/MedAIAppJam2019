package com.example.medaijam;

import java.util.ArrayList;
import java.util.List;

public class Dataset {
    public static class getSBP{
        private List<Integer> sbp = new ArrayList();
        public void addSBP(int i){
            sbp.add(i);
        }
        public List<Integer> wantSBP(){
            return sbp;
        }
    }

    public static class getDBP{
        private List<Integer> dbp = new ArrayList();
        public void addDBP(int i){
            dbp.add(i);
        }
        public List<Integer> wantDBP(){
            return dbp;
        }
    }

    public static class getMAP{
        private List<Double> map = new ArrayList();
        public void addMAP(int sbp, int dbp){
            double s = sbp;
            double d = dbp;
            double i = 1.0/3.0*s+2.0/3.0*d;
            map.add(i);
        }
        public List<Double> wantMAP(){
            return map;
        }
    }

    public static class getHR{
        private List<Integer> hr = new ArrayList();
        public void addHR(int i){
            hr.add(i);
        }
        public List<Integer> wantHR(){
            return hr;
        }
    }

    public static class getIR{
        private List<Integer> ir = new ArrayList();
        public void addIR(int i){
            ir.add(i);
        }
        public List<Integer> wantIR(){
            return ir;
        }
    }

    public static class percentageMAP{
        private List<Double> pmap = new ArrayList();
        public void addPMAP(double initmap, double finalmap){
            double i = (finalmap-initmap)/initmap;
            pmap.add(i*100);
        }
        public List<Double> wantPMAP(){return pmap;}
    }
    public static class percentageHR{
        private List<Double> phr = new ArrayList();
        public void addPHR(double inithr, double finalhr){
            double i = (finalhr-inithr)/inithr;
            phr.add(i*100);
        }
        public List<Double> wantPHR(){return phr;}
    }

    /*public static void main(String[] args){
        getSBP ta = new getSBP();
        for (int i = 0; i <13; i++) {
            ta.addSBP(i);
        }
        System.out.println(ta.wantSBP());
        ta.wantSBP();

        getDBP tb = new getDBP();
        for (int i = 2; i <15; i++) {
            tb.addDBP(i);
        }
        System.out.println(tb.wantDBP());
        tb.wantDBP();

        getMAP ti = new getMAP();
        for (int i = 0; i<13; i++) {
            ti.addMAP(163+i,85+i);
        }
        System.out.println(ti.wantMAP());
        ti.wantMAP();

        getHR tc = new getHR();
        for (int i = 5; i <18; i++) {
            tc.addHR(i);
        }
        System.out.println(tc.wantHR());
        tc.wantHR();

        getIR tr = new getIR();
        for (int i = 0; i < 13; i++){
            String number = "1";
            int num = Integer.parseInt(number);
            tr.addIR(num);
        }
        System.out.println(tr.wantIR());
        tr.wantIR();
    }*/
    public static void main(String[] args) {
        System.out.println(EnterFragment.s.wantSBP());
        System.out.println(EnterFragment.d.wantDBP());
        System.out.println(EnterFragment.h.wantHR());
        System.out.println(EnterFragment.i.wantIR());
        System.out.println(EnterFragment.m.wantMAP());

    }

}
