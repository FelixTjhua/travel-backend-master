package com.shanzhu.travel.controller;

import com.shanzhu.travel.common.CommDAO;
import com.shanzhu.travel.util.Request;
import net.jntoo.db.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: Payment2Controller
 * @Package com.shanzhu.travel.controller
 * @Description: 酒店预定支付控制器
 * @date 2024/7/6 9:09
 */

@Controller
public class Payment2Controller extends BaseController {

    /**
     * 处理支付
     *
     * @return String
     */
    @RequestMapping("/payment2")
    public String payment() {
        String id, biao;
        if (request.getParameter("out_trade_no") != null) {
            String[] out_trade_no = request.getParameter("out_trade_no").split("\\-");
            id = out_trade_no[2];
            biao = out_trade_no[1];
        } else {
            id = request.getParameter("id");
            biao = request.getParameter("biao");
        }

        String sql = "update " + biao + " set iszf='是' where id='" + id + "'";
        new CommDAO().commOper(sql);
        HashMap order = Query.make(biao).find(id);

        if ("yuding2".equals(biao)) {
            Query.execute("update yuding2 set zhuangtai='预定成功' where id='" + order.get("id") + "'");
        }

        String referer = Request.get("referer").equals("") ? "sy.do" : Request.get("referer");
        return showSuccess("支付成功", referer);
    }
}
