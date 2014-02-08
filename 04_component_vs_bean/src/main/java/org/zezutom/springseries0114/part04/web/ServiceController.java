package org.zezutom.springseries0114.part04.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zezutom.springseries0114.part04.model.Message;
import org.zezutom.springseries0114.part04.model.MessageBuilder;

@Service
@RequestMapping("/service/message")
public class ServiceController {

    @Autowired
    private MessageBuilder messageBuilder;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Message message() {
        return messageBuilder.getInstance("Service", "At your service!");
    }

}
