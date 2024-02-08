package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.vo.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao{

	private static LprodDaoImpl instance;
	
	private LprodDaoImpl() { }
	
	public static LprodDaoImpl getInstance() {
		if(instance==null) instance = new LprodDaoImpl();
		return instance;
	}

	@Override
	public List<LprodVO> selectAllLprod() {
		List<LprodVO> list = null;
		SqlSession session = null;
		
		try {
			session=MybatisUtil.getSqlSession();
			list = session.selectList("lprod.selectAllLprod");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	
}
