package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;


@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		setContent(new Button("Click Me",e -> { Notification.show("Hello spring_vaadin user"); }));

	}

}
