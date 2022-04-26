package com.example.taskroadcast;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private ArrayList<entries> android;

    public DataAdapter(ArrayList<entries> android) {
        this.android = android;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {

        viewHolder.api_name.setText(android.get(i).getAPI());
        viewHolder.description.setText(android.get(i).getDescription());
        viewHolder.auth.setText(android.get(i).getAuth());
        viewHolder.https.setText(android.get(i).getHttp());
        viewHolder.cors.setText(android.get(i).getCors());
        viewHolder.link.setText(android.get(i).getLink());
        viewHolder.category.setText(android.get(i).getCategory());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView api_name, description, auth, https, cors, link, category;
        public ViewHolder(View view) {
            super(view);

            api_name = (TextView)view.findViewById(R.id.api_name);
            description = (TextView)view.findViewById(R.id.description);
            auth = (TextView)view.findViewById(R.id.auth);
            https = (TextView)view.findViewById(R.id.https);
            cors = (TextView)view.findViewById(R.id.cors);
            link = (TextView)view.findViewById(R.id.link);
            category = (TextView)view.findViewById(R.id.category);

        }
    }

}