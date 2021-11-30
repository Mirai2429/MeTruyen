package com.example.MeTruyen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder>{
    private List<Story> mListStory;

    public StoryAdapter(List<Story> mListStory) {
        this.mListStory = mListStory;
    }

    @NonNull
    @Override
    public StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_story, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull StoryViewHolder holder, int position) {
        Story story = mListStory.get(position);
        if(story == null){
            return;
        }
        holder.StoryPic.setImageResource(story.getStoryPic());
        holder.NameStory.setText(story.getNameStory());
    }

    @Override
    public int getItemCount() {
        if(mListStory != null){
            return mListStory.size();
        }
        return 0;
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{
        private ImageView StoryPic;
        private TextView NameStory;
        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            StoryPic = itemView.findViewById(R.id.Truyen1);
            NameStory = itemView.findViewById(R.id.TenTruyen1);
        }
    }
}
