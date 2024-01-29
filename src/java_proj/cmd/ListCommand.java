package java_proj.cmd;

import java_proj.common.Factory;
import java_proj.srv.ListService;

public class ListCommand implements Command {

  private ListService lstSrv;

  @Override
  public void execute(String[] userInputs) {

    lstSrv = Factory.getInstance().getLstSrv();
    lstSrv.getList();

  }

}
