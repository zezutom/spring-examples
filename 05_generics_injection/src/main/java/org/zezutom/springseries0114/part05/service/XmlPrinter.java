package org.zezutom.springseries0114.part05.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlPrinter extends Printer {

    @Override
    protected ObjectMapper getMapper() {
        return new XmlMapper();
    }
}
