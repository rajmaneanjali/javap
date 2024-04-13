package org.java.studentreceiptsproject.util.security.dao;

import org.java.studentreceiptsproject.util.security.admin.LoginRequest;
import org.java.studentreceiptsproject.util.security.admin.User;

public interface LoginDao {
  //This is login method.
  User getUserData(LoginRequest loginRequest);
}
