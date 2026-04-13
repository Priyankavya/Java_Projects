package employee.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RemoveEmployee  extends JFrame implements ActionListener{
	Choice choiceEmp;
	JButton delete,back;

	 RemoveEmployee() {
		 JLabel label=new JLabel(" Employee id");
		 label.setBounds(50, 50, 100, 30);
		 label.setFont(new Font("Tahoma",Font.BOLD,15));
		 add(label);
		 
		 choiceEmp=new Choice();
		 choiceEmp.setBounds(200, 50, 150, 30);
		 add(choiceEmp);
		 
		 try {
			 conn c=new conn();
			 ResultSet resultset=c.statement.executeQuery("select * from employee");
			 while(resultset.next())
			 {
				 choiceEmp.add(resultset.getString("empid"));
			 }
			 
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 JLabel name=new JLabel(" Name");
		 name.setBounds(50, 100, 100, 30);
		 name.setFont(new Font("Tahoma",Font.BOLD,15));
		 add( name);
		 
		 JLabel textName=new JLabel();
		 textName.setBounds(200, 100, 100, 30);
		 add(textName);
		 
		 JLabel LabelPhone=new JLabel("Phone");
		 LabelPhone.setBounds(50, 150, 100, 30);
		 LabelPhone.setFont(new Font("Tahoma",Font.BOLD,15));
		 add( LabelPhone);
		 
		 JLabel textPhone=new JLabel();
		 textPhone.setBounds(200, 150, 100, 30);
		 add(textPhone);
		 
		 
		 JLabel Labelemail=new JLabel("Email");
		 Labelemail.setBounds(50, 200, 100, 30);
		 Labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
		 add( Labelemail);
		 
		 JLabel textemail=new JLabel();
		 textemail.setBounds(200, 200, 100, 30);
		 add( textemail);
		 
		 
		 try {
			
			 conn c=new conn();
			 ResultSet resultset=c.statement.executeQuery("select * from employee where empid='"+choiceEmp.getSelectedItem()+"'");
			 while(resultset.next())
			 {
				 textName.setText(resultset.getString("name"));
				 textPhone.setText(resultset.getString("phone"));
				 textemail.setText(resultset.getString("email"));
			 }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
		 choiceEmp.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				try {
					 conn c=new conn();
					 ResultSet resultset=c.statement.executeQuery("select * from employee where empid='"+choiceEmp.getSelectedItem()+"'");
					 while(resultset.next())
					 {
						 textName.setText(resultset.getString("name"));
						 textPhone.setText(resultset.getString("phone"));
						 textemail.setText(resultset.getString("email"));
					 }
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		 
		 delete=new JButton("Delete");
		 delete.setBounds(80, 300, 100, 30);
		 delete.setBackground(Color.black);
		 delete.setForeground(Color.white);
		 delete.addActionListener(this);
		 add(delete);
		 
		 back=new JButton("Back");
		 back.setBounds(220, 300, 100, 30);
		 back.setBackground(Color.black);
		 back.setForeground(Color.white);
		 back.addActionListener(this);
		 add( back);
		 
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
		 Image i2=i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)	;
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel img=new JLabel(i3);
		 img.setBounds(700, 80, 200, 200);
		 add(img);
		 
		 ImageIcon i11=new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
		 Image i22=i11.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT)	;
		 ImageIcon i33=new ImageIcon(i22);
		 JLabel image=new JLabel(i33);
		 image.setBounds(0, 0, 1120, 630);
		 add(image);
		 
		 setSize(1000, 400);
		 setLocation(300, 150);
		 setLayout(null);
		 setVisible(true);
	}
	public static void main(String[] args) {
		new RemoveEmployee();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==delete)
		{
			try {
				conn c=new conn();
				String query="delete from employee where empid='"+choiceEmp.getSelectedItem()+"'";
				c.statement.executeQuery(query);
				JOptionPane.showMessageDialog(null, " Employee deleted successfully");
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
			
		}
		
		
	}

}
