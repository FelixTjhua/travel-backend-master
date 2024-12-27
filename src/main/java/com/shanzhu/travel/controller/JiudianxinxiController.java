package com.shanzhu.travel.controller;

import com.shanzhu.travel.common.CommDAO;
import com.shanzhu.travel.common.Query;
import com.shanzhu.travel.entity.Jiudianxinxi;
import com.shanzhu.travel.service.JiudianxinxiService;
import com.shanzhu.travel.util.DownloadRemoteImage;
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
 * @Title: JiudianxinxiController
 * @Package com.shanzhu.travel.controller
 * @Description: 酒店信息控制层
 * @date 2024/7/5 8:44
 */

@Controller
public class JiudianxinxiController extends BaseController {

    @Resource
    private JiudianxinxiService jiudianxinxiService;

    /**
     * 后台列表页
     */
    @RequestMapping("/jiudianxinxi_list")
    public String list() {
        // 检测是否有登录，没登录则跳转到登录页面
        if (!checkLogin()) {
            return showError("尚未登录", "./login.do");
        }

        String order = Request.get("order", "id"); // 获取前台提交的URL参数 order  如果没有则设置为id
        String sort = Request.get("sort", "desc"); // 获取前台提交的URL参数 sort  如果没有则设置为desc
        int pagesize = Request.getInt("pagesize", 12); // 获取前台一页多少行数据
        Example example = new Example(Jiudianxinxi.class); //  创建一个扩展搜索类
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
        List<Jiudianxinxi> list = jiudianxinxiService.selectPageExample(example, page, pagesize);   // 获取当前页的行数
        assign("diquList", new CommDAO().select("SELECT * FROM diqu ORDER BY id desc"));
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
        // 以下也是一样的操作，判断是否符合条件，符合则写入sql 语句
        if (!Request.get("jiudianbianhao").equals("")) {
            where += " AND jiudianbianhao LIKE '%" + Request.get("jiudianbianhao") + "%' ";
        }
        if (!Request.get("jiudianmingcheng").equals("")) {
            where += " AND jiudianmingcheng LIKE '%" + Request.get("jiudianmingcheng") + "%' ";
        }
        if (!Request.get("suoshudengji").equals("")) {
            where += " AND suoshudengji ='" + Request.get("suoshudengji") + "' ";
        }
        return where;
    }


    /**
     * 前台列表页
     */
    @RequestMapping("/jiudianxinxilist")
    public String index() {
        String order = Request.get("order", "id");
        String sort = Request.get("sort", "desc");

        Example example = new Example(Jiudianxinxi.class);
        Example.Criteria criteria = example.createCriteria();
        String where = " 1=1 ";
        where += getWhere();
        criteria.andCondition(where);
        if (sort.equals("desc")) {
            example.orderBy(order).desc();
        } else {
            example.orderBy(order).asc();
        }
        int page = request.getParameter("page") == null ? 1 : Integer.valueOf(request.getParameter("page"));
        page = Math.max(1, page);
        List<Jiudianxinxi> list = jiudianxinxiService.selectPageExample(example, page, 12);

        assign("mapdengji4", new CommDAO().select("SELECT id,dengjimingcheng FROM dengji"));
        assign("totalCount", request.getAttribute("totalCount"));
        assign("list", list);
        assign("where", where);
        assign("orderby", order);
        assign("sort", sort);
        return json();
    }


    @RequestMapping("/jiudianxinxi_add")
    public String add() {
        _var = new LinkedHashMap(); // 重置数据
        assign("dengjiList", new CommDAO().select("SELECT * FROM dengji ORDER BY id desc"));
        return json();   // 将数据写给前端
    }

    @RequestMapping("/jiudianxinxi_updt")
    public String updt() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        // 获取行数据，并赋值给前台jsp页面
        Jiudianxinxi mmm = jiudianxinxiService.find(id);
        assign("mmm", mmm);
        assign("updtself", 0);
        assign("dengjiList", new CommDAO().select("SELECT * FROM dengji ORDER BY id desc"));
        return json();   // 将数据写给前端
    }

    /**
     * 添加内容
     *
     * @return
     */
    @RequestMapping("/jiudianxinxiinsert")
    public String insert() {
        _var = new LinkedHashMap(); // 重置数据
        Jiudianxinxi post = new Jiudianxinxi();  // 创建实体类
        // 设置前台提交上来的数据到实体类中
        post.setJiudianbianhao(Request.get("jiudianbianhao"));

        post.setJiudianmingcheng(Request.get("jiudianmingcheng"));

        post.setSuoshudengji(Request.get("suoshudengji"));

        post.setTupian(Request.get("tupian"));

        post.setYingyeshijian(Request.get("yingyeshijian"));

        post.setDizhi(Request.get("dizhi"));

        post.setJiage(Request.getDouble("jiage"));

        post.setLiulanliang(Request.getInt("liulanliang"));

        post.setDachuangfang(Request.getInt("dachuangfang"));

        post.setShuangchuangfang(Request.getInt("shuangchuangfang"));

        post.setMiaoshu(DownloadRemoteImage.run(Request.get("miaoshu")));

        post.setAddtime(Info.getDateStr());

        jiudianxinxiService.insert(post); // 插入数据

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
    @RequestMapping("/jiudianxinxiupdate")
    public String update() {
        _var = new LinkedHashMap(); // 重置数据
        // 创建实体类
        Jiudianxinxi post = new Jiudianxinxi();
        // 将前台表单数据填充到实体类
        if (!Request.get("jiudianbianhao").equals(""))
            post.setJiudianbianhao(Request.get("jiudianbianhao"));
        if (!Request.get("jiudianmingcheng").equals(""))
            post.setJiudianmingcheng(Request.get("jiudianmingcheng"));
        if (!Request.get("suoshudengji").equals(""))
            post.setSuoshudengji(Request.get("suoshudengji"));
        if (!Request.get("tupian").equals(""))
            post.setTupian(Request.get("tupian"));
        if (!Request.get("yingyeshijian").equals(""))
            post.setYingyeshijian(Request.get("yingyeshijian"));
        if (!Request.get("dizhi").equals(""))
            post.setDizhi(Request.get("dizhi"));
        if (!Request.get("piaojia").equals(""))
            post.setJiage(Request.getDouble("jiage"));
        if (!Request.get("liulanliang").equals(""))
            post.setLiulanliang(Request.getInt("liulanliang"));
        if (!Request.get("miaoshu").equals(""))
            post.setMiaoshu(DownloadRemoteImage.run(Request.get("miaoshu")));
        if (!Request.get("addtime").equals(""))
            post.setAddtime(Request.get("addtime"));
        if (!Request.get("dachuangfang").equals(""))
            post.setDachuangfang(Request.getInt("dachuangfang"));
        if (!Request.get("shuangchuangfang").equals(""))
            post.setShuangchuangfang(Request.getInt("shuangchuangfang"));

        post.setId(Request.getInt("id"));
        jiudianxinxiService.update(post); // 更新数据

        if (isAjax()) {
            return jsonResult(post);
        }

        return showSuccess("保存成功", Request.get("referer")); // 弹出保存成功，并跳转到前台提交的 referer 页面
    }

    /**
     * 后台详情
     */
    @RequestMapping("/jiudianxinxi_detail")
    public String detail() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Jiudianxinxi map = jiudianxinxiService.find(id);  // 根据前台url 参数中的id获取行数据
        assign("map", map);  // 把数据写到前台
        return json();   // 将数据写给前端
    }

    /**
     * 前台详情
     */
    @RequestMapping("/jiudianxinxidetail")
    public String detailweb() {
        _var = new LinkedHashMap(); // 重置数据
        int id = Request.getInt("id");
        Jiudianxinxi map = jiudianxinxiService.find(id);
        Query.execute("UPDATE jiudianxinxi SET liulanliang=liulanliang+1 WHERE id=" + request.getParameter("id") + "");

        if (!checkLogin()) {
            assign("isCollect", false);
        } else {
            assign("isCollect", Query.make("shoucangjilu").where("username", session.getAttribute("username")).where(
                    "biao", "jiudianxinxi").where("xwid", id).count() > 0);
        }

        assign("map", map);
        return json();   // 将数据写给前端
    }

    /**
     * 删除
     */
    @RequestMapping("/jiudianxinxi_delete")
    public String delete() {
        _var = new LinkedHashMap(); // 重置数据
        if (!checkLogin()) {
            return showError("尚未登录");
        }
        int id = Request.getInt("id");  // 根据id 删除某行数据

        jiudianxinxiService.delete(id);// 根据id 删除某行数据
        return showSuccess("删除成功", request.getHeader("referer"));//弹出删除成功，并跳回上一页
    }
}
