package gui;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;
 
 
public class ViewAppointmentPanel extends JPanel {
        public JTextField roomField;
        public JTextField endField;
        public JTextField startField;
        public JTextArea descriptionField;
        public JTextArea participantsField;
        public JButton btnTilbake;
        public JButton btnAccept;
        public JButton btnDecline;
        public JLabel lblAvtale;
       
 
        /**
         * Create the panel.
         */
        public ViewAppointmentPanel() {
                setLayout(new FormLayout(new ColumnSpec[] {
                		FormFactory.RELATED_GAP_COLSPEC,
                		FormFactory.DEFAULT_COLSPEC,
                		FormFactory.RELATED_GAP_COLSPEC,
                		ColumnSpec.decode("85dlu:grow"),
                		FormFactory.RELATED_GAP_COLSPEC,
                		FormFactory.DEFAULT_COLSPEC,
                		FormFactory.RELATED_GAP_COLSPEC,
                		ColumnSpec.decode("max(6dlu;default)"),},
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
                		RowSpec.decode("max(32dlu;default)"),
                		FormFactory.RELATED_GAP_ROWSPEC,
                		RowSpec.decode("max(31dlu;default)"),
                		FormFactory.RELATED_GAP_ROWSPEC,
                		RowSpec.decode("max(7dlu;default)"),
                		FormFactory.RELATED_GAP_ROWSPEC,
                		FormFactory.DEFAULT_ROWSPEC,
                		FormFactory.RELATED_GAP_ROWSPEC,
                		RowSpec.decode("max(0dlu;default):grow"),}));
               
                lblAvtale = new JLabel("Avtale");
                lblAvtale.setFont(new Font("Tahoma", Font.PLAIN, 20));
                add(lblAvtale, "2, 1, 5, 3, center, default");
               
                JLabel lblStart = new JLabel("Start");
                lblStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(lblStart, "2, 4, right, default");
               
                startField = new JTextField();
                startField.setBackground(Color.WHITE);
                startField.setEditable(false);
                add(startField, "4, 4, 3, 1, fill, default");
                startField.setColumns(10);
               
                JLabel lblSlutt = new JLabel("Slutt");
                lblSlutt.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(lblSlutt, "2, 6, right, default");
               
                endField = new JTextField();
                endField.setBackground(Color.WHITE);
                endField.setEditable(false);
                add(endField, "4, 6, 3, 1, fill, default");
                endField.setColumns(10);
               
                JLabel lblRom = new JLabel("Rom");
                lblRom.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(lblRom, "2, 8, right, default");
               
                roomField = new JTextField();
                roomField.setBackground(Color.WHITE);
                roomField.setEditable(false);
                add(roomField, "4, 8, 3, 1, fill, default");
                roomField.setColumns(10);
               
                JLabel lblBeskrivelse = new JLabel("Beskrivelse");
                lblBeskrivelse.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(lblBeskrivelse, "2, 10, right, default");
               
                descriptionField = new JTextArea();
                descriptionField.setEditable(false);
                add(descriptionField, "4, 10, 3, 1, fill, fill");
               
                JLabel lblDeltakere = new JLabel("Deltakere");
                lblDeltakere.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(lblDeltakere, "2, 12, right, default");
               
                participantsField = new JTextArea();
                participantsField.setEditable(false);
                add(participantsField, "4, 12, 3, 1, fill, fill");
               
                btnAccept = new JButton("Godta");
                btnAccept.setBackground(Color.GREEN);
                btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(btnAccept, "4, 14");
               
                btnDecline = new JButton("Avsl\u00E5");
                btnDecline.setBackground(Color.RED);
                btnDecline.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(btnDecline, "6, 14");
               
                btnTilbake = new JButton("Tilbake");
                btnTilbake.setFont(new Font("Tahoma", Font.PLAIN, 14));
                add(btnTilbake, "4, 16, 3, 1");
 
        }
 
}