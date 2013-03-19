package gui;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JLabel;

import org.joda.time.DateTime;

import java.awt.Font;



public class CalendarPanel extends JPanel {

	public JButton btnBack;
	public JButton btnChooseAppointment;
	public Choice choice;
	public TextArea textArea;
	public JButton btnNextWeek;
	public JLabel lblWeek;
	public JButton btnPrevWeek;
	final public int currWeek = DateTime.now().getWeekOfWeekyear();
	public int currWeekView = currWeek;
	
	/**
	 * Create the panel.
	 */
	public CalendarPanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				//ColumnSpec.decode("2dlu"),
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				//ColumnSpec.decode("171dlu"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("27dlu:grow"),
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				//RowSpec.decode("max(125dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		btnPrevWeek = new JButton("<");
		add(btnPrevWeek, "2, 2, default, bottom");
		
		JLabel lblKalenderUke = new JLabel("Kalender     -    Uke:");
		lblKalenderUke.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblKalenderUke, "4, 2, right, default");
		
		lblWeek = new JLabel(String.valueOf(currWeek));
		lblWeek.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblWeek, "6, 2");
		
		btnNextWeek = new JButton(">");
		add(btnNextWeek, "8, 2");
		
		textArea = new TextArea();
		add(textArea, "4, 4, 3, 1");
		
		choice = new Choice();
		add(choice, "4, 6");
		
		btnChooseAppointment = new JButton("Velg avtale");
		add(btnChooseAppointment, "6, 6");
		
		btnBack = new JButton("Tilbake");
		add(btnBack, "4, 8, 3, 1");

	}

}
