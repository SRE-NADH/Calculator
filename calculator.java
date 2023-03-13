

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


 class calculator implements ActionListener{
    JFrame frame;
    JTextField textfield;
    JButton numberButtons[]=new JButton[10];
    JButton functionButtons[]=new JButton[10];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont=new Font("Ink free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;
    public calculator(){
     frame = new JFrame("calculator");  // create frame
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(500, 600);
	 frame.setLayout(null);
     frame.setResizable(false);
     textfield = new JTextField(); // create text field
     textfield.setBounds(50, 25, 300, 50);
     textfield.setFont(myFont);
     textfield.setEditable(false);
     frame.add(textfield); 

    addButton = new JButton("+");
	subButton = new JButton("-");
	mulButton = new JButton("*");
	divButton = new JButton("/");
	decButton = new JButton(".");
	equButton = new JButton("=");
	delButton = new JButton("Del");
	clrButton = new JButton("Clr");
	negButton = new JButton("(-)");

    // Initialise fnction buttons	
	functionButtons[0] = addButton;
	functionButtons[1] = subButton;
	functionButtons[2] = mulButton;
	functionButtons[3] = divButton;
	functionButtons[4] = decButton;
	functionButtons[5] = equButton;
	functionButtons[6] = delButton;
	functionButtons[7] = clrButton;
	functionButtons[8] = negButton;

 for(int i=0;i<10;i++){ // initialise number button Array and add action listener function
    numberButtons[i]= new JButton(String.valueOf(i));
    numberButtons[i].addActionListener(this);
	numberButtons[i].setFont(myFont);
	numberButtons[i].setFocusable(false);
 }
 for(int i=0;i<9;i++){ // add action listener to function buttons
    functionButtons[i].addActionListener(this);
	functionButtons[i].setFont(myFont);
	functionButtons[i].setFocusable(false);
 }

    negButton.setBounds(50,430,100,50);
	delButton.setBounds(150,430,100,50);
	clrButton.setBounds(250,430,100,50);

   panel = new JPanel();
   panel.setBounds(50, 100, 300, 300);
   panel.setLayout(new GridLayout(4,4,10,10));
    // add number buttons and function buttons to panel
   panel.add(numberButtons[1]);
   panel.add(numberButtons[2]);
   panel.add(numberButtons[3]);
   panel.add(addButton);
   panel.add(numberButtons[4]);
   panel.add(numberButtons[5]);
   panel.add(numberButtons[6]);
   panel.add(subButton);
   panel.add(numberButtons[7]);
   panel.add(numberButtons[8]);
   panel.add(numberButtons[9]);
   panel.add(mulButton);
   panel.add(decButton);
   panel.add(numberButtons[0]);
	panel.add(equButton);
	panel.add(divButton);
		
// add panel and 3 function buttons to frame
frame.add(negButton);
frame.add(clrButton);
frame.add(delButton);
frame.add(textfield);
frame.add(panel);
frame.setVisible(true);
    }

 public static void main(String[] args) {
    calculator calcu = new calculator();
 }
public void actionPerformed(ActionEvent e){

    for(int i=0;i<10;i++) {  // check for number buttons
        if(e.getSource() == numberButtons[i]) {
            textfield.setText(textfield.getText().concat(String.valueOf(i)));
        }
    }
    if(e.getSource()==decButton) { // check for decimal button
        textfield.setText(textfield.getText().concat("."));
    }
    if(e.getSource()==addButton) { // check for add button
        num1 = Double.parseDouble(textfield.getText());
        operator ='+';
        textfield.setText("");
    }
    if(e.getSource()==subButton){ // check for subtraction button
        num1= Double.parseDouble(textfield.getText());
        operator='-';
        textfield.setText("");
    }
    if(e.getSource()==divButton){ // check for division button
        num1= Double.parseDouble(textfield.getText());
        operator='/';
        textfield.setText("");
    }
  if(e.getSource()==mulButton){ // check for multiple button
        num1= Double.parseDouble(textfield.getText());
        operator='*';
        textfield.setText("");
    }  
    if(e.getSource()==equButton){ // check for equal button
        num2= Double.parseDouble(textfield.getText());
        switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
        String ans= String.valueOf(result);
        String r ="";
        // remove 0 after decimal
       if(ans.charAt(ans.length()-1)=='0' && ans.charAt(ans.length()-2)=='.' ){
        for(int i=0;i<ans.length()-2;i++){
           r=r+ans.charAt(i);
        }
        textfield.setText(r);
       }
       else{
        textfield.setText(""+result);
       }
    }
    if(e.getSource()==delButton){// check for delete button
       String str = textfield.getText();
       String s="";
       for(int i=0;i<str.length()-1;i++){
        s=s+str.charAt(i);
       }
       textfield.setText(s);
    }  
    if(e.getSource()==clrButton){// check for clear button
        textfield.setText("");
    }  
    if(e.getSource()==negButton) { // negative button
        double temp = Double.parseDouble(textfield.getText());
        temp*=-1;
        textfield.setText(String.valueOf(temp));
    }
}
       
}