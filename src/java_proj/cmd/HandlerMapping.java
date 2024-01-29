package java_proj.cmd;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

  // 명령어와 command 객체를 서로 연결시켜 주는 역할
  Map<String, Command> cmdMap = new HashMap<String, Command>();

  // 싱글톤 작업
  private static HandlerMapping instance;

  public static HandlerMapping getInstance() {
    if (instance == null) {
      instance = new HandlerMapping();
    }
    return instance;
  }

  // 팩토리 패턴
  private HandlerMapping() {
    cmdMap.put("new", new RegistCommand());
    cmdMap.put("list", new ListCommand());
//    cmdMap.put("modify", new ModifyCommand());
//    cmdMap.put("del", new DelCommand());
//    cmdMap.put("info", new InfoCommand());
//    cmdMap.put("search", new SearchCommand());    
  }

  // 클라이언트에 알맞은 Command 객체를 공급하는 함수
  public Command getCommand(String cmd) {
    return cmdMap.get(cmd);
  }

}
