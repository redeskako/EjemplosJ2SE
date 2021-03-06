package es.csc.biblioteca.customers.gui;

import es.csc.biblioteca.customers.dao.CustomerDTO;
import es.csc.biblioteca.i18n.LocaleManager;
import java.awt.event.ActionListener;
import java.sql.Date;

/**
 *
 * @author David Atencia
 * @version 0.1
 */
public class CustomerDetailsView extends javax.swing.JDialog {

    public CustomerDetailsView() {
        initComponents();
        hideWarnings();
    }

    public void setOkListener(ActionListener l, String command) {
        this.btnOk.addActionListener(l);
        this.btnOk.setActionCommand(command);
    }
    
    public void setCancelListener(ActionListener l, String command) {
        this.btnCancel.addActionListener(l);
        this.btnCancel.setActionCommand(command);
    }
    
    public void setCustomer(CustomerDTO customer) {System.out.println("HOLA1");
        if (customer == null) {System.out.println("HOLA2");
            this.dcCreationDate.setDate(new java.util.Date());
        } else {
            this.lblIdCustomer.setText(String.valueOf(customer.getIdSocio()));
            this.txtFirstName.setText(customer.getNombre());
            this.txtLastName.setText(customer.getApellidos());
            this.txtDNI.setText(customer.getDni());
            this.txtAddress.setText(customer.getDireccion());
            this.dcCreationDate.setDate(customer.getFechaAlta());
            System.out.println("HOLA3");
            System.out.println(customer.getNombre());
        }
    }
    
    public CustomerDTO getCustomer() {
        CustomerDTO dto = new CustomerDTO();
        if (!"".equals(this.lblIdCustomer.getText())) {
            dto.setIdSocio(Integer.parseInt(this.lblIdCustomer.getText()));
        }
        dto.setNombre(this.txtFirstName.getText());
        dto.setApellidos(this.txtLastName.getText());
        dto.setDireccion(this.txtAddress.getText());
        dto.setDni(this.txtDNI.getText());
        if (this.dcCreationDate.getDate() != null) {
            dto.setFechaAlta(new Date(this.dcCreationDate.getDate().getTime()));
        }
        return dto;
    }
    
    public void translate() {
        LocaleManager lm = LocaleManager.getInstance();
        this.setTitle(lm.getText("TITLE_CUSTOMER_DETAILS"));
        this.jLabel10.setText(lm.getText("TITLE_CUSTOMER_DETAILS"));
        this.lblDNI.setText(lm.getText("LABEL_DNI"));
        this.lblFirstName.setText(lm.getText("LABEL_FIRST_NAME"));
        this.lblLastName.setText(lm.getText("LABEL_LAST_NAME"));
        this.lblAddress.setText(lm.getText("LABEL_ADDRESS"));
        this.lblCreationDate.setText(lm.getText("LABEL_CREATION_DATE"));
        this.btnOk.setText(lm.getText("BUTTON_OK"));
        this.btnCancel.setText(lm.getText("BUTTON_CANCEL"));
    }
    
    public void hideWarnings() {
        this.lblWarningAddress.setVisible(false);
        this.lblWarningDate.setVisible(false);
        this.lblWarningFirstName.setVisible(false);
        this.lblWarningLastName.setVisible(false);
        this.lblWarningNIC.setVisible(false);
    }
    
    public void showWarningAddress(Boolean visible) {
        this.lblWarningAddress.setVisible(visible);
    }
    
    public void showWarningDate(Boolean visible) {
        this.lblWarningDate.setVisible(visible);
    }
    
    public void showWarningFirstName(Boolean visible) {
        this.lblWarningFirstName.setVisible(visible);
    }
    
    public void showWarningLastName(Boolean visible) {
        this.lblWarningLastName.setVisible(visible);
    }
    
    public void showWarningNIC(Boolean visible) {
        this.lblWarningNIC.setVisible(visible);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblId = new javax.swing.JLabel();
        lblDNI = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblCreationDate = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        txtLastName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        lblIdCustomer = new javax.swing.JLabel();
        dcCreationDate = new com.toedter.calendar.JDateChooser();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtDNI = new javax.swing.JTextField();
        lblWarningNIC = new javax.swing.JLabel();
        lblWarningFirstName = new javax.swing.JLabel();
        lblWarningLastName = new javax.swing.JLabel();
        lblWarningAddress = new javax.swing.JLabel();
        lblWarningDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Customer Details");
        setModal(true);
        setResizable(false);

        lblId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblId.setText("ID:");

        lblDNI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDNI.setText("NIC:");

        lblFirstName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFirstName.setText("First Name:");

        lblLastName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblLastName.setText("Last Name:");

        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblAddress.setText("Address:");

        lblCreationDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCreationDate.setText("Creation Date:");

        lblIdCustomer.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        dcCreationDate.setMaximumSize(new java.awt.Dimension(120, 20));
        dcCreationDate.setMinimumSize(new java.awt.Dimension(120, 20));

        btnOk.setText("Ok");

        btnCancel.setText("Cancel");
        btnCancel.setToolTipText("");

        jLabel10.setBackground(new java.awt.Color(64, 64, 64));
        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/csc/biblioteca/customers/gui/resources/user1_view32.png"))); // NOI18N
        jLabel10.setText("Customer Details");
        jLabel10.setFocusable(false);
        jLabel10.setOpaque(true);

        lblWarningNIC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/csc/biblioteca/customers/gui/resources/warning16.png"))); // NOI18N

        lblWarningFirstName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/csc/biblioteca/customers/gui/resources/warning16.png"))); // NOI18N

        lblWarningLastName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/csc/biblioteca/customers/gui/resources/warning16.png"))); // NOI18N

        lblWarningAddress.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/csc/biblioteca/customers/gui/resources/warning16.png"))); // NOI18N

        lblWarningDate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/es/csc/biblioteca/customers/gui/resources/warning16.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCreationDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcCreationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                                    .addComponent(lblLastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAddress)
                                        .addComponent(txtLastName)
                                        .addComponent(txtFirstName)
                                        .addComponent(lblIdCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE))
                                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblWarningNIC)
                            .addComponent(lblWarningFirstName)
                            .addComponent(lblWarningLastName)
                            .addComponent(lblWarningAddress)
                            .addComponent(lblWarningDate))
                        .addGap(0, 44, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dcCreationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCreationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblWarningDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblId)
                    .addComponent(lblIdCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWarningNIC)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblDNI)
                        .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblFirstName))
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarningFirstName))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lblLastName))
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWarningLastName))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblAddress))
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancel)
                            .addComponent(btnOk)))
                    .addComponent(lblWarningAddress))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnOk;
    private com.toedter.calendar.JDateChooser dcCreationDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCreationDate;
    private javax.swing.JLabel lblDNI;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdCustomer;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblWarningAddress;
    private javax.swing.JLabel lblWarningDate;
    private javax.swing.JLabel lblWarningFirstName;
    private javax.swing.JLabel lblWarningLastName;
    private javax.swing.JLabel lblWarningNIC;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    // End of variables declaration//GEN-END:variables

}
