package com.went.core.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.went.core.constants.BaseConstants;
import com.went.core.constants.Message;
import com.went.core.constants.UrlConstants;
import com.went.core.entity.BusinessInfo;
import com.went.core.erabatis.center.SqlSegment;
import com.went.core.erabatis.mapper.UsuallyMapper;
import com.went.core.service.BusinessService;
import com.went.core.utils.PageResult;
import com.went.core.utils.PlatResult;
import com.went.core.utils.ServerResult;
import com.went.core.utils.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/9.
 */
@RestController
@RequestMapping(UrlConstants.URL_PREFIX + "/business")
public class BusinessController {

  @RequestMapping("/queryAll")
  public PlatResult selectAll(@RequestParam Map<String, Object> param) {
    UsuallyMapper usuallyMapper = SpringContextHolder.getBean("usuallyMapper");
    List<SqlSegment> list = new LinkedList<>();
    SqlSegment select = new SqlSegment("select");
    SqlSegment code = new SqlSegment("code");
    SqlSegment segment = new SqlSegment(",");
    SqlSegment name = new SqlSegment("name");
    SqlSegment S__ = new SqlSegment(",");
    SqlSegment desc = new SqlSegment("'desc'");
    SqlSegment __ = new SqlSegment(",");
    SqlSegment createUser = new SqlSegment("create_user");
    SqlSegment from = new SqlSegment("from");
    SqlSegment t_business = new SqlSegment("era.t_business");
    SqlSegment ORDER_BY = new SqlSegment("order by");
    SqlSegment code1 = new SqlSegment("code");
    SqlSegment DESC = new SqlSegment("desc");
    list.add(select);
    list.add(code);
    list.add(segment);
    list.add(name);
    list.add(S__);
    list.add(desc);
    list.add(__);
    list.add(createUser);
    list.add(from);
    list.add(t_business);
    list.add(ORDER_BY);
    list.add(code1);
    list.add(DESC);
    List<Map<String, Object>> maps = usuallyMapper.plainSelect(list);
    String pageNum = param.get("pageNum").toString();
    String pageSize = param.get("pageSize").toString();
    int pan = Integer.valueOf(pageNum);
    int pas = Integer.valueOf(pageSize);
    PageHelper.startPage(pan, pas);

    PageInfo pageInfo = new PageInfo<>(maps);
    PageResult pageResult = new PageResult<>(pageInfo.getTotal(), pan, pas, maps);

    ServerResult serverResult = new ServerResult<>(pageResult, BaseConstants.STATUS_SUCCESS, Message.QUERY_SUCCESS);
    return PlatResult.success(serverResult);
  }
}
