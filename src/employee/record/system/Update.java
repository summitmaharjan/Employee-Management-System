
package employee.record.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.sql.*;

public class Update extends JFrame {
    JTextField tfposition,efname, elname, adrstxt, phntxt, citizentxt, saltxt, emailtxt,emptxt;
    JLabel empid;
    JButton adddetail, reset;
    String employee_id;
    Update(String employee_id){
     
        this.employee_id= employee_id;
        

        setLayout(null);
        setTitle("Update EMPLOYEE");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ray.jpg"));
        Image i2 = i1.getImage().getScaledInstance(560, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 300, 630);
        add(image);
        // image vitra ko image.
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/addimg.png"));
        Image i5 = i4.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(45, 40, 200, 200);
        image.add(image2);

        //left pannel ko side ko:
        JLabel hello = new JLabel("Update");
        hello.setBounds(110, 220, 200, 40);
        hello.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(hello);

        JLabel admin = new JLabel("Employee");
        admin.setBounds(75, 260, 200, 40);
        admin.setFont(new Font("Raleway", Font.BOLD, 30));
        image.add(admin);

        JButton home = new JButton("Home");
        home.setBounds(70, 500, 150, 40);
        image.add(home);

        home.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                setVisible(false);
                new Home().setVisible(true);
            }
        });
        //title for form::::::
        JLabel title = new JLabel("Update Employee Form ");
        title.setBounds(600, 30, 500, 40);
        title.setFont(new Font("Raleway", Font.BOLD, 30));
        title.setForeground(Color.RED);
        add(title);

        ////fin--
        //Employee Account form:::::
        JLabel fname = new JLabel("First Name:");
        fname.setBounds(350, 100, 200, 40);
        fname.setFont(new Font("Raleway", Font.BOLD, 15));
        add(fname);

        JLabel lblname = new JLabel();
        lblname.setBounds(460, 105, 200, 30);
        add(lblname);

        JLabel lname = new JLabel("Last Name:");
        lname.setBounds(700, 100, 200, 40);
        lname.setFont(new Font("Raleway", Font.BOLD, 15));
        add(lname);

        JLabel lbllast = new JLabel();
        lbllast.setBounds(800, 105, 200, 30);
        add(lbllast);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(350, 150, 200, 40);
        dob.setFont(new Font("Raleway", Font.BOLD, 15));
        add(dob);

        JLabel lbldob = new JLabel();
        lbldob.setBounds(460, 155, 200, 30);
        add(lbldob);

        JLabel address = new JLabel("Address:");
        address.setBounds(700, 150, 200, 40);
        address.setFont(new Font("Raleway", Font.BOLD, 15));
        add(address);

        adrstxt = new JTextField();
        adrstxt.setBounds(800, 155, 200, 30);
        add(adrstxt);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(350, 200, 200, 40);
        phone.setFont(new Font("Raleway", Font.BOLD, 15));
        add(phone);

        phntxt = new JTextField();
        phntxt.setBounds(460, 205, 200, 30);
        add(phntxt);

        JLabel position = new JLabel("Position:");
        position.setBounds(700, 200, 200, 40);
        position.setFont(new Font("Raleway", Font.BOLD, 15));
        add(position);

        tfposition = new JTextField();
        tfposition.setBounds(800, 205, 200, 30);
        add(tfposition);

        JLabel citizen = new JLabel("Citizenship no:");
        citizen.setBounds(350, 250, 200, 40);
        citizen.setFont(new Font("Raleway", Font.BOLD, 15));
        add(citizen);

        JLabel lblcitizen = new JLabel();
        lblcitizen.setBounds(460, 255, 200, 30);
        add(lblcitizen);

        JLabel salary = new JLabel("Salary:");
        salary.setBounds(700, 250, 200, 40);
        salary.setFont(new Font("Raleway", Font.BOLD, 15));
        add(salary);

        saltxt = new JTextField();
        saltxt.setBounds(800, 255, 200, 30);
        add(saltxt);

        JLabel email = new JLabel("Email:");
        email.setBounds(350, 300, 200, 40);
        email.setFont(new Font("Raleway", Font.BOLD, 15));
        add(email);

        emailtxt = new JTextField();
        emailtxt.setBounds(460, 305, 300, 30);
        add(emailtxt);

        empid = new JLabel("Employee id:");
        empid.setBounds(350, 350, 200, 40);
        empid.setFont(new Font("Raleway", Font.BOLD, 15));
        add(empid);

        emptxt = new JTextField();
        emptxt.setBounds(460, 355, 100, 30);
        emptxt.setEditable(false);
        add(emptxt);
        
        try{
            Conn c=new Conn();
            String query ="Select * from employee where employee_id='"+employee_id+"'";
           ResultSet rs= c.s.executeQuery(query);
           while(rs.next()){
             lblname.setText(rs.getString("fname"));
             lbllast.setText(rs.getString("lname"));
             lbldob.setText(rs.getString("dob"));
             adrstxt.setText(rs.getString("address"));
             phntxt.setText(rs.getString("phone"));
             tfposition.setText(rs.getString("position"));
             lblcitizen.setText(rs.getString("citizen_no"));
             saltxt.setText(rs.getString("salary"));
             emailtxt.setText(rs.getString("email"));
             emptxt.setText(rs.getString("employee_id"));
           }
        }catch(Exception e){
            e.printStackTrace();
        }

        adddetail = new JButton("Update detail");
        adddetail.setBounds(550, 450, 150, 40);
        add(adddetail);

        adddetail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                String address = adrstxt.getText();
                String phone = phntxt.getText();
                String position = tfposition.getText();
                String salary = saltxt.getText();
                String email = emailtxt.getText();
                
                try{
                    Conn conn=new Conn();
                    String query="update employee set address='"+address+"', phone='"+phone+"', position='"+position+"', salary='"+salary+"', email='"+email+"' where employee_id='"+employee_id+"'";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Detail has been updated");
                    setVisible(false);
//                    new Home();
                    new ViewRecords();
                }catch(Exception e){
                    e.printStackTrace();
                }
               
            }
        });
        
        reset = new JButton("Back");
        reset.setBounds(750, 450, 150, 40);
        add(reset);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent a) {
                setVisible(false);
            new ViewRecords();
            }
        });

        //
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 630);
        setLocation(200, 100);
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        new Update("");
    }
    }

