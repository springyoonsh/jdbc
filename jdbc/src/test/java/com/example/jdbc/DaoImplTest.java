package com.example.jdbc;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/data-config.xml")
public class DaoImplTest 
{
	@Autowired
	private BoardDaoImpl dao;
		
	@Test
	public void testSelectAll() {
		List<Board> list = dao.selectAll();
		
		for( Board board : list)
		{
			System.out.println( board.getUser_id() + ":" +board.getUser_pw());
		}
	}

	@Test
	public void testInsert() {		
		Board board = new Board("test222","insert222...");		
		//int rst = dao.insert(board);		
		//System.out.println(rst);
	}
	
	@Test
	public void testUpdate() {
		Board board = new Board(1,"update","update");
		int rst = dao.update(board);
		System.out.println("testUpdate="+rst);
	}
	
	@Test
	public void testDelete() {
		int rst = dao.delete(1);
		System.out.println("testDelete="+rst);
	}
}
