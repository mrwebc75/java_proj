package java_proj.common;

import java_proj.dao.MemberDAO;
import java_proj.srv.DeleteService;
import java_proj.srv.InfoService;
import java_proj.srv.ListService;
import java_proj.srv.ModifyService;
import java_proj.srv.RegistService;
import java_proj.srv.SearchService;

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

  // 강한결합(Compose has-a) - 필요한 의존객체를 직접 생성한다. (유지보수 관점에서 문제점 유발)
  // 의존객체를 직접 생성하면 생성부터 메모리 관리를 위한 소멸까지 해당객체의 라이프싸이클을 개발자가 다 관리해야 한다.

  private MemberDAO dao = new MemberDAO();

  // 회원등록
  private RegistService regSrv = new RegistService(dao);

  public RegistService getRegSrv() {
    return regSrv;
  }

  // 전체리스트
  private ListService lstSrv = new ListService(dao);

  public ListService getLstSrv() {
    return lstSrv;
  }

  // 단일회원정보 -> infoSrv
  private InfoService infoSrv = new InfoService(dao);

  public InfoService getInfoSrv() {
    return infoSrv;
  }

  // 회원정보수정
  private ModifyService modifySrv = new ModifyService(dao);

  public ModifyService getModifySrv() {
    return modifySrv;
  }
  
  //회원삭제
  private DeleteService delSrv = new DeleteService(dao);
  public DeleteService getDelSrv() {
    return delSrv;
  }
  
  
  //회원검색
  private SearchService srchSrv = new SearchService(dao);
  public SearchService getSrchSrv() {
    return srchSrv;
  }
}














