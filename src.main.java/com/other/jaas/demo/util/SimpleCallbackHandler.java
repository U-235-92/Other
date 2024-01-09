package com.other.jaas.demo.util;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;

public class SimpleCallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		Arrays.stream(callbacks).forEach(callback -> {
			if(callback instanceof NameCallback) {
				System.out.println(((NameCallback) callback).getPrompt());
				((NameCallback) callback).setName(new Scanner(System.in).nextLine());
			} else if(callback instanceof PasswordCallback) {
				System.out.println(((PasswordCallback) callback).getPrompt());
				((PasswordCallback) callback).setPassword(new Scanner(System.in).nextLine().toCharArray());
			}
		});
	}
}
