package Chapter01.service;

import Chapter01.common.BizException;
import Chapter01.entity.Userinfo;
import Chapter01.vo.LoginByMobileVo;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<Userinfo> {
    //获取短信验证码
    String getSmsCode(String mobile);

    //短信登录
    LoginByMobileVo loginByMobile(String mobile, String smsCode) throws BizException;

    //退出登录
    boolean loginExit(String accessToken);
}
