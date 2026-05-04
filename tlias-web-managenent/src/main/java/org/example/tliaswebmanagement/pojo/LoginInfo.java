package org.example.tliaswebmanagement.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*封装登录*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginInfo {
    private String username;
    private String name;
    private Integer id;
    private String token;
}
