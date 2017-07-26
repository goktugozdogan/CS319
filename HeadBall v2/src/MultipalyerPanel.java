import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MultipalyerPanel extends javax.swing.JPanel {



    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2; 
    int valueP1, valueP2;
    int scoreL, timeL;
    boolean isTime = false;
    // End of variables declaration
    public MultipalyerPanel() {
        initComponents();
    }
                         
    private void initComponents() {
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jCheckBox1 = new javax.swing.JCheckBox();
        jSpinner1 = new javax.swing.JSpinner();
        jCheckBox3 = new javax.swing.JCheckBox();
        jSpinner2 = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        
        // PLAYER 1 SLIDER
        jSlider1.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (source.getValueIsAdjusting()) {
                    valueP1 = (int)source.getValue();
                    if (valueP1 == 1) {
                        jLabel4.setIcon(new ImageIcon("images/players/1P1.png")); // NOI18N
                    }
                    if (valueP1 == 2) {
                        jLabel4.setIcon(new ImageIcon("images/players/2P1.png")); // NOI18N
                    }
                    if (valueP1 == 3) {
                        jLabel4.setIcon(new ImageIcon("images/players/3P1.png")); // NOI18N
                    }
                    if (valueP1 == 4) {
                        jLabel4.setIcon(new ImageIcon("images/players/4P1.png")); // NOI18N
                    }
                    if ( valueP1 == 5) {
                    	jLabel4.setIcon(new ImageIcon("images/players/5P1.png")); // NOI18N
                    }
                }
                repaint();
            }
        });
        
        // PLAYER 2 SLIDER
        jSlider2.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (source.getValueIsAdjusting()) {
                    valueP2 = (int)source.getValue();
                    if (valueP2 == 1) {
                        jLabel3.setIcon(new ImageIcon("images/players/1P2.png")); // NOI18N
                    }
                    if (valueP2 == 2) {
                        jLabel3.setIcon(new ImageIcon("images/players/2P2.png")); // NOI18N
                    }
                    if (valueP2 == 3) {
                        jLabel3.setIcon(new ImageIcon("images/players/3P2.png")); // NOI18N
                    }
                    if (valueP2 == 4) {
                        jLabel3.setIcon(new ImageIcon("images/players/4P2.png")); // NOI18N
                    }
                    if ( valueP2 == 5) {
                    	jLabel3.setIcon(new ImageIcon("images/players/5P2.png")); // NOI18N
                    }
                }
                repaint();
            }
        });
        
        jSlider1.setMinimum(1);
        jSlider1.setValue(1);
        jSlider1.setMaximum(5);
        
        jSlider2.setMinimum(1);
        jSlider2.setValue(5);
        jSlider2.setMaximum(5);
        
        //Turn on labels at major tick marks.
        jSlider1.setMajorTickSpacing(4);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);
        
        //Turn on labels at major tick marks.
        jSlider2.setMajorTickSpacing(4);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);
        
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        
        jCheckBox1.setSelected(true);

        
        jSpinner1.setValue(7);
        /*jSpinner1.addChangeListener(new ChangeListener(){
	        public void stateChanged(ChangeEvent e) {
	            scoreL = (int) jSpinner1.getValue();
	            repaint();
	        }
        });*/
        jSpinner2.setValue(30);
        
        jCheckBox1.setText("Score Limit");
        jCheckBox3.setText("Time (seconds)");
        
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("START");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jCheckBox1.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	            	jCheckBox3.setSelected(false);
	            	isTime = false;
	            } else {//checkbox has been deselected
	            	jCheckBox3.setSelected(true);
	            	isTime = true;
	            }
	            repaint();
	        }
        });
        jCheckBox3.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	            	jCheckBox1.setSelected(false);
	            	isTime = true;
	            } else {//checkbox has been deselected
	            	jCheckBox1.setSelected(true);
	            	isTime = false;
	            }
	            repaint();
	        }
        });
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Player 1");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player 2");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("images/players/3P2.png")); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("images/players/5P1.png")); // NOI18N

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        
        

        

        
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(529, 529, 529)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSlider2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(409, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(67, 67, 67)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(168, Short.MAX_VALUE)))
        );
    }                      
    
    // BACK BUTTON
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	Game g = new Game();
    	try {
           FileInputStream fileIn = new FileInputStream("data.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           g = (Game) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i) {
           i.printStackTrace();
           return;
        }catch(ClassNotFoundException c) {
           System.out.println("Game class not found");
           c.printStackTrace();
           return;
        }
    	
    	g.setMainMenuPanel(true);
        g.setMultiplayer(false);
        
    	try {
            FileOutputStream fileOut =
            new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(g);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
         }catch(IOException i) {
            i.printStackTrace();
         }
    	repaint();
    }
    
    // START BUTTON
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    	Game g = new Game();
    	try {
           FileInputStream fileIn = new FileInputStream("data.ser");
           ObjectInputStream in = new ObjectInputStream(fileIn);
           g = (Game) in.readObject();
           in.close();
           fileIn.close();
        }catch(IOException i) {
           i.printStackTrace();
           return;
        }catch(ClassNotFoundException c) {
           System.out.println("Game class not found");
           c.printStackTrace();
           return;
        }
    	
    	g.setGamePanel(true);
        g.setMultiplayer(false);
        
        //PLAYER 1
        if ( valueP1 == 1 )
        	g.setPlayer1Image(new ImageIcon("images/players/1P1.png"));
        if ( valueP1 == 2 )
        	g.setPlayer1Image(new ImageIcon("images/players/2P1.png"));
        if ( valueP1 == 3 )
        	g.setPlayer1Image(new ImageIcon("images/players/3P1.png"));
        if ( valueP1 == 4 )
        	g.setPlayer1Image(new ImageIcon("images/players/4P1.png"));
        if ( valueP1 == 5 )
        	g.setPlayer1Image(new ImageIcon("images/players/5P1.png"));
        
        // PLAYER 2
        if ( valueP2 == 1 )
        	g.setPlayer2Image(new ImageIcon("images/players/1P2.png"));
        if ( valueP2 == 2 )
        	g.setPlayer2Image(new ImageIcon("images/players/2P2.png"));
        if ( valueP2 == 3 )
        	g.setPlayer2Image(new ImageIcon("images/players/3P2.png"));
        if ( valueP2 == 4 )
        	g.setPlayer2Image(new ImageIcon("images/players/4P2.png"));
        if ( valueP2 == 5 )
        	g.setPlayer2Image(new ImageIcon("images/players/5P2.png"));
        
        if ( isTime ){
        	g.setTime((int) jSpinner2.getValue());
        	g.setIsTime(true);
        }
        else{
        	g.setScoreLimit((int) jSpinner1.getValue());
        	g.setIsTime(false);
        }  	
        
    	try {
            FileOutputStream fileOut =
            new FileOutputStream("data.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(g);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in data.ser");
         }catch(IOException i) {
            i.printStackTrace();
         }
    	repaint();
    }                  
}
