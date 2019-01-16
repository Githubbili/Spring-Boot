package com.mapper;

import com.entity.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {
    Account select(String user, String pass);
}
