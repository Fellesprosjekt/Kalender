package gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomePanel extends JPanel {
	public JButton btnRegistrerDeg;
	
	public HomePanel() {
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(106dlu;default)"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(106dlu;default)"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(21dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblHovedmeny = new JLabel("Hovedmeny");
		lblHovedmeny.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		add(lblHovedmeny, "2, 4, 3, 1, center, default");
		
		JButton btnLoggInn = new JButton("Logg inn");
		add(btnLoggInn, "2, 8, 1, 3");
		
		btnRegistrerDeg = new JButton("Registrer deg");
		add(btnRegistrerDeg, "4, 8, 1, 3");
	}

	
}
