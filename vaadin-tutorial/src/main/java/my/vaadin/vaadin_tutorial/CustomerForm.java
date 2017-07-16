package my.vaadin.vaadin_tutorial;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class CustomerForm extends FormLayout {
	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private TextField email = new TextField("email");
	private NativeSelect<CustomerStatus> status = new NativeSelect<>("Status");
	private DateField birthDate = new DateField("Birthday");
	private Button save = new Button("Save");
	private Button delate = new Button("Delete");
	
	private CustomerService service = CustomerService.getInstance();
	private Customer customer;
	private MyUI myUI;
	private Binder<Customer> binder = new Binder<>(Customer.class);
	
	

	public CustomerForm(MyUI myUI) {
		this.myUI = myUI;
		setSizeUndefined();
		HorizontalLayout buttons = new HorizontalLayout(save, delate);
		addComponents(firstName,lastName,email,status,birthDate,buttons);
		
		status.setItems(CustomerStatus.values());
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(KeyCode.ENTER);
		
		binder.bindInstanceFields(this);
		
		save.addClickListener(e -> save());
		delate.addClickListener(e-> delate());
		
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
		binder.setBean(customer);
		
		delate.setVisible(customer.isPersisted());
		setVisible(true);
		firstName.selectAll();
		
	}
	
	private void delate() {
		service.delete(customer);
		myUI.updateList();
		setVisible(false);
	}

	private void save() {
		service.save(customer);
		myUI.updateList();
		setVisible(false);
	}
}

