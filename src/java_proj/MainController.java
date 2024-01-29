package java_proj;

import java.util.Scanner;

import java_proj.cmd.Command;
import java_proj.cmd.HandlerMapping;
import java_proj.common.Util;

public class MainController {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    Command cmd = null;

    while (true) {
      Util.help();

      System.out.println("명령어를 입력하세요");
      String userInput = sc.nextLine();

      // 사용자가 입력한 정보를 빈칸으로 구분하여 배열로 저장
      String[] userInputs = userInput.split(" ");

      if (userInput.startsWith("new")) {// "new" 로 시작한다면
        cmd = HandlerMapping.getInstance().getCommand("new");
        cmd.execute(userInputs);

      } else if (userInput.compareToIgnoreCase("list") == 0) {
        cmd = HandlerMapping.getInstance().getCommand("list");
        cmd.execute(userInputs);

      } else if (userInput.startsWith("info")) {
        cmd = HandlerMapping.getInstance().getCommand("info");
        cmd.execute(userInputs);

      } else if (userInput.startsWith("modify")) {
        cmd = HandlerMapping.getInstance().getCommand("modify");
        cmd.execute(userInputs);

      } else if (userInput.startsWith("del")) {
        cmd = HandlerMapping.getInstance().getCommand("del");
        cmd.execute(userInputs);

      } else if (userInput.compareToIgnoreCase("help") == 0) {

      } else if (userInput.compareToIgnoreCase("exit") == 0) {

      } else {

      } // end of if

    } // end of while

  }
}
