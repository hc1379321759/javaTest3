package com.greatyun.controller;

import com.greatyun.common.ServerResponse;
import com.greatyun.pojo.Student;
import com.greatyun.service.IStudentService;
import com.greatyun.vo.StuIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/students/")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;


    @RequestMapping(value = "add.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<StuIdVo> addStudent(Student student){
        return iStudentService.addStudent(student);
    }

    @RequestMapping(value = "update.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateStudent(Student student){
        return iStudentService.updateStudent(student);
    }

    @RequestMapping(value = "fetch.do",method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse fetchStudent(int page,int pageSize){
        return iStudentService.fetchStudent(page,pageSize);
    }

    @RequestMapping(value = "delete.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteStudent(String idList){
        return iStudentService.deleteStudents(idList);
    }
}
