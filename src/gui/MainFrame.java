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
	private EditAppointmentPanel editapp;
	private CalendarPanel viewcal; 
	private AddAlarmPanel addalarm;

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
		setBounds(100, 100, 470, 320);
		home = new HomePanel();
		register = new RegisterPanel();
		loggedin = new LoggedInPanel();
		login = new LogInPanel();
		addapp = new AddAppointmentPanel();
		viewapp = new ViewAppointmentPanel();
		editapp = new EditAppointmentPanel();
		viewcal = new CalendarPanel();
		addalarm = new AddAlarmPanel();
		
		
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
		
		loggedin.btnVisKalender.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(viewcal);
                    viewcal.revalidate();
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
		
		//Knapper for visning av avtale
		viewapp.btnTilbake.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(loggedin);
                    loggedin.revalidate();
            }
		});
		
		viewapp.btnAccept.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    		viewapp.btnAccept.setEnabled(false);
		    		viewapp.btnDecline.setEnabled(false);
		    		viewapp.btnDecline.setVisible(false);
                   /*
                    * Set status
                    */
            }
		});
		
		viewapp.btnDecline.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    		viewapp.btnAccept.setEnabled(false);
		    		viewapp.btnDecline.setEnabled(false);
		    		viewapp.btnAccept.setVisible(false);
                    /*
                     * Set status
                     */
            }
		});
		
		viewapp.btnLeggTilAlarm.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    	setContentPane(addalarm);
                addalarm.revalidate();
            }
		});
		
		
		//Knapper for visning av kalender
		viewcal.btnBack.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(loggedin);
                    loggedin.revalidate();
            }
		});
		
		viewcal.btnNextWeek.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    		/*
		    		 * foreløpig ikke støtte for neste år (hvis aktuelt)
		    		 */
		    		viewcal.currWeekView += 1;
            }
		});
		
		viewcal.btnChooseAppointment.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		viewcal.btnPrevWeek.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    		/*
		    		 * foreløpig ikke støtte for forrige år (hvis aktuelt)
		    		 */
                    viewcal.currWeekView -=1;
            }
		});
	}
}
