package com.yangrui.shark.order.controller;


import com.yangrui.shark.utils.MarkDownUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiesuiyi 博客功能
 */
@Api("博客管理api")
@Controller
@RequestMapping(value = "/order")
public class OrderController {


	// markdown格式编辑博客，新进入新增页面
	@ApiOperation("新增博客")
	// @RequestMapping("/addBlog")
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String addBlog(Model model) {
		return "thymeleaf/order/order_add";
	}

}
