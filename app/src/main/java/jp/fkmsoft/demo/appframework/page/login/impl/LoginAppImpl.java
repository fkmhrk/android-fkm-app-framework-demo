package jp.fkmsoft.demo.appframework.page.login.impl;

import jp.fkmsoft.android.framework.UIHolder;
import jp.fkmsoft.android.framework.base.BaseApp;
import jp.fkmsoft.demo.appframework.page.login.LoginApp;
import jp.fkmsoft.demo.appframework.page.login.LoginUI;

/**
 * Implementation
 */
class LoginAppImpl extends BaseApp<LoginUI> implements LoginApp {
    LoginAppImpl(UIHolder<LoginUI> uiHolder) {
        super(uiHolder);
    }

    @Override
    public void login(String email, String password) {
        LoginUI ui = mUIHolder.get();
        if (ui == null) { return; }

        if (email == null || email.isEmpty()) {
            ui.showErrorMessage(LoginUI.MSG_EMAIL_EMPTY);
            return;
        }
        if (password == null || password.isEmpty()) {
            ui.showErrorMessage(LoginUI.MSG_PASSWORD_EMPTY);
            return;
        }
        // perform login process here
    }
}
