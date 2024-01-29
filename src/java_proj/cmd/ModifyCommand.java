package java_proj.cmd;

import java_proj.common.Factory;
import java_proj.common.Util;
import java_proj.except.MemberNotFoundException;
import java_proj.except.PasswordNotMatchingException;
import java_proj.model.MemberDTO;
import java_proj.srv.ModifyService;

public class ModifyCommand implements Command {

  @Override
  public void execute(String[] userInputs) {

    // 유효성검사 - 전달받은 정보의 개수를 확인
    if (userInputs.length != 7) {
      System.out.println("입력하신 정보가 형식에 맞지 않습니다. 다시 입력해 주세요~!");
      Util.help();
      return;
    }

    // 아이디 이름 이메일 연락처 비번 비번확인
    MemberDTO dto = new MemberDTO();
    dto.setId(userInputs[1]);
    dto.setName(userInputs[2]);
    dto.setEmail(userInputs[3]);
    dto.setPhone(userInputs[4]);
    dto.setPwd(userInputs[5]);
    dto.setConfirmPwd(userInputs[6]);

    ModifyService modifySrv = Factory.getInstance().getModifySrv();

    try {
      modifySrv.change(dto);
    } catch (MemberNotFoundException | PasswordNotMatchingException e) {
      System.out.println("에러 : " + e.getMessage());
    }

  }

}
