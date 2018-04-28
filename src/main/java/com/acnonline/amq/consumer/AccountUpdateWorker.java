package com.acnonline.amq.consumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AccountUpdateWorker
{
    @JmsListener(destination = "acnonline.worker.queue")
    public void receiveQueue(String text) {

        int num = 300 + (int)(Math.random()*2200);
        sleep(num);
        System.out.println(text+" wait time "+num);
    }
    private void sleep(int i)
    {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
