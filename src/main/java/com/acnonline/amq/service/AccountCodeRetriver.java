package com.acnonline.amq.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountCodeRetriver {
    public List<String> selectAllAccount(int startIndex,int pageSize)
    {
        List<String> codes = new ArrayList<>(pageSize);
        for(int i=0;i<= pageSize;i++)
        {
            codes.add("A0X"+startIndex+"-"+i);
        }
        return codes;
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
