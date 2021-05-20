package com.samrat.i18n.app.dal;

import com.samrat.i18n.app.entity.Customer;
import org.apache.ibatis.annotations.Select;

public interface LoginMapper {

    @Select("select * from customer where id = #{id}")
    Customer getCustomerDetail();

    @Select("select language from user_preferences where id = #{id}")
    String getUserLanguage(String id);
}
