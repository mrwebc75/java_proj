package java_proj.srv;

import java.util.Collection;

import java_proj.common.Util;
import java_proj.dao.MemberDAO;
import java_proj.model.MemberVO;

public class ListService {
  private MemberDAO dao;

  // 생성자함수를 통한 의존객체 주입
  public ListService(MemberDAO dao) {
    this.dao = dao;
  }

  // 전체회원정보 목록 출력 함수
  public void getList() {
    Collection<MemberVO> list = dao.selectList();

    list.stream().forEach(vo -> Util.print(vo));
  }

}
