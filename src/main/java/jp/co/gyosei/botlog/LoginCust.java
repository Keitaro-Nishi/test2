package jp.co.gyosei.botlog;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginCust extends User {

    private static final long serialVersionUID = 1L;

    // �ǉ�����i�e�[�u���Ń��[�U�[�̃L�[�ƂȂ�l��ݒ肷��j
    public String custid;

    // �ǉ�����
    public String password;

    // �ǉ�����
    public String role;

    public LoginCust(CustinfoEntityImpl cust) {
    	super(cust.custid, cust.password, true, true, true, true, new ArrayList<GrantedAuthority>());
        custid = cust.custid;
        password = cust.password;
        role = cust.role;
    }
}