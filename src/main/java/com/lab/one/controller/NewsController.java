package com.lab.one.controller;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.controller.base.BaseController;
import com.lab.one.entity.LabNews;
import com.lab.one.service.LabNewsService;
import com.lab.one.utils.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangzhaozhou
 * @date 2021/1/6
 */

@Api(tags = "公告管理")
@RestController
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    LabNewsService newsService;


    @ApiOperation(value = "查看文章列表", notes = "查看文章列表", response = LabNews.class)
    @PostMapping("/list")
    public Response newsList() {
        return Response.success(newsService.findNewsList());
    }

    @ApiOperation(value = "删除文章", notes = "删除文章")
    @PostMapping("/del")
    public Response delNews(String id) {
        if (StringUtils.isNotEmpty(id)) {
            newsService.deleteById(id);
        }
        return Response.success();
    }

    @ApiOperation(value = "修改文章", notes = "修改文章")
    @PostMapping("/update")
    public Response updateNews(LabNews news) {
        if (StringUtils.isNotEmpty(news.getId())) {
            return Response.fail("id不能为空");
        }
        newsService.updateById(news);
        return Response.success();
    }

    @ApiOperation(value = "新增文章", notes = "新增文章")
    @PostMapping("/add")
    public Response addNews(LabNews news) {
        if (StringUtils.isNotEmpty(news.getTitle()) || StringUtils.isEmpty(news.getNewsDetail())) {
            return Response.fail("标题或内容不能为空");
        }
        newsService.insert(news.setCreateTime(new Date()));
        return Response.success();
    }

    @ApiOperation(value = "查看文章明细", notes = "查看文章明细")
    @PostMapping("/detail")
    public Response addNews(String id) {
        if (StringUtils.isNotEmpty(id)) {
            return Response.fail("id不能为空");
        }
        return Response.success(newsService.selectById(id));
    }
}
