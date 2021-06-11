package br.com.fiap.ultils;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.fiap.model.User;

public class AuthorizationListener implements PhaseListener{


	private static final long serialVersionUID = -1397794690105048706L;

	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = FacesContext.getCurrentInstance();
		
		
		String page = context.getViewRoot().getViewId();
		if(page.equals("/login.xhtml"))return;
		if(page.equals("/register.xhtml"))return;
		
		User user = (User) context.getExternalContext().getSessionMap().get("user");
		if(user == null) {
			NavigationHandler navigation = context.getApplication().getNavigationHandler();
			navigation.handleNavigation(context, "", "login?faces-redirect=true");
			
		}
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
}
