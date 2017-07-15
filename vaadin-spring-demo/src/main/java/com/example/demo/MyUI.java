package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SpringUI(path="")
@SpringViewDisplay
@Theme("valo")
public class MyUI extends UI implements ViewDisplay {

	private Panel springViewDisplay;

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		final VerticalLayout root = new VerticalLayout();
		root.setSizeFull();
		setContent(root);
		
		final CssLayout navigationBar = new CssLayout();
		navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		navigationBar.addComponent(createNavigationButton("View Scoped View", ViewScopedView.VIEW_NAME));
		navigationBar.addComponent(createNavigationButton("UI Scoped View", UIScopedView.VIEW_NAME));
		
		root.addComponent(navigationBar);

		springViewDisplay = new Panel();
		springViewDisplay.setSizeFull();
		root.addComponent(springViewDisplay);
		root.setExpandRatio(springViewDisplay, 1.0f);
	}

	private Button createNavigationButton(String caption, final String viewName ) {
		Button button = new Button(caption);
		button.addStyleName(ValoTheme.BUTTON_SMALL);
		button.addClickListener(e-> getUI().getNavigator().navigateTo(viewName));
		return button;
	}

	@Override
	public void showView(View view) {
		// TODO Auto-generated method stub
		springViewDisplay.setContent((Component)view);
		
	}
	


}
