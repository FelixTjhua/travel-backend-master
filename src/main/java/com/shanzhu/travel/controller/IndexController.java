package com.shanzhu.travel.controller;


import net.jntoo.db.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 首页 控制层
 *
 * @author: ShanZhu
 * @date: 2024-01-26
 */
@Controller
public class IndexController extends BaseController {

    // 首页
    @RequestMapping(value = {"/", "index"})
    public String Index() {
        ArrayList<HashMap> bhtList = Query.make("lunbotu").order("id desc").limit(5).select();
        assign("bhtList", bhtList);

        ArrayList<HashMap> jingdianxinxilist1 = Query.make("jingdianxinxi").limit(4).order("liulanliang desc").select();
        assign("jingdianxinxilist1", jingdianxinxilist1);

        ArrayList<HashMap> difangmeishilist2 = Query.make("difangmeishi").limit(4).order("id desc").select();
        assign("difangmeishilist2", difangmeishilist2);

        ArrayList<HashMap> difangyanchulist3 = Query.make("difangyanchu").limit(4).order("id desc").select();
        assign("difangyanchulist3", difangyanchulist3);

        ArrayList<HashMap> lvyouxianlulist4 = Query.make("lvyouxianlu").limit(4).order("id desc").select();
        assign("lvyouxianlulist4", lvyouxianlulist4);

        ArrayList<HashMap> xinwenxinxilist5 = Query.make("xinwenxinxi").limit(4).order("id desc").select();
        assign("xinwenxinxilist5", xinwenxinxilist5);

        ArrayList<HashMap> jiudianxinxilist6 = Query.make("jiudianxinxi").limit(4).order("id desc").select();
        assign("jiudianxinxilist6", jiudianxinxilist6);
        if (isAjax()) {
            return json();
        }
        return "index";
    }


}
