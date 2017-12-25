package jp.co.gyosei.botlog.domain.repository;

import jp.co.gyosei.botlog.impl.CustinfoEntityImpl;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Repository;

@Repository
public interface CustinfoRepositoryCustom extends JpaRepository<CustinfoEntityImpl, String>{

	static CustinfoEntityImpl custinfoRepositoryCustom(String custid, String password, Collection<? extends GrantedAuthority> role) {
		// TODO �����������ꂽ���\�b�h�E�X�^�u
		return null;
	}

}