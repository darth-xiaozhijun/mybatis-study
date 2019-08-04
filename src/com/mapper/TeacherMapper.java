package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.pojo.Teacher;

public interface TeacherMapper {
	
	Teacher selById(int id);
	
	@Select("select * from teacher")
	List<Teacher> selectAll();
	
	@Insert("insert into teacher values(default,#{name})")
	int insTeacher(Teacher teacher);
	
	@Update("update teacher set name=#{name} where id=#{id}")
	int updTeacher(Teacher teacher);
	
	@Delete("delete from teacher where id=#{0}")
	int delById(int id);
	
	@Results(value={
			@Result(id=true,property="id",column="id"),
			@Result(property="name",column="name"),
			@Result(property="list",column="id",many=@Many(select="com.mapper.StudentMapper.selectByTid"))
	})
	@Select("select * from teacher")
	List<Teacher> selTeacher();
}
