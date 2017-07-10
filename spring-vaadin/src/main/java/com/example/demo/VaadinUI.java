package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6493427860323504176L;
	CustomerRepository repo;
	Grid<Customer> grid;
	TextField filter = new TextField();
	
	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		setContent(new Button("Click Me",e-> Notification.show("Hello Spring+Vaadin User")));
		filter.setPlaceholder("Filter by last name");
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e-> listCustomers(e.getValue()));
		VerticalLayout mainLayout = new VerticalLayout(filter, grid);
		setContent(mainLayout);
		listCustomers(null);
	}

	/**
	 * @param repo
	 */
	@Autowired
	public VaadinUI(CustomerRepository repo) {
		super();
		this.repo = repo;
		this.grid = new Grid<>(Customer.class);
	}
	
	private void listCustomers(String filterText) {
		if ( StringUtils.isEmpty(filterText) ) {
			grid.setItems(repo.findAll());
		} else {
			grid.setItems(repo.findByLastNameContainingIgnoreCase(filterText));
		}
	}

	
	
	
	
	
}
