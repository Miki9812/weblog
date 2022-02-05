package com.tong.web.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tong.pojo.Blog;
import com.tong.pojo.User;
import com.tong.service.BlogService;
import com.tong.service.TagService;
import com.tong.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;


    public void setTypeAndTag(Model model){
        model.addAttribute("types",typeService.getAllType());
        model.addAttribute("tags",tagService.getAllTag());
    }

    //博客列表
    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,3,orderBy);
        List<Blog> allBlog = blogService.getAllBlog();
        PageInfo pageInfo = new PageInfo(allBlog);
        setTypeAndTag(model);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String searchBlogs(Blog blog,Model model,
                         @RequestParam(required = false, defaultValue = "1",value = "pageNum") Integer pageNum){
        List<Blog> allBlog = blogService.searchByTitleAndType(blog);
        PageHelper.startPage(pageNum,3);
        PageInfo pageInfo = new PageInfo(allBlog);
        setTypeAndTag(model);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("message","查询成功");
        return "admin/blogs";
    }


    //编辑修改文章
    @PostMapping("/blogs/{id}")
    public String editPost(@Valid Blog blog,RedirectAttributes attributes){
        int b = blogService.updateBlog(blog);
        if (b == 0){
            attributes.addFlashAttribute("message","修改失败");
        } else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/blogs";
    }
    //博客新增
    @PostMapping("/blogs")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session){
        blog.setUser((User) session.getAttribute("user"));
        blog.setTypeId(blog.getType().getId());
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.getTagByString(blog.getTagIds()));

        if (blog.getId() == null){ //id为空，则为新增
            blogService.saveBlog(blog);
        }else {
            blogService.updateBlog(blog);
        }

        attributes.addFlashAttribute("message","新增成功");
        return "redirect:/admin/blogs";
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message","删除成功");
        return "redirect:/admin/blogs";
    }

    //跳转编辑修改文章
    @GetMapping("/blogs/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        Blog blogById = blogService.getBlogById(id);
        blogById.init(); // 将tags集合转换为tagIds字符串
        model.addAttribute("blog",blogById);
        setTypeAndTag(model);
        return "admin/blogs-input";
    }


    //跳转博客新增页面
    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("blog",new Blog());
        setTypeAndTag(model);
        return "admin/blogs-input";
    }

}
