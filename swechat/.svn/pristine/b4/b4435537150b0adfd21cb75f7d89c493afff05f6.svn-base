package com.better3U.com.service.impl;

import com.better3U.com.mapper.db1.CodeMapper;
import com.better3U.com.model.Code;
import com.better3U.com.service.SelectCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 处理文件上传
 */
@Service
public class SelectCodeServiceImpl implements SelectCodeService {
    @Autowired
    private CodeMapper codeMapper;

    @Override
    public List<Code> selectCode() {
        List<Code> selectCodeList=codeMapper.selectCode();
        return selectCodeList;
    }
}
