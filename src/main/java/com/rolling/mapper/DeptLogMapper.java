package com.rolling.mapper;

import com.rolling.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestMapping;

@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(create_time, description) VALUES (#{createTime},#{description})")
    void insert(DeptLog deptLog);
}
