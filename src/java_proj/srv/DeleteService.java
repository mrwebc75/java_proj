package java_proj.srv;

import java_proj.dao.MemberDAO;
import java_proj.except.MemberNotFoundException;
import java_proj.model.MemberVO;

public class DeleteService {

  private MemberDAO dao;

  public DeleteService(MemberDAO dao) {
    this.dao = dao;
  }

  public void delMember(String id) {

    MemberVO vo = dao.selectOne(id);

    if (vo == null)
      throw new MemberNotFoundException();

    dao.delete(id);
    System.out.println("삭제했습니다.");
  }
}
