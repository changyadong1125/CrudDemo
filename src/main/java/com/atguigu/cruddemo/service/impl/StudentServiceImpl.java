package com.atguigu.cruddemo.service.impl;

import com.atguigu.cruddemo.entity.Habby;
import com.atguigu.cruddemo.entity.Student;
import com.atguigu.cruddemo.entity.StudentVo;
import com.atguigu.cruddemo.mapper.HabbyMapper;
import com.atguigu.cruddemo.mapper.StudentMapper;
import com.atguigu.cruddemo.service.HabbyService;
import com.atguigu.cruddemo.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-06-30
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    private final HabbyService habbyService;
    @Resource
    private HabbyMapper habbyMapper;

    public StudentServiceImpl(HabbyService habbyService) {
        this.habbyService = habbyService;
    }

    @Override
    @Transactional
    public void addStudent(StudentVo studentVo) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVo, student);
        baseMapper.insert(student);
        List<String> habbys = studentVo.getHabby();
        if (habbys == null) habbys = new ArrayList<>();
        habbys.forEach(H -> {
            Habby habby = new Habby();
            habby.setName(H);
            habby.setSid(student.getId());
            habbyService.save(habby);
        });
    }

    @Override
    public List<StudentVo> findList() {
        List<StudentVo> studentVos = new ArrayList<>();
        List<Student> students = baseMapper.selectList(null);
        students.forEach(S -> {
            StudentVo studentVo = new StudentVo();
            BeanUtils.copyProperties(S, studentVo);
            List<String> habbys = habbyMapper.findHabby(S.getId());
            studentVo.setHabby(habbys);
            studentVos.add(studentVo);
        });
        return studentVos;
    }

    @Override
    public void deleteStudent(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public StudentVo selectStudentById(Integer id) {
        Student student = baseMapper.selectById(id);
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(student, studentVo);
        List<String> habbys = habbyMapper.findHabby(student.getId());
        studentVo.setHabby(habbys);
        return studentVo;
    }

    @Override
    @Transactional
    public void updateStudent(StudentVo studentVo, MultipartFile file) {
        Student student = new Student();
        BeanUtils.copyProperties(studentVo, student);
        /*
        存储图片
         */
        if (StringUtils.isEmpty(file.getOriginalFilename())) {
            String picture = baseMapper.selectById(studentVo.getId()).getPicture();
            student.setPicture(picture);
        }else {
            String picturePath = savePicture(file);
            student.setPicture(picturePath);
        }
        baseMapper.updateById(student);
        habbyMapper.removeBySid(studentVo.getId());
        List<String> habbys = studentVo.getHabby();
        if (habbys == null) habbys = new ArrayList<>();
        habbys.forEach(H -> {
            Habby habby = new Habby();
            habby.setSid(studentVo.getId());
            habby.setName(H);
            habbyService.save(habby);
        });
    }

    @SuppressWarnings("all")
    @Override
    public String savePicture(MultipartFile file) {
        try {
            //存项目
            String fileName = saveRootPicture(file);
            //存target
            String uploadPath = "D:\\Java\\尚硅谷java20230201\\20230201javaSEcode\\CrudDemo\\target\\classes\\static\\picture"; // 改这里
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            // 本地文件
            File localFile = new File(uploadPath + File.separator + fileName);
            // transfer to local
            file.transferTo(localFile);
            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("all")
    private String saveRootPicture(MultipartFile file) {
        String uploadPath = "D:\\Java\\尚硅谷java20230201\\20230201javaSEcode\\CrudDemo\\src\\main\\resources\\static\\picture";
        try {
            byte[] fileBytes = file.getBytes();
            String fileName = UUID.randomUUID().toString().replaceAll("-", "") + file.getOriginalFilename();
            FileOutputStream outputStream2 = new FileOutputStream(uploadPath + File.separator + fileName);
            outputStream2.write(fileBytes);
            outputStream2.close();
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addStudentAndSavePicture(StudentVo studentVo, MultipartFile file) {
        String picturePath = savePicture(file);
        studentVo.setPicture(picturePath);
        addStudent(studentVo);
    }
}
