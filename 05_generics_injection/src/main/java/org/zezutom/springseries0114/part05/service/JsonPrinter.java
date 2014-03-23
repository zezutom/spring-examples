package org.zezutom.springseries0114.part05.service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPrinter extends Printer {

    @Override
    protected ObjectMapper getMapper() {
        return new ObjectMapper();
    }
}
