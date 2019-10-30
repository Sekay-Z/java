package cn.shukai;

import cn.shukai.Service.See;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml")
public class demo {
    @Autowired
    private See ss;
    @Test
    public void fun(){
        ss.transfer("树凯","郭太",200);
    }
}
