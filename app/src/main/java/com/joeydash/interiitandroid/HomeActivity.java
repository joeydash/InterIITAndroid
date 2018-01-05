package com.joeydash.interiitandroid;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private RecyclerView rv_home;
    private Dbhelper dbhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        rv_home = findViewById(R.id.rv_home);
        dbhelper = new Dbhelper(this);
        renderHome();
    }

    private void renderHome() {
        QrDatasModel qrDatasModel = getQrFromDatabase();
        QrListAdapter qrListAdapter = new QrListAdapter(getBaseContext(), qrDatasModel);
        rv_home.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rv_home.setItemAnimator(new DefaultItemAnimator());
        rv_home.setAdapter(qrListAdapter);
    }

    public QrDatasModel getQrFromDatabase() {
        Cursor result = dbhelper.getAllData();
        QrDatasModel.QrDetails qrDetails;
        qrDetails = new QrDatasModel.QrDetails(1,"No Qr Scanned!");
        ArrayList<QrDatasModel.QrDetails> arrayList = new ArrayList<>();
        if (result.getCount()==0){
            arrayList.add(qrDetails);
        }else{
            while (result.moveToNext()){
                qrDetails.setID(Integer.parseInt(result.getString(0)));
                qrDetails.setQrDetails(result.getString(1));
                arrayList.add(qrDetails);
            }
        }
        return new QrDatasModel(arrayList);
    }

    public void openScan(View view) {
        Intent cameraActivity = new Intent(HomeActivity.this, CameraActivity.class);
        startActivity(cameraActivity);
    }

    public void clearDatas(View view) {
        dbhelper.deleteAll();
    }
}
