package com.example.MeTruyen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
    private RecyclerView rcvStory;
    private StoryAdapter storyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rcvStory = findViewById(R.id.rcv_story);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvStory.setLayoutManager(linearLayoutManager);

        storyAdapter = new StoryAdapter(getListStory());
        rcvStory.setAdapter(storyAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvStory.addItemDecoration(itemDecoration);
    }

    private List<Story> getListStory() {
        List<Story> list = new ArrayList<Story>();
        list.add(new Story("RUNAWAY", R.drawable.pic1));
        list.add(new Story("DRAGONBALL", R.drawable.pic2));
        list.add(new Story("Bí ẩn của đảo lớn", R.drawable.pic3));
        list.add(new Story("ROne Piece", R.drawable.pic4));
        list.add(new Story("Conan", R.drawable.pic5));
        list.add(new Story("RReign of the Superman", R.drawable.pic6));
        list.add(new Story("Ngược dòng thời gian", R.drawable.pic7));
        list.add(new Story("Huyết sắc", R.drawable.pic8));
        list.add(new Story("Kì Án Ánh Trăng", R.drawable.pic9));
        return list;
    }

}