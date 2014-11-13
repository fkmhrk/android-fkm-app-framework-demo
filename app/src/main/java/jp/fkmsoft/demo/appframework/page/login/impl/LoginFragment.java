package jp.fkmsoft.demo.appframework.page.login.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import jp.fkmsoft.android.framework.base.BaseFragment;
import jp.fkmsoft.android.framework.impl.UIHolderImpl;
import jp.fkmsoft.demo.appframework.R;
import jp.fkmsoft.demo.appframework.page.login.LoginApp;
import jp.fkmsoft.demo.appframework.page.login.LoginUI;

/**
 * Fragment for login page
 */
public class LoginFragment extends BaseFragment<LoginApp> implements LoginUI {
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @InjectView(R.id.edit_email)
    EditText mEmailEdit;

    @InjectView(R.id.edit_password)
    EditText mPasswordEdit;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.inject(this, root);

        return root;
    }

    @Override
    protected LoginApp createApp() {
        return new LoginAppImpl(new UIHolderImpl<LoginUI>(this));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    // UI event
    @OnClick(R.id.button_login)
    void loginClicked(View v) {
        String email = mEmailEdit.getText().toString();
        String password = mPasswordEdit.getText().toString();

        mApp.login(email, password);
    }

    // UI API
    @Override
    public void showErrorMessage(int messageId) {
        String message = toMessage(messageId);

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private String toMessage(int messageId) {
        switch (messageId) {
        case LoginUI.MSG_EMAIL_EMPTY: return getString(R.string.msg_email_empty);
        case LoginUI.MSG_PASSWORD_EMPTY: return getString(R.string.msg_password_empty);
        }
        return "";
    }
}
