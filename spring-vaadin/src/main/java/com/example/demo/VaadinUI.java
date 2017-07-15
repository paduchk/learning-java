package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.vaadin.annotations.Theme;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
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
	
	private final CustomerRepository repo;
	
	private final CustomerEditor editor;
	
	final Grid<Customer> grid;
	
	final TextField filter;
	
	private final Button addNewBtn;
	
	@Override
	protected void init(VaadinRequest request) {
		HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
		VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
		setContent(mainLayout);

		grid.setHeight(300,Unit.PIXELS);
		
		filter.setValueChangeMode(ValueChangeMode.LAZY);
		filter.addValueChangeListener(e -> listCustomers(e.getValue()));
		
		grid.asSingleSelect().addValueChangeListener(e -> {
			editor.editCustomer(e.getValue());
		});
		
		addNewBtn.addClickListener(e -> editor.editCustomer(new Customer("","")));
		
		editor.setChangeHandler(() -> {
			editor.setVisible(false);
			listCustomers(filter.getValue());
		});
		
		listCustomers(null);
		
	}

	/**
	 * @param repo
	 */
	@Autowired
	public VaadinUI(CustomerRepository repo, CustomerEditor editor) {
		this.repo = repo;
		this.editor = editor;
		this.grid = new Grid<>(Customer.class);
		this.filter = new  TextField();
		this.addNewBtn = new Button("New Customer",FontAwesome.PLUS_CIRCLE);
	}
	
	private void listCustomers(String filterText) {
		if ( StringUtils.isEmpty(filterText) ) {
			grid.setItems(repo.findAll());
		} else {
			grid.setItems(repo.findByLastNameContainingIgnoreCase(filterText));
		}
	}

	
	
	
	
	
}
