package util;

/**
 * Created with IntelliJ IDEA.
 * User: Shichirin
 * Date: 17.02.14
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
public class User {
    String username = "";
    String error = "";
    boolean loginflag = false;

    public User() {
    }

    public String GetUser() {
        return username;
    }

    public void Login(String Username) {
        loginflag = true;
        error = "";
        username = Username;
    }

    public void SetError(String Text) {
        error = Text;
    }

    public String GetError() {
        return error;
    }

    public String IsLogin() {
        if (loginflag)
            return "true";
        return "false";
    }

    public void Logout() {
        loginflag = false;
        username = "";
        error = "";
    }
}
