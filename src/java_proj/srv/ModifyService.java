package java_proj.srv;

import java_proj.dao.MemberDAO;
import java_proj.except.MemberNotFoundException;
import java_proj.except.PasswordNotMatchingException;
import java_proj.model.MemberDTO;
import java_proj.model.MemberVO;

public class ModifyService {

  private MemberDAO dao;

  public ModifyService(MemberDAO dao) {
    this.dao = dao;
  }

  public void change(MemberDTO dto) {

    MemberVO vo = dao.selectOne(dto.getId());

    // 실제 존재하는 id인지 유효성 검사
    if (vo == null) {
      throw new MemberNotFoundException();
    } else if (!vo.getPwd().equals(dto.getPwd())) {
      throw new PasswordNotMatchingException();
    }

    // MemberVO
    vo.setId(dto.getId());
    vo.setName(dto.getName());
    vo.setEmail(dto.getEmail());
    vo.setPhone(dto.getPhone());
    vo.setPwd(dto.getConfirmPwd());

    dao.update(vo);
    System.out.println("수정했습니다.");
  }
}
