package org.java.studentreceiptsproject.util.security.admin;

public interface SessionHandler {

    String createSession(User user);

    User validateToken(String token);
}
