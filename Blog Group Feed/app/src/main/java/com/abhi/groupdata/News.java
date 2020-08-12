package com.abhi.groupdata;

public class News {
    private String title, matter;
    private int imageId;

    public News() {
    }

    public News(Integer imageId,String title, String matter) {
        this.imageId=imageId;
        this.title = title;
        this.matter = matter;
        }
    public int getImageId(){
        return imageId;
    }
    public void setImageId(int imageId){
        this.imageId=imageId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getMatter() {
        return matter;
    }
    public void setMatter(String matter) {
        this.matter = matter;
    }
}

