package org.zezutom.springseries0114.part05.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;

public abstract class Printer {

    private static final Logger logger = Logger.getLogger(Printer.class);

    protected abstract ObjectMapper getMapper();

    public <T extends Object> String print(T object) {
        String result = null;
        try {
            result = getMapper().writeValueAsString(object);
        } catch (IOException e) {
            logger.error("The value couldn't be serialized", e);
        } finally {
            return result;
        }

    }
}
