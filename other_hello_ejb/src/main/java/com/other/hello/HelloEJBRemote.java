package com.other.hello;

import jakarta.ejb.Remote;

@Remote
public interface HelloEJBRemote {

	void sayHello();
}
