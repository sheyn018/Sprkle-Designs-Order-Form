import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class F_Receipt extends JFrame
{
	JPanel contentPane;

	static String strDriver = "com.mysql.cj.jdbc.Driver";
    static String strConn = "jdbc:mysql://localhost:3306/orderform";
    static String strUser = "linus";
    static String strPass = "password123";
    static Connection objConn;

	String TransactionNum = C_ClientInfo.TransactionNumber;
	String TransactionDate = C_ClientInfo.txtTransactionDate.getText().toString();
	String ClientNum = C_ClientInfo.ClientNum;
	String ClientName = C_ClientInfo.txtClientName.getText().toString();
	String ClientEmail = C_ClientInfo.txtClientEmail.getText().toString();
	String ClientContact = C_ClientInfo.txtClientContact.getText().toString();
	String PaymentRefNumber = C_ClientInfo.txtPaymentRefNumber.getText().toString();

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					F_Receipt frmReceipt = new F_Receipt();
					frmReceipt.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}



	public F_Receipt()
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
		setBounds(100, 100, 500, 750);
		setLocationRelativeTo(null);

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				F_Receipt.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(new Color(173, 124, 109));
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//CLIENT NUMBER
		JLabel lblClientNumber = new JLabel("Client No:");
		lblClientNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientNumber.setForeground(Color.WHITE);
		lblClientNumber.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblClientNumber.setBounds(25, 162, 68, 22);
		contentPane.add(lblClientNumber);

		JLabel lblClientNumber_1 = new JLabel(ClientNum);
		lblClientNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientNumber_1.setForeground(Color.WHITE);
		lblClientNumber_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblClientNumber_1.setBounds(95, 163, 68, 22);
		contentPane.add(lblClientNumber_1);

		//CLIENT NAME
		JLabel lblClientName = new JLabel("Client Name:");
		lblClientName.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientName.setForeground(new Color(173, 124, 109));
		lblClientName.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblClientName.setBounds(22, 185, 111, 22);
		contentPane.add(lblClientName);

		JLabel lblClientName_1 = new JLabel(ClientName);
		lblClientName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientName_1.setForeground(new Color(173, 124, 109));
		lblClientName_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		lblClientName_1.setBounds(105, 186, 126, 22);
		contentPane.add(lblClientName_1);

		//CLIENT CONTACT NUMBER
		JLabel lblClientContact = new JLabel("Contact Number:");
		lblClientContact.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientContact.setForeground(new Color(173, 124, 109));
		lblClientContact.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblClientContact.setBounds(23, 207, 141, 22);
		contentPane.add(lblClientContact);

		JLabel lblClientContact_1 = new JLabel(ClientContact);
		lblClientContact_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientContact_1.setForeground(new Color(173, 124, 109));
		lblClientContact_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		lblClientContact_1.setBounds(130, 207, 101, 22);
		contentPane.add(lblClientContact_1);

		//CLIENT EMAIL ADDRESS
		JLabel lblClientEmail = new JLabel("Email Address:");
		lblClientEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientEmail.setForeground(new Color(173, 124, 109));
		lblClientEmail.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblClientEmail.setBounds(228, 185, 120, 22);
		contentPane.add(lblClientEmail);

		JLabel lblClientEmail_1 = new JLabel(ClientEmail);
		lblClientEmail_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientEmail_1.setForeground(new Color(173, 124, 109));
		lblClientEmail_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		lblClientEmail_1.setBounds(325, 186, 153, 22);
		contentPane.add(lblClientEmail_1);

		//TRANSACTION DATE
		JLabel lblTransactionDate = new JLabel("Transaction Date:");
		lblTransactionDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransactionDate.setForeground(new Color(173, 124, 109));
		lblTransactionDate.setFont(new Font("Palatino Linotype", Font.BOLD, 13));
		lblTransactionDate.setBounds(228, 207, 126, 22);
		contentPane.add(lblTransactionDate);

		JLabel lblTransactionDate_1 = new JLabel(TransactionDate);
		lblTransactionDate_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTransactionDate_1.setForeground(new Color(173, 124, 109));
		lblTransactionDate_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 13));
		lblTransactionDate_1.setBounds(340, 207, 138, 22);
		contentPane.add(lblTransactionDate_1);

		//GRAND TOTAL
		JLabel lblGrandTotal = new JLabel("Grand Total:");
		lblGrandTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrandTotal.setForeground(new Color(173, 124, 109));
		lblGrandTotal.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblGrandTotal.setBounds(293, 535, 98, 22);
		contentPane.add(lblGrandTotal);

		JLabel lblGrandTotal_1 = new JLabel("");
		lblGrandTotal_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrandTotal_1.setForeground(new Color(173, 124, 109));
		lblGrandTotal_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblGrandTotal_1.setBounds(397, 535, 81, 22);
		contentPane.add(lblGrandTotal_1);

		//MODE OF PAYMENT
		JLabel lblPaymentMode = new JLabel("Mode of Payment:");
		lblPaymentMode.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaymentMode.setForeground(new Color(173, 124, 109));
		lblPaymentMode.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblPaymentMode.setBounds(23, 535, 110, 22);
		contentPane.add(lblPaymentMode);

		JRadioButton rdbGCash = new JRadioButton("GCash");
		rdbGCash.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		rdbGCash.setForeground(new Color(173, 124, 109));
		rdbGCash.setBounds(128, 535, 96, 22);
		rdbGCash.setEnabled(false);
		rdbGCash.setOpaque(false);
		rdbGCash.setBackground(Color.WHITE);
		contentPane.add(rdbGCash);

		JRadioButton rdbPaymaya = new JRadioButton("Paymaya");
		rdbPaymaya.setEnabled(false);
		rdbPaymaya.setForeground(new Color(173, 124, 109));
		rdbPaymaya.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		rdbPaymaya.setBackground(Color.WHITE);
		rdbPaymaya.setOpaque(false);
		rdbPaymaya.setBounds(198, 535, 86, 22);
		contentPane.add(rdbPaymaya);

		//PAYMENT REFERENCE NUMBER

		JLabel lblPaymentRefNumber = new JLabel("Payment Ref Number:");
		lblPaymentRefNumber.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaymentRefNumber.setForeground(new Color(173, 124, 109));
		lblPaymentRefNumber.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblPaymentRefNumber.setBounds(23, 560, 131, 22);
		contentPane.add(lblPaymentRefNumber);

		JLabel lblPaymentRefNumber_1 = new JLabel(PaymentRefNumber);
		lblPaymentRefNumber_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPaymentRefNumber_1.setForeground(new Color(173, 124, 109));
		lblPaymentRefNumber_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblPaymentRefNumber_1.setBounds(158, 560, 98, 22);
		contentPane.add(lblPaymentRefNumber_1);

		JLabel lblTransactionNum = new JLabel("T R A N S A C T I O N   N U M B E R");
		lblTransactionNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionNum.setForeground(Color.WHITE);
		lblTransactionNum.setFont(new Font("Palatino Linotype", Font.BOLD, 12));
		lblTransactionNum.setBounds(120, 639, 285, 22);
		contentPane.add(lblTransactionNum);

		JLabel lblTransactionNum_1 = new JLabel(TransactionNum);
		lblTransactionNum_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionNum_1.setForeground(Color.WHITE);
		lblTransactionNum_1.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		lblTransactionNum_1.setBounds(120, 657, 285, 22);
		contentPane.add(lblTransactionNum_1);


		//BROWN PANEL BACKGROUND
		JPanel pnlBrown = new JPanel();
		pnlBrown.setBounds(20, 160, 131, 27);
		pnlBrown.setBackground(new Color(173, 124, 109));
		contentPane.add(pnlBrown);

		JPanel pnlBrown_1 = new JPanel();
		pnlBrown_1.setBackground(new Color(173, 124, 109));
		pnlBrown_1.setBounds(23, 238, 455, 27);
		contentPane.add(pnlBrown_1);

		JLabel lblAttributes = new JLabel("Order ID           Description          Qty              Size              Unit Price        Total Price     ");
		lblAttributes.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttributes.setForeground(Color.WHITE);
		lblAttributes.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		pnlBrown_1.add(lblAttributes);

		 try
		    {
			 	Class.forName(strDriver);
		    	objConn = DriverManager.getConnection(strConn, strUser, strPass);

		    	String OrderID = "";
		    	String OrderSize = "";
		    	String OrderDesc = "";
		    	int OrderQty = 0;
		    	float OrderPrice = 0;
		    	float OrderTotal = 0;
		    	float GrandTotal = 0;

		    	String strSelect1 = "SELECT * FROM tblCharacteristics WHERE TransactionNum = ?";
		    	PreparedStatement objPreStatement1 = objConn.prepareStatement(strSelect1);
			    objPreStatement1.setString(1, TransactionNum);
				ResultSet objResultSet1 = objPreStatement1.executeQuery();

				String strSelect2 = "SELECT * FROM tblOrder WHERE OrderID = ?";
		    	PreparedStatement objPreStatement2 = objConn.prepareStatement(strSelect2);

				DefaultListModel<String> dlmOrderID = new DefaultListModel();
		    	DefaultListModel<String> dlmOrderDesc = new DefaultListModel();
		    	DefaultListModel<Integer> dlmOrderQty = new DefaultListModel();
		    	DefaultListModel<String> dlmOrderSize = new DefaultListModel();
		    	DefaultListModel<Float> dlmOrderPrice= new DefaultListModel();
		    	DefaultListModel<Float> dlmOrderTotal = new DefaultListModel();

				if(C_ClientInfo.rdbGCash.isSelected())
					rdbGCash.setSelected(true);
				if(C_ClientInfo.rdbPaymaya.isSelected())
					rdbPaymaya.setSelected(true);

				while(objResultSet1.next())
				{
					OrderID = objResultSet1.getString("OrderID");
					OrderSize = objResultSet1.getString("OrderSize");
					OrderQty = objResultSet1.getInt("OrderQty");
					OrderTotal = objResultSet1.getFloat("OrderTotal");
					GrandTotal = objResultSet1.getFloat("GrandTotal");

					objPreStatement2.setString(1, OrderID);
					ResultSet objResultSet2 = objPreStatement2.executeQuery();

					if(objResultSet2.next())
					{
						OrderDesc = objResultSet2.getString("OrderDesc");
						OrderPrice = objResultSet2.getFloat("OrderPrice");

						dlmOrderDesc.addElement(OrderDesc);
						dlmOrderPrice.addElement(OrderPrice);
					}

					dlmOrderID.addElement(OrderID);
					dlmOrderQty.addElement(OrderQty);
					dlmOrderSize.addElement(OrderSize);
					dlmOrderTotal.addElement(OrderTotal);

					lblGrandTotal_1.setText(String.valueOf(GrandTotal));
				}

				//ORDER ID
				JList lstOrderID = new JList(dlmOrderID);
				lstOrderID.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
				lstOrderID.setPreferredSize(new Dimension(250,147));
				lstOrderID.setBackground(Color.WHITE);
				lstOrderID.setBounds(23, 265, 68, 258);
				lstOrderID.setVisible(true);
				lstOrderID.setForeground(new Color(173, 124, 109));
				contentPane.add(lstOrderID);

				//ORDER DESC
				JList lstOrderDesc = new JList(dlmOrderDesc);
				lstOrderDesc.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
				lstOrderDesc.setBounds(91, 265, 111, 258);
				lstOrderDesc.setForeground(new Color(173, 124, 109));
				contentPane.add(lstOrderDesc);

				//ORDER QUANTITY
				JList lstOrderQty = new JList(dlmOrderQty);
				lstOrderQty.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
				lstOrderQty.setBounds(202, 265, 36, 258);
				lstOrderQty.setForeground(new Color(173, 124, 109));
				contentPane.add(lstOrderQty);

				//ORDER SIZE
				JList lstOrderSize = new JList(dlmOrderSize);
				lstOrderSize.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
				lstOrderSize.setBounds(237, 265, 92, 258);
				lstOrderSize.setForeground(new Color(173, 124, 109));
				contentPane.add(lstOrderSize);

				//UNIT PRICE
				JList lstOrderPrice = new JList(dlmOrderPrice);
				lstOrderPrice.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
				lstOrderPrice.setBounds(329, 265, 81, 258);
				lstOrderPrice.setForeground(new Color(173, 124, 109));
				contentPane.add(lstOrderPrice);

				//TOTAL PRICE
				JList lstOrderTotal = new JList(dlmOrderTotal);
				lstOrderTotal.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
				lstOrderTotal.setBounds(410, 265, 68, 258);
				lstOrderTotal.setForeground(new Color(173, 124, 109));
				contentPane.add(lstOrderTotal);
		    }

		    catch (Exception objEx)
		    {
		        System.out.println("Login failed!");
		        System.out.println(objEx.toString());
		    }


		//BACKGROUND
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(4, 4, 491, 740);
		lblBackground.setIcon(new ImageIcon("Images/Receipt BG.png"));
		contentPane.add(lblBackground);
	//---------------------------------------------------------------------------------------------------------------//
	}
}
