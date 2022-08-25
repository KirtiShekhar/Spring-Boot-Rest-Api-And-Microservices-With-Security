package com.springboot.microservices.addressservice.response;

import java.util.ArrayList;
import java.util.List;

public class HeaderMessages
{
    private List<HeaderMessage> messageList = new ArrayList<>();
    private List<HeaderMessage> warnings = new ArrayList<>();
    private List<HeaderMessage> errors = new ArrayList<>();

    public List<HeaderMessage> getMessages() {
        if(null == messageList)
        {
            return new ArrayList<>();
        }
        return messageList;
    }

    public void setMessageList(List<HeaderMessage> messages) {
        this.messageList = messages;
    }

    public List<HeaderMessage> getWarnings() {
        if(null == warnings)
        {
            return new ArrayList<>();
        }
        return warnings;
    }

    public void setWarnings(List<HeaderMessage> warnings) {
        this.warnings = warnings;
    }

    public List<HeaderMessage> getErrors() {
        if(null == errors)
        {
            return new ArrayList<>();
        }
        return errors;
    }

    public void setErrors(List<HeaderMessage> errors) {
        this.errors = errors;
    }

    public void addMessages(HeaderMessage message)
    {
        if(null == messageList)
        {
            messageList = new ArrayList<>();
        }
        messageList.add(message);
    }

    public void addWarnings(HeaderMessage warning)
    {
        if(null == warnings)
        {
            warnings = new ArrayList<>();
        }
        warnings.add(warning);
    }

    public void addError(HeaderMessage error)
    {
        if(null == errors)
        {
            errors = new ArrayList<>();
        }
        errors.add(error);
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
