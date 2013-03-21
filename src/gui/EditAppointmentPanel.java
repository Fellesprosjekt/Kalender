package gui;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Choice;


public class EditAppointmentPanel extends JPanel {

	public JTextField txtBeskrivelse;
	public Choice chcRom;
	public Choice chcLeggTilDeltaker;
	public Choice chcStartdag;
	public Choice chcStartmnd;
	public Choice chcStartaar;
	public Choice chcStarttime;
	public Choice chcStartmin;
	public Choice chcSluttime;
	public Choice chcSluttmin;
	public JButton btnOpprett;
	public JButton btnAvbryt;
	public JButton btnLeggTil;
	public JTextArea txtrDeltakere;
	private JLabel lblDeltaker_1;
	public Choice chcFjernDeltaker;
	public JButton btnFjern;
	
	
	/**
	 * Create the panel.
	 */
	public EditAppointmentPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(36dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("25dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("25dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("32dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(25dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("25dlu"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(11dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(15dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(19dlu;default)"),}));
		
		JLabel lblLeggTilNy = new JLabel("Endre avtale");
		lblLeggTilNy.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblLeggTilNy, "2, 2, 13, 1");
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		add(lblBeskrivelse, "2, 4, right, default");
		
		txtBeskrivelse = new JTextField();
		add(txtBeskrivelse, "4, 4, 11, 1, fill, default");
		txtBeskrivelse.setColumns(10);
		
		JLabel lblDeltaker = new JLabel("Deltaker");
		add(lblDeltaker, "2, 6, right, default");
		
		chcLeggTilDeltaker = new Choice();
		add(chcLeggTilDeltaker, "4, 6, 7, 1");
		
		btnLeggTil = new JButton("Legg til");
		add(btnLeggTil, "12, 6, 3, 1");
		
		txtrDeltakere = new JTextArea();
		add(txtrDeltakere, "4, 8, 11, 3, fill, fill");
		
		lblDeltaker_1 = new JLabel("Deltaker");
		add(lblDeltaker_1, "2, 12, right, default");
		
		chcFjernDeltaker = new Choice();
		add(chcFjernDeltaker, "4, 12, 7, 1");
		
		btnFjern = new JButton("Fjern");
		add(btnFjern, "12, 12, 3, 1");
		
		JLabel lblVelgRom = new JLabel("Velg rom");
		add(lblVelgRom, "2, 14, right, default");
		
		
		chcRom = new Choice();
		add(chcRom, "4, 14, 7, 1");
		
		JLabel lblDato = new JLabel("Dato");
		add(lblDato, "2, 16, right, default");
		
		chcStartdag = new Choice();
		add(chcStartdag, "4, 16");
		
		chcStartmnd = new Choice();
		add(chcStartmnd, "6, 16");
		
		chcStartaar = new Choice();
		add(chcStartaar, "8, 16");
		
		JLabel lblStarttid = new JLabel("Starttid");
		add(lblStarttid, "10, 16, right, default");
		
		chcStarttime = new Choice();
		add(chcStarttime, "12, 16");
		
		chcStartmin = new Choice();
		add(chcStartmin, "14, 16");
		
		JLabel lblSluttid = new JLabel("Sluttid");
		add(lblSluttid, "10, 18, right, default");
		
		chcSluttime = new Choice();
		add(chcSluttime, "12, 18");
		
		chcSluttmin = new Choice();
		add(chcSluttmin, "14, 18");
		
		btnOpprett = new JButton("Endre avtale");
		add(btnOpprett, "4, 20, 3, 1");
		
		btnAvbryt = new JButton("Avbryt");
		add(btnAvbryt, "8, 20, 3, 1");

		for(int i=1;i<32;i++){
			chcStartdag.add(String.valueOf(i));
		}
		
		for(int i=1;i<13;i++){
			chcStartmnd.add(String.valueOf(i));
		}
		
		for(int i=2013;i<2017;i++){
			chcStartaar.add(String.valueOf(i));
		}
		
		for(int i=8;i<21;i++){
			chcStarttime.add(String.valueOf(i));
			chcSluttime.add(String.valueOf(i));
		}
		
		for(int i=0;i<60;i++){
			chcStartmin.add(String.valueOf(i));
			chcSluttmin.add(String.valueOf(i));
		}	
	}
}

