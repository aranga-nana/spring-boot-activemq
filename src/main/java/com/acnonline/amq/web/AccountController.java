package com.acnonline.amq.web;

import com.acnonline.amq.service.AccountCodeRetriver;
import com.acnonline.amq.service.AccountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import javax.jms.Queue;

@RestController
@RequestMapping("/account")
public class AccountController
{


    @Autowired
    private AccountCodeRetriver retriver;

    @Autowired
    private AccountProcessor processor;

    @GetMapping({"","/"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String trigger()
    {

        for(int i=0;i < 200;i++)
        {
            List<String> result =retriver.selectAllAccount(i,200);
            result.stream().forEach(s->processor.submit(s));
        }
        return "OK";
    }

}
