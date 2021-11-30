package com.example.MeTruyen;

public class Story {
    private String NameStory;
    private int StoryPic;

    public Story(String nameStory, int storyPic) {
        NameStory = nameStory;
        StoryPic = storyPic;
    }

    public String getNameStory() {
        return NameStory;
    }

    public int getStoryPic() {
        return StoryPic;
    }

    public void setNameStory(String nameStory) {
        NameStory = nameStory;
    }

    public void setStoryPic(int storyPic) {
        StoryPic = storyPic;
    }
}

