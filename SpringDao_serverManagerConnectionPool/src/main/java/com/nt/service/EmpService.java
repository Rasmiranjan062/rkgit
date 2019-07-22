package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmpDao;

public class EmpService {
	private EmpDao dao;
	
	public EmpService() {
        System.out.println("EmpService.EmpService() 0-param constructor");
	}
	//setter injection
	public void setDao(EmpDao dao) {
		System.out.println("EmpService.setDao()");
		this.dao=dao;
	}
	public List search(String job)
	{
		//use dao
		List<Map<String,Object>> map=dao.getEmpDetails(job);
		return map;
		
		
	}

}
