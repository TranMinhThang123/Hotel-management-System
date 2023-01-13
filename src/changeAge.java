import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;

public class changeAge extends javax.swing.JFrame implements WindowListener{

    /**
     * Creates new form changeAge
     */
	private UpdateCustomer updateCustomer;
    public changeAge(UpdateCustomer updateCustomer) {
        initComponents();
        this.updateCustomer = updateCustomer;
        warningMessage.setVisible(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ageField = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        warningMessage = new javax.swing.JLabel();


        jLabel1.setText("Enter new age");


        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        warningMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        warningMessage.setForeground(new java.awt.Color(255, 0, 0));
        warningMessage.setText("Age must have 10 digit!!");
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
                            .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(ageField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    	if(check(ageField.getText())!=-1) {
    		warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
            warningMessage.setVerticalAlignment(SwingConstants.CENTER);
    		updateCustomer.setAgeLabel(ageField.getText());
    		warningMessage.setForeground(Color.GREEN);
    		warningMessage.setVisible(true);
    		warningMessage.setText("Sucessfully!!");
    	}else {
    		warningMessage.setHorizontalAlignment(SwingConstants.CENTER);
            warningMessage.setVerticalAlignment(SwingConstants.CENTER);
    		warningMessage.setForeground(Color.RED);
    		warningMessage.setVisible(true);
    		warningMessage.setText("Invalid age number!!");
    	}
    	
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField ageField;
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
