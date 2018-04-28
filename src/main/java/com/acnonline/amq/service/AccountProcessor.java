package com.acnonline.amq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class AccountProcessor {

    private Executor executor = Executors.newFixedThreadPool(20);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public boolean submit(String accCode)
    {
        Runnable r = ()->{
            long i = System.currentTimeMillis();
            jmsMessagingTemplate.convertAndSend(queue,accCode);
            System.out.println("Acc:"+accCode+" took "+(System.currentTimeMillis()-i)+" ms.");

        };
        executor.execute(r);
        return true;
    }

}
