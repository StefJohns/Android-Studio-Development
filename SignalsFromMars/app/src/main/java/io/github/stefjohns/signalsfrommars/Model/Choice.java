package io.github.stefjohns.signalsfrommars.Model;

public class Choice {
    // Member Variables
    private int textId;
    private int nextPage;

    // Getters and Setters

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }


    // Constructor

    public Choice(int textId, int nextPage) {
        this.textId = textId;
        this.nextPage = nextPage;
    }
}
