package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import springTest.ChangePasswordSerive;
import springTest.MemberNotFoundException;
import springTest.WrongIdPasswordException;

public class MainForCPS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		ChangePasswordSerive cps = ctx.getBean("changePasswordSerive",ChangePasswordSerive.class);
		
		try {
			cps.changePassword("dlagywn1", "1111", "2222");
			System.out.println("성공");
		} catch (MemberNotFoundException e) {
			// TODO: handle exception
			System.out.println("회원 데이터가 존재하지않습니다");
		} catch (WrongIdPasswordException e) {
			// TODO: handle exception
			System.out.println("암호가 올바르지않습니다.");
		}
		ctx.close();
	}
}
