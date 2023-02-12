package com.MyEJB;

import javax.ejb.Remote;

@Remote
public interface GreetingRemote {
	public int generateOTP();
	public boolean checkotp(int enter, int random);
	public void update(int i);

}
