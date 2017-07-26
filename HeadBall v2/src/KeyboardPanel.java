import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
public class KeyboardPanel extends javax.swing.JPanel {
    // Variables declaration                    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private int p1, p2;
    // End of variables declaration  
    public KeyboardPanel() {
        initComponents();
    }
                         
    private void initComponents() {
    	p1 = 1; p2 = 3;
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jButton2 = new javax.swing.JButton();
        
        jSlider1.setMinimum(1);
        jSlider1.setValue(1);
        jSlider1.setMaximum(3);
        
        jSlider2.setMinimum(1);
        jSlider2.setValue(3);
        jSlider2.setMaximum(3);
        
        //Turn on labels at major tick marks.
        jSlider1.setMajorTickSpacing(2);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);
        
        //Turn on labels at major tick marks.
        jSlider2.setMajorTickSpacing(2);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);
        
        jSlider1.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (source.getValueIsAdjusting()) {
                    int value = (int)source.getValue();
                    if (value == 1) {
                        jLabel4.setIcon(new ImageIcon("images/wasd.png")); // NOI18N
                        p1 = 1;
                    }
                    if ( value == 2) {
                    	jLabel4.setIcon(new ImageIcon("images/numpad.jpg")); // NOI18N
                    	p1 = 2;
                    }
                    if (value == 3) {
                        jLabel4.setIcon(new ImageIcon("images/arrows.png")); // NOI18N
                        p1 = 3;
                    }
                }
                repaint();
            }
        });
        jSlider2.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (source.getValueIsAdjusting()) {
                    int value = (int)source.getValue();
                    if (value == 1) {
                        jLabel3.setIcon(new ImageIcon("images/wasd.png")); // NOI18N
                        p2 = 1;
                    }
                    
                    if ( value == 2) {
                    	jLabel3.setIcon(new ImageIcon("images/numpad.jpg")); // NOI18N
                    	p2 = 2;
                    }
                    
                    if ( value == 3) {
                    	jLabel3.setIcon(new ImageIcon("images/arrows.png")); // NOI18N
                    	p2 = 3;
                    }
                }
                repaint();
            }
        });

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Player 1 KeyBinding");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Player 2 KeyBinding");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("images/wasd.png")); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("images/arrows.png")); // NOI18N

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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 25, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
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
        g.setKeyboard(false);
        
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
    
    // SAVE BUTTON
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if ( p1 == p2){
        	JFrame frame = new JFrame();
        	JOptionPane.showMessageDialog(frame, "Player 1 and Player 2 keys are same!");
        }
        else{
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
        	
        	// player1
        	if ( p1 == 1)
        		g.setP1Keyboard(1);
        	if ( p1 == 2)
        		g.setP1Keyboard(2);
        	if ( p1 == 3)
        		g.setP1Keyboard(3);
        	// player 2
        	if ( p2 == 1)
        		g.setP2Keyboard(1);
        	if ( p2 == 2)
        		g.setP2Keyboard(2);
        	if ( p2 == 3)
        		g.setP2Keyboard(3);
            
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
}
