package gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Choice;

public class AddAlarmPanel extends JPanel {
	
	public JButton btnLeggTil;
	public JButton btnAvbryt;
	public Choice chcHours;
	public Choice chcMinutes;

	/**
	 * Create the panel.
	 */
	public AddAlarmPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(29dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(35dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblOpprettAlarm = new JLabel("Opprett alarm");
		lblOpprettAlarm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblOpprettAlarm, "2, 2");
		
		JLabel lblTimer = new JLabel("Timer");
		add(lblTimer, "4, 4");
		
		JLabel lblMinutter = new JLabel("Minutter");
		add(lblMinutter, "6, 4");
		
		JLabel lblTidFr = new JLabel("Tid f\u00F8r");
		add(lblTidFr, "2, 6, right, default");
		
		chcHours = new Choice();
		add(chcHours, "4, 6");
		
		chcMinutes = new Choice();
		add(chcMinutes, "6, 6");
	
		
		btnLeggTil = new JButton("Legg til");
		add(btnLeggTil, "2, 8");
		
		btnAvbryt = new JButton("Avbryt");
		add(btnAvbryt, "4, 8, 3, 1");

		
		for(int i=0;i<24;i++){
			chcHours.add(String.valueOf(i));
		}
		
		for(int i=0;i<60;i++){
			chcMinutes.add(String.valueOf(i));

		}
	}

}
