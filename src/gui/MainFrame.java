package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private HomePanel home;
	private RegisterPanel register;
	private LogInPanel login;
	private LoggedInPanel loggedin;
	private ViewAppointmentPanel viewapp;
	private AddAppointmentPanel addapp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		home = new HomePanel();
		register = new RegisterPanel();
		loggedin = new LoggedInPanel();
		login = new LogInPanel();
		addapp = new AddAppointmentPanel();
		viewapp = new ViewAppointmentPanel();
		
		setContentPane(home);
		home.revalidate();
		
		//Knapper til hjempanelet
		home.btnRegistrerDeg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setContentPane(register);
				register.revalidate();
			}
		});
		
		home.btnLoggInn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setContentPane(login);
				login.revalidate();
			}
		});
		
		//Knapper til registrering av bruker
		register.btnRegistrer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    String name = register.firstname.getText() +" "+ register.lastname.getText();
                    String email = register.email.getText();
                    /*
                     * createEmployee(name, email)
                     */
            }
		});
		
		register.btnTilbake.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(home);
                    home.revalidate();
            }
		});
		
		//Knapper til innlogging
		login.btnTilbake.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(home);
                    home.revalidate();
            }
		});
		
		login.btnLoggInn.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(loggedin);
                    loggedin.revalidate();
            }
		});
		
		//Knapper for innlogget bruker
		loggedin.btnLoggUt.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(home);
                    home.revalidate();
            }
		});
		
		loggedin.btnNyAvtale.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(addapp);
                    addapp.revalidate();
            }
		});
		
		//Knapper for innlegging av avtale
		addapp.btnAvbryt.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(loggedin);
                    loggedin.revalidate();
            }
		});
	}
}
