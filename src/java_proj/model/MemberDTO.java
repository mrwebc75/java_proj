package java_proj.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {

  // 아이디 이름 이메일 연락처 비번 비번확인
  private String id;
  private String name;
  private String email;
  private String phone;
  private String pwd;
  private String confirmPwd;

  // 입력한 두개의 비번 일치여부 확인
  public boolean comparePwd() {
    return pwd.equals(confirmPwd);
  }

}
