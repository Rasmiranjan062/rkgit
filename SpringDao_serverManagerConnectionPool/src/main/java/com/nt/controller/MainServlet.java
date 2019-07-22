package com.nt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmpService;

public class MainServlet extends HttpServlet{
	ApplicationContext ctx=null;
	EmpService service;
	public MainServlet() {
            System.out.println("MainServlet.MainServlet() 0-param constructor");
	}
	
	public void init() {
		System.out.println("MainServlet.init()");
		//create ioc container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service=(EmpService) ctx.getBean("empService");
	}
	
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  RequestDispatcher rd=null;
	  //read form  data
	  String desg=req.getParameter("job");
	 	  //use service
	  List<Map<String,Object>> finalResult=service.search(desg);
	  //keep results in req scope to send to dest page
	  req.setAttribute("result",finalResult);
	  //forward request to result page
	  rd=req.getRequestDispatcher("/Result.jsp");
	  rd.forward(req, resp);
  }
  @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}
