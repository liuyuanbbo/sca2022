package Chapter01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
@TableName(value = "user_info")
public class Userinfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userId;
    private String nickName;
    private String mobileNo;
    private String password;
    private String isLogin;
    private Long loginTime;
    private String isDel;
    private Long createTime;
}
