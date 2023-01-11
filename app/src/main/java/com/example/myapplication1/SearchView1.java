package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

public class SearchView1 extends AppCompatActivity {

    private SearchView pencarian1;
    private RecyclerView pencarian2;
    ArrayList<ModelClass> arrayList=new ArrayList<>();
    ArrayList<ModelClass> searchlist;
    String[] namelist=new String[]{"imam","yahya","didi",
            "cahyo","rafa","sasa"};

    String[] desclist=new String[]{"1","2","3",
            "4","5","6"};

    int[] imglist=new int[]{R.drawable.a,R.drawable.b,R.drawable.c,
            R.drawable.d,R.drawable.e,R.drawable.f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        pencarian1 = (SearchView) findViewById(R.id.btn1);
        pencarian2 = (RecyclerView) findViewById(R.id.btn2);

        for (int i = 0; i < namelist.length; i++){
            ModelClass modelClass= new ModelClass();
            modelClass.setName(namelist[i]);
            modelClass.setDesc(desclist[i]);
            modelClass.setImg(imglist[i]);
            arrayList.add(modelClass);

            RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(SearchView1.this);
            pencarian2.setLayoutManager(layoutManager);

            NameAdapter nameAdapter=new NameAdapter(SearchView1.this,searchlist);
            pencarian2.setAdapter(nameAdapter);

            pencarian1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                     searchlist=new ArrayList<>();

                     if (s.length()>0) {
                         for (int i = 0; i < arrayList.size(); i++) {
                             if (arrayList.get(i).getName().toUpperCase().contains(s.toUpperCase())) {

                                 ModelClass modelClass = new ModelClass();
                                 modelClass.setName(arrayList.get(i).getName());
                                 modelClass.setDesc(arrayList.get(i).getDesc());
                                 modelClass.setImg(arrayList.get(i).getImg());
                                 searchlist.add(modelClass);
                             }
                         }
                         RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchView1.this);
                         pencarian2.setLayoutManager(layoutManager);

                         NameAdapter nameAdapter = new NameAdapter(SearchView1.this, searchlist);
                         pencarian2.setAdapter(nameAdapter);
                     }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    return false;
                }
            });

        }

    }

}