package pl.edu.pw.fizyka.pojava.przkaipioopo;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;



public class Gui extends JFrame{

	private static final long serialVersionUID = 1L;
	
	JPanel bottomPanel, startStopPanel, centralPanel,  bottomCenterPanel, bottomLeftPanel;
	public int languageSelection = 0; 
	JButton startButton, stopButton, resetButton;
	JMenuBar menuBar; 
	JSlider smallMass, bigMass, smallRadius, bigRadius, particleNumber; //Change to sliders!!!
	JLabel smallMassLabel, bigMassLabel, smallRadiusLabel, bigRadiusLabel, particleNumberLabel;
	JMenu upperMenu, subMenuForColour, subMenuForLanguage;
	JMenuItem exitButton, saveButton, colourChoose, smallParticlesColour, bigParticleColour, backgroundColour;
	JMenuItem polishLanguage, englishLanguage;
	
	Gui(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Getting the screen size
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setTitle(languageSelection==0?"Brownian motion simulation":"Symulacja ruchów Browna");
		this.setLayout(new BorderLayout());
		//Setting the window size as half the width and 3/4 height
		int screenHeight = (int) Math.round(screenSize.height*0.75);
		int screenWidth = (int) Math.round(screenSize.width/2);
		this.setSize(screenWidth, screenHeight);
		
		centralPanel = new JPanel();
		centralPanel.setBackground(Color.WHITE);
		this.add(centralPanel, BorderLayout.CENTER);
		
		bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(1, 3));
		this.add(bottomPanel, BorderLayout.PAGE_END);
		
		bottomLeftPanel = new JPanel();
		bottomLeftPanel.setLayout(new GridLayout(5, 1));
		smallMassLabel = new JLabel(languageSelection==0?"Mass of the small particle:":"Masa małej cząstki:");
		bigMassLabel = new JLabel(languageSelection==0?"Mass of the big particle:":"Masa dużej cząstki:");
		smallRadiusLabel = new JLabel(languageSelection==0?"Radius of the small particle:":"Promień małej cząstki:");
		bigRadiusLabel = new JLabel(languageSelection==0?"Radius of the big particle:":"Promień dużej cząstki:");
		particleNumberLabel = new JLabel(languageSelection==0?"Number of small particles:":"Ilość małych cząsteczek:");
		bottomLeftPanel.add(smallMassLabel); bottomLeftPanel.add(smallRadiusLabel); bottomLeftPanel.add(bigMassLabel);
		bottomLeftPanel.add(bigRadiusLabel); bottomLeftPanel.add(particleNumberLabel);
		
		bottomCenterPanel = new JPanel();
		bottomCenterPanel.setLayout(new GridLayout(5,1));
		smallMass = new JSlider(1, 5, 1); smallMass.setMajorTickSpacing(1); smallMass.setPaintLabels(true);
		bigMass = new JSlider(100, 500, 100); bigMass.setMajorTickSpacing(100); bigMass.setPaintLabels(true);
		smallRadius = new JSlider(1, 5, 1); smallRadius.setMajorTickSpacing(1); smallRadius.setPaintLabels(true);
		bigRadius = new JSlider(10, 50, 10); bigRadius.setMajorTickSpacing(10); bigRadius.setPaintLabels(true);
		particleNumber = new JSlider(200, 2000, 200);particleNumber.setMajorTickSpacing(400); particleNumber.setPaintLabels(true);
		bottomCenterPanel.add(smallMass); bottomCenterPanel.add(smallRadius); bottomCenterPanel.add(bigMass);
		bottomCenterPanel.add(bigRadius); bottomCenterPanel.add(particleNumber);
		
		menuBar = new JMenuBar();
		upperMenu = new JMenu("Menu");
		subMenuForColour = new JMenu(languageSelection==0?"Choose colours":"Wybierz kolory"); 
		smallParticlesColour = new JMenuItem(languageSelection==0?"Small particles colour":"Kolor małych cząstek");
		bigParticleColour = new JMenuItem(languageSelection==0?"Big particle colour":"Kolor dużej cząstki");
		backgroundColour = new JMenuItem(languageSelection==0?"Background colour":"Kolor tła");
		backgroundColour.addActionListener(new backgroundColorChooser());
		subMenuForColour.add(backgroundColour); subMenuForColour.add(smallParticlesColour); subMenuForColour.add(bigParticleColour);
		
		subMenuForLanguage = new JMenu( languageSelection==0?"Choose language":"Wybierz język" );
		polishLanguage = new JMenuItem("Polski");
		englishLanguage = new JMenuItem("English");
		subMenuForLanguage.add(englishLanguage); subMenuForLanguage.add(polishLanguage);
		
		englishLanguage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				languageSelection = 0;
				
			}
		});
		
		polishLanguage.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				languageSelection =1; 
				
				///Help help help help!
			}
			
		});
		
		exitButton = new JMenuItem(languageSelection==0?"Exit":"Wyjdź");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);	
			}
		});
		
		saveButton = new JMenuItem(languageSelection==0?"Save":"Zapisz");
		
		menuBar.add(upperMenu);
		upperMenu.add(saveButton);
		upperMenu.add(subMenuForColour);
		upperMenu.add(subMenuForLanguage);
		upperMenu.add(exitButton);	
		this.setJMenuBar(menuBar);
		
		bottomPanel.add(bottomLeftPanel);
		
		bottomPanel.add(bottomCenterPanel);
		
		startButton = new JButton("Start");
		stopButton = new JButton("Stop");
		resetButton = new JButton("Reset");
		startStopPanel = new JPanel();
		startStopPanel.setLayout(new FlowLayout());
		startStopPanel.add(startButton); startStopPanel.add(stopButton); startStopPanel.add(resetButton);
		bottomPanel.add(startStopPanel);
		
	}
		class  backgroundColorChooser extends JComponent implements ActionListener {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent arg0) {
				Color c;
				c = JColorChooser.showDialog(this, "Choose colour", Color.WHITE);
				centralPanel.setBackground(c);
			}
	}}
	/*public static void main(String[] args) {
		Gui gui = new Gui();
		
		/*SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				JFrame f = new JFrame("Balls");
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				AnimationPanel panel = new AnimationPanel();
				for (int i = 1; i<20 ; i++) panel.addBall();
				
				Ball ball = new Ball();
				
				f.add(panel);
				f.setVisible(true);
				ExecutorService exec = Executors.newFixedThreadPool(2);
				exec.execute(panel);
				ball.run();
				gui.add(f);
				exec.shutdown();
				
			}});
		
		gui.setVisible(true);
	}

}*/
