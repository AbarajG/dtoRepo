package com.andygomez.dto.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Objects;

@Component
public class MessageUtil {

    private MessageSource messageSource;

    @Autowired
    public MessageUtil(MessageSource messageSource){
        this.messageSource = messageSource;
    }

    public MessageSource getMessageSource(){
        return messageSource;
    }

    public String getMessage(String message, Objects[] obj, Locale locale){
        return getMessageSource().getMessage(message, obj, locale);
    }

}
