import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class E_Confirmation extends JFrame
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
					E_Confirmation frmConfirmation = new E_Confirmation();
					frmConfirmation.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public E_Confirmation()
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

		//LOGO
		JLabel lblLogo = new JLabel(" ");
		lblLogo.setBounds(96, 48, 295, 100);
		contentPane.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("Images/Watermark.png"));

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				E_Confirmation.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(new Color(173, 124, 109));
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

	//---------------------------------------------------------------------------------------------------------------//

		//FILL UP PANEL BUTTON
		JPanel pnlSeeReceipt = new JPanel();
		pnlSeeReceipt.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				E_Confirmation.this.dispose();
				F_Receipt frmReceipt = new F_Receipt();
            	frmReceipt.setVisible(true);
	        }
		});

		pnlSeeReceipt.setBounds(128, 388, 251, 36);
		pnlSeeReceipt.setBackground(new Color(0xad7c6d));
		pnlSeeReceipt.setLayout(null);
		contentPane.add(pnlSeeReceipt);

		JLabel lblReceipt = new JLabel("See Receipt");
		lblReceipt.setHorizontalAlignment(SwingConstants.CENTER);
		lblReceipt.setBounds(52, 5, 157, 25);
		lblReceipt.setFont(new Font("Palatino Linotype", Font.PLAIN, 16));
		lblReceipt.setForeground(Color.WHITE);
		pnlSeeReceipt.add(lblReceipt);

		//REMINDERS
		JLabel lblThankYou = new JLabel("Thank You");
		lblThankYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYou.setFont(new Font("Edwardian Script ITC", Font.BOLD, 70));
		lblThankYou.setForeground(new Color(0xad7c6d));
		lblThankYou.setBounds(88, 188, 319, 77);
		contentPane.add(lblThankYou);

		JLabel lblThankYou_1 = new JLabel("FOR TRUSTING SPRKLE DESIGNS!");
		lblThankYou_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYou_1.setForeground(new Color(173, 124, 109));
		lblThankYou_1.setFont(new Font("Palatino Linotype", Font.BOLD, 15));
		lblThankYou_1.setBounds(77, 262, 359, 22);
		contentPane.add(lblThankYou_1);

		JLabel lblThankYou_2 = new JLabel("Your order with us has been placed.");
		lblThankYou_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYou_2.setForeground(new Color(173, 124, 109));
		lblThankYou_2.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblThankYou_2.setBounds(97, 295, 319, 22);
		contentPane.add(lblThankYou_2);

		JLabel lblThankYou_3 = new JLabel("We will update you when your order is finished!");
		lblThankYou_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblThankYou_3.setForeground(new Color(173, 124, 109));
		lblThankYou_3.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblThankYou_3.setBounds(58, 314, 402, 22);
		contentPane.add(lblThankYou_3);

		//BACKGROUND
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(3, 3, 493, 493);
		lblBackground.setIcon(new ImageIcon("Images/Form Background.png"));

		contentPane.add(lblBackground);

	//---------------------------------------------------------------------------------------------------------------//
	}
}
