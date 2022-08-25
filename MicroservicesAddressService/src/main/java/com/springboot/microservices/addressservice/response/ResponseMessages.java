package com.springboot.microservices.addressservice.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseMessages<T>
{
    private Messages messages = new Messages();
    private HeaderMessages headerMessages = new HeaderMessages();
    private T data;

    public ResponseMessages()
    {}

    public ResponseMessages(Messages messages,T data)
    {
        this.messages = messages;
        this.data = data;
    }

    public ResponseMessages(HeaderMessages headerMessages,T data)
    {
        this.headerMessages = headerMessages;
        this.data = data;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

    public HeaderMessages getHeaderMessages() {
        if(null == headerMessages)
        {
            headerMessages = new HeaderMessages();
        }
        return headerMessages;
    }

    public void setHeaderMessages(HeaderMessages headerMessages) {
        this.headerMessages = headerMessages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void addMessages(String message)
    {
        if(null == messages)
        {
            messages = new Messages();
        }
        messages.addMessages(message);
    }

    public void addWarnings(String warning)
    {
        if(null == messages)
        {
            messages = new Messages();
        }
        messages.addWarnings(warning);
    }

    public void addError(String error)
    {
        if(null == messages)
        {
            messages = new Messages();
        }
        messages.addError(error);
    }

    public void merge(Messages mergeMe)
    {
        if(null == mergeMe)
        {
            return;
        }

        mergeMe.getMessages().forEach(this::addMessages);
        mergeMe.getWarnings().forEach(this::addWarnings);
        mergeMe.getErrors().forEach(this::addError);
    }

    public void addMessages(HeaderMessage message)
    {
        if(null == headerMessages)
        {
            headerMessages = new HeaderMessages();
        }
        headerMessages.addMessages(message);
    }

    public void addWarnings(HeaderMessage warning)
    {
        if(null == headerMessages)
        {
            headerMessages = new HeaderMessages();
        }
        headerMessages.addWarnings(warning);
    }

    public void addError(HeaderMessage error)
    {
        if(null == headerMessages)
        {
            headerMessages = new HeaderMessages();
        }
        headerMessages.addError(error);
    }

    public void merge(HeaderMessages mergeMe)
    {
        if(null == mergeMe)
        {
            return;
        }

        mergeMe.getMessages().forEach(this::addMessages);
        mergeMe.getWarnings().forEach(this::addWarnings);
        mergeMe.getErrors().forEach(this::addError);
    }
}
