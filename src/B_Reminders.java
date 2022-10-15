import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


import java.awt.event.*;

public class B_Reminders extends JFrame
{
	JPanel contentPane;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					B_Reminders frmHomePage = new B_Reminders();
					frmHomePage.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public B_Reminders()
	{
	//---------------------------------------------------------------------------------------------------------------//

		//CONTENT PANE
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0xad7c6d));
		contentPane.setBorder(new LineBorder(new Color(0xad7c6d), 3));
		contentPane.setLayout(null);

		//FRAMES
		setContentPane(contentPane);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		setLocationRelativeTo(null);

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				B_Reminders.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(new Color(173, 124, 109));
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);


	//---------------------------------------------------------------------------------------------------------------//

		//FILL UP PANEL BUTTON
		JPanel pnlFillUp = new JPanel();
		pnlFillUp.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				B_Reminders.this.dispose();
            	C_ClientInfo frmClientInfo = new C_ClientInfo();
            	frmClientInfo.setVisible(true);
	        }
		});

		pnlFillUp.setBounds(128, 380, 251, 36);
		pnlFillUp.setBackground(new Color(0xad7c6d));
		pnlFillUp.setLayout(null);
		contentPane.add(pnlFillUp);

		JLabel lblFillUp = new JLabel("Fill Up Order Form");
		lblFillUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblFillUp.setBounds(52, 8, 157, 25);
		lblFillUp.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblFillUp.setForeground(Color.WHITE);
		pnlFillUp.add(lblFillUp);

		//REMINDERS
		JLabel lblReminders = new JLabel("R E M I N D E R S :");
		lblReminders.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblReminders.setForeground(new Color(0xad7c6d));
		lblReminders.setBounds(59, 229, 151, 22);
		contentPane.add(lblReminders);

		JLabel lblReminders_1 = new JLabel("\u25CF Please input the complete details of your order.");
		lblReminders_1.setForeground(new Color(173, 124, 109));
		lblReminders_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblReminders_1.setBounds(88, 250, 359, 22);
		contentPane.add(lblReminders_1);

		JLabel lblReminders_2 = new JLabel("\u25CF Payment First and No Refund Policy.");
		lblReminders_2.setForeground(new Color(173, 124, 109));
		lblReminders_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblReminders_2.setBounds(88, 272, 402, 22);
		contentPane.add(lblReminders_2);

		JLabel lblReminders_3 = new JLabel("\u25CF The processing of orders will take 3-5 days.");
		lblReminders_3.setForeground(new Color(173, 124, 109));
		lblReminders_3.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblReminders_3.setBounds(88, 297, 402, 22);
		contentPane.add(lblReminders_3);

		JLabel lblReminders_4 = new JLabel("\u25CF We allow three revisions per layout.");
		lblReminders_4.setForeground(new Color(173, 124, 109));
		lblReminders_4.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblReminders_4.setBounds(88, 321, 402, 22);
		contentPane.add(lblReminders_4);

		//BACKGROUND
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(3, 3, 493, 493);
		lblBackground.setIcon(new ImageIcon("Images/Form BG.png"));

		contentPane.add(lblBackground);

	//---------------------------------------------------------------------------------------------------------------//
	}
}
