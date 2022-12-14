package com.woniu.controller;


import com.github.pagehelper.PageInfo;
import com.woniu.entity.Teacher;
import com.woniu.service.ITeacherService;
import com.woniu.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wdn
 * @since 2022-06-17
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('teacher:list')")
    public ResponseResult<Object> queryTeacher(String teacherName, Integer pageNum, Integer pageSize) {
        ResponseResult<Object> responseResult = null;

        PageInfo<Teacher> pageInfo = teacherService.queryTeacher(teacherName, pageNum, pageSize);

        responseResult = new ResponseResult<>(pageInfo, "OK", 200);

        return responseResult;
    }

    /**
     * 添加讲师表单
     * @return
     */
    @GetMapping("/addShow")
    @PreAuthorize("hasAuthority('teacher:add')")
    public ResponseResult<Void> addShow() {
        return new ResponseResult<>(200, "OK");
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('teacher:add')")
    public ResponseResult<Void> addTeacher(@RequestBody Teacher teacher) {
        boolean isOk = teacherService.save(teacher);
        ResponseResult<Void> responseResult = null;

        if(isOk) {
            responseResult = new ResponseResult<>(200, "添加讲师成功");
        } else {
            responseResult = new ResponseResult<>(500, "添加讲师失败");
        }

        return responseResult;
    }

    @GetMapping("/updateShow")
    @PreAuthorize("hasAuthority('teacher:update')")
    public ResponseResult<Void> updateShow() {
        return new ResponseResult<>(200, "OK");
    }

    @PostMapping("/update")
    @PreAuthorize("hasAuthority('teacher:update')")
    public ResponseResult<Void> updateTeacher(@RequestBody Teacher teacher) {
        boolean isOk = teacherService.updateById(teacher);
        ResponseResult<Void> responseResult = null;
        if(isOk) {
            responseResult = new ResponseResult<>(200, "编辑讲师成功");
        } else {
            responseResult = new ResponseResult<>(500, "编辑讲师失败");
        }
        return responseResult;
    }

    @GetMapping("/delete")
    @PreAuthorize("hasAuthority('teacher:delete')")
    public ResponseResult<Void> delete(Integer id) {
        boolean isOk = teacherService.removeById(id);
        ResponseResult<Void> responseResult = null;
        if(isOk) {
            responseResult = new ResponseResult<>(200, "编辑讲师成功");
        } else {
            responseResult = new ResponseResult<>(500, "编辑讲师失败");
        }
        return responseResult;
    }

}
