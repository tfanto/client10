package se.fanto.ui;

import org.vaadin.tabs.PagedTabs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.router.Route;

import se.fanto.user.CustomCrud;

@Route("")
public class VaadinUI extends Composite<PagedTabs> {

	private static final long serialVersionUID = -8149054919619312715L;

	public VaadinUI() {
		getContent().setSizeFull();

		addTab(new CustomCrud());
	}

	private void addTab(Component content) {
		getContent().add(content, content.getClass().getSimpleName());
	}

}
