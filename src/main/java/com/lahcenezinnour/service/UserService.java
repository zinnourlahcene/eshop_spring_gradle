package com.lahcenezinnour.service;

import com.lahcenezinnour.domain.Users;
import com.lahcenezinnour.util.Login;

/**
 * Created by lahcen on 4/4/17.
 */
public interface UserService extends InterfaceService<Users, Integer>{
  void test();

  Login login(String userEmail, String userPassword);

  Users findByUserEmail(String userEmail);

}
