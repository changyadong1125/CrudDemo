package com.atguigu.cruddemo.service;

import com.atguigu.cruddemo.entity.Student;
import com.atguigu.cruddemo.entity.StudentVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-06-30
 */
public interface StudentService extends IService<Student> {

    void addStudent(StudentVo studentVo);

    List<StudentVo> findList();

    void deleteStudent(Integer id);

    StudentVo selectStudentById(Integer id);

    void updateStudent(StudentVo studentVo, MultipartFile file);

    String savePicture(MultipartFile file);

    void addStudentAndSavePicture(StudentVo studentVo, MultipartFile file);
}
