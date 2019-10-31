package com.zhy.controller;

import com.zhy.pojo.Category;
import com.zhy.service.CategoryService;
import com.zhy.util.ImageUtil;
import com.zhy.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/categories")
    public Page4Navigator<Category> list(@RequestParam(defaultValue = "0", value = "start") int start,
                                         @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;
        Page4Navigator<Category> page;
        page = categoryService.list(start, size, 5);
        return page;
    }

    @PostMapping("/categories")
    public Category add(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        categoryService.add(bean);
        saveOrUpdateImageFile(bean, image, request);
        return bean;
    }

    @DeleteMapping("/categories/{id}")
    public String delete(@PathVariable int id, HttpServletRequest request) {
        categoryService.delete(id);
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, id + ".jpg");
        file.delete();
        return null;
    }

    private void saveOrUpdateImageFile(Category bean, MultipartFile image, HttpServletRequest request) throws IOException {
        File imageFolder = new File(request.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder, bean.getId() + ".jpg");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg((file));
        ImageIO.write(img, "jpg", file);
    }

    @GetMapping("/categories/{id}")
    public Category get(@PathVariable("id") int id) {
        return categoryService.get(id);
    }

    @PutMapping("/categories")
    public Object update(MultipartFile image, Category bean, HttpServletRequest request) throws Exception {
        categoryService.update(bean);
        if (image != null) {
            saveOrUpdateImageFile(bean, image, request);
        }
        return bean;
    }
}