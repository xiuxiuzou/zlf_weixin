package com.better3U.com.service;

import com.better3U.com.model.LivingExpense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UploadService {

    public void insert(List<LivingExpense> livingExpensesList) throws  Exception;
}
