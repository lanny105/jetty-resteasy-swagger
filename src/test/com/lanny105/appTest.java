package com.lanny105;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.UriInfo;

/**
 * Created by apple on 2017/6/24.
 */
public class appTest {
    public app myapp;



    @Test
    public void TestgetPara400() {

        myapp = new app();

        Assert.assertEquals(400, myapp.getPara(null).getStatus());
    }

    @Test
    public void TestgetPara200() {

        myapp = new app();
        Assert.assertEquals(200, myapp.getPara("ABCD").getStatus());
        Assert.assertEquals("{\"response\":\"Hello World ABCD\"}", myapp.getPara("ABCD").getEntity().toString());
    }

}
