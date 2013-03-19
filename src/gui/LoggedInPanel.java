package gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Color;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
 
 
public class LoggedInPanel extends JPanel {
        public JTextField loggedInAsField;
        public JButton btnNyAvtale;
        JButton btnVisKalender;
        JButton btnNyGruppe;
        JButton btnVisInvitasjoner;
        JButton btnLoggUt;
 
        /**
         * Create the panel.
         */
        public LoggedInPanel() {
                setBackground(Color.WHITE);
                setLayout(new FormLayout(new ColumnSpec[] {
                		FormFactory.RELATED_GAP_COLSPEC,
                		ColumnSpec.decode("105dlu"),
                		ColumnSpec.decode("center:4dlu"),
                		ColumnSpec.decode("106dlu:grow"),
                		FormFactory.RELATED_GAP_COLSPEC,
                		ColumnSpec.decode("max(0dlu;default)"),},
                	new RowSpec[] {
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,}));
               
                JLabel lblMeny = new JLabel("Meny");
                lblMeny.setFont(new Font("Tahoma", Font.PLAIN, 20));
                add(lblMeny, "2, 1, 3, 2, center, default");
               
                loggedInAsField = new JTextField();
                loggedInAsField.setBackground(Color.WHITE);
                loggedInAsField.setEditable(false);
                add(loggedInAsField, "2, 4, 3, 1, fill, default");
                loggedInAsField.setColumns(10);
               
                btnNyAvtale = new JButton("Ny avtale");
                add(btnNyAvtale, "2, 6, 1, 5");
               
                btnVisKalender = new JButton("Vis kalender");
                add(btnVisKalender, "4, 6, 1, 5");
               
                btnNyGruppe = new JButton("Ny gruppe");
                add(btnNyGruppe, "2, 12, 1, 5");
               
                btnVisInvitasjoner = new JButton("Vis invitasjoner");
                add(btnVisInvitasjoner, "4, 12, 1, 5");
               
                JButton btnLoggUt = new JButton("Logg ut");
                add(btnLoggUt, "2, 20, 3, 1");
 
        }
 
}
