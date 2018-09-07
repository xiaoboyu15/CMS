package com.example.tengj.cmss.Gson;

public class Contents {
    private int conId;
    private String title;
    private String tags;
    private String source;
    private String auto;
    private String editor;
    private String keywords;
    private String ImageAddress;
    private String text;

    public void setAuto(String auto) {
        this.auto = auto;
    }

    public void setConId(int conId) {
        this.conId = conId;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public void setImageAddress(String imageAddress) {
        ImageAddress = imageAddress;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getConId() {
        return conId;
    }

    public String getAuto() {
        return auto;
    }

    public String getEditor() {
        return editor;
    }

    public String getImageAddress() {
        return ImageAddress;
    }

    public String getKeywords() {
        return keywords;
    }

    public String getSource() {
        return source;
    }

    public String getTags() {
        return tags;
    }

    public String getText() {
        return text;
    }

    public String getTitle() {
        return title;
    }
    
}
