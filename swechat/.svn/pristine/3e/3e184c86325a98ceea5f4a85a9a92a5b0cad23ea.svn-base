package com.better3U.com.service.impl;

import com.better3U.com.mapper.db2.LivingExpenseMapper;
import com.better3U.com.service.UploadService;
import com.better3U.com.model.LivingExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 处理文件上传
 */
@Service
public class UploadServiceImpl implements UploadService {
    @Autowired
    private LivingExpenseMapper livingExpenseMapper;
    @Transactional
    public void insert( List<LivingExpense> livingExpensesList) throws  Exception{
        livingExpenseMapper.insert(livingExpensesList);
    }

}
