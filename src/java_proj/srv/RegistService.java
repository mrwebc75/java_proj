package java_proj.srv;

import java.util.Date;

import java_proj.dao.MemberDAO;
import java_proj.except.DuplicateMemberIdException;
import java_proj.model.MemberDTO;
import java_proj.model.MemberVO;

public class RegistService {

  private MemberDAO dao;

  // 약한결합 - 필요한 의존객체를 외부에서 주입받는다.
  public RegistService(MemberDAO dao) {
    this.dao = dao;
  }

  public void regist(MemberDTO dto) throws DuplicateMemberIdException {

    // 기존에 등록된 회원인지 확인
    if (dao.selectOne(dto.getId()) != null) {
      throw new DuplicateMemberIdException();
    }

    // VO 객체를 생성
    MemberVO vo = new MemberVO(dto.getId(), dto.getName(), dto.getEmail(), dto.getPhone(),
        dto.getPwd(), new Date());

    // DAO의 메소드를 통해서 DB에 저장
    dao.insert(vo);
    System.out.println("등록했습니다.\n");
  }

}
