package com.samrat.i18n.app.service;

import com.samrat.i18n.app.dal.LoginMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.annotation.Resource;
import java.util.Locale;

@Service
public class LoginService {

    private static final String ADMIN = "Tokyo2021";
    private static final String LANG_JAPAN = "ja";
    private static final String LANG_FRANCE = "fr";

    @Resource
    private LoginMapper loginMapper;

    @Resource
    private ApplicationContext context;

    public String checkUserPermission(String userName) {
        if (ADMIN.equals(userName)) {
            return "Success";
        }
        return "Failed";
    }

    public void checkUserLanguage(String userName) {
        SessionLocaleResolver localeResolver = (SessionLocaleResolver) context.getBean("localeResolver");
        String userPreferredLanguage = loginMapper.getUserLanguage(userName);
        if (LANG_JAPAN.equalsIgnoreCase(userPreferredLanguage)) {
            localeResolver.setDefaultLocale(Locale.JAPAN);
        } else if (LANG_FRANCE.equalsIgnoreCase(userPreferredLanguage)) {
            localeResolver.setDefaultLocale(Locale.FRANCE);
        } else {
            localeResolver.setDefaultLocale(Locale.US);
        }

    }
}
