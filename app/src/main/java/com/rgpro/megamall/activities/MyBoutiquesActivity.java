package com.rgpro.megamall.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.rgpro.megamall.R;
import com.rgpro.megamall.contracts.MyBoutiquesContract;
import com.rgpro.megamall.contracts.MyBoutiquesContract.MyBouttiquesViewItf;
import com.rgpro.megamall.models.MyboutiquesRecyclerViewCustomAdapter;
import com.rgpro.megamall.presenters.MyBoutiquesPresenterImpl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MyBoutiquesActivity extends AppCompatActivity implements MyBouttiquesViewItf {

    private RecyclerView mRecyclerView ;
    private  MyboutiquesRecyclerViewCustomAdapter mAdapter;
    private MyBoutiquesContract.MyBoutiquesPresenterItf mPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_boutiques);
        Toolbar toolbar = findViewById(R.id.myboutiquestoolbar);
        setSupportActionBar(toolbar);
        mRecyclerView =findViewById(R.id.myboutiquesrecyclerview);
        mAdapter = new MyboutiquesRecyclerViewCustomAdapter(null);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);

        ImageView addboutique = findViewById(R.id.addnewboutiquebutton);
        addboutique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),AddEditBoutiqueActivity.class);
                startActivity(intent);
            }
        });
        mPresenter = new MyBoutiquesPresenterImpl(this);
        mPresenter.getMyBoutiquesList();
    }

    @Override
    public void showBoutiquesList(Bundle[] boutiques) {
        if(boutiques!=null) {
            mAdapter.setDataSet(boutiques);
            mAdapter.notifyDataSetChanged();
            Toast.makeText(this,String.valueOf(boutiques.length),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this,"No Boutiques",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void showEditBoutiqueActivity(String boutiqueid) {

        Intent intent = new Intent("android.intent.action.AddEditBoutique");
        intent.putExtra("boutiqueid",boutiqueid);
        startActivityForResult(intent,0);
    }

    @Override
    public void dealWithIt(Bundle input) {
        //nothing here
    }

    @Override
    public void dealWithIt(Object input) {
        this.showBoutiquesList((Bundle[]) input);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            mPresenter.getMyBoutiquesList();
        }else if(resultCode==1){
            mPresenter.getMyBoutiquesList();
        }
    }
}
