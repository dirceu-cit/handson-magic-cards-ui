package magiccards.services.impl;

import magiccards.services.SpringBootMagicTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExpansionServiceImpl.class)
public class ExpansionServiceImplTest extends SpringBootMagicTest {

    @Autowired
    private ExpansionServiceImpl service;

    @Test
    public void getFormatedDataFromString() {
        Long date = new Long("1546308000000");//2019/01/01 in millisec
        String result =  service.getFormatedDateString(date);

        Assert.assertEquals("2019-01-01", result);

    }
}