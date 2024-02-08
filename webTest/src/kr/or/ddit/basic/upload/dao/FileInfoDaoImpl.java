package kr.or.ddit.basic.upload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.basic.upload.vo.FileInfoVO;
import kr.or.ddit.util.MybatisUtil;

public class FileInfoDaoImpl implements IFileInfoDao {

	private static FileInfoDaoImpl instance;
	
	private FileInfoDaoImpl() { }
	
	public static FileInfoDaoImpl getInstance() {
		if(instance==null) instance= new FileInfoDaoImpl();
		
		return instance;
	}
	
	
	@Override
	public int insertFileinfo(FileInfoVO vo) {
		int cnt = 0;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo",vo);
			if(cnt>0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {session.close();}
		}
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		List<FileInfoVO> list = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			list = session.selectList("fileinfo.getAllFileinfo");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {session.close();}
		}
		return list;
	}

	@Override
	public FileInfoVO getFileinfo(int fileNo) {
		FileInfoVO vo = null;
		SqlSession session = null;
		try {
			session = MybatisUtil.getSqlSession();
			vo = session.selectOne("fileinfo.getFileinfo",fileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) {session.close();}
		}
		return vo;
	}

}
