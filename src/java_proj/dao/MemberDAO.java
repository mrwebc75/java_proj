package java_proj.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import java_proj.model.MemberVO;

public class MemberDAO {

  private Map<String, MemberVO> mapDB = new HashMap<String, MemberVO>();

  // MemberVO 타입의 데이터를 받아 DB에 저장하는 함수
  public void insert(MemberVO vo) {
    mapDB.put(vo.getId(), vo);
  }

  // 전달받은 id로 등록된 회원유무 확인함수
  public MemberVO selectOne(String id) {
    return mapDB.get(id);// MemberVO 객체 리턴
  }

  // 전체회원 목록
  public Collection<MemberVO> selectList() {
    return mapDB.values();
  }

  // 정보수정
  public void update(MemberVO vo) {
    mapDB.put(vo.getId(), vo);
  }

  // 회원삭제
  public void delete(String id) {
    mapDB.remove(id);
  }

}
