import base.BaseTest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.went.core.entity.BusinessInfo;
import com.went.core.mapper.BusinessMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26.
 */

public class BusinessTest extends BaseTest{

    @Autowired
    BusinessMapper businessMapper;

    @Test
    public void test() {
        PageHelper.startPage(2,5);
        List<BusinessInfo> select = businessMapper.selectAll();
        PageInfo pageInfo = new PageInfo(select);
        pageInfo.getTotal();
        System.out.println(select);
    }


}
