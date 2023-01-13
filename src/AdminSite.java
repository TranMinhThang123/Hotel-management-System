
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminSite extends javax.swing.JFrame implements WindowListener{

    private Connection con;
    public AdminSite() {
        initComponents();
        try{  
            //chon driver cho ung dung
            Class.forName("com.mysql.jdbc.Driver");  
            con=DriverManager.getConnection(  
            "jdbc:mysql://localhost:3306/sonoo?autoReconnect=true&useSSL=false","root","123");  
            //ket noi den database sonoo username = root,password = 123
            getCustomerTable(con);
        }catch(Exception e){
            System.out.println(e);
        } 
        //disable customer component;
        tablePanel.setVisible(false);
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        ageLabel.setVisible(false);
        phoneLabel.setVisible(false);
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        ageField.setVisible(false);
        phoneField.setVisible(false);
        searchCustomerButton.setVisible(false);
        updateCustomerButton1.setVisible(false);
        updateCustomerButton.setVisible(false);
        deleteCustomerButton.setVisible(false);
        //disable room component
        idRoomLabel.setVisible(false);
        IdRoomField.setVisible(false);
        bedField.setVisible(false);
        bedLabel.setVisible(false);
        squareLabel.setVisible(false);
        squareField.setVisible(false);
        costField.setVisible(false);
        costLabel.setVisible(false);
        searchRoomButton.setVisible(false);
        addRoomButton.setVisible(false);
        updateRoomButton.setVisible(false);
        deleteRoomButton.setVisible(false);
        roomTablePanel.setVisible(false);
        bookRoomButton.setVisible(false);
        //disable booking component
        idCustomerLabel.setVisible(false);
        IdCustomerField.setVisible(false);
        IdRoomRecordField.setVisible(false);
        IdRecordRoomLabel.setVisible(false);
        dateouLabel.setVisible(false);
        dateouField.setVisible(false);
        dateInLabel.setVisible(false);
        dateInLabel.setVisible(false);
        recordTablePanel.setVisible(false);
        searchRecordButton.setVisible(false);
        unbookedRecordButton.setVisible(false);
        detailButton.setVisible(false);
        recordTable.setVisible(false);
        //enable employee component
        employeeTablePanel.setVisible(true);
        addEmployeeButton.setVisible(true);
        updateEmployeeButton.setVisible(true);
        searchEmployeeButton.setVisible(true);
        deleteEmployeeButton.setVisible(true);
        firstNameEmployeeField.setVisible(true);
        lastNameEmployeeField.setVisible(true);
        phoneEmployeeField.setVisible(true);
        ageEmployeeField.setVisible(true);
        firstNameEmployeeLabel.setVisible(true);
        lastNameEmployeeLabel.setVisible(true);
        phoneEmployeeLabel.setVisible(true);
        ageEmployeeLabel.setVisible(true);
        employeeTable.setVisible(true);
        getEmployeeTable(con);
        setEmployeeLayout();
        setVisible(true);
        DashboardButton.setBackground(new Color(0,102,102));
    }
    //cap nhat customer table
    public void getCustomerTable(Connection con){
        try{  
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from nguoidung where personrole = \"user\"");
            DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idcustomer")),String.valueOf(rs.getString("firstname")),String.valueOf(rs.getString("lastname")),rs.getInt("age"),String.valueOf(rs.getString("phone"))});
                }
            }
            CustomerTable.setModel(model);
            tablePanel.setVisible(true);
        }catch(Exception e){
            System.out.print(e);
        } 
    }
    //cap nhat bang room table
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

    public void getEmployeeTable(Connection con) {
    	try{  
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from nhanvien ");
            DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idnhanvien")),String.valueOf(rs.getString("firstname")),String.valueOf(rs.getString("lastname")),rs.getInt("age"),String.valueOf(rs.getString("phone"))});
                }
            }
            employeeTable.setModel(model);
            employeeTablePanel.setVisible(true);
        }catch(Exception e){
            System.out.print(e);
        } 
	}
    
    public void getBookingTable(Connection con) {
    	try{  
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
                     ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from customer_room ");
            DefaultTableModel model = (DefaultTableModel) recordTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idcustomer")),String.valueOf(rs.getString("idroom")),String.valueOf(rs.getString("indate")),rs.getInt("oudate"),"Booked"});
                }
            }
            recordTable.setModel(model);
            recordTablePanel.setVisible(true);
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
        DashboardButton = new javax.swing.JButton();
        CustomerButton = new javax.swing.JButton();
        RoomButton = new javax.swing.JButton();
        BookingButton = new javax.swing.JButton();
        DashboardPanel = new javax.swing.JPanel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        lastNameField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        firstNameField = new javax.swing.JTextField();
        ageField = new javax.swing.JTextField();
        deleteCustomerButton = new javax.swing.JButton();
        updateCustomerButton = new javax.swing.JButton();
        searchCustomerButton = new javax.swing.JButton();
        updateCustomerButton1 = new javax.swing.JButton();

        //Room component
        roomTablePanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        statusLabel = new javax.swing.JLabel();
        roomTable = new javax.swing.JTable();
        idRoomLabel = new javax.swing.JLabel();
        bedLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        squareLabel = new javax.swing.JLabel();
        bedField = new javax.swing.JTextField();
        costField = new javax.swing.JTextField();
        IdRoomField = new javax.swing.JTextField();
        squareField = new javax.swing.JTextField();
        deleteRoomButton = new javax.swing.JButton();
        updateRoomButton = new javax.swing.JButton();
        searchRoomButton = new javax.swing.JButton();
        addRoomButton = new javax.swing.JButton();
        bookRoomButton = new javax.swing.JButton();
        Booked = new javax.swing.JRadioButton();
        Unbooked = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        //Employee component
        employeeTablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        firstNameEmployeeLabel = new javax.swing.JLabel();
        lastNameEmployeeLabel = new javax.swing.JLabel();
        phoneEmployeeLabel = new javax.swing.JLabel();
        ageEmployeeLabel = new javax.swing.JLabel();
        lastNameEmployeeField = new javax.swing.JTextField();
        phoneEmployeeField = new javax.swing.JTextField();
        firstNameEmployeeField = new javax.swing.JTextField();
        ageEmployeeField = new javax.swing.JTextField();
        deleteEmployeeButton = new javax.swing.JButton();
        addEmployeeButton = new javax.swing.JButton();
        searchEmployeeButton = new javax.swing.JButton();
        updateEmployeeButton = new javax.swing.JButton();
        //Booking component
        recordTablePanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        recordTable = new javax.swing.JTable();
        idCustomerLabel = new javax.swing.JLabel();
        IdRecordRoomLabel = new javax.swing.JLabel();
        dateInLabel = new javax.swing.JLabel();
        dateouLabel = new javax.swing.JLabel();
        IdRoomRecordField = new javax.swing.JTextField();
        dateInField = new javax.swing.JTextField();
        IdCustomerField = new javax.swing.JTextField();
        dateouField = new javax.swing.JTextField();
        detailButton = new javax.swing.JButton();
        searchRecordButton = new javax.swing.JButton();
        unbookedRecordButton = new javax.swing.JButton();
        
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
                .addContainerGap(567, Short.MAX_VALUE))
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

        DashboardButton.setBackground(new java.awt.Color(0, 0, 0));
        DashboardButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        DashboardButton.setForeground(new java.awt.Color(255, 255, 255));
        DashboardButton.setText("Employee");
        DashboardButton.setBorder(null);
        DashboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DashboardButtonActionPerformed(evt);
            }
        });

        CustomerButton.setBackground(new java.awt.Color(0, 0, 0));
        CustomerButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        CustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        CustomerButton.setText("Customer");
        CustomerButton.setBorder(null);
        CustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerButtonActionPerformed(evt);
            }
        });

        RoomButton.setBackground(new java.awt.Color(0, 0, 0));
        RoomButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        RoomButton.setForeground(new java.awt.Color(255, 255, 255));
        RoomButton.setText("Room");
        RoomButton.setBorder(null);
        RoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoomButtonActionPerformed(evt);
            }
        });

        BookingButton.setBackground(new java.awt.Color(0, 0, 0));
        BookingButton.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        BookingButton.setForeground(new java.awt.Color(255, 255, 255));
        BookingButton.setText("Booking");
        BookingButton.setBorder(null);
        BookingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookingButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DashboardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(CustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(RoomButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BookingButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(logoutButton)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(DashboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BookingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addGap(21, 21, 21))
        );
        
        DashboardPanel.setBackground(new java.awt.Color(0, 102, 102));
        //=============================================================================================================================================================
        //customer view
        tablePanel.setBackground(new java.awt.Color(0, 102, 102));

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Age", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(CustomerTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        firstNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        firstNameLabel.setText("First name");

        lastNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lastNameLabel.setForeground(new java.awt.Color(204, 204, 204));
        lastNameLabel.setText("Last name");

        phoneLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phoneLabel.setForeground(new java.awt.Color(204, 204, 204));
        phoneLabel.setText("Phone");

        ageLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ageLabel.setForeground(new java.awt.Color(204, 204, 204));
        ageLabel.setText("Age");

        

        deleteCustomerButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteCustomerButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        deleteCustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteCustomerButton.setText("Delete");
        deleteCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCustomerButtonActionPerformed(evt);
            }
        });

        updateCustomerButton.setBackground(new java.awt.Color(51, 0, 255));
        updateCustomerButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        updateCustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        updateCustomerButton.setText("Add");
        updateCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCustomerButtonActionPerformed(evt);
            }
        });

        searchCustomerButton.setBackground(new java.awt.Color(51, 51, 255));
        searchCustomerButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        searchCustomerButton.setForeground(new java.awt.Color(255, 255, 255));
        searchCustomerButton.setText("Search");
        searchCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerButtonActionPerformed(evt);
            }
        });

        updateCustomerButton1.setBackground(new java.awt.Color(51, 0, 255));
        updateCustomerButton1.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        updateCustomerButton1.setForeground(new java.awt.Color(255, 255, 255));
        updateCustomerButton1.setText("Detail");
        updateCustomerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateCustomerButtonActionPerformed(evt);
            }
        });

        
        //===========================================================================================================================================================
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
        idRoomLabel.setText("Id Room");

        bedLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bedLabel.setForeground(new java.awt.Color(204, 204, 204));
        bedLabel.setText("Bed");

        costLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        costLabel.setForeground(new java.awt.Color(204, 204, 204));
        costLabel.setText("Cost");

        squareLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        squareLabel.setForeground(new java.awt.Color(204, 204, 204));
        squareLabel.setText("Square");

        statusLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        statusLabel.setForeground(new java.awt.Color(204, 204, 204));
        statusLabel.setText("Status");
        
        buttonGroup1.add(Booked);
        Booked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Booked.setForeground(new java.awt.Color(204, 204, 204));
        Booked.setText("Booked");
        Booked.setBackground(new Color(0,102,102));

        buttonGroup1.add(Unbooked);
        Unbooked.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Unbooked.setForeground(new java.awt.Color(204, 204, 204));
        Unbooked.setText("Unbooked");
        Unbooked.setBackground(new Color(0,102,102));
        

        deleteRoomButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteRoomButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        deleteRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteRoomButton.setText("Delete");
        deleteRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRoomButtonActionPerformed(evt);
            }
        });

        updateRoomButton.setBackground(new java.awt.Color(51, 0, 255));
        updateRoomButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        updateRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        updateRoomButton.setText("Detail");
        updateRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               updateRoomButtonActionPerformed(evt);
            }
        });

        searchRoomButton.setBackground(new java.awt.Color(51, 51, 255));
        searchRoomButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        searchRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        searchRoomButton.setText("Search");
        searchRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRoomButtonActionPerformed(evt);
            }
        });

        addRoomButton.setBackground(new java.awt.Color(51, 51, 255));
        addRoomButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        addRoomButton.setForeground(new java.awt.Color(255, 255, 255));
        addRoomButton.setText("Add");
        addRoomButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRoomButtonActionPerformed(evt);
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
        //===========================================================================================================================================================
        //employee view
        employeeTablePanel.setBackground(new java.awt.Color(0, 102, 102));

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First name", "Last name", "Age", "Phone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(employeeTable);

        javax.swing.GroupLayout employeeTablePanelLayout = new javax.swing.GroupLayout(employeeTablePanel);
        employeeTablePanel.setLayout(employeeTablePanelLayout);
        employeeTablePanelLayout.setHorizontalGroup(
            employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        employeeTablePanelLayout.setVerticalGroup(
            employeeTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        firstNameEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        firstNameEmployeeLabel.setForeground(new java.awt.Color(204, 204, 204));
        firstNameEmployeeLabel.setText("First name");

        lastNameEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lastNameEmployeeLabel.setForeground(new java.awt.Color(204, 204, 204));
        lastNameEmployeeLabel.setText("Last name");

        phoneEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        phoneEmployeeLabel.setForeground(new java.awt.Color(204, 204, 204));
        phoneEmployeeLabel.setText("Phone");

        ageEmployeeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ageEmployeeLabel.setForeground(new java.awt.Color(204, 204, 204));
        ageEmployeeLabel.setText("Age");



        deleteEmployeeButton.setBackground(new java.awt.Color(255, 0, 0));
        deleteEmployeeButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        deleteEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteEmployeeButton.setText("Delete");
        deleteEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEmployeeButtonActionPerformed(evt);
            }
        });

        addEmployeeButton.setBackground(new java.awt.Color(51, 0, 255));
        addEmployeeButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        addEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        addEmployeeButton.setText("Add");
        addEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButtonActionPerformed(evt);
            }
        });

        searchEmployeeButton.setBackground(new java.awt.Color(51, 51, 255));
        searchEmployeeButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        searchEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        searchEmployeeButton.setText("Search");
        searchEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeButtonActionPerformed(evt);
            }
        });

        updateEmployeeButton.setBackground(new java.awt.Color(51, 0, 255));
        updateEmployeeButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        updateEmployeeButton.setForeground(new java.awt.Color(255, 255, 255));
        updateEmployeeButton.setText("Detail");
        updateEmployeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateEmployeeButtonActionPerformed(evt);
            }
        });
        //==============================================================================================================================================================
        //booking view
        recordTablePanel.setBackground(new java.awt.Color(0, 102, 102));

        recordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Customer", "ID Room", "Date in", "Date out", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane5.setViewportView(recordTable);

        javax.swing.GroupLayout recordTablePanelLayout = new javax.swing.GroupLayout(recordTablePanel);
        recordTablePanel.setLayout(recordTablePanelLayout);
        recordTablePanelLayout.setHorizontalGroup(
            recordTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
                .addContainerGap())
        );
        recordTablePanelLayout.setVerticalGroup(
            recordTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(recordTablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        idCustomerLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        idCustomerLabel.setForeground(new java.awt.Color(204, 204, 204));
        idCustomerLabel.setText("Id Customer");

        IdRecordRoomLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        IdRecordRoomLabel.setForeground(new java.awt.Color(204, 204, 204));
        IdRecordRoomLabel.setText("Id Room");

        dateInLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateInLabel.setForeground(new java.awt.Color(204, 204, 204));
        dateInLabel.setText("Date in");

        dateouLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dateouLabel.setForeground(new java.awt.Color(204, 204, 204));
        dateouLabel.setText("Date out");

        

        detailButton.setBackground(new java.awt.Color(255, 0, 0));
        detailButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        detailButton.setForeground(new java.awt.Color(255, 255, 255));
        detailButton.setText("Detail");
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });

        searchRecordButton.setBackground(new java.awt.Color(51, 51, 255));
        searchRecordButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        searchRecordButton.setForeground(new java.awt.Color(255, 255, 255));
        searchRecordButton.setText("Search");
        searchRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchRecordButtonActionPerformed(evt);
            }
        });

        unbookedRecordButton.setBackground(new java.awt.Color(51, 0, 255));
        unbookedRecordButton.setFont(new java.awt.Font("Thonburi", 1, 15)); // NOI18N
        unbookedRecordButton.setForeground(new java.awt.Color(255, 255, 255));
        unbookedRecordButton.setText("Delete");
        unbookedRecordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unbookedRecordButtonActionPerformed(evt);
            }
        });
        //===========================================================================================================================================================
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

    //customer panel layout
    void setCustomerLayout() {
    	javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchCustomerButton)
                            .addComponent(updateCustomerButton1)
                            .addComponent(deleteCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(firstNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCustomerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateCustomerButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(updateCustomerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCustomerButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }
    //room panel layout
    void setRoomLayout() {
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
                            .addComponent(updateRoomButton)
                            .addComponent(addRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteRoomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bedField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateRoomButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(squareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(squareField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRoomButton))
                .addGap(7, 7, 7)
                .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(costField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookRoomButton))
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(deleteRoomButton)
                        .addGap(35, 35, 35))
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Booked))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Unbooked)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }
    //booking panel layout
    void setBookingLayout() {
    	javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idCustomerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IdRecordRoomLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateouLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateInLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(IdRoomRecordField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IdCustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateouField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateInField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchRecordButton)
                            .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unbookedRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recordTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addComponent(recordTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(idCustomerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IdCustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchRecordButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IdRecordRoomLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(IdRoomRecordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addComponent(unbookedRecordButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateouLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateouField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(detailButton))
                .addGap(7, 7, 7)
                .addComponent(dateInLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateInField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

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
    }
    //employee panel layout
    void setEmployeeLayout() {
    	javax.swing.GroupLayout DashboardPanelLayout = new javax.swing.GroupLayout(DashboardPanel);
        DashboardPanel.setLayout(DashboardPanelLayout);
        DashboardPanelLayout.setHorizontalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ageEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phoneEmployeeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ageEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(searchEmployeeButton)
                            .addComponent(updateEmployeeButton)
                            .addComponent(deleteEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addEmployeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(employeeTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        DashboardPanelLayout.setVerticalGroup(
            DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addComponent(employeeTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(DashboardPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(firstNameEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstNameEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchEmployeeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastNameEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateEmployeeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ageEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DashboardPanelLayout.createSequentialGroup()
                        .addComponent(ageEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(phoneEmployeeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addEmployeeButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneEmployeeField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEmployeeButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
    }
    
    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
        try {
	        con.close();
	        System.out.println("Close connection");
	        new Login();
        }catch (Exception e) {
			System.out.println(e);
		}
        //new Login();
    }                                        
//customer button 
    private void CustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {       
    	//set Customer component true
        firstNameLabel.setVisible(true);
        lastNameLabel.setVisible(true);
        ageLabel.setVisible(true);
        phoneLabel.setVisible(true);
        firstNameField.setVisible(true);
        lastNameField.setVisible(true);
        ageField.setVisible(true);
        phoneField.setVisible(true);
        searchCustomerButton.setVisible(true);
        updateCustomerButton1.setVisible(true);
        updateCustomerButton.setVisible(true);
        deleteCustomerButton.setVisible(true);
        //set Room component false
        idRoomLabel.setVisible(false);
        IdRoomField.setVisible(false);
        bedField.setVisible(false);
        bedLabel.setVisible(false);
        squareLabel.setVisible(false);
        squareField.setVisible(false);
        costField.setVisible(false);
        costLabel.setVisible(false);
        searchRoomButton.setVisible(false);
        addRoomButton.setVisible(false);
        updateRoomButton.setVisible(false);
        deleteRoomButton.setVisible(false);
        roomTablePanel.setVisible(false);
        bookRoomButton.setVisible(false);
        statusLabel.setVisible(false);
        Booked.setVisible(false);
        Unbooked.setVisible(false);
        //set Employee component false
        employeeTablePanel.setVisible(false);
        addEmployeeButton.setVisible(false);
        updateEmployeeButton.setVisible(false);
        searchEmployeeButton.setVisible(false);
        deleteEmployeeButton.setVisible(false);
        firstNameEmployeeField.setVisible(false);
        lastNameEmployeeField.setVisible(false);
        phoneEmployeeField.setVisible(false);
        ageEmployeeField.setVisible(false);
        firstNameEmployeeLabel.setVisible(false);
        lastNameEmployeeLabel.setVisible(false);
        phoneEmployeeLabel.setVisible(false);
        ageEmployeeLabel.setVisible(false);
        //set booking component false
        idCustomerLabel.setVisible(false);
        IdCustomerField.setVisible(false);
        IdRoomRecordField.setVisible(false);
        IdRecordRoomLabel.setVisible(false);
        dateouLabel.setVisible(false);
        dateouField.setVisible(false);
        dateInLabel.setVisible(false);
        dateInLabel.setVisible(false);
        recordTablePanel.setVisible(false);
        searchRecordButton.setVisible(false);
        unbookedRecordButton.setVisible(false);
        detailButton.setVisible(false);
        recordTable.setVisible(false);
    	setCustomerLayout();
        getCustomerTable(con); 
        CustomerButton.setBackground(new Color(0,102,102));
        DashboardButton.setBackground(Color.BLACK);
        RoomButton.setBackground(Color.BLACK);
        BookingButton.setBackground(Color.BLACK);
    }                                              
//dashboard button
    private void DashboardButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	//set Customer component false
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        ageLabel.setVisible(false);
        phoneLabel.setVisible(false);
        tablePanel.setVisible(false);
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        ageField.setVisible(false);
        phoneField.setVisible(false);
        searchCustomerButton.setVisible(false);
        updateCustomerButton1.setVisible(false);
        updateCustomerButton.setVisible(false);
        deleteCustomerButton.setVisible(false);
        //set Room component false
        idRoomLabel.setVisible(false);
        IdRoomField.setVisible(false);
        bedField.setVisible(false);
        bedLabel.setVisible(false);
        squareLabel.setVisible(false);
        squareField.setVisible(false);
        costField.setVisible(false);
        costLabel.setVisible(false);
        searchRoomButton.setVisible(false);
        addRoomButton.setVisible(false);
        updateRoomButton.setVisible(false);
        deleteRoomButton.setVisible(false);
        roomTablePanel.setVisible(false);
        bookRoomButton.setVisible(false);
        statusLabel.setVisible(false);
        Booked.setVisible(false);
        Unbooked.setVisible(false);
        //set employee component true
        employeeTablePanel.setVisible(true);
        addEmployeeButton.setVisible(true);
        updateEmployeeButton.setVisible(true);
        searchEmployeeButton.setVisible(true);
        deleteEmployeeButton.setVisible(true);
        firstNameEmployeeField.setVisible(true);
        lastNameEmployeeField.setVisible(true);
        phoneEmployeeField.setVisible(true);
        ageEmployeeField.setVisible(true);
        firstNameEmployeeLabel.setVisible(true);
        lastNameEmployeeLabel.setVisible(true);
        phoneEmployeeLabel.setVisible(true);
        ageEmployeeLabel.setVisible(true);
        //set booking component false
        idCustomerLabel.setVisible(false);
        IdCustomerField.setVisible(false);
        IdRoomRecordField.setVisible(false);
        IdRecordRoomLabel.setVisible(false);
        dateouLabel.setVisible(false);
        dateouField.setVisible(false);
        dateInLabel.setVisible(false);
        dateInLabel.setVisible(false);
        recordTablePanel.setVisible(false);
        searchRecordButton.setVisible(false);
        unbookedRecordButton.setVisible(false);
        detailButton.setVisible(false);
        recordTable.setVisible(false);
        setEmployeeLayout();
        getEmployeeTable(con);
        CustomerButton.setBackground(Color.BLACK);
        RoomButton.setBackground(Color.BLACK);
        BookingButton.setBackground(Color.BLACK);
        DashboardButton.setBackground(new Color(0,102,102));
    }                                               
//room button
    private void RoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	//disable customer component
    	firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        ageLabel.setVisible(false);
        phoneLabel.setVisible(false);
        tablePanel.setVisible(false);
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        ageField.setVisible(false);
        phoneField.setVisible(false);
        searchCustomerButton.setVisible(false);
        updateCustomerButton1.setVisible(false);
        updateCustomerButton.setVisible(false);
        deleteCustomerButton.setVisible(false);
        //enable room component
    	idRoomLabel.setVisible(true);
        IdRoomField.setVisible(true);
        bedField.setVisible(true);
        bedLabel.setVisible(true);
        squareLabel.setVisible(true);
        squareField.setVisible(true);
        costField.setVisible(true);
        costLabel.setVisible(true);
        searchRoomButton.setVisible(true);
        addRoomButton.setVisible(true);
        updateRoomButton.setVisible(true);
        deleteRoomButton.setVisible(true);
        roomTablePanel.setVisible(true);
        bookRoomButton.setVisible(true);
        statusLabel.setVisible(true);
        Booked.setVisible(true);
        Unbooked.setVisible(true);
        //set employee component false
        employeeTablePanel.setVisible(false);
        addEmployeeButton.setVisible(false);
        updateEmployeeButton.setVisible(false);
        searchEmployeeButton.setVisible(false);
        deleteEmployeeButton.setVisible(false);
        firstNameEmployeeField.setVisible(false);
        lastNameEmployeeField.setVisible(false);
        phoneEmployeeField.setVisible(false);
        ageEmployeeField.setVisible(false);
        firstNameEmployeeLabel.setVisible(false);
        lastNameEmployeeLabel.setVisible(false);
        phoneEmployeeLabel.setVisible(false);
        ageEmployeeLabel.setVisible(false);
        //set Booking component false
        idCustomerLabel.setVisible(false);
        IdCustomerField.setVisible(false);
        IdRoomRecordField.setVisible(false);
        IdRecordRoomLabel.setVisible(false);
        dateouLabel.setVisible(false);
        dateouField.setVisible(false);
        dateInLabel.setVisible(false);
        dateInLabel.setVisible(false);
        recordTablePanel.setVisible(false);
        searchRecordButton.setVisible(false);
        unbookedRecordButton.setVisible(false);
        detailButton.setVisible(false);
        recordTable.setVisible(false);
    	setRoomLayout();
        getRoomTable(con); 
        RoomButton.setBackground(new Color(0,102,102));
        DashboardButton.setBackground(Color.BLACK);
        CustomerButton.setBackground(Color.BLACK);
        BookingButton.setBackground(Color.BLACK);
    }
//booking button
    private void BookingButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	//set room component false
    	idRoomLabel.setVisible(false);
        IdRoomField.setVisible(false);
        bedField.setVisible(false);
        bedLabel.setVisible(false);
        squareLabel.setVisible(false);
        squareField.setVisible(false);
        costField.setVisible(false);
        costLabel.setVisible(false);
        searchRoomButton.setVisible(false);
        addRoomButton.setVisible(false);
        updateRoomButton.setVisible(false);
        deleteRoomButton.setVisible(false);
        roomTablePanel.setVisible(false);
        bookRoomButton.setVisible(false);
        statusLabel.setVisible(false);
        Booked.setVisible(false);
        Unbooked.setVisible(false);
    	//set booking component true
        idCustomerLabel.setVisible(true);
        IdCustomerField.setVisible(true);
        IdRoomRecordField.setVisible(true);
        IdRecordRoomLabel.setVisible(true);
        dateouLabel.setVisible(true);
        dateouField.setVisible(true);
        dateInLabel.setVisible(true);
        dateInLabel.setVisible(true);
        recordTablePanel.setVisible(true);
        searchRecordButton.setVisible(true);
        unbookedRecordButton.setVisible(true);
        detailButton.setVisible(true);
        recordTable.setVisible(true);
        //set employee component false
        employeeTablePanel.setVisible(false);
        addEmployeeButton.setVisible(false);
        updateEmployeeButton.setVisible(false);
        searchEmployeeButton.setVisible(false);
        deleteEmployeeButton.setVisible(false);
        firstNameEmployeeField.setVisible(false);
        lastNameEmployeeField.setVisible(false);
        phoneEmployeeField.setVisible(false);
        ageEmployeeField.setVisible(false);
        firstNameEmployeeLabel.setVisible(false);
        lastNameEmployeeLabel.setVisible(false);
        phoneEmployeeLabel.setVisible(false);
        ageEmployeeLabel.setVisible(false);
        //set customer component false
        firstNameLabel.setVisible(false);
        lastNameLabel.setVisible(false);
        ageLabel.setVisible(false);
        phoneLabel.setVisible(false);
        tablePanel.setVisible(false);
        firstNameField.setVisible(false);
        lastNameField.setVisible(false);
        ageField.setVisible(false);
        phoneField.setVisible(false);
        searchCustomerButton.setVisible(false);
        updateCustomerButton1.setVisible(false);
        updateCustomerButton.setVisible(false);
        deleteCustomerButton.setVisible(false);
        setBookingLayout();
        getBookingTable(con);
        BookingButton.setBackground(new Color(0,102,102));
        DashboardButton.setBackground(Color.BLACK);
        RoomButton.setBackground(Color.BLACK);
        CustomerButton.setBackground(Color.BLACK);
    }
                            
    //================================================================================================================================================================
    //customer action
    
    //customer action
    private void deleteCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = CustomerTable.getSelectedRow();
    	String primaryKey = CustomerTable.getModel().getValueAt(row, 0).toString();
    	try {
	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	int i = stmt.executeUpdate("delete from nguoidung where idcustomer = \""+primaryKey+"\";");
	    	getCustomerTable(con);
	    	if(i!=0) {
	    		new DeleteCustomerAlert();
	    	}
    	}catch (Exception e) {
    		System.out.println(e);
		}
    }   
    private void searchCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        String firstName = firstNameField.getText();
        String lastname = lastNameField.getText();
        String age = ageField.getText();
        String phone = phoneField.getText();
        try {
	        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	        ResultSet rs = stmt.executeQuery("select * from nguoidung where personrole = \"user\" "
	        		+ "and firstname like\"%"+firstName+"%\""
	        		+ "and lastname like\"%"+lastname+"%\""
	        		+ "and age like\"%"+age+"%\""
	        		+ "and phone like\"%"+phone+"%\"");
	        DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idcustomer")),String.valueOf(rs.getString("firstname")),String.valueOf(rs.getString("lastname")),rs.getInt("age"),String.valueOf(rs.getString("phone"))});
                }
            }
            CustomerTable.setModel(model);
            tablePanel.setVisible(true);
        }catch (Exception e) {
			System.out.println(e);
		}
    }
    private void updateCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {     
    	int row = CustomerTable.getSelectedRow();
    	String primaryKey = CustomerTable.getModel().getValueAt(row, 0).toString();
    	try {
	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	ResultSet rs = stmt.executeQuery("select * from nguoidung where idcustomer = \""+primaryKey+"\";");
	    	if(rs.last()) {
	    		rs.absolute(1);
	    		new UpdateCustomer(this,rs.getString("idcustomer"),rs.getString("firstname")
	    				,rs.getString("lastname"),rs.getString("age"),rs.getString("gmail"),rs.getString("phone"),rs.getString("pass"));
	    	}
    	}catch (Exception e) {
    		System.out.println("update fail");
    		System.out.println(e);
		}
    }
    private void addCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        new AddCustomer(this);
    }
    //room action
    //================================================================================================================================================================
    //room action
    private void deleteRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = roomTable.getSelectedRow();
    	String primaryKey = roomTable.getModel().getValueAt(row, 0).toString();
    	try {
	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	int i = stmt.executeUpdate("delete from room where idroom = \""+primaryKey+"\";");
	    	getRoomTable(con);
	    	if(i!=0) {
	    		new DeleteRoomAlert();
	    	}
    	}catch (Exception e) {
    		System.out.println(e);
		}
    }
    private void updateRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = roomTable.getSelectedRow();
    	String primaryKey = roomTable.getModel().getValueAt(row, 0).toString();
    	try {
	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	ResultSet rs = stmt.executeQuery("select * from room where idroom = \""+primaryKey+"\";");
	    	if(rs.last()) {
	    		rs.absolute(1);
	    		new UpdateRoom(this,rs.getString("idroom"),rs.getString("cost"),rs.getString("NoBed"),rs.getString("dientich"));
	    	}
    	}catch (Exception e) {
    		System.out.println("update fail");
    		System.out.println(e);
		}
    }
    private void addRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	new AddRoom(this);
    }
    private void searchRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String idroom = IdRoomField.getText().toString();
        String cost = costField.getText().toString();
        String numBed = bedField.getText().toString();
        String square = squareField.getText().toString();
//        System.out.println(cost);
//        System.out.println(cost.equals(""));
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
    
    
    private void bookRoomButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = roomTable.getSelectedRow();
    	String primaryKey = roomTable.getModel().getValueAt(row, 0).toString();
    	String cost = roomTable.getModel().getValueAt(row, 3).toString();
    	String status = roomTable.getModel().getValueAt(row, 4).toString();
    	if(status.equals("busy")) {
    		new BusyRoomAlert();
    	}else {
    		new BookRoom(cost,primaryKey, this);	
    	}
    }
  //employee action
    //===============================================================================================================================================================
    //employee action
	public void searchEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String firstName = firstNameEmployeeField.getText();
        String lastname = lastNameEmployeeField.getText();
        String age = ageEmployeeField.getText();
        String phone = phoneEmployeeField.getText();
        try {
	        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	        ResultSet rs = stmt.executeQuery("select * from nhanvien where "
	        		+ "firstname like\"%"+firstName+"%\""
	        		+ "and lastname like\"%"+lastname+"%\""
	        		+ "and age like\"%"+age+"%\""
	        		+ "and phone like\"%"+phone+"%\"");
	        DefaultTableModel model = (DefaultTableModel) employeeTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idnhanvien")),String.valueOf(rs.getString("firstname")),String.valueOf(rs.getString("lastname")),rs.getInt("age"),String.valueOf(rs.getString("phone"))});
                }
            }
            employeeTable.setModel(model);
            employeeTablePanel.setVisible(true);
        }catch (Exception e) {
			System.out.println(e);
		}
		}
	public void deleteEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int row = employeeTable.getSelectedRow();
    	String primaryKey = employeeTable.getModel().getValueAt(row, 0).toString();
    	try {
	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	int i = stmt.executeUpdate("delete from nhanvien where idnhanvien = \""+primaryKey+"\";");
	    	getEmployeeTable(con);
	    	if(i!=0) {
	    		new DeleteEmployeeAlert();
	    	}
    	}catch (Exception e) {
    		System.out.println(e);
		}
	}
	public void addEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		new AddEmployee(this);
	}
    public void updateEmployeeButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = employeeTable.getSelectedRow();
    	String primaryKey = employeeTable.getModel().getValueAt(row, 0).toString();
    	try {
	    	Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	    	ResultSet rs = stmt.executeQuery("select * from nhanvien where idnhanvien = \""+primaryKey+"\";");
	    	if(rs.last()) {
	    		rs.absolute(1);
	    		new UpdateEmployee(this,rs.getString("idnhanvien"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("age"),rs.getString("gmail"),rs.getString("phone"),rs.getString("calamviec"));
	    	}
    	}catch (Exception e) {
    		System.out.println("update fail");
    		System.out.println(e);
		}
	}
    
    //booking action
    public void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = recordTable.getSelectedRow();
    	String idCustomer = recordTable.getModel().getValueAt(row, 0).toString();
    	String idRoom = recordTable.getModel().getValueAt(row, 1).toString();
    	new DetailBooked(idRoom,idCustomer);
    }
    public void searchRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	String idcustomer = IdCustomerField.getText();
        String idroom = IdRoomRecordField.getText();
        String datein = dateInField.getText();
        String dateout = dateouField.getText();
        try {
	        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	        ResultSet rs = stmt.executeQuery("select * from customer_room where "
	        		+ "idcustomer like\"%"+idcustomer+"%\""
	        		+ "and idroom like\"%"+idroom+"%\""
	        		+ "and indate like\"%"+datein+"%\""
	        		+ "and oudate like\"%"+dateout
	        		+"%\"");
	        DefaultTableModel model = (DefaultTableModel) recordTable.getModel();
            model.setRowCount(0);
            if(rs.last()){
                rs.last();
                int size = rs.getRow();
                for(int i=1;i<=size;i++){
                    rs.absolute(i);
                    model.addRow(new Object[]{String.valueOf(rs.getString("idcustomer")),String.valueOf(rs.getString("idroom")),String.valueOf(rs.getString("indate")),rs.getInt("oudate"),"Booked"});
                }
            }
            recordTable.setModel(model);
            recordTablePanel.setVisible(true);
        }catch (Exception e) {
			System.out.println(e);
		}
    }
    
    public void unbookedRecordButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	int row = recordTable.getSelectedRow(); 
    	String idCustomer = recordTable.getModel().getValueAt(row, 0).toString();
    	String idRoom = recordTable.getModel().getValueAt(row, 1).toString();
    	try {
	        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  
	                ResultSet.CONCUR_UPDATABLE);
	        int i = stmt.executeUpdate("delete from customer_room where idroom = \""+idRoom+"\" and idcustomer = \""+idCustomer+"\"");
	        int i2 = stmt.executeUpdate("update room set trangthai = \"ready\" where idroom = \""+idRoom+"\";");
            getBookingTable(con);
        }catch (Exception e) {
			System.out.println(e);
		}
    }
    // customer panel                  
    private javax.swing.JButton BookingButton;
    private javax.swing.JButton CustomerButton;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JButton DashboardButton;
    private javax.swing.JPanel DashboardPanel;
    private javax.swing.JButton RoomButton;
    private javax.swing.JTextField ageField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton deleteCustomerButton;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JButton searchCustomerButton;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JButton updateCustomerButton;
    private javax.swing.JButton updateCustomerButton1;
    // Room Panel
    private javax.swing.JTextField IdRoomField;
    private javax.swing.JButton addRoomButton;
    private javax.swing.JTextField bedField;
    private javax.swing.JLabel bedLabel;
    private javax.swing.JTextField costField;
    private javax.swing.JLabel costLabel;
    private javax.swing.JButton deleteRoomButton;
    private javax.swing.JLabel idRoomLabel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable roomTable;
    private javax.swing.JPanel roomTablePanel;
    private javax.swing.JButton searchRoomButton;
    private javax.swing.JTextField squareField;
    private javax.swing.JLabel squareLabel;
    private javax.swing.JButton updateRoomButton;
    private javax.swing.JButton bookRoomButton;
    private javax.swing.JRadioButton Booked;
    private javax.swing.JRadioButton Unbooked;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel statusLabel;
    //employee component
    private javax.swing.JButton addEmployeeButton;
    private javax.swing.JTextField ageEmployeeField;
    private javax.swing.JLabel ageEmployeeLabel;
    private javax.swing.JButton deleteEmployeeButton;
    private javax.swing.JTable employeeTable;
    private javax.swing.JPanel employeeTablePanel;
    private javax.swing.JTextField firstNameEmployeeField;
    private javax.swing.JLabel firstNameEmployeeLabel;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lastNameEmployeeField;
    private javax.swing.JLabel lastNameEmployeeLabel;
    private javax.swing.JTextField phoneEmployeeField;
    private javax.swing.JLabel phoneEmployeeLabel;
    private javax.swing.JButton searchEmployeeButton;
    private javax.swing.JButton updateEmployeeButton;
    //booking component
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable recordTable;
    private javax.swing.JPanel recordTablePanel;
    private javax.swing.JButton searchRecordButton;
    private javax.swing.JTextField dateouField;
    private javax.swing.JLabel dateouLabel;
    private javax.swing.JButton unbookedRecordButton;
    private javax.swing.JTextField dateInField;
    private javax.swing.JLabel dateInLabel;
    private javax.swing.JButton detailButton;
    private javax.swing.JLabel idCustomerLabel;
    private javax.swing.JTextField IdCustomerField;
    private javax.swing.JLabel IdRecordRoomLabel;
    private javax.swing.JTextField IdRoomRecordField;
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		dispose();
		try {
			con.close();
			System.out.println("Close connection");
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
