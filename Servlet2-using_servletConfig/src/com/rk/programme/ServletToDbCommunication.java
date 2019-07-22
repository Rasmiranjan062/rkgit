package com.rk.programme;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletToDbCommunication extends HttpServlet{
	Connection con;
	PreparedStatement ps;
	public void init() {
		try {
			//get access to servlet config object
		  ServletConfig cg=getServletConfig();
		  String s1=cg.getInitParameter("driver");
		  String s2=cg.getInitParameter("url");
		  String s3=cg.getInitParameter("username");
		  String s4=cg.getInitParameter("password");
		  //create jdbc connection
		  Class.forName(s1);
		  con=DriverManager.getConnection(s2,s3,s4);
		  //create jdbc prepared statement 
		  ps=con.prepareStatement("select empno,ename,job,sal from emp where empno=?");
		}//try
		  catch(Exception e){
			  e.printStackTrace();
		}//catch
		
	}//init()
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) {
		try {
		//general setting 
	    PrintWriter pw=res.getWriter();
	    res.setContentType("text/html");
	    //read form data
	    int no=Integer.parseInt(req.getParameter("eno"));
	    //set query param
	    ps.setInt(1,no);
	  //execute the sql query
	    ResultSet rs=ps.executeQuery();
	    //process the result
	    if(rs.next()) {
	    	pw.println(rs.getInt(1)+"  "+rs.getString(2) +"   "+rs.getString(3)+"  "+rs.getFloat(4));
	     }//if
	    else {
	    	pw.print("No record found with this eno..........");
	    }//else
		}//try
		catch(Exception e) {
			e.printStackTrace();
		}//catch
	}//doget()
	
	public void doPost(HttpServletRequest req , HttpServletResponse res) {
		doGet(req,res);
	}//doPost();
}
