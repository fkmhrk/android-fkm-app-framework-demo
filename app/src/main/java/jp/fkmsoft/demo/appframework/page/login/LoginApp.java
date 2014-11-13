package jp.fkmsoft.demo.appframework.page.login;

import jp.fkmsoft.android.framework.App;

/**
 * App for login page
 */
public interface LoginApp extends App {
    void login(String email, String password);
}
