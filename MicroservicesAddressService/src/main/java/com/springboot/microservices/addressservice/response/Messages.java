package com.springboot.microservices.addressservice.response;

import java.util.ArrayList;
import java.util.List;


public class Messages
{
    private List<String> messageList = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();
    private List<String> errors = new ArrayList<>();

    public List<String> getMessages() {
        if(null == messageList)
        {
            return new ArrayList<>();
        }
        return messageList;
    }

    public void setMessageList(List<String> messages) {
        this.messageList = messages;
    }

    public List<String> getWarnings() {
        if(null == warnings)
        {
            return new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<String> getErrors() {
        if(null == errors)
        {
            return new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public void addMessages(String message)
    {
        if(null == messageList)
        {
            messageList = new ArrayList<>();
        }
        messageList.add(message);
    }

    public void addWarnings(String warning)
    {
        if(null == warnings)
        {
            warnings = new ArrayList<>();
        }
        warnings.add(warning);
    }

    public void addError(String error)
    {
        if(null == errors)
        {
            errors = new ArrayList<>();
        }
        errors.add(error);
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
}
