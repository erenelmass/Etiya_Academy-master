package com.etiya.ecommercedemopair2.core.util.messages;


import lombok.AllArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessagesManager implements MessagesService {
    private MessageSource messageSource;

    @Override
    public String Messages(String message) {
        return messageSource.getMessage(message,null, LocaleContextHolder.getLocale());
    }
}