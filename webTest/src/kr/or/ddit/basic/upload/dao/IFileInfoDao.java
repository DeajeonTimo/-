package kr.or.ddit.basic.upload.dao;

import java.util.List;

import kr.or.ddit.basic.upload.vo.FileInfoVO;

public interface IFileInfoDao {
	/**
	 * FileInfoVO객체에 저장된 자료를 DB에 insert하는 메서드
	 * @param vo :  저장할 데이터가 저장된 FileInfoVO객체
	 * @return 작업 성공 : 1 , 작업실패 : 0
	 */
	public int insertFileinfo(FileInfoVO vo);
	
	/**
	 * db에 저장된 전체 파일 목록을 가져와 리스트에 담아서 반환하는 매서드
	 * @return 파일 정보 목록이 저장된 리스트 객체
	 */
	public List<FileInfoVO> getAllFileinfo();
	/**
	 * fileNo를 매개변수로 받아서 해당 파일 정보를 검색하여 찾은 파일정보를 반환하는 매서드
	 * @param fileNo 검색할 파일 번호
	 * @return 검색된 데이터가 저장된 FileInfoVO 객체
	 */
	public FileInfoVO getFileinfo(int fileNo);
}
