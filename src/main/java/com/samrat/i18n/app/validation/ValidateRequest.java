package com.samrat.i18n.app.validation;

import com.samrat.i18n.app.exception.MyCustomException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ValidateRequest {

    public void validate(String userName) {
        if (!StringUtils.hasText(userName)) {
            throw new MyCustomException("user.name.not.null");
        } else if (userName.startsWith("test")) {
            throw new MyCustomException("user.login.denied", new Object[]{userName});
        }
    }
}
