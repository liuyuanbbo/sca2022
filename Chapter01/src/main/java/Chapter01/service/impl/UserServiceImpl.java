package Chapter01.service.impl;

import Chapter01.common.BizException;
import Chapter01.entity.UserSmsCode;
import Chapter01.entity.Userinfo;
import Chapter01.mapper.UserSmsCodeMapper;
import Chapter01.mapper.UserinfoMapper;
import Chapter01.service.UserService;
import Chapter01.vo.LoginByMobileVo;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import static Chapter01.utils.LocalDateTimeUtil.localDateTime2Stamp;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserinfoMapper, Userinfo> implements UserService {

    final UserSmsCodeMapper userSmsCodeMapper;

    @Override
    public String getSmsCode(String mobile) {
        String code = RandomStringUtils.randomNumeric(6);
        UserSmsCode userSmsCode = UserSmsCode.builder()
                .mobileNo(mobile)
                .smsCode(code)
                .sendTime(localDateTime2Stamp(null))
                .createTime(localDateTime2Stamp(null))
                .build();
        userSmsCodeMapper.insert(userSmsCode);
        return code;
    }

    @Override
    public LoginByMobileVo loginByMobile(String mobile, String smsCode) throws BizException {
        return null;
    }

    @Override
    public boolean loginExit(String accessToken) {
        return false;
    }
}
