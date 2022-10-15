import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class D_OrderInfo extends JFrame
{
	static String strDriver = "com.mysql.cj.jdbc.Driver";
    static String strConn = "jdbc:mysql://localhost:3306/orderform";
    static String strUser = "linus";
    static String strPass = "password123";
    static Connection objConn;
    static ResultSet objResultSet;
    static PreparedStatement objPreStatement;
    static Statement objInsert;
    static String tblCharacteristics;

	JPanel contentPane;
	static String strUsername, strPassword;
	DefaultComboBoxModel<String> cmbModel;
	JRadioButton rdbSquare;
	JRadioButton rdbPortrait;
	JRadioButton rdbLandscape;

	//Variable Declarations
	static String TransactionNumber = C_ClientInfo.TransactionNumber;
	static String OrderID = "";
	static float OrderPrice = 0;
	static String OrderSize = "";
	static String OrderDesc = "";
	static String strQty = "";
	static int OrderQty = 0;
	static int intIndex = 0;
	static int intIndexQty = 1;
	static int intIndexGrandTotal = 0;
	static String OrderContent = "";
	static float OrderTotal = 0;
	static float GrandTotal = 0;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Class.forName(strDriver);
					D_OrderInfo frmOrderInfo = new D_OrderInfo();
					frmOrderInfo.setVisible(true);
				}

				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public D_OrderInfo()
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
				D_OrderInfo.this.dispose();
			}
		});
		lblCloseButton.setFont(new Font("Arial Unicode MS", Font.BOLD, 16));
		lblCloseButton.setHorizontalAlignment(SwingConstants.CENTER);
		lblCloseButton.setForeground(new Color(173, 124, 109));
		lblCloseButton.setBounds(467, 0, 33, 31);
		contentPane.add(lblCloseButton);

		//---------------------------------------------------------------------------------------------------------------//

		try
		{
		    //Database
		    objConn = DriverManager.getConnection(strConn, strUser, strPass);
		    objInsert = objConn.createStatement();

	        String strCurrentData = C_ClientInfo.objOrders.get(intIndex);
	        String strSelect = "SELECT * FROM tblOrder WHERE OrderID = ?";
	        objPreStatement = objConn.prepareStatement(strSelect);
		    objPreStatement.setString(1, strCurrentData);
			objResultSet = objPreStatement.executeQuery();

			if(objResultSet.next())
			{
				OrderID = objResultSet.getString("OrderID");
				OrderPrice = objResultSet.getFloat("OrderPrice");
				OrderDesc = objResultSet.getString("OrderDesc");
			}

			if(OrderID.equals("GD-001"))
			{
				strQty = C_ClientInfo.LogoQty;
			}

			if(OrderID.equals("GD-002"))
			{
				strQty = C_ClientInfo.ProductAdsQty;
			}

			if(OrderID.equals("GD-003"))
			{
				strQty = C_ClientInfo.ShopTemplateQty;
			}

			if(OrderID.equals("GD-004"))
			{
				strQty = C_ClientInfo.ProductLabelQty;
			}

			if(OrderID.equals("GD-005"))
			{
				strQty = C_ClientInfo.CardLayoutQty;
			}

			if(OrderID.equals("GD-006"))
			{
				strQty = C_ClientInfo.CoverPhotoQty;
			}

			OrderQty = Integer.parseInt(strQty);

			OrderTotal = OrderPrice*OrderQty;

			GrandTotal();
	    }

		catch (Exception objEx)
		{
		    System.out.println("Login failed!");
			System.out.println(objEx.toString());
		}

		JLabel lblOrderSizeError = new JLabel("");
		lblOrderSizeError.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderSizeError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 11));
		lblOrderSizeError.setForeground(new Color(173, 124, 109));
		lblOrderSizeError.setBounds(244, 360, 183, 14);
		contentPane.add(lblOrderSizeError);

		JLabel lblOrderContentError = new JLabel("");
		lblOrderContentError.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderContentError.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 11));
		lblOrderContentError.setForeground(new Color(173, 124, 109));
		lblOrderContentError.setBounds(64, 360, 183, 14);
		contentPane.add(lblOrderContentError);



		//---------------------------------------------------------------------------------------------------------------//

		//ORDER INFORMATION TITLE
		JLabel lblOrderInfo = new JLabel("O R D E R    I N F O R M A T I O N :");
		lblOrderInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderInfo.setForeground(new Color(173, 124, 109));
		lblOrderInfo.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblOrderInfo.setBounds(96, 159, 308, 22);
		contentPane.add(lblOrderInfo);

		//ORDER
		JLabel lblOrder = new JLabel("O R D E R :");
		lblOrder.setHorizontalAlignment(SwingConstants.LEFT);
		lblOrder.setForeground(Color.WHITE);
		lblOrder.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblOrder.setBounds(140, 200, 96, 22);
		contentPane.add(lblOrder);

		//CLIENT'S ORDER
		JLabel lblClientsOrder = new JLabel(OrderDesc);
		lblClientsOrder.setHorizontalAlignment(SwingConstants.LEFT);
		lblClientsOrder.setForeground(Color.WHITE);
		lblClientsOrder.setFont(new Font("Palatino Linotype", Font.PLAIN, 15));
		lblClientsOrder.setBounds(232, 200, 120, 22);
		contentPane.add(lblClientsOrder);

		//BROWN BACKGROUND
		JPanel pnlBrown = new JPanel();
		pnlBrown.setBounds(59, 188, 378, 37);
		pnlBrown.setBackground(new Color(173, 124, 109));
		contentPane.add(pnlBrown);

		//ORDER SIZE
		JLabel lblSize = new JLabel("Size/Orientation");
		lblSize.setForeground(new Color(173, 124, 109));
		lblSize.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblSize.setBounds(275, 260, 183, 22);
		contentPane.add(lblSize);

		rdbSquare = new JRadioButton("Square");
		rdbSquare.setForeground(new Color(0xad7c6d));
		rdbSquare.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		rdbSquare.setBounds(290, 283, 102, 22);
		rdbSquare.setOpaque(false);
		contentPane.add(rdbSquare);

		rdbPortrait = new JRadioButton("Portrait");
		rdbPortrait.setForeground(new Color(0xad7c6d));
		rdbPortrait.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		rdbPortrait.setOpaque(false);
		rdbPortrait.setBounds(290, 303, 102, 22);
		contentPane.add(rdbPortrait);

		rdbLandscape = new JRadioButton("Landscape");
		rdbLandscape.setForeground(new Color(0xad7c6d));
		rdbLandscape.setFont(new Font("Palatino Linotype", Font.PLAIN, 14));
		rdbLandscape.setOpaque(false);
		rdbLandscape.setBounds(290, 323, 102, 22);
		contentPane.add(rdbLandscape);

		ButtonGroup rdbGroup = new ButtonGroup();
		rdbGroup.add(rdbSquare);
		rdbGroup.add(rdbPortrait);
		rdbGroup.add(rdbLandscape);

		JLabel lblOrderContent = new JLabel("Order Content:");
		lblOrderContent.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderContent.setForeground(new Color(173, 124, 109));
		lblOrderContent.setFont(new Font("Palatino Linotype", Font.BOLD, 17));
		lblOrderContent.setBounds(64, 260, 183, 22);
		contentPane.add(lblOrderContent);

		TextArea txtOrderContent = new TextArea();
		txtOrderContent.setBounds(64, 283, 183, 71);
		txtOrderContent.setForeground(new Color(173, 124, 109));
		txtOrderContent.setFont(new Font("Palatino Linotype", Font.PLAIN, 12));
		contentPane.add(txtOrderContent);

		//NEXT BUTTON
		JPanel pnlNext = new JPanel();
		pnlNext.addMouseListener(new MouseAdapter()
		{
					@Override
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					 //SIZE
					 if(rdbSquare.isSelected())
					 {
						 OrderSize = "Square";
					 }

					 if(rdbPortrait.isSelected())
					 {
						 OrderSize = "Portrait";
					 }

					 if(rdbLandscape.isSelected())
					 {
						 OrderSize = "Landscape";
					 }

					 String OrderContent = txtOrderContent.getText().toString();

					 if(txtOrderContent.getText().isEmpty() || OrderSize.length() == 0)
					 {
						 if(txtOrderContent.getText().isEmpty())
							 lblOrderContentError.setText("Please enter a content");

						 else
							 lblOrderContentError.setText(" ");


						 if(OrderSize.length() == 0)
							 lblOrderSizeError.setText("Please input a size");

						 else
							 lblOrderSizeError.setText(" ");

					 }

					 else
					 {
						 tblCharacteristics = "INSERT INTO TblCharacteristics (TransactionNum, OrderID, OrderContent, OrderSize, OrderQty, OrderTotal, GrandTotal) "
								 				+ "VALUES ('"+TransactionNumber+"', '"+OrderID+"', '"+OrderContent+"', '"+OrderSize+"', "+OrderQty+", "
								 				+ ""+OrderTotal+", "+GrandTotal+")";

						 objInsert.executeUpdate(tblCharacteristics);
						 System.out.print("\nRecord Added in Characteristics Table");

						 OrderSize = "";
						 ++intIndexQty;

						 if(intIndexQty > OrderQty)
						 {
							 ++intIndex;
							 intIndexQty = 1;
						 }

						 D_OrderInfo.this.dispose();

						 if(intIndex < C_ClientInfo.objOrders.size())
						 {
							 D_OrderInfo frmOrderInfo = new D_OrderInfo();
							 frmOrderInfo.setVisible(true);
						 }

						 else
						 {
							 System.out.print("\n\nOrder Complete");
							 E_Confirmation frmConfirmation = new E_Confirmation();
							 frmConfirmation.setVisible(true);
						 }
					 }
				}

				catch (Exception objEx)
				{
					System.out.println("Login failed!");
					System.out.println(objEx.toString());
				}
			}
		});

		pnlNext.setBounds(127, 410, 251, 36);
		pnlNext.setBackground(new Color(0xad7c6d));
		pnlNext.setLayout(null);
		contentPane.add(pnlNext);

		JLabel lblNext = new JLabel("N  E  X  T");
		lblNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblNext.setBounds(6, 8, 239, 25);
		lblNext.setFont(new Font("Palatino Linotype", Font.BOLD, 16));
		lblNext.setForeground(Color.WHITE);
		pnlNext.add(lblNext);


		//BACKGROUND
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(3, 3, 493, 493);
		lblBackground.setIcon(new ImageIcon("Images/Form Background.png"));
		contentPane.add(lblBackground);


	}

	//---------------------------------------------------------------------------------------------------------------//

		//METHODS

		public static void GrandTotal()
		{
			try
			{
				while(intIndexGrandTotal < C_ClientInfo.objOrders.size())
				{
					String TempOrderID = "";
					float TempOrderPrice = 0;
					String TempstrQty = "";
					int TempOrderQty = 1;
					float TempOrderTotal = 0;

					String strTempCurrentData = C_ClientInfo.objOrders.get(intIndexGrandTotal);
					String strSelect = "SELECT * FROM tblOrder WHERE OrderID = ?";
			        objPreStatement = objConn.prepareStatement(strSelect);
				    objPreStatement.setString(1, strTempCurrentData);
					objResultSet = objPreStatement.executeQuery();

					if(objResultSet.next())
					{
						TempOrderID = objResultSet.getString("OrderID");
						TempOrderPrice = objResultSet.getFloat("OrderPrice");
					}

					if(TempOrderID.equals("GD-001"))
					{
						TempstrQty = C_ClientInfo.LogoQty;
					}

					if(TempOrderID.equals("GD-002"))
					{
						TempstrQty = C_ClientInfo.ProductAdsQty;
					}

					if(TempOrderID.equals("GD-003"))
					{
						TempstrQty = C_ClientInfo.ShopTemplateQty;
					}

					if(TempOrderID.equals("GD-004"))
					{
						TempstrQty = C_ClientInfo.ProductLabelQty;
					}

					if(TempOrderID.equals("GD-005"))
					{
						TempstrQty = C_ClientInfo.CardLayoutQty;
					}

					if(TempOrderID.equals("GD-006"))
					{
						TempstrQty = C_ClientInfo.CoverPhotoQty;
					}

					TempOrderQty = Integer.parseInt(TempstrQty);
					TempOrderTotal = TempOrderPrice*TempOrderQty;
					GrandTotal = TempOrderTotal + GrandTotal;
					intIndexGrandTotal++;
				}
			}

			catch (Exception objEx)
			{
			    System.out.println("Login failed!");
				System.out.println(objEx.toString());
			}
		}
}
