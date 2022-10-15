import java.awt.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import javax.mail.internet.*;

public class C_ClientInfo extends JFrame
{
	//DATABASE DECLARATIONS
	static String strDriver = "com.mysql.cj.jdbc.Driver";
    static String strConn = "jdbc:mysql://localhost:3306/orderform";
    static String strUser = "linus";
    static String strPass = "password123";
    static Connection objConn;
    static Statement objSQLQuery;
    static ResultSet objResultSet;
    static int intIndex=0;

    //VARIABLE DECLARATIONS
    JPanel contentPane;
    static String ClientNum = "";
    static String TransactionNumber = "";

	static JTextField txtClientName;
	static JTextField txtClientContact;
	static JTextField txtClientEmail;
	static JTextField txtTransactionDate;
	static JTextField txtPaymentRefNumber;

	static JRadioButton rdbGCash;
	static JRadioButton rdbPaymaya;

	public static ArrayList<String> objOrders = new ArrayList<String>();
	private JLabel lblLogo;
	static JTextField txtLogo;
	static JTextField txtProductAds;
	static JTextField txtShopTemplate;
	static JTextField txtProductLabel;
	static JTextField txtCardLayout;
	static JTextField txtCoverPhoto;

	static String LogoQty = "";
	static String ProductAdsQty = "";
	static String ShopTemplateQty = "";
	static String ProductLabelQty = "";
	static String CardLayoutQty = "";
	static String CoverPhotoQty = "";

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Class.forName(strDriver);
					C_ClientInfo frmClientInfo = new C_ClientInfo();
					frmClientInfo.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public C_ClientInfo()
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
		JLabel lblWatermark = new JLabel(" ");
		lblWatermark.setBounds(96, 48, 295, 100);
		contentPane.add(lblWatermark);
		lblWatermark.setIcon(new ImageIcon("Images/Watermark.png"));

		//CLOSE BUTTON
		JLabel lblCloseButton = new JLabel("x");
		lblCloseButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				C_ClientInfo.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(new Color(173, 124, 109));
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//---------------------------------------------------------------------------------------------------------------//

		//CLIENT INFO HEADER
		JLabel lblClientInfo = new JLabel("C L I E N T   I N F O R M A T I O N :");
		lblClientInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientInfo.setForeground(new Color(173, 124, 109));
		lblClientInfo.setFont(new Font("palatino linotype", Font.BOLD, 17));
		lblClientInfo.setBounds(106, 162, 308, 22);
		contentPane.add(lblClientInfo);

		//---------------------------------------------------------------------------------------------------------------//
		//TOP PART

		//CLIENT NAME
		JLabel lblClientName = new JLabel("Full Name:");
		lblClientName.setForeground(new Color(173, 124, 109));
		lblClientName.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblClientName.setBounds(31, 217, 99, 22);
		contentPane.add(lblClientName);

		txtClientName = new JTextField();
		txtClientName.setText("John Smith");
		txtClientName.setHorizontalAlignment(SwingConstants.CENTER);
		txtClientName.setFont(new Font("Arial", Font.PLAIN, 11));
		txtClientName.setForeground(Color.LIGHT_GRAY);
		txtClientName.setBounds(106, 215, 112, 20);
		txtClientName.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtClientName.setText("");
				  txtClientName.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtClientName);
		txtClientName.setColumns(10);

		//CLIENT CONTACT NUMBER
		JLabel lblClientContact = new JLabel("Contact No:");
		lblClientContact.setForeground(new Color(173, 124, 109));
		lblClientContact.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblClientContact.setBounds(31, 250, 99, 22);
		contentPane.add(lblClientContact);

		txtClientContact = new JTextField();
		txtClientContact.setText("099999999");
		txtClientContact.setFont(new Font("Arial", Font.PLAIN, 11));
		txtClientContact.setHorizontalAlignment(SwingConstants.CENTER);
		txtClientContact.setColumns(10);
		txtClientContact.setForeground(Color.LIGHT_GRAY);
		txtClientContact.setBounds(106, 250, 112, 20);
		txtClientContact.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtClientContact.setText("");
				  txtClientContact.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtClientContact);

		//CLIENT EMAIL ADDRESS
		JLabel lblClientEmail = new JLabel("Email Address:");
		lblClientEmail.setForeground(new Color(173, 124, 109));
		lblClientEmail.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblClientEmail.setBounds(228, 217, 112, 22);
		contentPane.add(lblClientEmail);

		txtClientEmail = new JTextField();
		txtClientEmail.setText("jsmith@example.com");
		txtClientEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		txtClientEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtClientEmail.setColumns(10);
		txtClientEmail.setForeground(Color.LIGHT_GRAY);
		txtClientEmail.setBounds(345, 215, 122, 20);
		txtClientEmail.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtClientEmail.setText("");
				  txtClientEmail.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtClientEmail);

		//TRANSACTION DATE
		JLabel lblTransactionDate = new JLabel("Transaction Date:");
		lblTransactionDate.setForeground(new Color(173, 124, 109));
		lblTransactionDate.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblTransactionDate.setBounds(228, 250, 112, 22);
		contentPane.add(lblTransactionDate);

		txtTransactionDate = new JTextField();
		txtTransactionDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtTransactionDate.setFont(new Font("Arial", Font.PLAIN, 11));
		txtTransactionDate.setText("MM/DD/YYYY");
		txtTransactionDate.setForeground(Color.LIGHT_GRAY);
		txtTransactionDate.setColumns(10);
		txtTransactionDate.setBounds(343, 250, 124, 20);
		contentPane.add(txtTransactionDate);

		txtTransactionDate.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtTransactionDate.setText("");
				  txtTransactionDate.setForeground(new Color(173, 124, 109));
			  }
		});

		//---------------------------------------------------------------------------------------------------------------//
		//BOTTOM LEFT PART

		//MODE OF PAYMENT
		JLabel lblPaymentMode = new JLabel("MODE OF PAYMENT:");
		lblPaymentMode.setForeground(new Color(173, 124, 109));
		lblPaymentMode.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblPaymentMode.setBounds(31, 289, 153, 22);
		contentPane.add(lblPaymentMode);

		rdbGCash = new JRadioButton("GCash");
		rdbGCash.setFont(new Font("palatino linotype", Font.PLAIN, 12));
		rdbGCash.setForeground(new Color(173, 124, 109));
		rdbGCash.setBounds(41, 309, 96, 22);
		rdbGCash.setOpaque(false);
		rdbGCash.setBackground(Color.WHITE);
		contentPane.add(rdbGCash);

		rdbPaymaya = new JRadioButton("Paymaya");
		rdbPaymaya.setForeground(new Color(173, 124, 109));
		rdbPaymaya.setFont(new Font("palatino linotype", Font.PLAIN, 12));
		rdbPaymaya.setBackground(Color.WHITE);
		rdbPaymaya.setOpaque(false);
		rdbPaymaya.setBounds(132, 309, 86, 22);
		contentPane.add(rdbPaymaya);

		ButtonGroup rdbGroup = new ButtonGroup();
		rdbGroup.add(rdbGCash);
		rdbGroup.add(rdbPaymaya);

		//PAYMENT REFERENCE NUMBER
		txtPaymentRefNumber = new JTextField();
		txtPaymentRefNumber.setText("0123456789");
		txtPaymentRefNumber.setFont(new Font("Arial", Font.PLAIN, 11));
		txtPaymentRefNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaymentRefNumber.setColumns(10);
		txtPaymentRefNumber.setForeground(Color.LIGHT_GRAY);
		txtPaymentRefNumber.setBounds(41, 362, 177, 20);
		txtPaymentRefNumber.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtPaymentRefNumber.setText("");
				  txtPaymentRefNumber.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtPaymentRefNumber);

		JLabel lblPaymentRefNumber = new JLabel("PAYMENT REF NO:");
		lblPaymentRefNumber.setForeground(new Color(173, 124, 109));
		lblPaymentRefNumber.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblPaymentRefNumber.setBounds(31, 344, 133, 22);
		contentPane.add(lblPaymentRefNumber);

		//---------------------------------------------------------------------------------------------------------------/
		//BOTTOM RIGHT PART

		//ORDER DESCRIPTION
		JLabel lblOrder = new JLabel("ORDERS:");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setForeground(new Color(173, 124, 109));
		lblOrder.setFont(new Font("palatino linotype", Font.BOLD, 13));
		lblOrder.setBounds(260, 289, 168, 22);
		contentPane.add(lblOrder);

		//Logo
		lblLogo = new JLabel("Logo");
		lblLogo.setBackground(new Color(240, 240, 240));
		lblLogo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogo.setForeground(new Color(173, 124, 109));
		lblLogo.setFont(new Font("palatino linotype", Font.PLAIN, 13));
		lblLogo.setBounds(270, 315, 79, 22);
		contentPane.add(lblLogo);

		txtLogo = new JTextField();
		txtLogo.setText("0");
		txtLogo.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogo.setForeground(Color.LIGHT_GRAY);
		txtLogo.setFont(new Font("Arial", Font.BOLD, 11));
		txtLogo.setBounds(240, 315, 22, 17);
		txtLogo.setColumns(10);
		txtLogo.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtLogo.setText("");
				  txtLogo.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtLogo);

		//Product Ads
		JLabel lblProductAds = new JLabel("Product Ads");
		lblProductAds.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductAds.setForeground(new Color(173, 124, 109));
		lblProductAds.setFont(new Font("palatino linotype", Font.PLAIN, 13));
		lblProductAds.setBackground(SystemColor.menu);
		lblProductAds.setBounds(270, 335, 79, 22);
		contentPane.add(lblProductAds);

		txtProductAds = new JTextField();
		txtProductAds.setText("0");
		txtProductAds.setHorizontalAlignment(SwingConstants.CENTER);
		txtProductAds.setForeground(Color.LIGHT_GRAY);
		txtProductAds.setFont(new Font("Arial", Font.BOLD, 11));
		txtProductAds.setColumns(10);
		txtProductAds.setBounds(240, 334, 22, 19);
		txtProductAds.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtProductAds.setText("");
				  txtProductAds.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtProductAds);

		//Shop Template
		JLabel lblShopTemplate = new JLabel("Shop Template");
		lblShopTemplate.setHorizontalAlignment(SwingConstants.LEFT);
		lblShopTemplate.setForeground(new Color(173, 124, 109));
		lblShopTemplate.setFont(new Font("palatino linotype", Font.PLAIN, 13));
		lblShopTemplate.setBackground(SystemColor.menu);
		lblShopTemplate.setBounds(270, 355, 98, 22);
		contentPane.add(lblShopTemplate);

		txtShopTemplate = new JTextField();
		txtShopTemplate.setText("0");
		txtShopTemplate.setHorizontalAlignment(SwingConstants.CENTER);
		txtShopTemplate.setForeground(Color.LIGHT_GRAY);
		txtShopTemplate.setFont(new Font("Arial", Font.BOLD, 11));
		txtShopTemplate.setColumns(10);
		txtShopTemplate.setBounds(240, 355, 22, 19);
		txtShopTemplate.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtShopTemplate.setText("");
				  txtShopTemplate.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtShopTemplate);

		//Product Label
		JLabel lblProductLabel = new JLabel("Product Label");
		lblProductLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductLabel.setForeground(new Color(173, 124, 109));
		lblProductLabel.setFont(new Font("palatino linotype", Font.PLAIN, 13));
		lblProductLabel.setBackground(SystemColor.menu);
		lblProductLabel.setBounds(395, 315, 102, 22);
		contentPane.add(lblProductLabel);

		txtProductLabel = new JTextField();
		txtProductLabel.setText("0");
		txtProductLabel.setHorizontalAlignment(SwingConstants.CENTER);
		txtProductLabel.setForeground(Color.LIGHT_GRAY);
		txtProductLabel.setFont(new Font("Arial", Font.BOLD, 11));
		txtProductLabel.setColumns(10);
		txtProductLabel.setBounds(365, 315, 22, 17);
		txtProductLabel.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtProductLabel.setText("");
				  txtProductLabel.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtProductLabel);

		JLabel lblCardLayout = new JLabel("Card Layout");
		lblCardLayout.setHorizontalAlignment(SwingConstants.LEFT);
		lblCardLayout.setForeground(new Color(173, 124, 109));
		lblCardLayout.setFont(new Font("palatino linotype", Font.PLAIN, 13));
		lblCardLayout.setBackground(SystemColor.menu);
		lblCardLayout.setBounds(395, 335, 102, 22);
		contentPane.add(lblCardLayout);

		txtCardLayout = new JTextField();
		txtCardLayout.setText("0");
		txtCardLayout.setHorizontalAlignment(SwingConstants.CENTER);
		txtCardLayout.setForeground(Color.LIGHT_GRAY);
		txtCardLayout.setFont(new Font("Arial", Font.BOLD, 11));
		txtCardLayout.setColumns(10);
		txtCardLayout.setBounds(365, 335, 22, 17);
		txtCardLayout.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtCardLayout.setText("");
				  txtCardLayout.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtCardLayout);

		JLabel lblCoverPhoto = new JLabel("Cover Photo");
		lblCoverPhoto.setHorizontalAlignment(SwingConstants.LEFT);
		lblCoverPhoto.setForeground(new Color(173, 124, 109));
		lblCoverPhoto.setFont(new Font("palatino linotype", Font.PLAIN, 13));
		lblCoverPhoto.setBackground(SystemColor.menu);
		lblCoverPhoto.setBounds(395, 355, 102, 22);
		contentPane.add(lblCoverPhoto);

		txtCoverPhoto = new JTextField();
		txtCoverPhoto.setText("0");
		txtCoverPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		txtCoverPhoto.setForeground(Color.LIGHT_GRAY);
		txtCoverPhoto.setFont(new Font("Arial", Font.BOLD, 11));
		txtCoverPhoto.setColumns(10);
		txtCoverPhoto.setBounds(365, 355, 22, 17);
		txtCoverPhoto.addMouseListener(new MouseAdapter()
		{
			  @Override
			  public void mouseClicked(MouseEvent e)
			  {
				  txtCoverPhoto.setText("");
				  txtCoverPhoto.setForeground(new Color(173, 124, 109));
			  }
		});
		contentPane.add(txtCoverPhoto);

		//---------------------------------------------------------------------------------------------------------------//

		//ERRORS
		JLabel lblClientNameError = new JLabel("");
		lblClientNameError.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientNameError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblClientNameError.setBounds(106, 235, 112, 14);
		lblClientNameError.setForeground(new Color(173, 124, 109));
		contentPane.add(lblClientNameError);

		JLabel lblClientContactError = new JLabel("");
		lblClientContactError.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientContactError.setForeground(new Color(173, 124, 109));
		lblClientContactError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblClientContactError.setBounds(76, 270, 168, 14);
		contentPane.add(lblClientContactError);

		JLabel lblClientEmailError = new JLabel("");
		lblClientEmailError.setHorizontalAlignment(SwingConstants.CENTER);
		lblClientEmailError.setForeground(new Color(173, 124, 109));
		lblClientEmailError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblClientEmailError.setBounds(317, 234, 168, 14);
		contentPane.add(lblClientEmailError);

		JLabel lblTransactionDateError = new JLabel("");
		lblTransactionDateError.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactionDateError.setForeground(new Color(173, 124, 109));
		lblTransactionDateError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblTransactionDateError.setBounds(317, 270, 168, 14);
		contentPane.add(lblTransactionDateError);

		JLabel lblPaymentModeError = new JLabel("");
		lblPaymentModeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentModeError.setForeground(new Color(173, 124, 109));
		lblPaymentModeError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblPaymentModeError.setBounds(50, 328, 134, 14);
		contentPane.add(lblPaymentModeError);

		JLabel lblPaymentRefNumError = new JLabel("");
		lblPaymentRefNumError.setHorizontalAlignment(SwingConstants.CENTER);
		lblPaymentRefNumError.setForeground(new Color(173, 124, 109));
		lblPaymentRefNumError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblPaymentRefNumError.setBounds(41, 382, 177, 14);
		contentPane.add(lblPaymentRefNumError);

		JLabel lblOrderDescError = new JLabel("");
		lblOrderDescError.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderDescError.setForeground(new Color(173, 124, 109));
		lblOrderDescError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 9));
		lblOrderDescError.setBounds(280, 382, 166, 14);
		contentPane.add(lblOrderDescError);

		//---------------------------------------------------------------------------------------------------------------//

		//PROCEED PANEL BUTTON
		JPanel pnlProceed = new JPanel();
		pnlProceed.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				 try
			     {
					 String TransactionDate = txtTransactionDate.getText().toString();
					 String ClientName = txtClientName.getText().toString();
					 String ClientContact = txtClientContact.getText().toString();
					 String ClientEmail = txtClientEmail.getText().toString();
					 String PaymentRefNumber = txtPaymentRefNumber.getText().toString();
					 String PaymentMode = "";
					 boolean boolResult = EmailValidation(ClientEmail);

					 if(rdbGCash.isSelected())
						 PaymentMode = "GCash";
					 if(rdbPaymaya.isSelected())
					     PaymentMode = "Paymaya";

					 //IF TEXT FIELDS ARE EMPTY
					 if(ClientName.isEmpty() 		|| 	ClientName.equals("John Smith") 			||
						ClientContact.isEmpty()		|| 	ClientContact.equals("09999999999") 		|| 	ContactValidation(ClientContact)==false ||
						ClientEmail.isEmpty() 		|| 	ClientEmail.equals("jsmith@example.com")	||	boolResult == false ||
						TransactionDate.isEmpty() 	||  TransactionDate.equals("MM/DD/YYYY") 		|| 	DateValidation(TransactionDate) == false ||
						PaymentMode == ""			||
						PaymentRefNumber.isEmpty() 	|| 	PaymentRefNumber.equals("0123456789") 		||
						(txtLogo.getText().equals("0") 			&& 	txtProductAds.getText().equals("0") 		&& 	txtShopTemplate.getText().equals("0") &&
						txtProductLabel.getText().equals("0")	&&	txtCardLayout.getText().equals("0") 		&& 	txtCoverPhoto.getText().equals("0") ))
					 {
						 //CLIENT NAME
						 if(ClientName.isEmpty() || ClientName.equals("John Smith") )
							 lblClientNameError.setText("Please input your name");
						 else if(ClientName.length() >50)
							 lblClientNameError.setText("Data is too long!");
						 else if(ClientName.length() <= 50 && ClientName.length()>0)
							 lblClientNameError.setText("");

						 //CLIENT CONTACT
						 if(ClientContact.isEmpty() || ClientContact.equals("09999999999") )
							 lblClientContactError.setText("Please input your number");
						 else if(ContactValidation(ClientContact)==false)
							 lblClientContactError.setText("Please input a valid contact number");
						 else if(ContactValidation(ClientContact)==true)
							 lblClientContactError.setText("");

						 //CLIENT EMAIL
						 if(ClientEmail.isEmpty() || ClientEmail.equals("jsmith@example.com"))
							 lblClientEmailError.setText("Please input your email");
						 else if(boolResult==false)
							 lblClientEmailError.setText("Please enter a valid email address!");
						 else if(boolResult==true)
							 lblClientEmailError.setText("");

						 //TRANSACTION DATE
						 if(TransactionDate.isEmpty() || TransactionDate.equals("MM/DD/YYYY"))
							 lblTransactionDateError.setText("Please input a date");
						 else if (DateValidation(TransactionDate)==false)
							 lblTransactionDateError.setText("Please enter date in MM/DD/YYYY");
						 else if (DateValidation(TransactionDate)==true)
							 lblTransactionDateError.setText("");

						 //MODE OF PAYMENT
						 if(PaymentMode=="")
							 lblPaymentModeError.setText("Please input MOP");
						 else
							 lblPaymentModeError.setText("");

						//PAYMENT REFERENCE NUMBER
						 if(PaymentRefNumber.isEmpty() || PaymentRefNumber.equals("0123456789"))
							 lblPaymentRefNumError.setText("Please input the reference number");
						 else if(PaymentRefNumber.length() > 15)
							 lblPaymentRefNumError.setText("Data is too long!");
						 else if(PaymentRefNumber.length() <=15)
							 lblPaymentRefNumError.setText("");

						//ORDER DESCRIPTION AND ORDER QUANTITY
						 if( (	txtLogo.getText().equals("0") 			|| txtLogo.getText().equals("")			)	&&
							 (	txtProductAds.getText().equals("0")		|| txtProductAds.getText().equals("")	) 	&&
							 (	txtShopTemplate.getText().equals("0") 	|| txtShopTemplate.getText().equals("")	)	&&
							 (	txtProductLabel.getText().equals("0") 	|| txtProductLabel.getText().equals("")	)	&&
							 (	txtCardLayout.getText().equals("0") 	|| txtCardLayout.getText().equals("")	) 	&&
							 (	txtCoverPhoto.getText().equals("0") || txtCoverPhoto.getText().equals("")		)	)

							 lblOrderDescError.setText("Please input number of orders");
						 else
							 lblOrderDescError.setText("");
					 }


					 //IF ALL ITEMS ARE FILLED OUT AND VALID
					 else
					 {
						 if(Integer.parseInt(txtLogo.getText())>0)
						 {
							 objOrders.add("GD-001");
							 LogoQty = txtLogo.getText().toString();
						 }

						 if(Integer.parseInt(txtProductAds.getText())>0)
						 {
							 objOrders.add("GD-002");
							 ProductAdsQty = txtProductAds.getText().toString();
						 }

						 if(Integer.parseInt(txtShopTemplate.getText()) >0)
						 {
							 objOrders.add("GD-003");
							 ShopTemplateQty = txtShopTemplate.getText().toString();
						 }

						 if(Integer.parseInt(txtProductLabel.getText()) > 0)
						 {
							 objOrders.add("GD-004");
							 ProductLabelQty = txtProductLabel.getText().toString();
						 }

						 if(Integer.parseInt(txtCardLayout.getText())>0)
						 {
							 objOrders.add("GD-005");
							 CardLayoutQty = txtCardLayout.getText().toString();
						 }

						 if(Integer.parseInt(txtCoverPhoto.getText()) > 0)
						 {
							 objOrders.add("GD-006");
							 CoverPhotoQty = txtCoverPhoto.getText().toString();
						 }

						 ClientNumber();
						 TransactionNumber();

						 objConn = DriverManager.getConnection(strConn, strUser, strPass);
						 Statement objInsert = objConn.createStatement();

						 String tblClient = "INSERT INTO tblClient (ClientNum, ClientName, ClientContact, ClientEmail, PaymentRefNumber, PaymentMode) "
						     				+ "VALUES ('"+ClientNum+"', '"+ClientName+"', '"+ClientContact +"', '"+ClientEmail+"', "
						     				+ " '"+PaymentRefNumber+"', '" +PaymentMode+ "' );" ;

						 String tblTransaction = "INSERT INTO tblTransaction (TransactionNum, TransactionDate, ClientNum) VALUES "
						     					 + "('"+TransactionNumber+"', STR_TO_DATE('"+TransactionDate+"', '%m/%d/%Y'), '"+ClientNum+"');";

						 objInsert.executeUpdate(tblClient);
						 objInsert.executeUpdate(tblTransaction);

						 System.out.print("\nRecord Added in Client and Transaction Tables\n");

						 C_ClientInfo.this.dispose();
					     D_OrderInfo frmOrderInfo = new D_OrderInfo();
					     frmOrderInfo.setVisible(true);
					 }
			     }

				 catch (Exception objEx)
			     {
		             System.out.println("ERROR RECORD NOT ADDED");
			         System.out.println(objEx.toString());
			     }

	        }
		});

		pnlProceed.setBounds(127, 410, 251, 36);
		pnlProceed.setBackground(new Color(0xad7c6d));
		pnlProceed.setLayout(null);
		contentPane.add(pnlProceed);

		JLabel lblProceed = new JLabel("Proceed to Order Details");
		lblProceed.setHorizontalAlignment(SwingConstants.CENTER);
		lblProceed.setBounds(22, 8, 219, 25);
		lblProceed.setFont(new Font("palatino linotype", Font.BOLD, 16));
		lblProceed.setForeground(Color.WHITE);
		pnlProceed.add(lblProceed);


		//BACKGROUND
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(3, 3, 493, 493);
		lblBackground.setIcon(new ImageIcon("Images/Form Background.png"));
		contentPane.add(lblBackground);


	}

	//---------------------------------------------------------------------------------------------------------------//

		//METHODS

		//CLIENT NUMBER
		public static void ClientNumber()
		{
			try
			{
				 objConn = DriverManager.getConnection(strConn, strUser, strPass);
				 objSQLQuery = objConn.createStatement();
		         String strSQLCount = "SELECT COUNT(*) from tblClient";
		         objResultSet = objSQLQuery.executeQuery(strSQLCount);
		         objResultSet.next();

		         int intRows = objResultSet.getInt(1);

		         if(intRows == 0)
		         {
		        	 ClientNum = "C001";
		         }

		         else
		         {
		            intRows = objResultSet.getInt(1) + 1;
		            String strNumberofRows = String.valueOf(intRows);

		            if(intRows < 10)
		            {
		            	ClientNum = "C00" + strNumberofRows;
		            }

		            else if(intRows >= 10 && intRows < 100)
		            {
		            	ClientNum = "C0" + strNumberofRows;
		            }

		            else
		            {
		            	ClientNum = "C" + strNumberofRows;
		            }
		         }
			}

			catch (Exception objEx)
		     {
	             System.out.println("ERROR CLIENTNUMBER");
		         System.out.println(objEx.toString());
		     }
		}

		//TRANSACTION NUMBER
		public static void TransactionNumber()
		{
			try
			{
				 objConn = DriverManager.getConnection(strConn, strUser, strPass);
				 objSQLQuery = objConn.createStatement();
		 		 String strSQLQuery = "SELECT TransactionNum FROM tblTransaction;";
		 		 objResultSet = objSQLQuery.executeQuery(strSQLQuery);

		         int intIndex;
		 		 Random Random = new Random();
		 		 String strDigits[] = new String[10];
		 		 StringBuffer Combine = new StringBuffer();

		 	 	 for(intIndex = 0; intIndex < 10; intIndex++)
		 		 {
		 			int intRandNumber = Random.nextInt(9);
		 			String strRandNumber = String.valueOf(intRandNumber);
		 			strDigits[intIndex] = strRandNumber;
		 			Combine.append(strDigits[intIndex]);
		 		 }

		         String AppendedNumber = Combine.toString();

		         if(!objResultSet.next())
		         {
		        	 TransactionNumber = AppendedNumber;
		         }

		         else
		         {
		        	 TransactionNumber = AppendedNumber;

			         while (objResultSet.next())
			         {
			        	 String strData = objResultSet.getString("TransactionNum");

			        	 if(AppendedNumber.equals(strData))
			        	 {
			        		 for(intIndex = 0; intIndex < 10; intIndex++)
					 		 {
					 			int intRandNumber = Random.nextInt(9);
					 			String strRandNumber = String.valueOf(intRandNumber);
					 			strDigits[intIndex] = strRandNumber;
					 			Combine.append(strDigits[intIndex]);
					 		 }

			        		 TransactionNumber = Combine.toString();
			        	 }

			         }
		         }
			}

			catch (Exception objEx)
		    {
		        System.out.println("ERROR TRANSACTION NUMBER");
			    System.out.println(objEx.toString());
		    }
		}

		//TRANSACTION DATE VALIDATION
		public static boolean DateValidation(String TransactionDate)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf.setLenient(false);

			try
			{
				Date dt = sdf.parse(TransactionDate);
			}

			catch (ParseException e)
			{
				return false;
			 }
			//RETURN TRUE IF VALID DATE
			return true;
		}

		//CLIENT CONTACT NUMBER VALIDATION
		public static boolean ContactValidation(String ClientContact)
		{
			return ClientContact.charAt(0) == '0' && ClientContact.charAt(1) == '9' && ClientContact.length() == 11 && ClientContact.matches("[0-9]+");
		}

		public static boolean EmailValidation(String ClientEmail)
		{
			   boolean result = true;

			   try
			   {
			      InternetAddress emailAddr = new InternetAddress(ClientEmail);
			      emailAddr.validate();
			   }
			   catch (AddressException ex)
			   {
			      result = false;
			   }

			   return result;
			}


}

