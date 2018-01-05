package com.joeydash.interiitandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by joeydash on 5/1/18.
 */

public class QrListAdapter extends RecyclerView.Adapter<QrListAdapter.ViewHolder> {
    private Context context;
    private QrDatasModel qrDatasModel;

    public QrListAdapter(Context context, QrDatasModel qrDatasModel) {
        this.context = context;
        this.qrDatasModel = qrDatasModel;
    }

    @Override
    public QrListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.activity_home,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(QrListAdapter.ViewHolder holder, int position) {
        holder.tv_qr_detail.setText(qrDatasModel.getQrDetailList().get(position).getQrDetails());
    }

    @Override
    public int getItemCount() {
        return qrDatasModel.getQrDetailList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView tv_qr_detail;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_qr_detail = itemView.findViewById(R.id.tv_qr_detail);
        }
    }
}
