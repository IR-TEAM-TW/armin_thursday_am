package edu.ws2024.armin.online_project.data;

public class HomeData {
    private String name;
    private int image;

    public HomeData(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public HomeData() {
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }
}
