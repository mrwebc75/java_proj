package java_proj.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberVO {

  private String id;
  private String name;
  private String email;
  private String phone;
  private String pwd;
  private Date regDate;

}
