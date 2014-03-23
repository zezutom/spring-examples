package org.zezutom.springseries0114.part05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zezutom.springseries0114.part05.conf.AppConfig;
import org.zezutom.springseries0114.part05.model.Person;
import org.zezutom.springseries0114.part05.service.JsonPrinter;
import org.zezutom.springseries0114.part05.service.PrinterService;
import org.zezutom.springseries0114.part05.service.XmlPrinter;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class PrinterServiceTests {

    @Autowired
    private PrinterService<JsonPrinter> jsonService;

    @Autowired
    private PrinterService<XmlPrinter> xmlService;

    @Test
    public void printAsJson() {
        assertEquals("{\"firstName\":\"John\"," +
                        "\"lastName\":\"Doe\",\"age\":25}",
                        jsonService.print(new Person("John", "Doe", 25)));
    }

    @Test
    public void printAsXml() {
        assertEquals("<Person xmlns=\"\"><firstName>John</firstName>" +
                        "<lastName>Doe</lastName><age>25</age></Person>",
                        xmlService.print(new Person("John", "Doe", 25)));
    }

}
