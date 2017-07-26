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

public class SinglePlayerPanel extends javax.swing.JPanel {
    // Variables declaration
	private static final long serialVersionUID = 1L;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    int valueP1, value, difficulty;
    int scoreL, timeL;
    boolean isTime = false;
    // End of variables declaration  
    
    public SinglePlayerPanel() {
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
        jSlider4 = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

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
        jSlider2.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (source.getValueIsAdjusting()) {
                    value = (int)source.getValue();
                    if (value == 1)
                        jLabel3.setIcon(new ImageIcon("images/teams/arsenal.jpg")); // NOI18N
                    if (value == 2)
                        jLabel3.setIcon(new ImageIcon("images/teams/atletico.gif")); // NOI18N
                    if (value == 3)
                        jLabel3.setIcon(new ImageIcon("images/teams/barcelona.gif")); // NOI18N
                    if (value == 4)
                        jLabel3.setIcon(new ImageIcon("images/teams/bayern.gif")); // NOI18N
                    if (value == 5)
                        jLabel3.setIcon(new ImageIcon("images/teams/benfica.gif")); // NOI18N
                    if (value == 6)
                        jLabel3.setIcon(new ImageIcon("images/teams/dourtmund.gif")); // NOI18N
                    if (value == 7)
                        jLabel3.setIcon(new ImageIcon("images/teams/juventus.gif")); // NOI18N
                    if (value == 8)
                        jLabel3.setIcon(new ImageIcon("images/teams/mancity.png")); // NOI18N
                    if (value == 9)
                        jLabel3.setIcon(new ImageIcon("images/teams/manunt.png")); // NOI18N
                    if (value == 10)
                        jLabel3.setIcon(new ImageIcon("images/teams/milan.gif")); // NOI18N
                    if (value == 11)
                        jLabel3.setIcon(new ImageIcon("images/teams/monaco.gif")); // NOI18N
                    if (value == 12)
                        jLabel3.setIcon(new ImageIcon("images/teams/napoli.gif")); // NOI18N
                    if (value == 13)
                        jLabel3.setIcon(new ImageIcon("images/teams/porto.gif")); // NOI18N
                    if (value == 14)
                        jLabel3.setIcon(new ImageIcon("images/teams/psg.gif")); // NOI18N
                    if (value == 15)
                        jLabel3.setIcon(new ImageIcon("images/teams/real.gif")); // NOI18N
                    if (value == 16)
                        jLabel3.setIcon(new ImageIcon("images/teams/tottenham.jpg")); // NOI18N
                }
                repaint();
            }
        });
        jSlider4.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider)e.getSource();
                if (source.getValueIsAdjusting()) {
                    difficulty = (int)source.getValue();
                    if (difficulty == 1) {
                        // easy
                    }
                    if ( difficulty == 2) {
                    	// medium
                    }
                    if ( difficulty == 3) {
                    	// hard
                    }
                }
                repaint();
            }
        });
        
        jSlider1.setMinimum(1);
        jSlider1.setValue(1);
        jSlider1.setMaximum(5);
        
        jSlider2.setMinimum(1);
        jSlider2.setValue(15);
        jSlider2.setMaximum(16);
        
        jSlider4.setMinimum(1);
        jSlider4.setValue(1);
        jSlider4.setMaximum(3);
        
        //Turn on labels at major tick marks.
        jSlider1.setMajorTickSpacing(4);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);
        
        //Turn on labels at major tick marks.
        jSlider2.setMajorTickSpacing(15);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);
        
        //Turn on labels at major tick marks.
        jSlider4.setMajorTickSpacing(2);
        jSlider4.setMinorTickSpacing(1);
        jSlider4.setPaintTicks(true);
        jSlider4.setPaintLabels(true);
        
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        
        jCheckBox1.setSelected(true);

        
        jSpinner1.setValue(7);
        jSpinner2.setValue(30);
        
        jCheckBox1.setText("Score Limit");
        jCheckBox3.setText("Time (seconds)");
        
        jButton1.setText("Back");
        jButton2.setText("START");
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jCheckBox1.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	            	jCheckBox3.setSelected(false);
	            } else {//checkbox has been deselected
	            	jCheckBox3.setSelected(true);
	            }
	            repaint();
	        }
        });
        jCheckBox3.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent e) {
	            if(e.getStateChange() == ItemEvent.SELECTED) {//checkbox has been selected
	            	jCheckBox1.setSelected(false);
	            } else {//checkbox has been deselected
	            	jCheckBox1.setSelected(true);
	            }
	            repaint();
	        }
        });
        
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Choose Player");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Choose Team");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("images/teams/real.gif")); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon("images/players/5P1.png")); // NOI18N

        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Difficulty");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                    .addGap(62, 62, 62)
                                    .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSlider4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    }// </editor-fold>                        

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
    	
    	if ( g.isChampions() ){
	    	g.setMainMenuPanel(true);
	        g.setChampions(false);
	        g.createSeason();
    	}
    	if( g.isTraining() ){
    		g.setMainMenuPanel(true);
	        g.setTraining(false);
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
    	
    	if ( g.isChampions() ){
	    	g.setConti(true);
	        g.setChampions(false);
	        g.createSeason();
    	}
    	if( g.isTraining() ){
    		g.setGamePanel(true);
	        g.setTraining(false);
    	}
        
        // PLAYER 1
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
        
        // TEAM
        if (value == 1)
           g.setTeam(new ImageIcon("images/teams/arsenal.jpg")); // NOI18N
        if (value == 2)
            g.setTeam(new ImageIcon("images/teams/atletico.gif")); // NOI18N
        if (value == 3)
        	g.setTeam(new ImageIcon("images/teams/barcelona.gif")); // NOI18N
        if (value == 4)
        	g.setTeam(new ImageIcon("images/teams/bayern.gif")); // NOI18N
        if (value == 5)
        	g.setTeam(new ImageIcon("images/teams/benfica.gif")); // NOI18N
        if (value == 6)
        	g.setTeam(new ImageIcon("images/teams/dourtmund.gif")); // NOI18N
        if (value == 7)
        	g.setTeam(new ImageIcon("images/teams/juventus.gif")); // NOI18N
        if (value == 8)
        	g.setTeam(new ImageIcon("images/teams/mancity.png")); // NOI18N
        if (value == 9)
        	g.setTeam(new ImageIcon("images/teams/manunt.png")); // NOI18N
        if (value == 10)
        	g.setTeam(new ImageIcon("images/teams/milan.gif")); // NOI18N
        if (value == 11)
        	g.setTeam(new ImageIcon("images/teams/monaco.gif")); // NOI18N
        if (value == 12)
        	g.setTeam(new ImageIcon("images/teams/napoli.gif")); // NOI18N
        if (value == 13)
        	g.setTeam(new ImageIcon("images/teams/porto.gif")); // NOI18N
        if (value == 14)
        	g.setTeam(new ImageIcon("images/teams/psg.gif")); // NOI18N
        if (value == 15)
            g.setTeam(new ImageIcon("images/teams/real.gif")); // NOI18N
        if (value == 16)
        	g.setTeam(new ImageIcon("images/teams/tottenham.jpg")); // NOI18N
        
        if ( isTime ){
        	g.setTime((int) jSpinner2.getValue());
        	g.setIsTime(true);
        }
        else{
        	g.setScoreLimit((int) jSpinner1.getValue());
        	g.setIsTime(false);
        }
        
        g.setDifficulty(difficulty);
        
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
