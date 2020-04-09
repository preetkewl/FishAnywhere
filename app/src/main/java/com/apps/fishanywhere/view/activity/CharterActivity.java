package com.apps.fishanywhere.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.fishanywhere.R;
import com.apps.fishanywhere.model.Callbacks.GetCharterIDsCallback;
import com.apps.fishanywhere.view.adapter.CharterListAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CharterActivity extends AppCompatActivity {
    @BindView(R.id.tv_charter)
    TextView tvCharter;
    @BindView(R.id.rv_charter)
    RecyclerView rvCharter;
    private Context context;
    ArrayList<GetCharterIDsCallback> data= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charter);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        context = this;
        Intent intent=getIntent();
        if(intent!=null){
            data= (ArrayList<GetCharterIDsCallback>) intent.getSerializableExtra("charterlsit");
            setdata();
        }

    }

    private void setdata() {
        rvCharter.setAdapter(new CharterListAdapter(context,data));
        rvCharter.setLayoutManager(new LinearLayoutManager(context));
    }
}
