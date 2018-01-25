package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.persistence.BoardDAO;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class BoardDAOTest {
	@Inject
	private BoardDAO dao;
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
/*	@Test
	public void testCreate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setTitle("게시글명");
		vo.setContent("내용입니다.");
		vo.setWriter("작성자");
		
		dao.create(vo);
	}
	
	@Test
	public void testRead() throws Exception{
		logger.info(dao.read(3).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setBno(1);
		vo.setTitle("게시글수정명");
		vo.setContent("내용수정입니다.");

		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception{
		dao.delete(1);
	}
	
	@Test
	public void testListPage() throws Exception{
		int page = 3;
		List<BoardVO> list = dao.listPage(page);
		
		for(BoardVO boardVO : list){
			logger.info(boardVO.getBno()+" : "+ boardVO.getTitle());
		}
	}*/
	
	@Test
	public void testListCriteria()throws Exception{
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(20);
		
		List<BoardVO> list = dao.listCriteria(cri);
		for(BoardVO boardVO : list){
			logger.info(boardVO.getBno()+" : "+boardVO.getTitle());
		}
	}

}
