package com.better3U.com.controller;

import com.better3U.com.model.Code;
import com.better3U.com.service.SelectCodeService;
import com.google.gson.Gson;
import com.better3U.com.model.Message;
import com.better3U.com.model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


/**
 * 
 * @author 邹林方
 * @date 2017年12月28日
 * @todo 渠道销售
 *
 */
@Controller
@RequestMapping("/ota")
@Scope("prototype")
public class CodeController {

	@Autowired
	private SelectCodeService selectCodeService;

	public CodeController() {
	}

	@RequestMapping("/SelectCode")
	public void SelectCode(HttpServletRequest request, HttpServletResponse response) throws ParseException {
		Message msg = new Message();
		msg.setStatus(Status.ERROR);
		msg.setStatusMsg("查找错误");
		Gson gson = new Gson();
		String returnmsg = gson.toJson(msg);
		Code code = new Code();
		List<Code> list = new ArrayList<Code>();
		PrintWriter out = null;
		out = null;
		try {
			out = response.getWriter();
			list = selectCodeService.selectCode();
			msg.setStatus(Status.SUCCESS);
			returnmsg = gson.toJson(list);
		} catch (Exception e) {
			out.write(returnmsg);
			e.printStackTrace();
			return;
		}
		out.write(returnmsg);
	}
}
