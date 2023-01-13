

import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import javax.sound.midi.Soundbank;

import com.mysql.jdbc.MysqlDataTruncation;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.text.SimpleDateFormat;  
public class BookRoom extends javax.swing.JFrame implements WindowListener {

	private AdminSite adminSite;
	private String idRoom;
	private Connection con;
	private String cost;
	private String idcustomer;
	private UserSite userSite;
    public BookRoom(String cost, String idRooom,AdminSite adminSite) {
        initComponents();
        this.adminSite = adminSite;
        this.idRoom = idRooom;
        this.cost = cost;
        try{  
            //chon driver cho ung dung
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sonoo?autoReconnect=true&useSSL=false","root","123");  
            //ket noi den database sonoo username = root,password = 123
        }catch(Exception e){
            System.out.println(e);
        }
        costField.setText(cost);
        warningMessage.setVisible(false);
        setVisible(true);
        }
    
    public BookRoom(String cost, String idRooom,String idcustomer,UserSite userSite) {
        initComponents();
        this.idcustomer = idcustomer;
        this.idRoom = idRooom;
        this.cost = cost;
        this.userSite = userSite;
        try{  
            //chon driver cho ung dung
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sonoo?autoReconnect=true&useSSL=false","root","123");  
            //ket noi den database sonoo username = root,password = 123
        }catch(Exception e){
            System.out.println(e);
        }
        idcustomerField.setText(idcustomer);
        costField.setText(cost);
        warningMessage.setVisible(false);
        setVisible(true);
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dateinLabel = new javax.swing.JLabel();
        dateoutLabel = new javax.swing.JLabel();
        idcustomerLabel = new javax.swing.JLabel();
        idcustomerField = new javax.swing.JTextField();
        dateinField = new javax.swing.JTextField();
        dateoutField = new javax.swing.JTextField();
        costLabel = new javax.swing.JLabel();
        costField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        warningMessage = new javax.swing.JLabel();


        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hotel Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        dateinLabel.setText("Date in(yyyy-MM-dd)");

        dateoutLabel.setText("Date out(yyyy-MM-dd)");

        idcustomerLabel.setText("Id customer");

        costLabel.setText("Cost");


        okButton.setBackground(new java.awt.Color(51, 0, 255));
        okButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        okButton.setForeground(new java.awt.Color(255, 255, 255));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        warningMessage.setBackground(new java.awt.Color(204, 204, 204));
        warningMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        warningMessage.setForeground(new java.awt.Color(255, 51, 51));
        warningMessage.setText("Invalid information!");
        warningMessage.setBorder(null);
        

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateinField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idcustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idcustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateoutField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 152, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(okButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(warningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(idcustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idcustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateinLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateinField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateoutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateoutField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(warningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                                                               

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	String idString = idcustomerField.getText();
        String dateinString = dateinField.getText();
        String dateoutString = dateoutField.getText();
        String costString = costField.getText();
        try {
        	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	//kiem tra xem id moi co trung vs id nao truoc do hay khong
	    	ResultSet rs = stmt.executeQuery("select * from nguoidung where idcustomer = \""+idString+"\";");
	    	if(rs.last()==false) {
	    		warningMessage.setText("Customer does not exist!");
	    		warningMessage.setVisible(true);
	    	}else {
	    		if(!dateinString.equals("") && !dateoutString.equals(costString) && !costString.equals("")) {
		    		int i = stmt.executeUpdate("update room "
		    				+ "set cost = "+costString+","
		    				+ "trangthai = \"busy\" where idroom = "+"\""+idRoom+"\";");
		    		int i2 = stmt.executeUpdate("insert into customer_room(idcustomer,idroom,indate,oudate,thucan,donphong,giatquanao)"
		    				+ "values(\""+idString+"\""+","+"\""+idRoom+"\""+",\""+dateinString+"\",\""+dateoutString+"\",0,0,0);");
		    		if(adminSite!=null) {
		    			adminSite.getRoomTable(con);
		    		}
		    		if(userSite!=null) {
		    			userSite.getRoomTable(con);
		    		}
		    		warningMessage.setText("Booking succesfully!");
		    		warningMessage.setForeground(Color.GREEN);
		    		warningMessage.setVisible(true);
	    		}else {
	    			warningMessage.setText("Invalid information");
	    			warningMessage.setForeground(Color.red);
	    			warningMessage.setVisible(true);
	    		}
	    	}
        }catch(MysqlDataTruncation e){
        	new DataTruncationException();
        }catch(Exception e) {
        	System.out.println(e);
        }
    }                                        
                                             


    private javax.swing.JTextField costField;
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextField dateinField;
    private javax.swing.JLabel dateinLabel;
    private javax.swing.JTextField dateoutField;
    private javax.swing.JLabel dateoutLabel;
    private javax.swing.JTextField idcustomerField;
    private javax.swing.JLabel idcustomerLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel warningMessage;
    // End of variables declaration                   
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		try {
			this.dispose();
			con.close();
		}catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
