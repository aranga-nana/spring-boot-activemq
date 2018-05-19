package com.acnonline.amq.web;

import com.acnonline.amq.service.AccountCodeRetriver;
import com.acnonline.amq.service.AccountProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import javax.jms.Queue;

@RestController
@RequestMapping("/account")
public class AccountController
{

    @Value("${app.reload.time}")
    private long appRelaodTime;

    @Autowired
    private AccountCodeRetriver retriver;

    @Autowired
    private AccountProcessor processor;

    @GetMapping({"","/"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String trigger()
    {
        process(10);
        return "OK";
    }
    @GetMapping({"/{pages}","/{pages}/"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public String simulate(@PathVariable("pages") int pages )
    {
        process(pages);
        return "OK";
    }
    @GetMapping({"/hello","/hello/"})
    public  Info greet()
    {
        return new Info(appRelaodTime);
    }
    private void process(int size)
    {
        for(int i=0;i < size;i++)
        {
            List<String> result =retriver.selectAllAccount(i,200);
            System.out.println(result);
            result.stream().forEach(s->processor.submit(s));
        }

    }

}
