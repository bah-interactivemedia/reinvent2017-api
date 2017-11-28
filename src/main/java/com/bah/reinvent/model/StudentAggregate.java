package com.bah.reinvent.model;

import java.util.List;

public class StudentAggregate {

   private List<StudentAttrib> attributeHistory;
   private int bmiAvg;
   private int bodyfatCalcAvg;
   private int weightAvg;
   private int heightFeetAvg;
   private int heightInchesAvg;
   private int calfSkinfoldAvg;
   private int tricepSkinfoldAvg;

    public StudentAggregate(List<StudentAttrib> attributeHistory, int bmiAvg, int bodyfatCalcAvg, int weightAvg, int heightFeetAvg, int heightInchesAvg, int calfSkinfoldAvg, int tricepSkinfoldAvg) {
        this.attributeHistory = attributeHistory;
        this.bmiAvg = bmiAvg;
        this.bodyfatCalcAvg = bodyfatCalcAvg;
        this.weightAvg = weightAvg;
        this.heightFeetAvg = heightFeetAvg;
        this.heightInchesAvg = heightInchesAvg;
        this.calfSkinfoldAvg = calfSkinfoldAvg;
        this.tricepSkinfoldAvg = tricepSkinfoldAvg;
    }

    public List<StudentAttrib> getAttributeHistory() {
        return attributeHistory;
    }

    public void setAttributeHistory(List<StudentAttrib> attributeHistory) {
        this.attributeHistory = attributeHistory;
    }

    public int getBmiAvg() {
        return bmiAvg;
    }

    public void setBmiAvg(int bmiAvg) {
        this.bmiAvg = bmiAvg;
    }

    public int getBodyfatCalcAvg() {
        return bodyfatCalcAvg;
    }

    public void setBodyfatCalcAvg(int bodyfatCalcAvg) {
        this.bodyfatCalcAvg = bodyfatCalcAvg;
    }

    public int getWeightAvg() {
        return weightAvg;
    }

    public void setWeightAvg(int weightAvg) {
        this.weightAvg = weightAvg;
    }

    public int getHeightFeetAvg() {
        return heightFeetAvg;
    }

    public void setHeightFeetAvg(int heightFeetAvg) {
        this.heightFeetAvg = heightFeetAvg;
    }

    public int getHeightInchesAvg() {
        return heightInchesAvg;
    }

    public void setHeightInchesAvg(int heightInchesAvg) {
        this.heightInchesAvg = heightInchesAvg;
    }

    public int getCalfSkinfoldAvg() {
        return calfSkinfoldAvg;
    }

    public void setCalfSkinfoldAvg(int calfSkinfoldAvg) {
        this.calfSkinfoldAvg = calfSkinfoldAvg;
    }

    public int getTricepSkinfoldAvg() {
        return tricepSkinfoldAvg;
    }

    public void setTricepSkinfoldAvg(int tricepSkinfoldAvg) {
        this.tricepSkinfoldAvg = tricepSkinfoldAvg;
    }
}
