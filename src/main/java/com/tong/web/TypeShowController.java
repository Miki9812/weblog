package com.tong.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tong.pojo.Blog;
import com.tong.pojo.Type;
import com.tong.service.BlogService;
import com.tong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(Model model,
                        @RequestParam(defaultValue = "1",value = "pageNum")Integer pageNum,
                        @PathVariable Long id) {
        PageHelper.startPage(pageNum,100);
        List<Type> types = typeService.getBlogType();
        if (id == -1){
            id = types.get(0).getId();
        }
        List<Blog> blogs = blogService.getByTypeId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("types",types);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("activeTypeId",id);
        return "types";
    }
}
