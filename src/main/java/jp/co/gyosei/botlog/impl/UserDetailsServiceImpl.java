package jp.co.gyosei.botlog.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;
import jp.co.gyosei.botlog.LoginCust;
import jp.co.gyosei.botlog.domain.repository.CustinfoRepositoryCustom;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustinfoRepositoryCustom custinfoRepositoryCustom;

    @Override
    public UserDetails loadUserByUsername(String custid)
            throws UsernameNotFoundException {

    	CustinfoEntityImpl cust = custinfoRepositoryCustom.findOne(custid);
		if (cust == null) {
            throw new UsernameNotFoundException("ユーザーが見つかりませんでした。");
        }

        return new LoginCust(cust);
    }
}
