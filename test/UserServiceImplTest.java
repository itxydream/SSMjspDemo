import com.ssm.domain.Goods;
import com.ssm.service.impl.GoodsServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/12/21.
 */
public class UserServiceImplTest {
    @Test
    public void login() {
        ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DeptService deptService = (DeptService) act.getBean("deptServiceImpl");
//        List<Dept> deptsByCondition = deptService.findDeptsByCondition(null);
//        System.out.println(deptsByCondition.size());

        GoodsServiceImpl goodsServiceImpl = (GoodsServiceImpl) act.getBean("goodsServiceImpl");
        List<Goods> all = goodsServiceImpl.findAll();
        System.out.println(all);
    }
}
