package employee.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class updateEmployee  extends JFrame implements ActionListener{


	JTextField teducation,tfname,tdob,taddress,tphone,tadhar,temail,tsalary,tdesignation,tempid;
	JButton add,back;
	JComboBox Boxeducation;
	String number;
	updateEmployee(String number) {
		this.number=number;
getContentPane().setBackground(Color.cyan);
		
		JLabel heading = new JLabel(" Update Employee Details");
		heading.setBounds(300, 30, 500, 50);
		heading.setFont(new Font("serif",Font.BOLD,25));
		add(heading);
		
		JLabel name=new JLabel(" First Name");
		name.setBounds(50, 100, 150, 30);
		name.setFont(new Font("san_serif",Font.BOLD,20));
		add(name);
		
		JLabel tname=new JLabel();
		tname.setBounds(170, 100, 250, 30);
		tname.setBackground(Color.LIGHT_GRAY);
		add(tname);
		
		
		JLabel fname=new JLabel("Father's Name");
		fname.setBounds(500, 100, 150, 30);
		fname.setFont(new Font("san_serif",Font.BOLD,20));
		add(fname);
		
		tfname=new JTextField();
		tfname.setBounds(650, 100, 250, 30);
		tfname.setBackground(Color.LIGHT_GRAY);
		add(tfname);
		
		JLabel dob=new JLabel("Date of Birth");
		dob.setBounds(50, 150, 150, 30);
		dob.setFont(new Font("san_serif",Font.BOLD,20));
		add(dob);
		
		JLabel tdob =new JLabel();
		tdob.setBounds(170, 150, 250, 30);
		
		tdob.setBackground(Color.LIGHT_GRAY);
		add(tdob);
		
		
		
		JLabel salary=new JLabel("Salary");
		salary.setBounds(500, 150, 150, 30);
		salary.setFont(new Font("san_serif",Font.BOLD,20));
		add(salary);
		
		tsalary=new JTextField();
		tsalary.setBounds(650, 150, 250, 30);
		tsalary.setBackground(Color.LIGHT_GRAY);
		add(tsalary);
		
		
		JLabel address=new JLabel("Address");
		address.setBounds(50, 200, 150, 30);
		address.setFont(new Font("san_serif",Font.BOLD,20));
		add(address);
		
		taddress=new JTextField();
		taddress.setBounds(170, 200, 250, 30);
		taddress.setBackground(Color.LIGHT_GRAY);
		add(taddress);
		
		
		JLabel phone=new JLabel("Phone No");
		phone.setBounds(500, 200, 150, 30);
		phone.setFont(new Font("san_serif",Font.BOLD,20));
		add(phone);
		
		tphone=new JTextField();
		tphone.setBounds(650, 200, 250, 30);
		tphone.setBackground(Color.LIGHT_GRAY);
		add(tphone);
		
		JLabel email=new JLabel("Email");
		email.setBounds(50, 250, 150, 30);
		email.setFont(new Font("san_serif",Font.BOLD,20));
		add(email);
		
		temail=new JTextField();
		temail.setBounds(170, 250, 250, 30);
		temail.setBackground(Color.LIGHT_GRAY);
		add(temail);
		
		
		JLabel education=new JLabel("Education");
	    education.setBounds(500, 250, 150, 30);
	    education.setFont(new Font("san_serif",Font.BOLD,20));
	    add(education);
	    
	    teducation=new JTextField();
	    teducation.setBounds(650, 250, 250, 30);
	    teducation.setBackground(Color.LIGHT_GRAY);
		add( teducation);
		
	   
	    
	    
	    JLabel adhar=new JLabel("Adhar No");
	    adhar.setBounds(50, 300, 150, 30);
	    adhar.setFont(new Font("san_serif",Font.BOLD,20));
		add(adhar);
		
		JLabel tadhar=new JLabel();
		tadhar.setBounds(170, 300, 250, 30);
		tadhar.setBackground(Color.LIGHT_GRAY);
		add(tadhar);
		
		 
	    JLabel empid=new JLabel("Empid");
	    empid.setBounds(500, 300, 150, 30);
	    empid.setFont(new Font("san_serif",Font.BOLD,20));
		add(empid);
		
		 JLabel tempid=new JLabel();
		tempid.setBounds(650, 300, 250, 30);
		tempid.setBackground(Color.LIGHT_GRAY);
		add(tempid);
		
		JLabel designation=new JLabel("Designation");
		designation.setBounds(50, 350, 150, 30);
		designation.setFont(new Font("san_serif",Font.BOLD,20));
		add(designation);
		
		tdesignation=new JTextField();
		tdesignation.setBounds(170, 350, 250, 30);
		tdesignation.setBackground(Color.LIGHT_GRAY);
		add(tdesignation);
		
		
		try {
			
			conn c=new conn();
			String query="select * from employee where empid='"+number+"'";
			ResultSet resultset=c.statement.executeQuery(query);
			while(resultset.next())
			{
				tname.setText(resultset.getString("name"));
				tfname.setText(resultset.getString("fname"));
				tdob.setText(resultset.getString("dob"));
				taddress.setText(resultset.getString("address"));
				tsalary.setText(resultset.getString("salary"));
				tphone.setText(resultset.getString("phone"));
				temail.setText(resultset.getString("email"));
				teducation.setText(resultset.getString("education"));
				tadhar.setText(resultset.getString("adhar"));
				tempid.setText(resultset.getString("empid"));
				tdesignation.setText(resultset.getString("designation"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		add=new JButton("Update ");
		add.setBounds(200, 450, 250, 40);
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.addActionListener(this);
		add(add);
		
		back=new JButton("Back To Home ");
		back.setBounds(500, 450, 250, 40);
		back.setBackground(Color.black);
		back.setForeground(Color.white);
		back.addActionListener(this);
		add(back);
		
		
		setSize(1000, 700);
		setLocation(300, 50);
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		new updateEmployee(" ");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==add)
		{
			String fname=tfname.getText();
			String salary=tsalary.getText();
			String address=taddress.getText();
			String phone=tphone.getText();
			String email=temail.getText();
			String education=teducation.getText();
			String designation=tdesignation.getText();
			
			try {
				conn c=new conn();
				String query="update employee set fname='"+fname+"',salary= '"+salary+"', address= '"+address+"', phone='"+phone+"',email= '"+email+"',education= '"+education+"',designation = '"+designation+"' where empid='"+number+"'";
				c.statement.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Details updated successfully !!");
				setVisible(false);
				new Main_class();
				
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
			
			
			
			
			
		}
		else
		{
			setVisible(false);
			new Main_class();
			
		}
		
	}
}
