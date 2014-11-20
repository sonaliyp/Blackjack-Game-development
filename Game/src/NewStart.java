import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewStart extends JFrame {
	public static int numPlayer;
	public static int numDealer;
	public static final String CARD_DIR = "cards_gif";
	
	private JButton Hitme = new JButton("Hit Me!");
	private JButton Stand = new JButton("Stand !");
	private JButton newHand = new JButton("New Hand ");
	private JButton Hint = new JButton("Hint !");
	public JLabel label1 = new JLabel();
	private JLabel label2 = new JLabel();
	private JLabel card1 = new JLabel();
	private JLabel card2dealer = new JLabel();
	private JLabel playercard2 = new JLabel();
	private JLabel playercard1 = new JLabel();

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel jpanel = new JPanel();
	JPanel JpanelDealer = new JPanel();
	Icon icon31 = new ImageIcon("Dealer.png"); // Dealer
	JTextField ScorePlayer = new JTextField(10); // basic

	JPanel panelForSCtry = new JPanel(); // blue
	static JTextField panelForSCtrytxt = new JTextField(4);
	JPanel PlayerSCore = new JPanel(); // blue
	static JTextField plearScoreTxt = new JTextField(4);

	
	static JLabel label = new JLabel();
	static JPanel jp = new JPanel();
	static JPanel sugg = new JPanel();
	static JTextField msg = new JTextField(20);

	
	static String name;


	public static int getRandomNumber() {
		int random = (int) ((System.currentTimeMillis() + Math.random() * 100) % 52);
		return random;
	}

	public NewStart() {
		JPanel panel = new JPanel(); // panel for buttons

		panel1.removeAll();
		JpanelDealer.removeAll();
		
		panelForSCtrytxt.setEditable(false);
		plearScoreTxt.setEditable(false);

		this.add(JpanelDealer, BorderLayout.WEST);
		JpanelDealer.setPreferredSize(new Dimension(400, 150));
		JpanelDealer.setBackground(Color.lightGray);
		this.add(panel1);
		panel.add(Hitme);
		panel.add(Stand);
		panel.add(newHand);
		panel.add(Hint);
		label1.setText("Dealer ");

		label2.setText("             Player");
		panel2.add(label1);
		panel2.add(panelForSCtrytxt, BorderLayout.LINE_END);
		panel2.add(label2);
		panel2.add(plearScoreTxt, BorderLayout.LINE_END);
	

		card1.setBounds(50, 50, 100, 100);
		Icon icon3 = new ImageIcon("Dealer.png");
		card1 = new JLabel(icon3);
		card2dealer = new JLabel(icon3);

		Icon playericon = new ImageIcon("Player.png");
		
		playercard1 = new JLabel(playericon);
		playercard2 = new JLabel(playericon);

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				playercard1);

		playercard1.setLayout(jPanel1Layout);
		panel1.add(card1);
		panel1.add(playercard1);
		panel1.add(playercard2);
		JpanelDealer.add(card1);
		JpanelDealer.add(card2dealer); //add second card
		/**
		 * hit me function
		 */
		Hitme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hitMe();

			}
		});
		/**
		 * Hint action event
		 */
		Hint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Hint");
			
				hintDisply();

			}
		});
		/**
		 * Stand Event
		 */
		Stand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Stand");
			
				dealerStand();
			}
		});
		/*
		 * New Hand
		 */
		newHand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cardisplay();

			}
		});
		
		this.add(panel, BorderLayout.SOUTH);
		panel.setBackground(Color.yellow);
		panel1.setBackground(Color.lightGray);
		panel2.setBackground(Color.yellow);
	
		panel1.setPreferredSize(new Dimension(250, 250));
		this.add(panel1);
		this.add(panel2, BorderLayout.NORTH);
		
	}

	/**
	 * New Hand
	 * 
	 */
	public void cardisplay() {
		setLayout(null);
		numPlayer = 0;
		numDealer = 0;
		panel1.removeAll();
		JpanelDealer.removeAll();
		panel1.repaint();
		JpanelDealer.repaint();

		File file = new File(CARD_DIR);
		String[] fileList = file.list();

		HashMap cardMap = new HashMap();

		for (int count = 0; count < fileList.length; count++) {
			cardMap.put(count, fileList[count]);
		}

		JFrame frame = new JFrame();

		JLabel label1 = new JLabel();
		JLabel label2 = new JLabel();
		
		/**
		 * player card
		 */
		int randomNumPlayer = NewStart.getRandomNumber();
		String fileName1 = (String) cardMap.get(randomNumPlayer);
		Icon icon1 = new ImageIcon(CARD_DIR + "\\" + fileName1);
		label1 = new JLabel(icon1);
		System.out.println("card one  = " + randomNumPlayer);
		/**
		 * dealer card 
		 */
		int randomNumDealer = NewStart.getRandomNumber();
		String fileName2 = (String) cardMap.get(randomNumDealer);
		Icon icon2 = new ImageIcon(CARD_DIR + "\\" + fileName2);
		label2 = new JLabel(icon2);
		
		/**
		 * new hand card
		 */

		card1 = new JLabel(icon31);

		Icon playericon = new ImageIcon("Player.png");
		playercard1 = new JLabel(playericon);
		/**
		 * Player sum
		 */

		if (randomNumPlayer >= 0 && randomNumPlayer <= 12) {
			System.out.println("ans = " + randomNumPlayer);
			randomNumPlayer = randomNumPlayer + 1;
		} else if (randomNumPlayer >= 13 && randomNumPlayer <= 25) {
			System.out.println("ans = " + randomNumPlayer + "-13");
			randomNumPlayer = randomNumPlayer - 13 + 1;
		} else if (randomNumPlayer >= 26 && randomNumPlayer <= 38)

		{
			System.out.println("ans = " + randomNumPlayer + "-26");
			randomNumPlayer = randomNumPlayer - 26 + 1;
		} else if (randomNumPlayer >= 39 && randomNumPlayer <= 51) {
			System.out.println("ans = " + randomNumPlayer + "-39");
			randomNumPlayer = randomNumPlayer - 39 + 1;
		}
		/**
		 * dealer sum 
		 * 
		 */
		if (randomNumDealer >= 0 && randomNumDealer <= 12) {
			randomNumDealer = randomNumDealer + 1;
		} else if (randomNumDealer >= 13 && randomNumDealer <= 25) {
		
			randomNumDealer = randomNumDealer - 13 + 1;
		} else if (randomNumDealer >= 26 && randomNumDealer <= 38) {
		
			randomNumDealer = randomNumDealer - 26 + 1;
		} else if (randomNumDealer >= 39 && randomNumDealer <= 51) {
			
			randomNumDealer = (randomNumDealer - 39) + 1;
		}
		sumOfPlayer(randomNumPlayer);
		sumOfDelaler(randomNumDealer);

		JpanelDealer.add(card1);
		JpanelDealer.add(label2);
		panel1.add(playercard1);

		panel1.add(label1);

		this.add(panel1);
	
		this.setVisible(true);
	}
/**
 * Hit me function
 */
	public void hitMe() {
		File file = new File(CARD_DIR);
		String[] fileList = file.list();
		System.out.println("Hit Me!");
		HashMap cardMap = new HashMap();

		for (int count = 0; count < fileList.length; count++) {
			cardMap.put(count, fileList[count]);
		}

		int randomNumPlayer = NewStart.getRandomNumber();
		String fileName1 = (String) cardMap.get(randomNumPlayer);
		Icon icon1 = new ImageIcon(CARD_DIR + "\\" + fileName1);
		label1 = new JLabel(icon1);
		System.out.println("card one  = " + randomNumPlayer);
		if (randomNumPlayer >= 0 && randomNumPlayer <= 12) {
			System.out.println("ans = " + randomNumPlayer);
			randomNumPlayer = randomNumPlayer + 1;
		} else if (randomNumPlayer >= 13 && randomNumPlayer <= 25) {
			System.out.println("ans = " + randomNumPlayer + "-13");
			randomNumPlayer = randomNumPlayer - 13 + 1;
		} else if (randomNumPlayer >= 26 && randomNumPlayer <= 38)

		{
			System.out.println("ans = " + randomNumPlayer + "-26");
			randomNumPlayer = randomNumPlayer - 26 + 1;
		} else if (randomNumPlayer >= 39 && randomNumPlayer <= 51) {
			System.out.println("ans = " + randomNumPlayer + "-39");
			randomNumPlayer = randomNumPlayer - 39 + 1;
		}
		sumOfPlayer(randomNumPlayer);
		panel1.remove(playercard1);
		panel1.add(label1);// new card add

		this.add(panel1);

		this.setVisible(true);
	}
/**
 * Stand function
 */
	public void stand() {
		JLabel labelofScore = new JLabel();
		File file = new File(CARD_DIR);
		String[] fileList = file.list();
		System.out.println("Hit Me!");
		HashMap cardMap = new HashMap();

		for (int count = 0; count < fileList.length; count++) {
			cardMap.put(count, fileList[count]);
		}
		int randomNumDealer = NewStart.getRandomNumber();
		String fileName2 = (String) cardMap.get(randomNumDealer);
		Icon icon2 = new ImageIcon(CARD_DIR + "\\" + fileName2);
		label2 = new JLabel(icon2);

		if (randomNumDealer >= 0 && randomNumDealer <= 12) {
			randomNumDealer = randomNumDealer + 1;
		} else if (randomNumDealer >= 13 && randomNumDealer <= 25) {
			
			randomNumDealer = randomNumDealer - 13 + 1;
		} else if (randomNumDealer >= 26 && randomNumDealer <= 38) {
			
			randomNumDealer = randomNumDealer - 26 + 1;
		} else if (randomNumDealer >= 39 && randomNumDealer <= 51) {
		
			randomNumDealer = (randomNumDealer - 39) + 1;
		}
		System.out.println("randomNumDealer     =    " + randomNumDealer);

		sumOfDelaler(randomNumDealer);
		JpanelDealer.remove(card1);
	
		JpanelDealer.add(label2);
		

		JpanelDealer.add(labelofScore);
		add(JpanelDealer);

		this.add(panel1);
	
		this.setVisible(true);

	}

	public void dealerStand() {

		int a = 17;

		for (int i = 0; i < 17; i++) {

			if (numDealer <= a) {

				stand();
			} else {

				System.out.println("Dealer stop!");

				break;
			}
		}
		compre();
	}
/**
 * Hint display
 */
	public void hintDisply() {
		int row = 14;

		int column = 12;

		java.lang.String[][] map = new String[row][column];

		try {

			FileReader fileInStrm = new FileReader("Game.txt");

			BufferedReader inFile = new BufferedReader(fileInStrm);

			String inputLine;

			int i = 0;

			while ((inputLine = inFile.readLine()) != null) {
				for (int j = 0; j < column; j++) {

					map[i][j] = inputLine.substring(j, j + 1);
				}

				i++;

			}

			inFile.close();

		} catch (Exception ex) {

			// System.out.println("No such files.");
		}
		
		/**
		 * Display suggestion 
		 */

		String name1 = print(map, numPlayer, numDealer);
		JFrame gui = new JFrame();
		gui.setTitle("images");
		gui.setVisible(true);
		gui.setSize(400, 400);

		label.setIcon(new ImageIcon("Picture1.png"));

		jp.add(label);
		gui.add(jp);
		msg.setEditable(false);
		sugg.add(msg);
		msg.setText(name1);
		sugg.setBackground(Color.blue);
		gui.add(sugg, BorderLayout.SOUTH);
		System.out.println("name = " + name1);
		gui.validate();
		System.out.println("name = " + name1);

	}

	public static void main(String[] args) {
		JFrame frame = new NewStart();
		frame.setTitle("Black Jack Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);

	}

	/**
	 * display hint here
	 * 
	 * @author Sonali
	 * 
	 */
/**
 * sum of player
 * @param num
 * @return
 */
	public static int sumOfPlayer(int num) {
		numPlayer += num;
		System.out.println("sum of player = " + numPlayer);
		plearScoreTxt.setText(String.valueOf(new DecimalFormat("")
				.format(numPlayer)));
		return numPlayer;
	}
/**
 * Sum of dealer
 * @param num
 * @return
 */
	public static int sumOfDelaler(int num) {
		numDealer += num;
		System.out.println("Sum of Dealer = " + numDealer);
		panelForSCtrytxt.setText(String.valueOf(new DecimalFormat("")
				.format(numDealer)));
		return numDealer;
	}

	public static String print(String map[][], int a, int b) {
	
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		int player = a;
		int dealer = b;
		/*
		 * for space
		 */
		if (dealer % 2 == 0) {
			if (dealer > 10) {
				dealer = 10;
			}
		} else {
			dealer = dealer + 1;
			if (dealer > 10) {
				dealer = 10;
			}
		}
		if (player > 17) {
			name = "Stand  Suggestion: [ Hitme or Stand ] ";
			System.out.println("Stand  Suggestion: [ Hitme or Stand  ] ");
			if (player >= 20) {
				name = "you are in the risk ! Take stand  ";
				System.out.println("you are in the risk ! Take stand  ");
			}
		}

		if (player < 7) {
			name = "Suggestion: [ Hitme ] ";
			System.out.println("main name = " + name);
			System.out.println("Suggestion: [ Hitme ] ");
		}
		if (player >= 7 && player <= 17) {

			player = player - 6;
			String d = map[player][dealer];

			if (dealer >= 11) {
				dealer = 10;
			}

			if (d.compareTo("H") == 0) {
				name = "Suggestion: [Hitme or Stand ] ";
				System.out.println("Suggestion: [2 or 3] ");

			}
			if (d.compareTo("S") == 0) {
				name = "Suggestion: [Stand] ";
				System.out.println("Suggestion: [3] ");

			}
			if (d.compareTo("D") == 0) {
				name = "Suggestion: [Hitme] ";
				System.out.println("Suggestion: [ Hitme ] ");

			}

		}
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		
		return name;
	}
/**
 * Compare the dealer and player sum
 */
	public static void compre() {

		int comp = 0;

		if (numDealer > 21 && numPlayer <= 21) {

			System.out.println("House busts! You win!");

		} else {
			if (numPlayer > numDealer && numPlayer <= 21) {
				JOptionPane.showMessageDialog(null,
						"*****  Player Win ! ***** !");
				System.out.println("*****  Player Win ! ***** !");
			} else if (numDealer > numPlayer && numDealer <= 21) {
				JOptionPane
						.showMessageDialog(null, "*****  Dealer Win ! *****");
				System.out.println("*****  Dealer Win ! *****");
			} else if (numPlayer == numDealer && numPlayer == 21
					|| numPlayer > 21 && numDealer > 21) {
				JOptionPane.showMessageDialog(null, "No one win !");
				System.out.println("No one win !");
			}
			if (numPlayer > 21 && numDealer <= 21) {
				JOptionPane
						.showMessageDialog(null, "*****  Dealer Win ! *****");
				System.out.println("*****  Dealer Win ! *****");
			}
			if (numPlayer == numDealer) {
				JOptionPane.showMessageDialog(null, "***** No one win ! *****");
				System.out.println("No one win !");
			}
		}

	}
}

class CirclePanel extends JPanel {
	private int radius = 5;

	public void enlarge() {
		radius++;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius,
		// 2 * radius, 2 * radius);
	}
}