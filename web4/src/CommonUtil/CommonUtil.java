package CommonUtil;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class CommonUtil {
    public static <T> T toBean(Map map, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        T bean = (T) clazz.newInstance();
        try {
            BeanUtils.populate(bean,map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
