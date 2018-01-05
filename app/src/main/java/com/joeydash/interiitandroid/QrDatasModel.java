package com.joeydash.interiitandroid;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class QrDatasModel {
    public static class QrDetails {
        private int ID;
        private String qrDetails;

        public QrDetails(int ID, String qrDetails) {
            this.ID = ID;
            this.qrDetails = qrDetails;
        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getQrDetails() {
            return qrDetails;
        }

        public void setQrDetails(String qrDetails) {
            this.qrDetails = qrDetails;
        }
    }
    private ArrayList<QrDetails> QrDetailList;

    public ArrayList<QrDetails> getQrDetailList() {
        return QrDetailList;
    }

    public void setQrDetailList(ArrayList<QrDetails> qrDetailList) {
        QrDetailList = qrDetailList;
    }

    public QrDatasModel(ArrayList<QrDetails> qrDetailList) {

        QrDetailList = qrDetailList;
    }
}
