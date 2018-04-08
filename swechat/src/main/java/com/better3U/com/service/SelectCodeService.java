package com.better3U.com.service;

import com.better3U.com.model.Code;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SelectCodeService {

    List<Code> selectCode();
}
