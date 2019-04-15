package com.greatyun.service;

import com.greatyun.common.ServerResponse;
import com.greatyun.pojo.Student;
import com.greatyun.vo.PageVo;


public interface IStudentService {
    ServerResponse addStudent(Student student);

    ServerResponse updateStudent(Student student);

    ServerResponse deleteStudents(String idList);

    ServerResponse<PageVo> fetchStudent(int page, int pageSize);
}
