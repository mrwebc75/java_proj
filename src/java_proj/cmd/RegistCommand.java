package java_proj.cmd;

import java_proj.common.Factory;
import java_proj.common.Util;
import java_proj.except.DuplicateMemberIdException;
import java_proj.model.MemberDTO;
import java_proj.srv.RegistService;

public class RegistCommand implements Command {

  @Override
  public void execute(String[] userInputs) {

    // 유효성검사 - 전달받은 정보의 개수를 확인
    if (userInputs.length != 7) {
      System.out.println("입력하신 정보가 형식에 맞지 않습니다. 다시 입력해 주세요~!");
      Util.help();
      return;
    }

    // 전달받은 데이터를 DTO에 담는다.
    // MemberDTO dto = new MemberDTO(userInputs[1], userInputs[2], userInputs[3],
    // userInputs[4], userInputs[5], userInputs[6]);
    MemberDTO dto = new MemberDTO();
    dto.setId(userInputs[1]);
    dto.setName(userInputs[2]);
    dto.setEmail(userInputs[3]);
    dto.setPhone(userInputs[4]);
    dto.setPwd(userInputs[5]);
    dto.setConfirmPwd(userInputs[6]);

    // 유효성검사 -비번일치 여부
    if (!dto.comparePwd()) { // dto.comparePwd() == false 와 같은 표현
      System.out.println("입력하신 비번이 일치하지 않습니다.");
      return;
    }

    // 서비스 객체를 통해 비지니스로직 처리
    // 의존주입(DI) - 이미 만들어져 있는 객체를 주입받아서 기능을 사용할 수 있게 만드는 것을 뜻한다.
    // 약한결합(Association has-a) : 누군가가 생성한 것을 주입받아 사용하기만 하면 되므로 개발자가 직접 관리할 것이 적어진다는
    // 장점이 있다.
    RegistService regSrv = Factory.getInstance().getRegSrv();

    try {
      regSrv.regist(dto);
    } catch (DuplicateMemberIdException e) {
      System.out.println("에러 : " + e.getMessage());
    }

  }

}
