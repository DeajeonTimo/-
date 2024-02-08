package kr.or.ddit.basic.upload.service;

import java.util.List;

import kr.or.ddit.basic.upload.dao.FileInfoDaoImpl;
import kr.or.ddit.basic.upload.vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {

private static FileInfoServiceImpl instance;
private FileInfoDaoImpl dao;

	
	private FileInfoServiceImpl() { 
		dao = FileInfoDaoImpl.getInstance();
	}
	
	public static FileInfoServiceImpl getInstance() {
		if(instance==null) instance= new FileInfoServiceImpl();
		
		return instance;
	}
	
	
	@Override
	public int insertFileinfo(FileInfoVO vo) {
		
		return dao.insertFileinfo(vo);
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		
		return dao.getAllFileinfo();
	}

	@Override
	public FileInfoVO getFileinfo(int fileNo) {
		
		return dao.getFileinfo(fileNo);
	}

}
