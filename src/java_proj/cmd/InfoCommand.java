package java_proj.cmd;

import java_proj.common.Factory;
import java_proj.common.Util;
import java_proj.srv.InfoService;

public class InfoCommand implements Command {

  @Override
  public void execute(String[] userInputs) {

    // 유효성검사 - 전달받은 정보의 개수를 확인
    if (userInputs.length != 2) {
      System.out.println("입력하신 정보가 형식에 맞지 않습니다. 다시 입력해 주세요~!");
      Util.help();
      return;
    }

    // infoSrv 주입처리
    InfoService infoSrv = Factory.getInstance().getInfoSrv();

    // infoSrv.getMember() 호출
    infoSrv.getMember(userInputs[1]);

  }

}
