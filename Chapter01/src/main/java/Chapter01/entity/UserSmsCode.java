package Chapter01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@TableName(value = "user_sms_code")
public class UserSmsCode {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String mobileNo;
    private String smsCode;
    private Long sendTime;
    private Long createTime;
}
