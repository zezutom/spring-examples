package org.zezutom.springseries0114.part04.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zezutom.springseries0114.part04.model.Message;
import org.zezutom.springseries0114.part04.model.MessageBuilder;

@Component
@RequestMapping("/component/message")
public class ComponentController {

    @Autowired
    private MessageBuilder messageBuilder;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Message message() {
        return messageBuilder.getInstance("Component", "greetings from a component!");
    }

}
