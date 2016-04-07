package com.example.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class Main 
{
	static BoardDao dao;
	
	
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("data-config.xml");
		dao = (BoardDao)ctx.getBean("boardDaoImpl");
		
		transactionTest();
	}
	

	public static void transactionTest()
	{
		Board board  = new Board(2,"tran1","tran1");	
		Board board2  = new Board(2,"tran2","tran2");	
		
		int rst1;
		int rst2;		
		try {
			rst1 = dao.insert(board);				
			rst2 = dao.insert(board2);	
		} catch (Exception e) {
			System.out.println("ERROR");
			new RuntimeException();
			//e.printStackTrace();
		}	

		

		
		
	}
}
