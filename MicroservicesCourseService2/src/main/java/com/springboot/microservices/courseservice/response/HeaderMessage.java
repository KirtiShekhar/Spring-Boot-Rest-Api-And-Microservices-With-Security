package com.springboot.microservices.courseservice.response;

public class HeaderMessage
{
    private String header;
    private String text;

    public HeaderMessage(){}

    public HeaderMessage(String header, String text) {
        this.header = header;
        this.text = text;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
