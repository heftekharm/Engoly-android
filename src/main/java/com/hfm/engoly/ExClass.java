package com.hfm.engoly;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Hosein on 10/13/2016.
 */
public class ExClass implements Serializable {
    private String name;
    private ArrayList<Integer> numbers;
    public ExClass(String n,Integer... nums){
        name=n;
        numbers=new ArrayList<Integer>();
        for(int j=0;j<nums.length;j++){
            numbers.add(nums[j]);
        }
    }
}
