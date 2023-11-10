package com.sergi.C4_TA22_PT3;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sergi.C4_TA22_PT3.controller.CientificoController;
import com.sergi.C4_TA22_PT3.utils.PopulateDatabase;
import com.sergi.C4_TA22_PT3.view.AddCientificoView;
import com.sergi.C4_TA22_PT3.view.CientificoView;
import com.sergi.C4_TA22_PT3.view.EditCientificoView;

/**
 * Hello world!
 *
 */
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
		CientificoView view = new CientificoView();
		AddCientificoView addView = new AddCientificoView();
		EditCientificoView editView = new EditCientificoView();
		CientificoController cientificoController = new CientificoController (view, addView, editView); 
		cientificoController.initializeView();
	}
}
