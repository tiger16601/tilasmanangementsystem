package com.rolling.service;

import com.rolling.pojo.DeptLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptLogService {
    public void insert(DeptLog deptLog);
}
