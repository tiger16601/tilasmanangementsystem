package com.rolling.mapper;

import com.rolling.pojo.Emp;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    /* @Select("select count(*) from emp")
     Long count();

     @Select("select * from emp limit #{start},#{pageSize}")
     List<Emp> page(Integer start, Integer pageSize);*/
//    @Select("select * from emp")
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    @Insert("insert into emp(username,name,gender,image,job,entrydate,dept_id,create_time,update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createDate},#{updateDate}) ")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);

    void update(Emp emp);

    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id = #{deptid}")
    void deleteByDeptId(Integer deptId);
}
