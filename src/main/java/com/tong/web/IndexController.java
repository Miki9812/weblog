package com.tong.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tong.NotFoundException;
import com.tong.pojo.Blog;
import com.tong.pojo.Tag;
import com.tong.pojo.Type;
import com.tong.service.BlogService;
import com.tong.service.TagService;
import com.tong.service.TypeService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,8);
        List<Blog> allBlog = blogService.getIndexBlog();
        List<Type> allType = typeService.getBlogType();
        List<Tag> allTag = tagService.getBlogTag();
        List<Blog> recommendBlog = blogService.getAllRecommendBlog();

        PageInfo pageInfo = new PageInfo(allBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("tags",allTag);
        model.addAttribute("types",allType);
        model.addAttribute("recommendBlog",recommendBlog);
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                         @RequestParam String query){
        PageHelper.startPage(pageNum,5);
        List<Blog> searchBlog = blogService.getSearchBlog(query);
        PageInfo pageInfo = new PageInfo(searchBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String blogId(@PathVariable Long id,Model model){
        Blog blog = blogService.getDetailedBlog(id);
        model.addAttribute("blog",blog);
        return "blog";
    }


    @GetMapping("/blog")
    public String blog(){
        return "blog";
    }


}
