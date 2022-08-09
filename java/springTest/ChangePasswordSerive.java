package springTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dao.MemberDao;

@Component
public class ChangePasswordSerive {

	@Autowired
	private MemberDao memberDao;
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if (member == null) 
			throw new MemberNotFoundException();
		
		member.changePassword(newPwd, oldPwd);
		memberDao.update(member);
	}
}
