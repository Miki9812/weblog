package com.tong.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tong.pojo.Blog;
import com.tong.pojo.Tag;
import com.tong.service.BlogService;
import com.tong.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagShowController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/tags/{id}")
    public String tags(Model model,
                       @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                       @PathVariable Long id){
        PageHelper.startPage(pageNum,100);
        List<Tag> tags = tagService.getBlogTag();
        if (id==-1){
            id = tags.get(0).getId();
        }
        List<Blog> blogs = blogService.getByTagId(id);
        for (Blog blog : blogs){
            System.out.println(blog);
        }
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("tags",tags);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTagId",id);

        return "tags";
    }

}
