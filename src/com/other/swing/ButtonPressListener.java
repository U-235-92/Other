package com.other.swing;

import java.util.EventListener;

public interface ButtonPressListener extends EventListener {
	
	/*
	 * ���� �������� ���������� � ������� � ������(��) �����(�) ���������� ��� ����������� �������
	 */

	public void buttonPressed(ButtonPressEvent e);
}
