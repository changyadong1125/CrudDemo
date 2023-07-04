package com.atguigu.cruddemo.controller;

import com.atguigu.cruddemo.entity.StudentVo;
import com.atguigu.cruddemo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-06-30
 */
@Controller
@RequestMapping("/crud")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping("/list")
    public String toIndex(Map<String, List<StudentVo>> map) {
        List<StudentVo> list = studentService.findList();
        map.put("students", list);
        return "List";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "Add";
    }

    /**
     * return:
     * author: smile
     * version: 1.0
     * description:这里没有用文件接收，只接受了文件名
     */
    @RequestMapping("/add")
    public String add(@RequestParam("pictureFile") MultipartFile file,StudentVo studentVo) {
        studentService.addStudentAndSavePicture(studentVo,file);
        return "redirect:/crud/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return "redirect:/crud/list";
    }

    @RequestMapping("/update/{id}")
    public String toUpdate(@PathVariable Integer id, Map<String, StudentVo> map) {
        StudentVo studentVo = studentService.selectStudentById(id);
        map.put("studentVo", studentVo);
        return "Update";
    }

    @PostMapping ("/update")
    public String update(@RequestParam(value = "pictureFile",required = false) MultipartFile file,StudentVo studentVo) {
        studentService.updateStudent(studentVo,file);
        return "redirect:/crud/list";
    }
}

