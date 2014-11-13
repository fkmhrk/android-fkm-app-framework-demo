package jp.fkmsoft.demo.appframework.page.login;

import jp.fkmsoft.android.framework.UI;

/**
 * UI for login page
 */
public interface LoginUI extends UI {

    public static final int MSG_EMAIL_EMPTY = 1;
    public static final int MSG_PASSWORD_EMPTY = 2;

    void showErrorMessage(int messageId);
}
