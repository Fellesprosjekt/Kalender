package gui;


import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;

import exceptions.DateTimeException;
import exceptions.RoomBookedException;
import exceptions.RoomSizeException;

import appLogic.Appointment;
import appLogic.Employee;
import appLogic.MainLogic;
import appLogic.Room;

public class MainFrame extends JFrame {

	private MainLogic main; 
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
	
	private void init() {
		//legger inn brukere til innlogging
		//legger inn brukere i opprett avtale
		//legger inn brukere i endre avtale
		for (Employee e : Employee.employees) {
			login.choice.add(e.toString()); 
			addapp.chcDeltaker.add(e.toString());
			editapp.chcLeggTilDeltaker.add(e.toString());
			editapp.chcFjernDeltaker.add(e.toString());
		}
		for (Room r : Room.rooms) {
			addapp.chcRom.add(r.toString());
			editapp.chcRom.add(r.toString());
		}
		
		
	}
	//END INIT

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		main = new MainLogic();
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
		init(); 
		
		
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
	
		
		//Knapper for innlogging
		login.btnTilbake.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(home);
                    home.revalidate();
            }
		});
		
		login.btnLoggInn.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent event) {
                    if (login.choice.getSelectedItem() != "Velg bruker...") {
                    	setContentPane(loggedin);
	                    loggedin.revalidate();
	                    main.logInEmployee(Employee.getEmployee(login.choice.getSelectedItem()));
	                    loggedin.loggedInAsField.setText("Logget inn som: " + MainLogic.currentUser.toString()); 
                    }
            }
		});
		
		//Knapper for innlogget bruker
		loggedin.btnLoggUt.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(home);
                    home.revalidate();
                    main.logInEmployee(null); 
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
                    viewcal.showWeek(viewcal.currWeek);
                    viewcal.addChoices(); 
            }
		});
		
		
		/*
		 * START LEGG INN AVTALE
		 */
		addapp.btnAvbryt.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(loggedin);
                    loggedin.revalidate();
            }
		});
		
		addapp.btnLeggTil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				addapp.addUser(Employee.getEmployee(addapp.chcDeltaker.getSelectedItem()));
				/*
				 * Hente ut gruppe også
				 * Sjekk addUser i panelet
				 */
			}
		});
		
		addapp.btnOpprett.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(addapp.chcRom.getSelectedItem().equals(" ") || addapp.chcStartaar.getSelectedItem().equals(" ")
						|| addapp.chcStartmnd.equals(" ") || addapp.chcStartdag.getSelectedItem().equals(" ")
						|| addapp.chcStarttime.equals(" ") || addapp.chcStartmin.equals(" ")
						|| addapp.chcSluttime.equals(" ") || addapp.chcSluttmin.equals(" ")
						|| addapp.txtBeskrivelse.equals(" ") || addapp.deltakere.isEmpty()) 
				{
					//Ikke opprett avtale
				} else {
					String desc = addapp.txtBeskrivelse.getText();
					Room room = Room.getRoom(addapp.chcRom.getSelectedItem()); 
					Employee leader = MainLogic.currentUser; 
					int year = Integer.parseInt(addapp.chcStartaar.getSelectedItem());
					int month = Integer.parseInt(addapp.chcStartmnd.getSelectedItem());
					int day = Integer.parseInt(addapp.chcStartdag.getSelectedItem());
					int hourStart = Integer.parseInt(addapp.chcStarttime.getSelectedItem());
					int minStart = Integer.parseInt(addapp.chcStartmin.getSelectedItem());
					int hourEnd = Integer.parseInt(addapp.chcSluttime.getSelectedItem());
					int minEnd = Integer.parseInt(addapp.chcSluttmin.getSelectedItem());
					try {
						DateTime start = new DateTime(year, month, day, hourStart, minStart, 0);
						DateTime end = new DateTime(year, month, day, hourEnd, minEnd, 0);
						new Appointment(desc, room, leader, addapp.deltakere, start, end);
						System.out.println("Avtale opprettet!");
						setContentPane(loggedin);
	                    loggedin.revalidate();
					} catch (DateTimeException e1) {
						System.out.println("DateTimeException");
					} catch (RoomBookedException e1) {
						System.out.println("RoomBookedException");
					} catch (RoomSizeException e1) {
						System.out.println("RoomSizeException");
					} catch (IllegalFieldValueException e1) {
						System.out.println("Ugyldig dato!");
					}
				}
			}
		});
		/*
		 * END LEGG INN AVTALE
		 */

		
		
		//Knapper for visning av avtale
		viewapp.btnTilbake.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(viewcal);
                    viewcal.revalidate();
            }
		});
		
		viewapp.btnAccept.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    		viewapp.viewStatusCurrentUser(viewapp.descriptionField.getText());
		    		/*
		    		 * Må resettes
		    		 */
                   /*
                    * Set status
                    */
            }
		});
		
		viewapp.btnDecline.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
		    		viewapp.viewStatusCurrentUser(viewapp.descriptionField.getText());
		    		/*
		    		 * Må resettes
		    		 */
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
		
		//Knapper for opprettelse av alarm
		addalarm.btnAvbryt.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    setContentPane(viewapp);
                    viewapp.revalidate();
            }
		});
		
		addalarm.btnLeggTil.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                   
		    		/*
                     * Opprett alarm for currentUser
                     */
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
		    		viewcal.currWeekView += 1;
		    		viewcal.lblWeek.setText("" + viewcal.currWeekView); 
		    		viewcal.showWeek(viewcal.currWeekView);
            }
		});
		
		viewcal.btnChooseAppointment.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (!viewcal.choice.getSelectedItem().equals("Velg avtale...")) {
					
					viewapp.showAppointment(viewcal.choice.getSelectedItem());
					viewapp.viewStatusCurrentUser(viewapp.descriptionField.getText());
					setContentPane(viewapp);
                    viewapp.revalidate();
				}
			}
		});
		
		viewcal.btnPrevWeek.addMouseListener(new MouseAdapter() {
		    @Override
            public void mouseClicked(MouseEvent e) {
                    viewcal.currWeekView -=1;
                    viewcal.lblWeek.setText("" + viewcal.currWeekView);
                    viewcal.showWeek(viewcal.currWeekView);
            }
		});
	}
}
