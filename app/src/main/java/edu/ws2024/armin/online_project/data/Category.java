package edu.ws2024.armin.online_project.data;

public class Category {
    private String title;
    private int id;
    private boolean selected = false;

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public Category(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
