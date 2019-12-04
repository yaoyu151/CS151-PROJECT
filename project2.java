import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class project2 implements ActionListener {
   static CardLayout contentPaneLayout;
   static Container contentPane;
   static JTextField Bal = new JTextField();
   static JTextField accountName1;
   static JTextField Bal1;
   static JTextField accountName;
   static JTextField accountName2;
   static JButton createNew;
   static JButton loadf;
   static JButton add;
   static JButton view;
   static JButton save;
   static JButton exit;
   static JButton create;
   static JButton cancel;
   static JButton load1;
   static JButton cancel2;
   static JTextField date;
   static String[] TransType = {"Deposit", "Automatic Deposit", "ATM Withdrawal", "Check", "Debit Card", "Other"};
   static JComboBox<String> SelectType = new JComboBox<String>(TransType);
   static JTextField CheckNO;
   static JTextField TransDes;
   static JTextField debit;
   static JTextField credit;
   static JButton saveNew;
   static JButton topMenu;
   static JButton search1;
   static JButton topMenu2;
   static JButton sort2;
   static JButton topMenu3;
   static JRadioButton Jradiobutton1, Jradiobutton2;
   static JButton deleteSelect;
   static JButton topMenu4;
   static double Balance = 0;
   static JTable abtable;
   static Transaction TA[] = new Transaction [100];
   static JScrollPane scrollPane2 = new JScrollPane();
   static JScrollPane scrollPane = new JScrollPane();
  
   static String[] columnName = {"Date", "Trans.Type", "Check NO.", "Trans.Description", "Withdrawal (-)", "Deposit (+)", "Balance"};
   static int Tnumber = 0;
   public static void main(String[] args) {
      ActionListener AL = new project2();
      JFrame frame = new JFrame("Checkbook");
      contentPane = frame.getContentPane();
      contentPane.setLayout(contentPaneLayout=new CardLayout());
      
      
      JPanel accountBalancePanel = new JPanel(new FlowLayout());
      JPanel title = new JPanel(new BorderLayout());
      title.add(new JLabel("<html><font size=5><b>Use The Buttons Below To Manage Transactions</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      accountBalancePanel.add(new JLabel("Account Name:"));
      accountBalancePanel.add(accountName = new JTextField(10));
      accountName.setEditable(false);
      accountBalancePanel.add(new JLabel("Balance:"));
      Bal = new JTextField("0.0", 10);
      Bal.setEditable(false);
      Bal.setHorizontalAlignment(JTextField.RIGHT);
      accountBalancePanel.add(Bal);
      title.add(accountBalancePanel, BorderLayout.CENTER);
      JPanel buttons = new JPanel(new GridLayout(2,4));
      buttons.add(createNew = new JButton("Create a New Account"));
      buttons.add(loadf = new JButton("Load Trans From a File"));
      buttons.add(add = new JButton("Add New Transactions"));
      buttons.add(view = new JButton("View/Delete Transactions"));
      buttons.add(save = new JButton("Save Trans to a File"));
      buttons.add(exit = new JButton("Exit"));
      title.add(buttons, BorderLayout.SOUTH);
      contentPane.add("Card 1", title);
      //contentPane.add(title);
      JPanel createAcc = new JPanel(new GridLayout(0,1));
      createAcc.add(new JLabel("<html><font size=5><b>Create a New Account</b></html>", JLabel.CENTER));
      JPanel acc = new JPanel(new FlowLayout());
      acc.add(new JLabel("Account Name: "));
      acc.add(accountName1 = new JTextField(10));
      JPanel Int = new JPanel(new FlowLayout());
      Int.add(new JLabel("Initial Balance: "));
      Int.add(Bal1 = new JTextField(10));
      JPanel buttons1 = new JPanel(new FlowLayout());
      buttons1.add(create = new JButton("Create"));
      buttons1.add(cancel = new JButton("Cancel"));
      createAcc.add(acc);
      createAcc.add(Int);
      createAcc.add(buttons1);
      contentPane.add("Card 2", createAcc);
   
      //contentPane.add(createAcc); 
      JPanel load = new JPanel(new GridLayout(0,1));
      load.add(new JLabel("<html><font size=5><b>Load Transactions From a File</b></html>", JLabel.CENTER));
      JPanel accName = new JPanel(new FlowLayout());
      accName.add(new JLabel("Account Name: "));
      accName.add(accountName2 = new JTextField(10));
      JPanel buttons2 = new JPanel(new FlowLayout());
      buttons2.add(load1 = new JButton("Load"));
      buttons2.add(cancel2 = new JButton("Cancel"));
      load.add(accName);
      load.add(buttons2);
      contentPane.add("Card 3", load);
      //contentPane.add(load);
      JPanel newTrans = new JPanel(new BorderLayout());
      JPanel transBut = new JPanel(new GridLayout(0,2));
      transBut.add(new JLabel("Date: ", JLabel.RIGHT));
      transBut.add(date = new JTextField(20));
      transBut.add(new JLabel("Trans. Type: ", JLabel.RIGHT));
      transBut.add(SelectType);
      transBut.add(new JLabel("Check NO: ", JLabel.RIGHT));
      transBut.add(CheckNO = new JTextField(20));
      CheckNO.setEditable(false);
      transBut.add(new JLabel("Trans. Description: ", JLabel.RIGHT));
      transBut.add(TransDes = new JTextField(20));
      transBut.add(new JLabel("Withdrawal (-): ", JLabel.RIGHT));
      transBut.add(debit = new JTextField(20));
      debit.setEditable(false);
      transBut.add(new JLabel("Deposit (+): ", JLabel.RIGHT));
      transBut.add(credit = new JTextField(20));
      JPanel buttons3 = new JPanel(new FlowLayout());
      buttons3.add(saveNew = new JButton("Save New Transaction"));
      buttons3.add(topMenu = new JButton("Top Menu"));
      newTrans.add(transBut, BorderLayout.CENTER);
      newTrans.add(buttons3, BorderLayout.SOUTH);
      contentPane.add("Card 4", newTrans);
      //contentPane.add(newTrans);
      JPanel search = new JPanel(new BorderLayout());
      search.add(new JLabel("Search Transactions by Transaction Date/Type/Check NO./Description", JLabel.CENTER), BorderLayout.NORTH);
      
      search.add(scrollPane, BorderLayout.CENTER);
      JPanel search2 = new JPanel(new GridLayout(2,0));
      JPanel searchS = new JPanel(new FlowLayout());
      searchS.add(new JLabel("Search String: "));
      JPanel buttons4 = new JPanel(new FlowLayout());
      buttons4.add(search1 = new JButton("Search"));
      buttons4.add(topMenu2 = new JButton("Top Menu"));
      search2.add(searchS);
      search2.add(buttons4);
      search.add(search2, BorderLayout.SOUTH);
      contentPane.add("Card 5", search);
      //contentPane.add(search);
      JPanel sort = new JPanel(new BorderLayout());
      sort.add(new JLabel("<html><font size=5><b>Sort Transactions</b></html>", JLabel.CENTER), BorderLayout.NORTH);
      JPanel radio = new JPanel(new FlowLayout());
      
      radio.add(Jradiobutton1 = new JRadioButton("By Type"));
      radio.add(Jradiobutton2 = new JRadioButton("By Date"));
      ButtonGroup group = new ButtonGroup(); 
      group.add(Jradiobutton1);
      group.add(Jradiobutton2);
      JPanel buttons6 = new JPanel(new FlowLayout());
      buttons6.add(sort2 = new JButton("Sort"));
      buttons6.add(topMenu3 = new JButton("Top Menu"));
      sort.add(radio, BorderLayout.CENTER);
      sort.add(buttons6, BorderLayout.SOUTH);
      contentPane.add("Card 6", sort);
      //contentPane.add(sort);
      JPanel transBook = new JPanel(new BorderLayout());
      transBook.add(new JLabel("Transactions Currently In The Checkbook", JLabel.CENTER), BorderLayout.NORTH);
      
       
      String[][] data = new String [0][0];
      abtable = new JTable(data,TransType); 
      JScrollPane tmp = new JScrollPane(abtable); 
      scrollPane.setViewport(tmp.getViewport());
      transBook.add(scrollPane, BorderLayout.CENTER);
      
      JPanel buttons5 = new JPanel(new FlowLayout());
      buttons5.add(deleteSelect = new JButton("Delete Selected"));
      buttons5.add(topMenu4 = new JButton("Top Menu"));
      transBook.add(buttons5, BorderLayout.SOUTH);
      contentPane.add("Card 7", transBook);
      //contentPane.add(transBook);
      createNew.addActionListener(AL);
      loadf.addActionListener(AL);
      add.addActionListener(AL);
      view.addActionListener(AL);
      save.addActionListener(AL);
      exit.addActionListener(AL);
      create.addActionListener(AL);
      cancel.addActionListener(AL);
      load1.addActionListener(AL);
      cancel2.addActionListener(AL);
      saveNew.addActionListener(AL);
      topMenu.addActionListener(AL);
      search1.addActionListener(AL);
      topMenu2.addActionListener(AL);
      sort2.addActionListener(AL);
      topMenu3.addActionListener(AL);
      deleteSelect.addActionListener(AL);
      topMenu4.addActionListener(AL);
      SelectType.addActionListener(AL);
      contentPaneLayout.show(contentPane, "Card 1");
      frame.pack();
      frame.setSize(800,300);
   //frm.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true); 
   }
   public void actionPerformed(ActionEvent e) {      
      Object source = e.getSource();
      String s = (String) SelectType.getSelectedItem();
      
      switch (s) {
         case "Deposit": 
               debit.setText("");
               debit.setEditable(false);
               CheckNO.setText("");
               CheckNO.setEditable(false);
               credit.setEditable(true);
               break;
         case "Automatic Deposit":
               debit.setText("");
               debit.setEditable(false);
               CheckNO.setText("");
               CheckNO.setEditable(false);
               credit.setEditable(true);
               break;
         case "ATM Withdrawal":
               CheckNO.setText("");
               CheckNO.setEditable(false);
               debit.setEditable(true);
               credit.setText("");
               credit.setEditable(false);
               break;
         case "Check":
               CheckNO.setEditable(true);
               debit.setEditable(true);
               credit.setText("");
               credit.setEditable(false);
               break;
         case "Debit Card":
               CheckNO.setText("");
               CheckNO.setEditable(false);
               debit.setEditable(true);
               credit.setText("");
               credit.setEditable(false);
               break;
               
         case "Other" :
               CheckNO.setText("");
               CheckNO.setEditable(false);
               debit.setEditable(true);
               credit.setText("");
               credit.setEditable(false);
               break;
               }
           
               
      if (source == createNew) {contentPaneLayout.show(contentPane, "Card 2"); 
         return;}
      if (source == loadf) {contentPaneLayout.show(contentPane, "Card 3"); 
         return;}
      if (source == add) {contentPaneLayout.show(contentPane, "Card 4"); 
         return;}
      if (source == save) {
         try {	FileOutputStream fos = new FileOutputStream (accountName.getText(), false);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0;i<Tnumber;++i) {
               oos.writeObject(TA[i]); 
            }
            oos.close();
         } 
         catch(FileNotFoundException ee){ System.out.println(ee.toString());
         } 
         catch(IOException ee){ ee.printStackTrace();}
      }
      if (source == load1) {
         try {
            FileInputStream fis = new FileInputStream (accountName2.getText());
            accountName.setText(accountName2.getText());
            ObjectInputStream ois = new ObjectInputStream(fis);
            Tnumber=0;
            Balance = 0;
            while (true) {
               Transaction T = (Transaction) ois.readObject();
               TA [Tnumber++] = T;
               if (T.getTransactionType()<=1) {
               
                  Balance += T.getAmount();
               }
               else {
                  Balance -= T.getAmount();
               }
            }
         } 
         catch(EOFException ee){
         } 
         catch(Exception ee){ ee.printStackTrace();
         
         }
         Bal.setText("" + Balance);
         {contentPaneLayout.show(contentPane, "Card 1"); 
            return;
         }
      }
      if (source == deleteSelect) {
         int d = abtable.getSelectedRow();
         for (int i=d; i<Tnumber-1;++i){
            TA [i] = TA [i+1];
         }
         Tnumber--;
         String[][] data = new String [Tnumber][8];
         Balance = 0;
         for (int i = 0;i<Tnumber;++i) {
            data [i][0] = TA [i].getDate();
            data [i][1] = TransType[TA[i].getTransactionType()];
            data [i][2] = "" + TA [i].getCheckNO();
            data [i][3] = TA [i].getTransactionDes();
            if (TA [i].getTransactionType()>=1) {
               data [i][4] = "" + TA[i].getAmount();
               data [i][5]= "";
               Balance -= TA [i].getAmount();
            }
            else {
               data [i][5] = "" + TA [i].getAmount();
               data [i][4]= "";
               Balance += TA [i].getAmount();
            
            }
            data [i][6] = "" + Balance;
            
         }
      
         abtable = new JTable(data,columnName); 
         JScrollPane tmp = new JScrollPane(abtable); 
         scrollPane.setViewport(tmp.getViewport());
         Bal.setText("" +Balance);
         contentPaneLayout.show(contentPane, "Card 7"); 
         return;}
      
      if (source == view) 
      { 
         String[][] data = new String [Tnumber][8];
         Balance = 0;
         for (int i = 0;i<Tnumber;++i) {
            data [i][0] = TA [i].getDate();
            data [i][1] = TransType[TA[i].getTransactionType()];
            data [i][2] = "" + TA [i].getCheckNO();
            data [i][3] = TA [i].getTransactionDes();
            if (TA [i].getTransactionType()>=1) {
               data [i][4] = "" + TA[i].getAmount();
               data [i][5]= "";
               Balance -= TA [i].getAmount();
            }
            else {
               data [i][5] = "" + TA [i].getAmount();
               data [i][4]= "";
               Balance += TA [i].getAmount();
            
            }
            data [i][6] = "" + Balance;
         }
      
         abtable = new JTable(data,columnName); 
         JScrollPane tmp = new JScrollPane(abtable); 
         scrollPane.setViewport(tmp.getViewport());
         
         contentPaneLayout.show(contentPane, "Card 7"); 
         return;}
     
      if (source == cancel) {contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == cancel2) {contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == topMenu) {contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == topMenu2) {contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == topMenu3) {contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == topMenu4) {contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == exit) {System.exit(0);}
   
      if (source == create) {
         accountName.setText(accountName1.getText());
       
         Balance = Double.parseDouble(Bal1.getText());
         Bal.setText(""+ Balance);
         Transaction T = new Transaction();
         T.setAmount(Balance);
         T.setTransactionType(0);
         TA [0] = T;
         Tnumber = 1;
         contentPaneLayout.show(contentPane, "Card 1"); 
         return;}
      if (source == saveNew) {
         Transaction T = new Transaction();
         T.setDate(date.getText());
         T.setTransactionDes(TransDes.getText());
         T.setTransactionType(SelectType.getSelectedIndex()); 
         if (T.getTransactionType()<=1) {
        	T.setAmount(Double.parseDouble(credit.getText()));
            Balance += T.getAmount();
         }
         else {
            T.setAmount(Double.parseDouble(debit.getText()));
            if(T.getAmount()<=Balance)
            {
            	Balance -= T.getAmount();
            }
            else
            {
            	JOptionPane.showMessageDialog(TransDes, "Balance not sufficent for deposit");
            	T.setTransactionDes("VOID");
            	T.setAmount(Balance);
            }
         }
         TA [Tnumber++] = T;
         date.setText("");  
         CheckNO.setText("");
         TransDes.setText("");
         debit.setText("");
         credit.setText("");
         Bal.setText("" + Balance);
      }
   }
      
}