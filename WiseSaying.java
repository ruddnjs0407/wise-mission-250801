package com.back;

public class WiseSaying {
    private int id;
    private String content;
    private String author;

    public WiseSaying(int id, String content, String author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void revisionContent(String content) {
        this.content = content;
    }

    public void revisionAuthor(String author) {
        this.author = author;
    }
    //오버라이딩으로 목록 출력
    @Override
    public String toString() {
        return id + " / " + author + " / " + content;
    }
}
