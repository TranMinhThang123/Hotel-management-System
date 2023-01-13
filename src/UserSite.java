
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.QuadCurve2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserSite extends javax.swing.JFrame implements WindowListener{

    /**
     * Creates new form AdminSite
     */
    private Connection con;
    private String idcustomer;
    public UserSite(String idcustomer) {
        initComponents();
        this.idcustomer = idcustomer;
        try{  
            //chon driver cho ung dung
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sonoo?autoReconnect=true&useSSL=false","root","123");  
            //ket noi den database sonoo username = root,password = 123
            getYourRoomTable(con);
        }catch(Exception e){
            System.out.println(e);
        } 
        //disable room component
        idRoomLabel.setVisible(false);
        IdRoomField.setVisible(false);
        squareField.setVisible(false);
        squareLabel.setVisible(false);
        bedField.setVisible(false);
        bedLabel.setVisible(false);
        costField.setVisible(false);
        costLabel.setVisible(false);
        statusLabel.setVisible(false);
        Unbooked.setVisible(false);
        Booked.setVisible(false);
        searchRoomButton.setVisible(false);
        bookRoomButton.setVisible(false);
        roomTablePanel.setVisible(false);
        //enable service component
        foodPanel.setVisible(true);
        drinkPanel.setVisible(true);
        servicePanel.setVisible(true);
        yourRoomTablePanel.setVisible(true);
        billButton.setVisible(true);
        profileButton.setVisible(true);
        requireButton.setVisible(true);
        setServiceLayout();
        ServiceButton.setBackground(new Color(0,102,102));
        setVisible(true);
    }
    void getYourRoomTable(Connection con){
        try{  
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from customer_room where idcustomer = \""+idcustomer+"\"");
            DefaultTableModel model = (DefaultTableModel) youroomTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idroom")),String.valueOf(rs.getString("indate")),String.valueOf(rs.getString("oudate"))});
                    //System.out.println("for loop");
                }
            }
            //System.out.println("After for loop");
            youroomTable.setModel(model);
            //System.out.println("After set mode");
            yourRoomTablePanel.setVisible(true);
            //System.out.println("after setVisible");
        }catch(Exception e){
            System.out.print(e);
        } 
    }

    
    public void getRoomTable(Connection con){
        try{  
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from room;");
            DefaultTableModel model = (DefaultTableModel) roomTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idroom")),String.valueOf(rs.getString("NoBed")),String.valueOf(rs.getString("dientich")),String.valueOf(rs.getString("cost")),String.valueOf(rs.getString("trangthai"))});
                }
            }
            roomTable.setModel(model);
            roomTablePanel.setVisible(true);
        }catch(Exception e){
            System.out.print(e);
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        ServiceButton = new javax.swing.JButton();
        roomButton = new javax.swing.JButton();
        DashboardPanel = new javax.swing.JPanel();
        yourRoomTablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        youroomTable = new javax.swing.JTable();
        foodPanel = new javax.swing.JPanel();
        noodleCheckBox = new javax.swing.JCheckBox();
        soupCheckbox = new javax.swing.JCheckBox();
        chickenCheckbox = new javax.swing.JCheckBox();
        hambugerCheckbox = new javax.swing.JCheckBox();
        iceCreamCheckbox = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        drinkPanel = new javax.swing.JPanel();
        cocaCheckbox = new javax.swing.JCheckBox();
        pepsiCheckbox = new javax.swing.JCheckBox();
        sodaCheckbox = new javax.swing.JCheckBox();
        whiskyCheckbox = new javax.swing.JCheckBox();
        vodkaCheckbox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        servicePanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        washingCheckbox = new javax.swing.JCheckBox();
        cleanRoomCheckbox = new javax.swing.JCheckBox();
        requireButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        billButton = new javax.swing.JButton();
        //room component
        roomTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        roomTable = new javax.swing.JTable();
        idRoomLabel = new javax.swing.JLabel();
        bedLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        squareLabel = new javax.swing.JLabel();
        bedField = new javax.swing.JTextField();
        costField = new javax.swing.JTextField();
        IdRoomField = new javax.swing.JTextField();
        squareField = new javax.swing.JTextField();
        searchRoomButton = new javax.swing.JButton();
        bookRoomButton = new javax.swing.JButton();
        costLabel = new javax.swing.JLabel();
        Booked = new javax.swing.JRadioButton();
        Unbooked = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hotel Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        ServiceButton.setBackground(new java.awt.Color(0, 0, 0));
        ServiceButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        ServiceButton.setForeground(new java.awt.Color(255, 255, 255));
        ServiceButton.setText("Service");
        ServiceButton.setBorder(null);
        ServiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServiceButtonActionPerformed(evt);
            }
        });

        roomButton.setBackground(new java.awt.Color(0, 0, 0));
        roomButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        roomButton.setForeground(new java.awt.Color(255, 255, 255));
        roomButton.setText("Room");
        roomButton.setBorder(null);
        roomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ServiceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(roomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(logoutButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(ServiceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(21, 21, 21))
        );

        DashboardPanel.setBackground(new java.awt.Color(0, 102, 102));
    setServiceLayout();
        //===========================================================================================================================================================
        //service view
        youroomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdRoom", "Date in", "Date out"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(youroomTable);

        javax.swing.GroupLayout yourRoomTablePanelLayout = new javax.swing.GroupLayout(yourRoomTablePanel);
        yourRoomTablePanel.setLayout(yourRoomTablePanelLayout);
        yourRoomTablePanelLayout.setHorizontalGroup(
            yourRoomTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, yourRoomTablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        yourRoomTablePanelLayout.setVerticalGroup(
            yourRoomTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yourRoomTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        foodPanel.setBackground(new java.awt.Color(102, 0, 0));

        noodleCheckBox.setBackground(new java.awt.Color(102, 0, 0));
        noodleCheckBox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        noodleCheckBox.setForeground(new java.awt.Color(204, 204, 204));
        noodleCheckBox.setText("Noodle (25K)");
        

        soupCheckbox.setBackground(new java.awt.Color(102, 0, 51));
        soupCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        soupCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        soupCheckbox.setText("Soup (20K)");
        

        chickenCheckbox.setBackground(new java.awt.Color(102, 0, 0));
        chickenCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        chickenCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        chickenCheckbox.setText("Chicken (35K)");
        

        hambugerCheckbox.setBackground(new java.awt.Color(102, 0, 0));
        hambugerCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        hambugerCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        hambugerCheckbox.setText("Hambuger (15K)");
        

        iceCreamCheckbox.setBackground(new java.awt.Color(102, 0, 0));
        iceCreamCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        iceCreamCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        iceCreamCheckbox.setText("Ice cream (20K)");
        

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Food");

        javax.swing.GroupLayout foodPanelLayout = new javax.swing.GroupLayout(foodPanel);
        foodPanel.setLayout(foodPanelLayout);
        foodPanelLayout.setHorizontalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iceCreamCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(foodPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hambugerCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(chickenCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soupCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(noodleCheckBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        foodPanelLayout.setVerticalGroup(
            foodPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(foodPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(noodleCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(soupCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chickenCheckbox)
                .addGap(12, 12, 12)
                .addComponent(hambugerCheckbox)
                .addGap(12, 12, 12)
                .addComponent(iceCreamCheckbox)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        drinkPanel.setBackground(new java.awt.Color(153, 51, 0));

        cocaCheckbox.setBackground(new java.awt.Color(153, 51, 0));
        cocaCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cocaCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        cocaCheckbox.setText("Coca (10K)");
        

        pepsiCheckbox.setBackground(new java.awt.Color(153, 51, 0));
        pepsiCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        pepsiCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        pepsiCheckbox.setText("Pepsi (10K)");
        

        sodaCheckbox.setBackground(new java.awt.Color(153, 51, 0));
        sodaCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        sodaCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        sodaCheckbox.setText("Soda (15K)");
        

        whiskyCheckbox.setBackground(new java.awt.Color(153, 51, 0));
        whiskyCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        whiskyCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        whiskyCheckbox.setText("Whisky (100K)");
        

        vodkaCheckbox.setBackground(new java.awt.Color(153, 51, 0));
        vodkaCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        vodkaCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        vodkaCheckbox.setText("Vodka (75K)");
        

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Drink");

        javax.swing.GroupLayout drinkPanelLayout = new javax.swing.GroupLayout(drinkPanel);
        drinkPanel.setLayout(drinkPanelLayout);
        drinkPanelLayout.setHorizontalGroup(
            drinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drinkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(drinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vodkaCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(whiskyCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                    .addComponent(sodaCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pepsiCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cocaCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        drinkPanelLayout.setVerticalGroup(
            drinkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drinkPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cocaCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pepsiCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sodaCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(whiskyCheckbox)
                .addGap(12, 12, 12)
                .addComponent(vodkaCheckbox)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        servicePanel.setBackground(new java.awt.Color(0, 51, 204));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Service");

        washingCheckbox.setBackground(new java.awt.Color(0, 51, 204));
        washingCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        washingCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        washingCheckbox.setText("Washing (30K)");
        

        cleanRoomCheckbox.setBackground(new java.awt.Color(0, 51, 204));
        cleanRoomCheckbox.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        cleanRoomCheckbox.setForeground(new java.awt.Color(204, 204, 204));
        cleanRoomCheckbox.setText("CleanRoom (50K)");
        

        javax.swing.GroupLayout servicePanelLayout = new javax.swing.GroupLayout(servicePanel);
        servicePanel.setLayout(servicePanelLayout);
        servicePanelLayout.setHorizontalGroup(
            servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(servicePanelLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(servicePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(cleanRoomCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(washingCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        servicePanelLayout.setVerticalGroup(
            servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(servicePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(servicePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cleanRoomCheckbox)
                    .addComponent(washingCheckbox))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        requireButton.setBackground(new java.awt.Color(51, 0, 255));
        requireButton.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        requireButton.setForeground(new java.awt.Color(255, 255, 255));
        requireButton.setText("Require");
        requireButton.addActionListener(null);
        requireButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                requireCheckBoxActionPerformed(evt);
            }
        });

        profileButton.setBackground(new java.awt.Color(0, 51, 255));
        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        profileButton.setForeground(new java.awt.Color(255, 255, 255));
        profileButton.setText("Profile");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileCheckBoxActionPerformed(evt);
            }
        });

        billButton.setBackground(new java.awt.Color(0, 51, 255));
        billButton.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        billButton.setForeground(new java.awt.Color(255, 255, 255));
        billButton.setText("Bill");
        billButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                billCheckBoxActionPerformed(evt);
            }
        });
        //=====================================================================================================================================================
        //room view
        roomTablePanel.setBackground(new java.awt.Color(0, 102, 102));

        roomTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Bed", "Square", "Cost", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(roomTable);

        javax.swing.GroupLayout roomTablePanelLayout = new javax.swing.GroupLayout(roomTablePanel);
        roomTablePanel.setLayout(roomTablePanelLayout);
        roomTablePanelLayout.setHorizontalGroup(
            roomTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        roomTablePanelLayout.setVerticalGroup(
            roomTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roomTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        idRoomLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idRoomLabel.setForeground(new java.awt.Color(204, 204, 204));
        idRoomLabel.setText("ID");

        bedLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bedLabel.setForeground(new java.awt.Color(204, 204, 204));
        bedLabel.setText("Num of Bed");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(204, 204, 204));
        statusLabel.setText("Status");

        squareLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        squareLabel.setForeground(new java.awt.Color(204, 204, 204));
        squareLabel.setText("Square");

        costLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        costLabel.setForeground(new java.awt.Color(204, 204, 204));
        costLabel.setText("Cost");


        searchRoomButton.setBackground(new java.awt.Color(51, 51, 255));
        searchRoomButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        searchRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        searchRoomButton.setText("Search");
        searchRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomButtonActionPerformed(evt);
            }
        });

        bookRoomButton.setBackground(new java.awt.Color(51, 0, 255));
        bookRoomButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        bookRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        bookRoomButton.setText("Book");
        bookRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookRoomButtonActionPerformed(evt);
            }
        });

       

        buttonGroup1.add(Booked);
        Booked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Booked.setForeground(new java.awt.Color(204, 204, 204));
        Booked.setBackground(new Color(0,102,102));
        Booked.setText("Booked");

        buttonGroup1.add(Unbooked);
        Unbooked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Unbooked.setForeground(new java.awt.Color(204, 204, 204));
        Unbooked.setBackground(new Color(0,102,102));
        Unbooked.setText("Unbooked");
        //=====================================================================================================================================================
        //view chung
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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

    public void setServiceLayout() {
    	javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DashboardPanelLayout.createSequentialGroup()
                        .addComponent(foodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(drinkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(servicePanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addComponent(profileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(billButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(requireButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(yourRoomTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yourRoomTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(drinkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(foodPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(servicePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(requireButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(billButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
    }
    public void setRoomLayout() {
    	javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idRoomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(squareLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bedField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(squareField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DashboardPanelLayout.createSequentialGroup()
                                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Unbooked, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Booked, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchRoomButton)
                            .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 52, Short.MAX_VALUE))
                    .addComponent(costLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roomTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addComponent(roomTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(idRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IdRoomField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchRoomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bedField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookRoomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(squareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(squareField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Booked))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Unbooked)
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }
    
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {   
    	try {
    		dispose();
    		con.close();
            new Login();
    	}catch (Exception e) {
			System.out.println(e);
		}
    }                                            
    public void cleanSelected() {
    	noodleCheckBox.setSelected(false);
    	soupCheckbox.setSelected(false);
    	chickenCheckbox.setSelected(false);
    	hambugerCheckbox.setSelected(false);
    	iceCreamCheckbox.setSelected(false);
    	cocaCheckbox.setSelected(false);
    	pepsiCheckbox.setSelected(false);
    	sodaCheckbox.setSelected(false);
    	whiskyCheckbox.setSelected(false);
    	vodkaCheckbox.setSelected(false);
    	cleanRoomCheckbox.setSelected(false);
    	washingCheckbox.setSelected(false);
    }
    private void roomButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	//disable room component
        idRoomLabel.setVisible(true);
        IdRoomField.setVisible(true);
        squareField.setVisible(true);
        squareLabel.setVisible(true);
        bedField.setVisible(true);
        bedLabel.setVisible(true);
        costField.setVisible(true);
        costLabel.setVisible(true);
        statusLabel.setVisible(true);
        Unbooked.setVisible(true);
        Booked.setVisible(true);
        searchRoomButton.setVisible(true);
        bookRoomButton.setVisible(true);
        roomTablePanel.setVisible(true);
        //enable service component
        foodPanel.setVisible(false);
        drinkPanel.setVisible(false);
        servicePanel.setVisible(false);
        yourRoomTablePanel.setVisible(false);
        billButton.setVisible(false);
        profileButton.setVisible(false);
        requireButton.setVisible(false);
        getRoomTable(con);
        setRoomLayout();
        ServiceButton.setBackground(Color.BLACK);
        roomButton.setBackground(new Color(0,102,102));
    }                                          
    
    
    public void ServiceButtonActionPerformed(java.awt.event.ActionEvent evt) {   
    	 idRoomLabel.setVisible(false);
         IdRoomField.setVisible(false);
         squareField.setVisible(false);
         squareLabel.setVisible(false);
         bedField.setVisible(false);
         bedLabel.setVisible(false);
         costField.setVisible(false);
         costLabel.setVisible(false);
         statusLabel.setVisible(false);
         Unbooked.setVisible(false);
         Booked.setVisible(false);
         searchRoomButton.setVisible(false);
         bookRoomButton.setVisible(false);
         roomTablePanel.setVisible(false);
         //enable service component
         foodPanel.setVisible(true);
         drinkPanel.setVisible(true);
         servicePanel.setVisible(true);
         yourRoomTablePanel.setVisible(true);
         billButton.setVisible(true);
         profileButton.setVisible(true);
         requireButton.setVisible(true);
         getYourRoomTable(con);
         setServiceLayout();
         ServiceButton.setBackground(new Color(0,102,102));
         roomButton.setBackground(Color.BLACK);
    }                                             

    public void searchRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String idroom = IdRoomField.getText().toString();
        String cost = costField.getText().toString();
        String numBed = bedField.getText().toString();
        String square = squareField.getText().toString();
        String status="";
        if(Booked.isSelected()) {
        	status = "busy";
        }
        if(Unbooked.isSelected()) {
        	status = "ready";
        }
        try {
	        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	        String command = "select * from room where idroom like\"%"+idroom+"%\"";
	        if(!cost.equals("")) {
		        command+=" and cost = "+cost;
	        }
	        if(!numBed.equals("")) {
	        	command+=" and NoBed = "+numBed;
	        }
	        if(!square.equals("")) {
	        	command+=" and dientich ="+square;
	        }
	        if(!status.equals("")) {
	        	command+=" and trangthai = \""+status+"\";";
	        }
	        System.out.println(command);
	        ResultSet rs = stmt.executeQuery(command);
	        DefaultTableModel model = (DefaultTableModel) roomTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idroom")),String.valueOf(rs.getString("NoBed")),String.valueOf(rs.getString("dientich")),rs.getInt("cost"),String.valueOf(rs.getString("trangthai"))});
                }
	           roomTable.setModel(model);
	           roomTablePanel.setVisible(true);
	           buttonGroup1.clearSelection();
	        }
        }catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void bookRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = roomTable.getSelectedRow();
    	String primaryKey = roomTable.getModel().getValueAt(row, 0).toString();
    	String cost = roomTable.getModel().getValueAt(row, 3).toString();
    	String status = roomTable.getModel().getValueAt(row, 4).toString();
    	if(status.equals("busy")) {
    		new BusyRoomAlert();
    	}else {
    		new BookRoom(cost,primaryKey, idcustomer,this);	
    	}
    }
    
    private void requireCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
    	float sum = 0;
    	float sum2 = 0;
    	float sum3 = 0;
    	if(noodleCheckBox.isSelected()) {
    		sum+=25000;
    	}
    	if(soupCheckbox.isSelected()) {
    		sum+=20000;
    	}
    	if(chickenCheckbox.isSelected()) {
    		sum+=35000;
    	}
    	if(hambugerCheckbox.isSelected()) {
    		sum+=15000;
    	}
    	if(iceCreamCheckbox.isSelected()) {
    		sum+=20000;
    	}
    	if(cocaCheckbox.isSelected()) {
    		sum+=10000;
    	}
    	if(pepsiCheckbox.isSelected()) {
    		sum+=10000;
    	}
    	if(sodaCheckbox.isSelected()) {
    		sum+=15000;
    	}
    	if(whiskyCheckbox.isSelected()) {
    		sum+=100000;
    	}
    	if(vodkaCheckbox.isSelected()) {
    		sum+=75000;
    	}
    	if(cleanRoomCheckbox.isSelected()) {
    		sum2+=50000;
    	}
    	if(washingCheckbox.isSelected()) {
    		sum3+=30000;
    	}
    	int row = youroomTable.getSelectedRow();
    	String idroom = youroomTable.getModel().getValueAt(row, 0).toString();
    	try{  
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from customer_room where idcustomer = \""+idcustomer+"\" and idroom = \""+idroom+"\";");
            rs.absolute(1);
            float thucan = Float.parseFloat(rs.getString("thucan"));
            float donphong =  Float.parseFloat(rs.getString("donphong"));
            float giatquanao = Float.parseFloat(rs.getString("giatquanao"));
            thucan+=sum;
            donphong+=sum2;
            giatquanao+=sum3;
            int i = stmt.executeUpdate("update customer_room set thucan = "+thucan+", donphong = "+donphong+",giatquanao = "+giatquanao
            		+" where idcustomer = \""+idcustomer+"\" and idroom = \""+idroom+"\";");
            cleanSelected();
            new RequestSuccessfullyAlert();
        }catch(Exception e){
            System.out.print(e);
        } 
    }
    
	private void billCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
	    int row = youroomTable.getSelectedRow();
	    String idroom = youroomTable.getModel().getValueAt(row, 0).toString();
	    new DetailBooked(idroom, idcustomer);
	}
	private void profileCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {
		try {
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                    ResultSet.CONCUR_UPDATABLE);
           ResultSet rs = stmt.executeQuery("select * from nguoidung where idcustomer = \""+idcustomer+"\";");
           rs.absolute(1);
           String firstname = rs.getString("firstname");
           String lastname = rs.getString("lastname");
           String age = rs.getString("age");
           String phone = rs.getString("phone");
           String gmail = rs.getString("gmail");
           String password = rs.getString("pass");
           new UpdateCustomer(idcustomer, firstname, lastname, age, gmail, phone, password);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify                     
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JButton ServiceButton;
    private javax.swing.JCheckBox chickenCheckbox;
    private javax.swing.JCheckBox cleanRoomCheckbox;
    private javax.swing.JCheckBox cocaCheckbox;
    private javax.swing.JPanel drinkPanel;
    private javax.swing.JPanel foodPanel;
    private javax.swing.JCheckBox hambugerCheckbox;
    private javax.swing.JCheckBox iceCreamCheckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JCheckBox noodleCheckBox;
    private javax.swing.JCheckBox pepsiCheckbox;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton requireButton;
    private javax.swing.JButton roomButton;
    private javax.swing.JPanel servicePanel;
    private javax.swing.JCheckBox sodaCheckbox;
    private javax.swing.JCheckBox soupCheckbox;
    private javax.swing.JCheckBox vodkaCheckbox;
    private javax.swing.JCheckBox washingCheckbox;
    private javax.swing.JCheckBox whiskyCheckbox;
    private javax.swing.JPanel yourRoomTablePanel;
    private javax.swing.JTable youroomTable;
    private javax.swing.JButton billButton;
    
    //room component
    private javax.swing.JTextField IdRoomField;
    private javax.swing.JRadioButton Unbooked;
    private javax.swing.JTextField bedField;
    private javax.swing.JLabel bedLabel;
    private javax.swing.JButton bookRoomButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField costField;
    private javax.swing.JLabel costLabel;
    private javax.swing.JLabel idRoomLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable roomTable;
    private javax.swing.JPanel roomTablePanel;
    private javax.swing.JButton searchRoomButton;
    private javax.swing.JTextField squareField;
    private javax.swing.JLabel squareLabel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JRadioButton Booked;
    private javax.swing.JRadioButton UnBooked;
    // End of variables declaration                   
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		this.dispose();
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
