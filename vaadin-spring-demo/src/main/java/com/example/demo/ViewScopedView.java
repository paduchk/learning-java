package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = ViewScopedView.VIEW_NAME)
public class ViewScopedView extends VerticalLayout implements View {
	
	public static final String VIEW_NAME = "view";
	
	@Autowired
	private ViewGreeter viewGreeter;
	
	@Autowired
	private Greeter uiGreeter;

	@PostConstruct
	void init() {
		addComponent(new Label("This is a view scoped view : "+ this.toString()));
		addComponent(new Label(uiGreeter.sayHello()));
		addComponent(new Label(viewGreeter.sayHello()));
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		// TODO Auto-generated method stub
	}

}
