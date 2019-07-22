package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDao {
   private JdbcTemplate jt;
   
   public EmpDao() {
       System.out.println("empdao 0-param constructor");
   }
   //setter injection
   public void setJt(JdbcTemplate jt)
   {
	   System.out.println("EmpDao.setJt()");
	   this.jt=jt;
   }
   public List getEmpDetails(String condition) {
	   List<Map<String,Object>> list=jt.queryForList("select empno,ename,job,sal from emp where job ="+"'"+condition+"'");
	return list;
	   
   }
   
}
