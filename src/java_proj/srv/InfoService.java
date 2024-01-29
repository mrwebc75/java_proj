package java_proj.srv;

import java_proj.common.Util;
import java_proj.dao.MemberDAO;
import java_proj.except.MemberNotFoundException;
import java_proj.model.MemberVO;

public class InfoService {

  // 생성자함수를 통해 MemberDAO 객체를 주입받는 코드를 작성하시오.
  private MemberDAO dao;

  public InfoService(MemberDAO dao) {
    this.dao = dao;
  }

  // 아이디를 전달받아 MemberDAO에서 조회후 전달받은 MemberVO객체를 출력하는 getMember 메소드를 작성하시오.
  public void getMember(String id) {
    MemberVO vo = dao.selectOne(id);

    try {
      Util.print(vo);
    } catch (MemberNotFoundException e) {
      System.out.println(e.getMessage());
    }
  }

}
