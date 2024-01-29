package java_proj.srv;

import java.util.Collection;

import java_proj.common.Util;
import java_proj.dao.MemberDAO;
import java_proj.except.MemberNotFoundException;
import java_proj.model.MemberVO;

public class SearchService {

  private MemberDAO dao;

  public SearchService(MemberDAO dao) {
    this.dao = dao;
  }

  // 검색된 회원정보 목록 출력
  public void srchList(String name) {

    Collection<MemberVO> list = dao.selectList();

    int cnt = (int) list.stream().filter(vo -> vo.getName().equals(name)).count();

    if (cnt == 0)
      throw new MemberNotFoundException();

    list.stream().filter(vo -> vo.getName().equals(name)).forEach(vo -> Util.print(vo));

  }
}
