import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.awt.Color;

public class awtFrame extends Frame implements ActionListener 
{
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,lblRegNo,l12,l13,l14;
	TextField tName,tAge,tQ,tPercentage,tUniverse,tworkEx,temail,taddress;
	TextArea tworkExp,tskills;
	Button bcreate,bClear;
	Panel p1,p2,p3,p4;
	DataInputStream dataIn;
	DataOutputStream dataOut;
	Checkbox male,female,transgender;
	CheckboxGroup cbg;
	Checkbox selectedCheckbox;
	Choice c;
	
	public awtFrame()
	{
		setBackground(Color.lightGray);

		setSize(600,850);
		
		this.setLayout(null); 
		
		p1=new Panel();
		p2=new Panel();
		p3=new Panel();
		p4=new Panel();
		
		p1.setLayout(null);
		p2.setLayout(null);
		p3.setLayout(null);
		p4.setLayout(null);
		
		p1.setBounds(10,10,590,50);
		p2.setBounds(40,70,490,310);
		p3.setBounds(40,380,490,380);
		
		l3=new Label("Resume Creator",Label.CENTER);
		l3.setBounds(30,20,525,40);
		Font myFont = new Font("Serif",Font.BOLD,24);
		l3.setFont(myFont);
		p1.add(l3);
		
		add(p1);
		
		l4=new Label("Personal Info");
		l4.setBounds(10,20,120,40);
		Font my1Font = new Font("Serif",Font.BOLD,18);
		l4.setFont(my1Font);
		p2.add(l4);
		
		l1=new Label("Name");
		l1.setBounds(10,75,60,20);
		p2.add(l1);
		tName=new TextField("");
		tName.setBounds(120,75,300,20);
		p2.add(tName);
		
		
		l2=new Label("Age");
		l2.setBounds(10,115,60,20);
		p2.add(l2);
		tAge=new TextField("");
		tAge.setBounds(120,115,300,20);
		p2.add(tAge);
		
		l5=new Label("Gender");
		l5.setBounds(10,155,50,20);
		p2.add(l5);
		
		cbg = new CheckboxGroup();  
        male = new Checkbox("Male", cbg,false);    
        male.setBounds(120,155,60,20);    
        female = new Checkbox("Female", cbg, false);
		female.setBounds(180,155,70,20);    
        transgender = new Checkbox("Transgender",cbg,false);
		transgender.setBounds(250,155,100,20);
		p2.add(male);    
        p2.add(female);
		p2.add(transgender);
		
		l6=new Label("Country");
		l6.setBounds(10,195,50,20);
		p2.add(l6);
		c=new Choice();  
        c.setBounds(120,195,150,20);
		c.add("----");
        c.add("USA");  
        c.add("Australia");  
        c.add("India");  
        c.add("Ireland");  
        c.add("Dubai");  
        p2.add(c);
		
		l13=new Label("Email");
		l13.setBounds(10,235,60,20);
		p2.add(l13);
		temail=new TextField("");
		temail.setBounds(120,235,300,20);
		p2.add(temail);
		
		l14=new Label("Address");
		l14.setBounds(10,275,60,20);
		p2.add(l14);
		taddress=new TextField("");
		taddress.setBounds(120,275,300,20);
		p2.add(taddress);
		
		add(p2);

		l7=new Label("Academic Info");
		l7.setBounds(10,20,150,40);
		l7.setFont(my1Font);
		p3.add(l7);
		
		l8=new Label("Qualification");
		l8.setBounds(10,75,80,20);
		p3.add(l8);
		tQ=new TextField();
		tQ.setBounds(120,75,300,20);
		p3.add(tQ);
		
		l9=new Label("Percent");
		l9.setBounds(10,115,60,20);
		p3.add(l9);
		tPercentage=new TextField();
		tPercentage.setBounds(120,115,300,20);
		p3.add(tPercentage);
		
		l11=new Label("work experience");
		l11.setBounds(10,155,90,20);
		p3.add(l11);
		tworkExp=new TextArea("");
		tworkExp.setBounds(120,155,300,80);
		p3.add(tworkExp);
		
		l12=new Label("Skills");
		l12.setBounds(10,255,90,20);
		p3.add(l12);
		tskills=new TextArea("");
		tskills.setBounds(120,255,300,80);
		p3.add(tskills);
		
		add(p3);
		
		bcreate=new Button("Create");
		bClear=new Button("Clear");
		
		bcreate.setBounds(150,780,70,30);
		bClear.setBounds(330,780,70,30);
		
		add(bcreate);
		add(bClear);
		
		bcreate.addActionListener(this);
		bClear.addActionListener(this);
		
		//for closing window
		
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                
				dispose();  
            }			
        });  
	}
	public void actionPerformed(ActionEvent a)
	{
		if(a.getActionCommand()=="Create")
		{	
			if(tName.getText().equals("") || tAge.getText().equals("") || temail.getText().equals("") || taddress.getText().equals("") || c.getItem(c.getSelectedIndex()).equals("----")  || tQ.getText().equals("") || tPercentage.getText().equals("") || cbg.getSelectedCheckbox()==null)
			{
				System.out.println("No details can be left blank");
			}
			else
			{	
				try
				{				
					//personal info
					
					String name="Name: "+tName.getText();
					String age="Age: "+tAge.getText();
					
					selectedCheckbox=cbg.getSelectedCheckbox();
					String gender="Gender: "+selectedCheckbox.getLabel();
					String country="Country: "+c.getItem(c.getSelectedIndex());
					String email="Email: "+temail.getText();
					String address="Address: "+taddress.getText();
					
					//academic info
					
					String qual= "Qualification: "+tQ.getText();
					String percentage="Percentage: "+tPercentage.getText();
					String Exp="Work Experience: "+tworkExp.getText();
					String skills="Skills: "+tskills.getText();
					
					//Writing File
					
					FileWriter myWriter = new FileWriter("resume-"+tName.getText()+".txt");
					myWriter.write("Resume");
					myWriter.write(System.getProperty( "line.separator"));
					myWriter.write(name);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(age);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(gender);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(country);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(email);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(address);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(qual);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(percentage);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(Exp);
					myWriter.write(System.getProperty( "line.separator" ));
					myWriter.write(skills);
					myWriter.close();
					
					System.out.println("Resume Created Successfully!!!");
				}
				catch(IOException e)
				{
					System.out.println(e);
				}
			}
		}
		if(a.getActionCommand()=="Clear")
		{
			//bug
			tName.setText(" ");
			tAge.setText(" ");
			taddress.setText(" ");
			temail.setText(" ");
			tQ.setText(" ");
			tPercentage.setText(" ");
			tworkExp.setText(" ");
			tskills.setText(" ");
			
			tName.setText("");
			tAge.setText("");
			taddress.setText("");
			temail.setText("");
			tQ.setText("");
			tPercentage.setText("");
			tworkExp.setText("");
			tskills.setText("");
			cbg.getSelectedCheckbox().setState(false);
			c.select(0);	
		}
	}
	public static void main(String[] p)
	{
		awtFrame f=new awtFrame();
		f.setTitle("Resume Creator");
		f.setVisible(true);	
	}
}

		
		