package com.testssm.event;


import com.testssm.exception.SystemConfigurationException;

public class HandlerNotFoundException extends SystemConfigurationException {
    public HandlerNotFoundException(String message) {
        super(message);
    }
}
