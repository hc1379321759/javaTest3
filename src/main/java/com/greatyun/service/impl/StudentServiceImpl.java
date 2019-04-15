package com.greatyun.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.greatyun.common.ServerResponse;
import com.greatyun.dao.StudentMapper;
import com.greatyun.pojo.Student;
import com.greatyun.service.IStudentService;
import com.greatyun.vo.PageVo;
import com.greatyun.vo.StuIdVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("iStudentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    public ServerResponse<StuIdVo> addStudent(Student student){
        int rowCount = studentMapper.insert(student);
        if (rowCount == 1){
            StuIdVo stuIdVo = new StuIdVo(getStudentMaxId());
            return ServerResponse.createBySuccess("新增学生成功", stuIdVo);
        }
        return ServerResponse.createBySuccessMessage("新增学生失败");
    }

    private Integer getStudentMaxId(){
        return studentMapper.selectMaxId();
    }

    public ServerResponse updateStudent(Student student){
       int rowCount = studentMapper.updateByPrimaryKeySelective(student);
       if (rowCount == 1){
           return ServerResponse.createBySuccess("更新成功");
       }
       return ServerResponse.createByErrorMessage("更新失败");
    }

    public ServerResponse deleteStudents(String idList){
        List<Integer> list = new ArrayList<>();
        list = stringToList(idList);
        int rowCount = studentMapper.batchDeleteStudents(list);
        if (rowCount == list.size()){
            return ServerResponse.createBySuccess("删除成功");
        }else if (rowCount > 0 && rowCount < list.size()){
            return ServerResponse.createByErrorMessage("部分删除成功");
        }else {
            return ServerResponse.createByErrorMessage("删除对象不存在");
        }
    }

    //将"1，2，3，4..."转换成list
    private List<Integer> stringToList(String idList){
        List<Integer> list = new ArrayList<>();
        for (String str: idList.split(",")){
            list.add(Integer.parseInt(str));
        }
        return list;
    }

    public ServerResponse<PageVo> fetchStudent(int page, int pageSize){
        //startPage--start
        //填充自己的sql查询逻辑
        //pageHelper--收尾
        PageHelper.startPage(page+1,pageSize);
        List<Student> studentList = studentMapper.selectList();

        PageInfo pageResult = new PageInfo(studentList);

        PageVo pageVo;
        if (pageResult.isHasNextPage()){
            pageVo = new PageVo(1,studentList);
        }else {
            pageVo = new PageVo(0,studentList);
        }
        return ServerResponse.createBySuccess(pageVo);
    }

}
