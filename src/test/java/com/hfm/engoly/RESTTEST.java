package com.hfm.engoly;

import org.junit.Test;
import org.junit.Assert;
/**
 * Created by Hosein on 9/30/2016.
 */
public class RESTTEST {
    @Test
    public void REST_requestingJson_returnsString(){
        String name="We Seem to Have a Bad Connection";
        String jsonInString =REST.GetJsonAsStringFromServer(name);
        Assert.assertEquals("first character of a json is {  ",'{',jsonInString.charAt(0));

    };
}
