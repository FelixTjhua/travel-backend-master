package com.shanzhu.travel.controller;

import com.shanzhu.travel.common.Query;
import com.shanzhu.travel.entity.Jiudianxinxi;
import com.shanzhu.travel.entity.Yuding2;
import com.shanzhu.travel.service.JiudianxinxiService;
import com.shanzhu.travel.service.Yuding2Service;
import com.shanzhu.travel.service.impl.JiudianxinxiServiceImpl;
import com.shanzhu.travel.util.Info;
import com.shanzhu.travel.util.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author wsc
 * @version V1.0
 * Copyright (c) 2024, 2353489264@qq.com All Rights Reserved.
 * @ProjectName:travel-backend
 * @Title: Yuding2Controller
 * @Package com.shanzhu.travel.controller
 * @Description: 酒店预订控制器
 * @date 2024/7/5 21:04
 */

@Controller
public class Yuding2Controller extends BaseController {

    @Resource
    private Yuding2Service yuding2Service;

    @Resource
    private JiudianxinxiServiceImpl jiudianxinxiService;

    /**
     * 后台列表页
     */
    @RequestMapping("/yuding2_list")
    public String list() {

        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据
        Example example = new Example(Yuding2.class); //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();          // 创建一个扩展搜索条件类
        String where = " 1=1 ";   // 创建初始条件为：1=1
        where += getWhere();      // 从方法中获取url 上的参数，并写成 sql条件语句
        criteria.andCondition(where);   // 将条件写进上面的扩展条件类中
        if (sort.equals("desc")) {        // 判断前台提交的sort 参数是否等于  desc倒序  是则使用倒序，否则使用正序
            example.orderBy(order).desc();  // 把sql 语句设置成倒序
        } else {
            example.orderBy(order).asc();   // 把 sql 设置成正序
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));  //
        // 获取前台提交的URL参数 page  如果没有则设置为1
        page = Math.max(1, page);  // 取两个数的最大值，防止page 小于1
        List<Yuding2> list = yuding2Service.selectPageExample(example, page, pagesize);   // 获取当前页的行数


        // 将列表写给界面使用
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);  // 把当前排序结果写进前台
        assign("sort", sort);      // 把当前排序结果写进前台
        return json();   // 将数据写给前端
    }

    public String getWhere() {
        _var = new LinkedHashMap(); // 重置数据
        String where = " ";
        // 判断URL 参数jiudianxinxiid是否大于0
        if (Request.getInt("jiudianxinxiid") > 0) {
            // 大于0 则写入条件
            where += " AND jiudianxinxiid='" + Request.getInt("jiudianxinxiid") + "' ";
        }
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
        if (!Request.get("jiudianbianhao").equals("")) {
            where += " AND jiudianbianhao LIKE '%" + Request.get("jiudianbianhao") + "%' ";
        }
        if (!Request.get("jiudianmingcheng").equals("")) {
            where += " AND jiudianmingcheng LIKE '%" + Request.get("jiudianmingcheng") + "%' ";
        }
        if (!Request.get("dizhi").equals("")) {
            where += " AND dizhi LIKE '%" + Request.get("dizhi") + "%' ";
        }
        return where;
    }

    /**
     * 预订人列表
     */
    @RequestMapping("/yuding2_list_yudingren")
    public String listyudingren() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }
        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据


        Example example = new Example(Yuding2.class);  //  创建一个扩展搜索类
        Example.Criteria criteria = example.createCriteria();           // 创建一个扩展搜索条件类
        // 初始化一个条件，条件为：预订人=当前登录用户
        String where = " yudingren='" + request.getSession().getAttribute("username") + "' ";
        where += getWhere();

        criteria.andCondition(where);   // 将条件写入
        if (sort.equals("desc")) {        // 注释同list
            example.orderBy(order).desc(); // 注释同list
        } else {
            example.orderBy(order).asc(); // 注释同list
        }

        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page")); // 注释同list
        page = Math.max(1, page); // 注释同list

        List<Yuding2> list = yuding2Service.selectPageExample(example, page, pagesize);
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("orderby", order);
        assign("sort", sort);
        return json();   // 将数据写给前端
    }


    @RequestMapping("/yuding2_add")
    public String add() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");  // 根据id 获取 旅游线路模块中的数据
        Jiudianxinxi readMap = jiudianxinxiService.find(id);
        // 将数据行写入给前台jsp页面
        assign("readMap", readMap);


        return json();   // 将数据写给前端
    }

    @RequestMapping("/yuding2_updt")
    public String updt() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Yuding2 mmm = yuding2Service.find(id);
        assign("mmm", mmm);
        assign("updtself", 0);

        return json();   // 将数据写给前端
    }

    /**
     * 添加内容
     *
     * @return
     */
    @RequestMapping("/yuding2insert")
    public String insert() {
        _var = new LinkedHashMap(); // 重置数据
        String tmp = "";
        Yuding2 post = new Yuding2();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setJiudianxinxiid(Request.getInt("jiudianxinxiid"));

        post.setJiudianbianhao(Request.get("jiudianbianhao"));

        post.setJiudianmingcheng(Request.get("jiudianmingcheng"));

        post.setDizhi(Request.get("dizhi"));

        post.setJiage(Request.getDouble("jiage"));

        post.setDingdanhao(Request.get("dingdanhao"));

        post.setYudingshijian(Request.get("yudingshijian"));

        post.setYudingrenxingming(Request.get("yudingrenxingming"));

        post.setLianxifangshi(Request.get("lianxifangshi"));

        post.setZhuangtai(Request.get("zhuangtai"));

        post.setBeizhu(Request.get("beizhu"));

        post.setYudingren(Request.get("yudingren"));

        post.setAddtime(Info.getDateStr());

        post.setJiudianxinxiid(Request.getInt("jiudianxinxiid"));
        post.setIszf("否");
        post.setRoomType(Request.get("roomType"));

        // 获取前端传递的酒店编号
        String jiudianbianhao = Request.get("jiudianbianhao");
        if (jiudianbianhao == null || jiudianbianhao.isEmpty()) {
            return showError("酒店编号不能为空");
        }

        // 根据酒店编号查询酒店信息
        Jiudianxinxi jiudianxinxi = jiudianxinxiService.findByJiudianbianhao(jiudianbianhao);
        if (jiudianxinxi == null) {
            return showError("未找到酒店信息");
        }

        // 更新酒店信息表中的字段
        String roomType = Request.get("roomType");
        if (roomType != null && !roomType.isEmpty()) {
            if ("dachuangfang".equals(roomType)) {
                int dachuangfangCount = jiudianxinxi.getDachuangfang();
                if (dachuangfangCount > 0) {
                    jiudianxinxi.setDachuangfang(dachuangfangCount - 1);
                } else {
                    return showError("该房间预定已满");
                }
            } else if ("shuangchuangfang".equals(roomType)) {
                int shuangchuangfangCount = jiudianxinxi.getShuangchuangfang();
                if (shuangchuangfangCount > 0) {
                    jiudianxinxi.setShuangchuangfang(shuangchuangfangCount - 1);
                } else {
                    return showError("该房间预定已满");
                }
            }
            jiudianxinxiService.update1(jiudianxinxi);
        }

        yuding2Service.insert(post); // 插入数据
        int charuid = post.getId().intValue();
        Query.execute("update yuding2 set zhuangtai");


        if (isAjax()) {
            return jsonResult(post);

        }
        return showSuccess("保存成功", Request.get("referer").equals("") ? request.getHeader("referer") : Request.get(
                "referer"));
    }

    /**
     * 更新内容
     *
     * @return
     */
    @RequestMapping("/yuding2update")
    public String update() {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Yuding2 post = new Yuding2();
        // 将前台表单数据填充到实体类
        if (!Request.get("jiudianxinxiid").equals(""))
            post.setJiudianxinxiid(Request.getInt("jiudianxinxiid"));
        if (!Request.get("jiudianbianhao").equals(""))
            post.setJiudianbianhao(Request.get("jiudianbianhao"));
        if (!Request.get("jiudianmingcheng").equals(""))
            post.setJiudianmingcheng(Request.get("jiudianmingcheng"));
        if (!Request.get("dizhi").equals(""))
            post.setDizhi(Request.get("dizhi"));
        if (!Request.get("jiage").equals(""))
            post.setJiage(Request.getDouble("jiage"));
        if (!Request.get("dingdanhao").equals(""))
            post.setDingdanhao(Request.get("dingdanhao"));
        if (!Request.get("yudingshijian").equals(""))
            post.setYudingshijian(Request.get("yudingshijian"));
        if (!Request.get("yudingrenxingming").equals(""))
            post.setYudingrenxingming(Request.get("yudingrenxingming"));
        if (!Request.get("lianxifangshi").equals(""))
            post.setLianxifangshi(Request.get("lianxifangshi"));
        if (!Request.get("zhuangtai").equals(""))
            post.setZhuangtai(Request.get("zhuangtai"));
        if (!Request.get("beizhu").equals(""))
            post.setBeizhu(Request.get("beizhu"));
        if (!Request.get("yudingren").equals(""))
            post.setYudingren(Request.get("yudingren"));
        if (!Request.get("addtime").equals(""))
            post.setAddtime(Request.get("addtime"));
        if(!Request.get("roomType").equals(""))
            post.setRoomType(Request.get("roomType"));

        // 获取前端传递的酒店编号
        String jiudianbianhao = Request.get("jiudianbianhao");
        if (jiudianbianhao == null || jiudianbianhao.isEmpty()) {
            return showError("酒店编号不能为空");
        }

        // 根据酒店编号查询酒店信息
        Jiudianxinxi jiudianxinxi = jiudianxinxiService.findByJiudianbianhao(jiudianbianhao);
        if (jiudianxinxi == null) {
            return showError("未找到酒店信息");
        }

        // 更新酒店信息表中的字段
        String roomType = Request.get("roomType");
        if (roomType != null && !roomType.isEmpty()) {
            if ("dachuangfang".equals(roomType)) {
                int dachuangfangCount = jiudianxinxi.getDachuangfang();
                if (dachuangfangCount > 0) {
                    jiudianxinxi.setDachuangfang(dachuangfangCount - 1);
                } else {
                    return showError("该房间预定已满");
                }
            } else if ("shuangchuangfang".equals(roomType)) {
                int shuangchuangfangCount = jiudianxinxi.getShuangchuangfang();
                if (shuangchuangfangCount > 0) {
                    jiudianxinxi.setShuangchuangfang(shuangchuangfangCount - 1);
                } else {
                    return showError("该房间预定已满");
                }
            }
            jiudianxinxiService.update1(jiudianxinxi);
        }


        post.setId(Request.getInt("id"));
        yuding2Service.update(post); // 更新数据



        if (isAjax()) {
            return jsonResult(post);
        }

        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     * 删除
     */
    @RequestMapping("/yuding2_delete")
    public String delete() {
        _var = new LinkedHashMap(); // 重置数据
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据

        yuding2Service.delete(id);// 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
