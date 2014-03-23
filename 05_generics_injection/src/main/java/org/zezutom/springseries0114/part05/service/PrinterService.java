package org.zezutom.springseries0114.part05.service;

import org.zezutom.springseries0114.part05.model.Person;

public class PrinterService<T extends Printer> {

    private T printer;

    public PrinterService(T printer) {
        this.printer = printer;
    }

    public<E extends Object> String print(E entity) {
        return printer.print(entity);
    }
}
