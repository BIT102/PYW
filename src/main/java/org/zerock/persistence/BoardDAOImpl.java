package org.zerock.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

@Repository // 저장소라는 의미로 DAO를 인식시키기위한 어노테이션 이다. 
public class BoardDAOImpl implements BoardDAO{
	
	@Inject  // Dependency Injection 의존성 주입 Autowired가 spring이 제공하는 것 inject 는 자바에서 제공(같은 내용임)
	private SqlSession session; 
	// sqlSession session = new SqlSessionTemplate();와 같은 의미이나 위처럼할시 xml파일에서 설정된대로 만들어줌. 
	
	private static String namespace = "org.zerock.mapper.BoardMapper";
	
	@Override
	public void create(BoardVO vo)throws Exception{
		session.insert(namespace+".createBoard",vo);
	}
	
	@Override
	public BoardVO read(Integer bno) throws Exception{
		return session.selectOne(namespace+".readBoard", bno); 
	}
	
	@Override
	public void update(BoardVO vo) throws Exception{
		session.update(namespace+".updateBoard",vo);
	}
	
	@Override
	public void delete(Integer bno) throws Exception{
		session.delete(namespace+".deleteBoard", bno);
	}
	
	@Override
	public List<BoardVO> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception{
		
		if(page<=0){
			page = 1;
		}
		page = (page-1)*10; // 10 부터 20부터 30부터 40부터 .....
		return session.selectList(namespace+".listPage",page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception{
		return session.selectList(namespace+".listCriteria",cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception{
		return session.selectOne(namespace+".countPaging",cri);
	}
	
}
