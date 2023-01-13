import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateRoom extends javax.swing.JFrame {

    /**
     * Creates new form AddCustomer
     */
	private String idroom;
	private String cost;
	private String numBed;
	private String square;
	private AdminSite adminSite;
	private Connection con;
    public UpdateRoom(AdminSite adminSite,String idroom,String cost,String numBed,String square) {
        initComponents();
        try{  
            //chon driver cho ung dung
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sonoo?autoReconnect=true&useSSL=false","root","123");  
            //ket noi den database sonoo username = root,password = 123
        }catch(Exception e){
            System.out.println(e);
        }
        this.idroom = idroom;
        this.cost = cost;
        this.numBed = numBed;
        this.square = square;
        this.adminSite = adminSite;
        idroomField.setText(idroom);
        costField.setText(cost);
        noBedField.setText(numBed);
        squareField.setText(square);
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
        costLabel = new javax.swing.JLabel();
        noBedLabel = new javax.swing.JLabel();
        idroomLabel = new javax.swing.JLabel();
        idroomField = new javax.swing.JTextField();
        costField = new javax.swing.JTextField();
        noBedField = new javax.swing.JTextField();
        squareLabel = new javax.swing.JLabel();
        squareField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
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

        costLabel.setText("Cost");

        noBedLabel.setText("Number of Bed");

        idroomLabel.setText("Id room");

        squareLabel.setText("Square");


        saveButton.setBackground(new java.awt.Color(51, 0, 255));
        saveButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
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
                    .addComponent(noBedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idroomField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idroomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noBedField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(squareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(squareField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 152, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(228, 228, 228)
                        .addComponent(saveButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(warningMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(idroomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idroomField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noBedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noBedField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(squareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(squareField, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
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

                                          

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String idString = idroomField.getText();
        String costString = costField.getText();
        String noBedString = noBedField.getText();
        String squareString = squareField.getText();
        if(!idroom.equals(idString)) {
        	try {
    	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
    	                ResultSet.CONCUR_UPDATABLE);
    	    	//kiem tra xem id moi co trung vs id nao truoc do hay khong
    	    	ResultSet rs = stmt.executeQuery("select * from room where idroom = \""+idString+"\";");
    	    	if(rs.last()==false) {
    	    		int i = stmt.executeUpdate("update room "
    	    		+ " set idroom = "+idString+","
            		+ " cost = "+costString+","
            		+ " NoBed = "+noBedString+","
            		+ " dientich = "+squareString
            		+ " where idroom = "+idroom);
    	    		adminSite.getRoomTable(con);
    	    		warningMessage.setText("Update successfully!");
    	    		warningMessage.setForeground(Color.GREEN);
    	    		warningMessage.setVisible(true);
    	    	}else {
    	    		warningMessage.setText("Id was used!");
    	    		warningMessage.setVisible(true);
    	    	}
        	}catch (Exception e) {
				System.out.println(e);
			}
        }else {
        	try {
        		Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
    	                ResultSet.CONCUR_UPDATABLE);
        		int i = stmt.executeUpdate("update room "
        	    		+ " set idroom = "+idString+","
                		+ " cost = "+costString+","
                		+ " NoBed = "+noBedString+","
                		+ " dientich = "+squareString
                		+ " where idroom = "+idroom);
        		adminSite.getRoomTable(con);
        		warningMessage.setText("Update successfully!");
        		warningMessage.setForeground(Color.GREEN);
	    		warningMessage.setVisible(true);
        	}
        	catch (Exception e) {
				System.out.println(e);
			}
        }
    }                                          
                                             

    // Variables declaration - do not modify     
    private javax.swing.JTextField costField;
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextField idroomField;
    private javax.swing.JLabel idroomLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField noBedField;
    private javax.swing.JLabel noBedLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField squareField;
    private javax.swing.JLabel squareLabel;
    private javax.swing.JLabel warningMessage;
    // End of variables declaration                   
}
