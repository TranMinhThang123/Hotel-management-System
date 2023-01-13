import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;

public class changePhoneEmployee extends javax.swing.JFrame implements WindowListener{

    /**
     * Creates new form changePhone
     */
	private UpdateEmployee updateEmployee;
    public changePhoneEmployee(UpdateEmployee updateEmployee) {
        initComponents();
        warningMessage.setVisible(false);
        this.updateEmployee = updateEmployee;
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        warningMessage = new javax.swing.JLabel();


        jLabel1.setText("Enter new phone");


        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        warningMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        warningMessage.setForeground(new java.awt.Color(255, 0, 0));
        warningMessage.setText("Phone must have 10 digit!!");
        warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
        warningMessage.setVerticalAlignment(SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(okButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(warningMessage)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(warningMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                       

    private int check(String s) {
    	char chars[] = s.toCharArray();
		for(Character c:chars) {
			if(!Character.isDigit(c)) {
				return -1;
			}
		}
		return 1;
	}
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {
    	if(phoneField.getText().length()>10||phoneField.getText().length()<10||check(phoneField.getText())==-1) {
    		warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
            warningMessage.setVerticalAlignment(SwingConstants.CENTER);
    		warningMessage.setText("Phone must be 10 digit!!");
    		warningMessage.setForeground(Color.red);
    		warningMessage.setVisible(true);
    	}else {
    		warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
            warningMessage.setVerticalAlignment(SwingConstants.CENTER);
    		warningMessage.setForeground(Color.GREEN);
    		warningMessage.setText("Successfully!!");
    		warningMessage.setVisible(true);
    		updateEmployee.setPhoneEmployeeLabel(phoneField.getText());
    	}
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel warningMessage;
    // End of variables declaration                   
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		dispose();
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
