package com.better3U.com.controller;

import com.better3U.com.service.UploadService;
import com.better3U.com.model.LivingExpense;
import com.better3U.com.model.Message;
import com.better3U.com.model.Status;
import com.better3U.com.utils.DateUtil;
import com.better3U.com.utils.POIExcelUtil;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 通过excel批量导入数据
 *
 * @author tangyuan
 * @create 2018-03-01 15:03
 **/
@Controller
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private UploadService uploadServiceImpl;

    @RequestMapping("/excel")
    public String money(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        return "uploadByExcel";
    }

    /**
     * 上传excel,只允许上传一个
     *
     * @param files   传入的文件
     * @param request
     */
    @RequestMapping("/moneyExcel")
    public void moneyExcel(@RequestParam(value = "fileUpload") MultipartFile[] files, HttpServletRequest request, HttpServletResponse response) {
        /* 提取名为“fileUpload”的MultipartFile类型的参数,并将之作为输入参数传入
         * 相当于request.getParameter*/
        Gson gson = new Gson();
        Message msg = new Message();
        msg.setStatus(Status.ERROR);
        msg.setStatusMsg("读取失败");
        /* response.setCharacterEncoding("UTF-8");*/
        PrintWriter out = null;
        String filePath;
        try {
            out = response.getWriter();
            //excel读取
            List<String[]> dataList = POIExcelUtil.readExcel(files[0]);
            //数据装入及合法性验证
            List<LivingExpense> livingExpensesList = new ArrayList<LivingExpense>();
            for (int row = 0; row < dataList.size(); row++) {
                String[] cells = dataList.get(row);
                LivingExpense livingExpense = new LivingExpense();
                if (!"".equals(cells[0])) {
                    livingExpense.setCategory(Integer.parseInt(cells[0]));
                }
                if (!"".equals(cells[1])) {
                    livingExpense.setSpendPerMonth(Double.parseDouble(cells[1]));
                }
                if (!"".equals(cells[2])) {
                    livingExpense.setLeftMoney(Double.parseDouble(cells[2]));

                }
                if (!"".equals(cells[3])) {
                    livingExpense.setDepositMoney(Double.parseDouble(cells[3]));
                }
                if (!"".equals(cells[4])) {
                    livingExpense.setSeeTime(DateUtil.parseDate(cells[4], "yyyy-MM-dd"));
                }
                Date addDate = new Date();
                livingExpense.setAddTime(addDate);
                livingExpensesList.add(livingExpense);
            }
            uploadServiceImpl.insert(livingExpensesList);
            msg.setStatus(Status.SUCCESS);
            msg.setStatusMsg("插入成功");
        } catch (Exception e) {
            e.printStackTrace();

        }
        out.write(gson.toJson(msg));
    }


}
