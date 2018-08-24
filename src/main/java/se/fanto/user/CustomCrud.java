package se.fanto.user;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * @author Alejandro Duarte
 */
public class CustomCrud extends Composite<VerticalLayout> {

	private Button refresh = new Button("", VaadinIcon.REFRESH.create());
	private Button add = new Button("", VaadinIcon.PLUS.create());
	private Button edit = new Button("", VaadinIcon.PENCIL.create());

	private Grid<User> grid = new Grid<>(User.class);

	public CustomCrud() {
		initLayout();
		initBehavior();
		refresh();
	}

	private void initLayout() {
		HorizontalLayout header = new HorizontalLayout(refresh, add, edit);

		grid.setColumns("firstname", "lastname", "email", "mainrole");
		grid.addComponentColumn(user -> new Button("Delete", e -> deleteClicked(user)));
		grid.setSizeFull();

		getContent().add(header, grid);
		getContent().expand(grid);
		getContent().setSizeFull();
		getContent().setMargin(false);
		getContent().setPadding(false);
	}

	private void initBehavior() {
		grid.asSingleSelect().addValueChangeListener(e -> updateHeader());
		refresh.addClickListener(e -> refresh());
		add.addClickListener(e -> showAddDialog());
		edit.addClickListener(e -> showEditDialog());
	}

	public void refresh() {
		grid.setItems(UserRepository.findAll());
		updateHeader();
	}

	private void deleteClicked(User user) {
		showRemoveDialog(user);
		refresh();
	}

	private void updateHeader() {
		boolean selected = !grid.asSingleSelect().isEmpty();
		edit.setEnabled(selected);
	}

	private void showAddDialog() {
		// UserFormDialog dialog = new UserFormDialog("Add", new User());
		// dialog.open();
	}

	private void showEditDialog() {
		// UserFormDialog dialog = new UserFormDialog("Edit",
		// grid.asSingleSelect().getValue());
		// dialog.open();
	}

	private void showRemoveDialog(User user) {
		// RemoveDialog dialog = new RemoveDialog(user);
		// dialog.open();
	}

}
