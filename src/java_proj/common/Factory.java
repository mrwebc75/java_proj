package java_proj.common;

import java_proj.srv.RegistService;

//객체를 생성하고 필요로 하는 클래스에 의존객체를 주입해주는 DI담당 클래스 
public class Factory {

  // 싱글톤작업
  private static Factory instance;

  private Factory() {
  }

  public static Factory getInstance() {
    if (instance == null) {
      instance = new Factory();
    }
    return instance;
  }

  //강한결합(Compose has-a) - 필요한 의존객체를 직접 생성한다. (유지보수 관점에서 문제점 유발)
  //의존객체를 직접 생성하면 생성부터 메모리 관리를 위한 소멸까지 해당객체의 라이프싸이클을 개발자가 다 관리해야 한다.
  RegistService regSrv = new RegistService();

  public RegistService getRegSrv() {
    return regSrv;
  }

}











