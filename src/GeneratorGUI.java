import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;


public class GeneratorGUI extends JFrame{

	private JFrame frmPasswordGenerator;
	private JTextField txtPassword;
	private int[] lengthOfPassword = {10,11,12,13,14,15,16,17,18,19,20};
	private JComboBox cbmLength;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GeneratorGUI window = new GeneratorGUI();
					window.frmPasswordGenerator.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GeneratorGUI() {
		initialize();
		System.out.println("----OPENING GUI ------");
		Generator generator = new Generator();
		String password = Generator.generatePassword(5);
		System.out.println("PASSWORD IS: " + password);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPasswordGenerator = new JFrame();
		frmPasswordGenerator.setTitle("Password Generator");
		frmPasswordGenerator.setBounds(100, 100, 665, 344);
		frmPasswordGenerator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNumberOfCharacters = new JLabel("Number of Characters:");
		lblNumberOfCharacters.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JLabel lblPasswordGenerator = new JLabel("PASSWORD GENERATOR");
		lblPasswordGenerator.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		cbmLength = new JComboBox();
		for(int len : lengthOfPassword)
		{
			cbmLength.addItem(len);
		}
		cbmLength.setSelectedIndex(0);
		System.out.println("Default: " + cbmLength.getSelectedItem());
		
		JCheckBox chkUpper = new JCheckBox("Upper Case");
		chkUpper.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JCheckBox chkLower = new JCheckBox("Lower Case");
		chkLower.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JCheckBox chkNumbers = new JCheckBox("Numbers");
		chkNumbers.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		JCheckBox chkSymbols = new JCheckBox("Symbols");
		chkSymbols.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		
		txtPassword = new JTextField();
		txtPassword.setEditable(false);
		txtPassword.setColumns(20);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		GroupLayout groupLayout = new GroupLayout(frmPasswordGenerator.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(202)
							.addComponent(lblPasswordGenerator, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumberOfCharacters)
								.addComponent(chkUpper))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(chkLower)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(chkNumbers))
								.addComponent(cbmLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(chkSymbols, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addGap(45))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(txtPassword, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(168)
					.addComponent(btnGenerate, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(13)
					.addComponent(lblPasswordGenerator, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumberOfCharacters)
						.addComponent(cbmLength, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(chkUpper)
						.addComponent(chkLower)
						.addComponent(chkNumbers)
						.addComponent(chkSymbols))
					.addGap(18)
					.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnGenerate, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
					.addContainerGap())
		);
		frmPasswordGenerator.getContentPane().setLayout(groupLayout);
	}
}
