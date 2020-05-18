package com.tarn.tarn_forum.utils.Enum;

public enum PostsEnum {

    KNOWLEDGE_MODULAR("知识问答模块", 1),
    GAME_MODULAR("游戏模块", 2),
    JOURNALISM_MODULAR("新闻模块", 3),
    OTHER_MODULAR("新闻模块",4);

    private String name;
    private int index;

    private PostsEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getIndex() {
        return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
}
