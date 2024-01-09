package com.other.jaas.accessor.authentication;

import java.io.IOException;
import java.util.Scanner;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class ConsoleCallBackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		for(Callback callback : callbacks) {
			if(callback instanceof NameCallback) {
				System.out.println(((NameCallback) callback).getPrompt());
				((NameCallback) callback).setName(new Scanner(System.in).nextLine());
			}
		}
	}

}
