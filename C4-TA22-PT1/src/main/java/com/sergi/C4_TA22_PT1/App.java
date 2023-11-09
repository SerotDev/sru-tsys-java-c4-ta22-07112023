package com.sergi.C4_TA22_PT1;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sergi.C4_TA22_PT1.view.AddClienteView;
import com.sergi.C4_TA22_PT1.view.ClienteView;
import com.sergi.C4_TA22_PT1.view.EditClienteView;
import com.sergi.C4_TA22_PT1.controller.ClienteController;
//import com.sergi.C4_TA22_PT1.controller.ClienteController;
import com.sergi.C4_TA22_PT1.model.Cliente;
import com.sergi.C4_TA22_PT1.services.ClienteService;
import com.sergi.C4_TA22_PT1.utils.PopulateDatabase;

public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel (UIManager.getSystemLookAndFeelClassName());
		}
		catch (UnsupportedLookAndFeelException e) {
			System.err.println(e);
		}
		catch (ClassNotFoundException e) {
			System.err.println(e);
		}
		catch (InstantiationException e) {
			System.err.println(e);
		}
		catch (IllegalAccessException e) {
			System.err.println(e);
		}
		
		//it creates the database and fill it in case of not exist
		PopulateDatabase.populateDatabaseIfNotExists();
		
		//Initialize the views
		ClienteView view = new ClienteView();
		AddClienteView addView = new AddClienteView();
		EditClienteView editView = new EditClienteView();
		ClienteController controller = new ClienteController (view, addView, editView); 
		controller.initializeView();
	}
}
