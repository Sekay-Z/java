package cn.shukai.Service;

import cn.shukai.Dao.Dao;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class See implements S{
    private Dao d;

    public void setD(Dao d) {
        this.d = d;
    }

    public Dao getD() {
        return d;
    }

    @Override
    @Transactional(isolation=Isolation.DEFAULT,propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String from, String to, Integer money) {
        d.add(to,money);
        d.decrease(from,money);
    }
}
