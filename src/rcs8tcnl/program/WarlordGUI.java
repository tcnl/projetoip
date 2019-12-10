package rcs8tcnl.program;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Choice;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Choice;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Rectangle;
import java.awt.Cursor;

import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JFormattedTextField;

import java.awt.ComponentOrientation;

import rcs8tcnl.basics.*;
import rcs8tcnl.exceptions.*;
import rcs8tcnl.front.*;

import javax.swing.UIManager;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTable;
import javax.swing.JTextPane;

public class WarlordGUI extends JFrame {
	public static final String FILES_SPREADSHEET = "Excel.xls";
	public static final String FILES_MONEYINCOME_SHEET = "Money";
	public static final String FILES_PEOPLE_SHEET = "People";
	public static final String FILES_WEAPONS_SHEET = "Weapon";
	public static final String CONFIG_TXT_REPOSITORY = "Config.txt";
	public static final String TXT_ARMY = "Army.txt";
	public static final String TXT_PRISONER = "Prisoner.txt";
	public static final String TXT_INCOME = "Income.txt";
	public static final String TXT_COMPANION = "Companion.txt";
	public static final String TXT_PROFIT = "Profit.txt";
	public static final String FILES_INDEX_SHEET = "Index";

	private TheEmpireBusiness fachada;

	private boolean morreu;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField TF_SWH;
	private JTextField TF_SC;
	private JTextField TF_SID;
	private Choice TF_Wpn;
	private JTextField TF_PID;
	private JTextField TF_PInfoID;
	private JTextField TF_PInfoN;
	private JTextField TF_PInfoA;
	private JTextField TF_PInfoC;
	private JTextField TF_PInfoDP;
	private JTextField TF_PInfoWH;
	private JTextField TF_PInfoS;
	private JTextField TF_SInfoID;
	private JTextField TF_PleasureID;
	private Choice TF_DN;
	private JTextField TF_DW;
	private JTextField TF_DPpK;
	private JTextField TF_PN;
	private JTextField TF_PA;
	private JTextField TF_PC;
	private JTextField TF_PWH;
	private JTextField txtDigiteSeuNome;
	private JTextField TF_SInfoN;
	private JTextField TF_SInfoA;
	private JTextField TF_SInfoC;
	private JComboBox TF_SInfoW;
	private JTextField TF_SInfoWH;
	private JTextField TF_DInfoN;
	private JTextField TF_DInfoW;
	private JTextField TF_DInfoPpK;
	private JTextField TF_DInfoS;
	private JTextField TF_PleasureInfoID;
	private JTextField TF_PleasureInfoN;
	private JTextField TF_PleasureInfoA;
	private JTextField TF_PleasureInfoC;
	private JTextField TF_PleasureInfoWH;
	private JTextField TF_PleasureInfoME;
	private JTextField TF_SA;
	private JComboBox textField_11;
	private JTextField TF_SN;
	private JComboBox txtescolhaAArma;
	private JTextField TF_PInfoCook;
	private JTextField TF_SInfoDC;
	private JTextField TF_SInfoWHA;
	private JTextField TF_DInfoSell;
	private JTextField TF_PleasureInfoDrugs;
	private JComboBox textField_16;

	private Choice TF_SWpn;
	private JTextField TF_WID;
	private Choice TF_WName;
	private JTextField TF_WMagazine;

	private Choice CB_DInfo;

	private Choice CB_PleasureDrugs;
	private JComboBox textField;
	private JTextField TF_PleasureN;
	private JTextField TF_PleasureA;
	private JTextField TF_PleasureWH;
	private JTextField TF_PleasureP;
	private JTextField TF_PleasureC;

	private JTextField TF_PInfoWHA;

	private Choice CB_DFaction;

	private Choice CB_PFaction;

	private Choice TF_WN;
	private JTextField TF_WTAmmo;
	private JTextField TF_WInfoID;
	private JTextField TF_WInfoN;
	private JTextField TF_WInfoM;
	private JTextField TF_WInfoTA;

	private String GR = "Gauss Rifle";
	private String FM = "Fat Man";
	private String PA = "Power Armor";
	private String FT = "Flame Thrower";
	private String PR = "Plasma Rifle";
	private String MG = "Minigun";
	private String SG = "Submachine Gun";
	private String PP = "Pipe Pistol";

	private String PS = "Psycho";
	private String JT = "Jet";
	private String MX = "Med-X";
	private String NC = "Nuka Cola Quantum";
	private String BO = "Buffout";
	private String MT = "Mentats";
	private String RA = "RadAway";
	private String LO = "LoL";

	private String BS = "Brotherhood of Steel";
	private String RD = "Raiders";
	private String IT = "Institute";
	private String GN = "Gunners";
	private JTextField TF_PleasureInfoWHA;

	private Choice CB_DInfoFaction;
	private JTextField TF_SInfoWp2;
	private DefaultListModel modPro;
	private DefaultListModel modArmy;
	private DefaultListModel modDrugs;
	private DefaultListModel modPrisoner;
	private DefaultListModel modPleasure;
	private JTextField TF_WInfoADD;
	private JTextField TF_SInfoS;
	private JTextArea TA_SR;
	private Object textPane;
	private Document doc;
	private AttributeSet keyWord;
	private JTextArea textArea;
	private JList list;
	private JLabel LBL_ReportSoldier;
	private JLabel label_15;
	private JLabel label_17;
	private JLabel label_21;
	private JLabel LBL_PR;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			File file = new File(FILES_SPREADSHEET);
			File config = new File(CONFIG_TXT_REPOSITORY);
			File army = new File(TXT_ARMY);
			File prisoner = new File(TXT_PRISONER);
			File companion = new File(TXT_COMPANION);
			File profit = new File(TXT_PROFIT);

			if (!file.exists()) {
				file.createNewFile();
				FileOutputStream exit = new FileOutputStream(file);
				Workbook workbook = new HSSFWorkbook();
				Sheet paper = workbook.createSheet(FILES_PEOPLE_SHEET);
				Row first = paper.createRow(0);
				first.createCell(0).setCellValue("Dogtag");
				first.createCell(1).setCellValue("Name");
				first.createCell(2).setCellValue("Age");
				first.createCell(3).setCellValue("Status");
				first.createCell(4).setCellValue("Custo Alimentar");
				first.createCell(5).setCellValue("Horas Trabalhadas");
				first.createCell(6).setCellValue("Atributo Pessoal");
				first.createCell(7).setCellValue("Tipo");

				paper = workbook.createSheet(FILES_MONEYINCOME_SHEET);
				first = paper.createRow(0);
				first.createCell(0).setCellValue("Tipo");
				first.createCell(1).setCellValue("ID");
				first.createCell(2).setCellValue("Lucro Ano");
				first.createCell(3).setCellValue("4");
				first.createCell(4).setCellValue("5");
				first.createCell(5).setCellValue("6");
				first.createCell(6).setCellValue("7");
				first.createCell(7).setCellValue("8");
				first.createCell(8).setCellValue("9");
				first.createCell(9).setCellValue("10");

				paper = workbook.createSheet(FILES_WEAPONS_SHEET);
				first = paper.createRow(0);
				first.createCell(0).setCellValue("Serial");
				first.createCell(1).setCellValue("Nome");
				first.createCell(2).setCellValue("Balas por pente");
				first.createCell(3).setCellValue("Balas restantes");
				
				paper = workbook.createSheet(FILES_INDEX_SHEET);
				first = paper.createRow(0);
				first.createCell(0).setCellValue(1);
				first.createCell(1).setCellValue(1);
				first.createCell(2).setCellValue(1);
				
				workbook.write(exit);
				exit.close();
				workbook.close();
			}
			if (!config.exists()) {
				config.createNewFile();
			}
			if (!army.exists()) {
				army.createNewFile();
			}
			if (!prisoner.exists()) {
				prisoner.createNewFile();
			}
			if (!companion.exists()) {
				companion.createNewFile();
			}
			if (!profit.exists()) {
				profit.createNewFile();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					WarlordGUI frame = new WarlordGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WarlordGUI() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
			    int confirmed = JOptionPane.showConfirmDialog(null, 
			        "Você tem certeza que deseja fechar o programa?", "Saindo...",
			        JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	JOptionPane.showMessageDialog(null, "Corre Berg!!");
			    	dispose();
			    }
			  }
			});
		setFont(new Font("Consolas", Font.PLAIN, 12));
		setBackground(Color.WHITE);

		setBounds(new Rectangle(0, 0, 871, 625));
		setMaximumSize(new Dimension(871, 625));
		setMinimumSize(new Dimension(871, 625));
		setPreferredSize(new Dimension(871, 625));
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(WarlordGUI.class.getResource("/images/VaultTecICON_FrameSmall.jpg")));
		setTitle("Valt-Tec Warlord Utility Tool");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 872, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/** 1.0 PAINEIS **/

		final JPanel MainPanel = new JPanel();// PAINEL PRINCIPAL
		MainPanel.setBounds(0, 0, 866, 597);
		contentPane.add(MainPanel);
		MainPanel.setLayout(new CardLayout(0, 0));

		JPanel PanelWS = new JPanel();// PAINEL Welcome
		MainPanel.add(PanelWS, "name_4210317332992");
		PanelWS.setLayout(null);

		// 1.1 - PAINEIS 'DIGITE SEU NOME'

		// PAINEL YourNameBlank
		final JPanel PanelB = new JPanel();
		PanelB.setBounds(10, 342, 846, 204);
		PanelWS.add(PanelB);
		PanelB.setLayout(new CardLayout(0, 0));

		// PAINEL YourName 1
		final JPanel PanelB1 = new JPanel();
		PanelB1.setSize(416, 76);
		PanelB1.setLocation(170, 0);
		PanelB.add(PanelB1, "name_4514765440391");
		PanelB1.setLayout(null);

		// PAINEL YourName 2
		final JPanel PanelB2 = new JPanel();
		PanelB.add(PanelB2, "name_4517335780685");
		PanelB2.setLayout(null);

		// PAINEL YourName 3
		final JPanel PanelB3 = new JPanel();
		PanelB3.setToolTipText("Vamos come\u00E7ar!");
		PanelB3.setBorder(null);
		PanelB.add(PanelB3, "name_4519724189236");
		PanelB3.setLayout(null);

		// 1.2 - PAINEIS 'TELA INICIAL'

		// PAINEL MainScreen
		final JPanel PanelMS = new JPanel();
		MainPanel.add(PanelMS, "name_4779650582918");
		PanelMS.setLayout(null);

		// PAINEL Class
		final JPanel ClassPanel = new JPanel();
		ClassPanel.setBounds(10, 11, 846, 535);
		PanelMS.add(ClassPanel);
		ClassPanel.setLayout(new CardLayout(0, 0));

		// PAINEL ClassBlank
		final JPanel BlankClass = new JPanel();
		ClassPanel.add(BlankClass, "name_73519682075641");
		BlankClass.setLayout(null);

		// PAINEL PleasureGiverReport
		final JPanel PleasureGiverReport = new JPanel();
		PleasureGiverReport.setLayout(null);
		ClassPanel.add(PleasureGiverReport, "name_6936079353148");

		// PAINEL DrugsReport
		final JPanel DrugsReport = new JPanel();
		DrugsReport.setLayout(null);
		ClassPanel.add(DrugsReport, "name_6483926327169");

		// PAINEL PleasureGiverInfo
		final JPanel PleasureGiverInfo = new JPanel();
		ClassPanel.add(PleasureGiverInfo, "name_347199458329203");
		PleasureGiverInfo.setLayout(null);

		JLabel lblMenuPrincipal = new JLabel("Menu Principal");
		lblMenuPrincipal.setForeground(Color.GREEN);
		lblMenuPrincipal.setBounds(0, 0, 846, 74);
		BlankClass.add(lblMenuPrincipal);
		lblMenuPrincipal.setFont(new Font("Consolas", Font.PLAIN, 23));
		lblMenuPrincipal.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel LBL_BlankArmy = new JLabel("");
		LBL_BlankArmy.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/VaultBoy_SoldierInfo2.1.png")));
		LBL_BlankArmy.setBounds(-6, 0, 260, 535);
		BlankClass.add(LBL_BlankArmy);

		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/VaultGirl.png")));
		label_4.setBounds(377, 0, 244, 535);
		BlankClass.add(label_4);

		JLabel label_5 = new JLabel("");
		label_5.setSize(new Dimension(480, 320));
		label_5.setMinimumSize(new Dimension(480, 320));
		label_5.setMaximumSize(new Dimension(480, 320));
		label_5.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/VaultBerg.png")));
		label_5.setBounds(586, 11, 260, 524);
		BlankClass.add(label_5);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/VB_DD01_deco_1.png")));
		label_3.setBounds(247, 0, 260, 535);
		BlankClass.add(label_3);

		JLabel LBL_BlankClass_WP = new JLabel("");
		LBL_BlankClass_WP.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_BlankClass_WP.setBounds(0, 0, 866, 597);
		BlankClass.add(LBL_BlankClass_WP);

		// PAINEL SoldierInfo
		final JPanel SoldierInfo = new JPanel();
		ClassPanel.add(SoldierInfo, "name_72991565541169");
		SoldierInfo.setLayout(null);

		final JPanel BasicDrugs = new JPanel();
		ClassPanel.add(BasicDrugs, "name_79571956055745");
		BasicDrugs.setLayout(null);

		JLabel LBL_DN = new JLabel("Nome:");
		LBL_DN.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_DN.setForeground(Color.GREEN);
		LBL_DN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DN.setBounds(175, 61, 305, 46);
		BasicDrugs.add(LBL_DN);

		JLabel LBL_DW = new JLabel("Peso:");
		LBL_DW.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_DW.setForeground(Color.GREEN);
		LBL_DW.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DW.setBounds(175, 177, 305, 46);
		BasicDrugs.add(LBL_DW);

		JLabel LBL_PpK = new JLabel("Pre\u00E7o por quilo:");
		LBL_PpK.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PpK.setForeground(Color.GREEN);
		LBL_PpK.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PpK.setBounds(175, 293, 305, 46);
		BasicDrugs.add(LBL_PpK);

		final JPanel DrugsInfo = new JPanel();
		ClassPanel.add(DrugsInfo, "name_6670321532566");
		DrugsInfo.setLayout(null);

		final Choice TF_DN = new Choice();
		TF_DN.add(PS);
		TF_DN.add(JT);
		TF_DN.add(MX);
		TF_DN.add(NC);
		TF_DN.add(BO);
		TF_DN.add(MT);
		TF_DN.add(RA);
		TF_DN.add(LO);
		TF_DN.setForeground(Color.GREEN);
		TF_DN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DN.setBounds(490, 61, 305, 46);
		BasicDrugs.add(TF_DN);

		TF_DW = new JTextField();
		TF_DW.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_DW.setSelectionColor(Color.BLACK);
		TF_DW.setSelectedTextColor(Color.GREEN);
		TF_DW.setForeground(Color.GREEN);
		TF_DW.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DW.setDisabledTextColor(Color.GREEN);
		TF_DW.setColumns(10);
		TF_DW.setBounds(490, 177, 305, 46);
		BasicDrugs.add(TF_DW);

		TF_DPpK = new JTextField();
		TF_DPpK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_DPpK.setSelectionColor(Color.BLACK);
		TF_DPpK.setSelectedTextColor(Color.GREEN);
		TF_DPpK.setForeground(Color.GREEN);
		TF_DPpK.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DPpK.setDisabledTextColor(Color.GREEN);
		TF_DPpK.setColumns(10);
		TF_DPpK.setBounds(490, 293, 305, 46);
		BasicDrugs.add(TF_DPpK);

		JButton button_1 = new JButton("Cadastrar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TF_DW.getText().equalsIgnoreCase("") || TF_DPpK.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os dados para realizar o cadastro.");
				} else {
					String id = TF_DN.getSelectedItem();
					double PpK = Double.parseDouble(TF_DPpK.getText());
					double w = Double.parseDouble(TF_DW.getText());
					insertDrugs(w, PpK, id);
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
				}
			}
		});
		button_1.setToolTipText("Cadastra um soldado.");
		button_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(36, 475, 125, 36);
		BasicDrugs.add(button_1);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String id = TF_DN.getSelectedItem();
					searchDrugs(id);
					ClassPanel.removeAll();
					ClassPanel.repaint();
					ClassPanel.revalidate();

					ClassPanel.add(DrugsInfo);
					ClassPanel.repaint();
					ClassPanel.revalidate();
				}
		});
		btnProcurar.setToolTipText("Cadastra um soldado.");
		btnProcurar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnProcurar.setBackground(Color.WHITE);
		btnProcurar.setBounds(358, 475, 125, 36);
		BasicDrugs.add(btnProcurar);

		JButton btnRelatorio = new JButton("Relatorio");
		btnRelatorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reportDrugs();
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(DrugsReport);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		btnRelatorio.setToolTipText("Cadastra um soldado.");
		btnRelatorio.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnRelatorio.setBackground(Color.WHITE);
		btnRelatorio.setBounds(680, 475, 125, 36);
		BasicDrugs.add(btnRelatorio);

		JLabel LBL_DWP1 = new JLabel("");
		LBL_DWP1.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/oie_transparent.png")));
		LBL_DWP1.setBounds(0, 0, 846, 535);
		BasicDrugs.add(LBL_DWP1);

		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_6.setBounds(0, 0, 846, 535);
		BasicDrugs.add(label_6);

		TF_DInfoN = new JTextField();
		TF_DInfoN.setSelectionColor(Color.BLACK);
		TF_DInfoN.setSelectedTextColor(Color.GREEN);
		TF_DInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DInfoN.setEditable(false);
		TF_DInfoN.setColumns(10);
		TF_DInfoN.setBounds(500, 42, 305, 46);
		DrugsInfo.add(TF_DInfoN);

		TF_DInfoW = new JTextField();
		TF_DInfoW.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_DInfoW.setSelectionColor(Color.BLACK);
		TF_DInfoW.setSelectedTextColor(Color.GREEN);
		TF_DInfoW.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DInfoW.setEditable(false);
		TF_DInfoW.setColumns(10);
		TF_DInfoW.setBounds(500, 138, 305, 46);
		DrugsInfo.add(TF_DInfoW);

		TF_DInfoPpK = new JTextField();
		TF_DInfoPpK.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_DInfoPpK.setSelectionColor(Color.BLACK);
		TF_DInfoPpK.setSelectedTextColor(Color.GREEN);
		TF_DInfoPpK.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DInfoPpK.setEditable(false);
		TF_DInfoPpK.setColumns(10);
		TF_DInfoPpK.setBounds(500, 234, 305, 46);
		DrugsInfo.add(TF_DInfoPpK);

		TF_DInfoS = new JTextField();
		TF_DInfoS.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_DInfoS.setSelectionColor(Color.BLACK);
		TF_DInfoS.setSelectedTextColor(Color.GREEN);
		TF_DInfoS.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_DInfoS.setEditable(false);
		TF_DInfoS.setColumns(10);
		TF_DInfoS.setBounds(500, 330, 305, 46);
		DrugsInfo.add(TF_DInfoS);

		JButton BTN_DInfoBack = new JButton("Voltar");
		BTN_DInfoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicDrugs);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		BTN_DInfoBack.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_DInfoBack.setBackground(Color.WHITE);
		BTN_DInfoBack.setBounds(62, 499, 125, 36);
		DrugsInfo.add(BTN_DInfoBack);

		TF_DInfoSell = new JTextField();
		TF_DInfoSell.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_DInfoSell.setBounds(199, 433, 125, 20);
		DrugsInfo.add(TF_DInfoSell);
		TF_DInfoSell.setColumns(10);

		JButton BTN_DInfoSell = new JButton("Vender");
		BTN_DInfoSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String faction = CB_DInfoFaction.getSelectedItem();
				sellDrugs(faction);
				JOptionPane.showMessageDialog(null, "Drogas vendidas com sucesso");
			}
		});
		BTN_DInfoSell.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_DInfoSell.setBackground(Color.WHITE);
		BTN_DInfoSell.setBounds(199, 499, 125, 36);
		DrugsInfo.add(BTN_DInfoSell);

		CB_DInfoFaction = new Choice();
		CB_DInfoFaction.addItem(BS);
		CB_DInfoFaction.addItem(RD);
		CB_DInfoFaction.addItem(GN);
		CB_DInfoFaction.addItem(IT);
		CB_DInfoFaction.setForeground(Color.GREEN);
		CB_DInfoFaction.setFont(new Font("Consolas", Font.PLAIN, 11));
		CB_DInfoFaction.setBounds(175, 459, 169, 20);
		DrugsInfo.add(CB_DInfoFaction);

		JLabel LBL_DInfoN = new JLabel("Nome:");
		LBL_DInfoN.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_DInfoN.setForeground(Color.GREEN);
		LBL_DInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DInfoN.setBounds(185, 42, 305, 46);
		DrugsInfo.add(LBL_DInfoN);

		JLabel LBL_DInfoW = new JLabel("Peso:");
		LBL_DInfoW.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_DInfoW.setForeground(Color.GREEN);
		LBL_DInfoW.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DInfoW.setBounds(185, 138, 305, 46);
		DrugsInfo.add(LBL_DInfoW);

		JLabel LBL_DInfoPpK = new JLabel("Pre\u00E7o por quilo:");
		LBL_DInfoPpK.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_DInfoPpK.setForeground(Color.GREEN);
		LBL_DInfoPpK.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DInfoPpK.setBounds(185, 234, 305, 46);
		DrugsInfo.add(LBL_DInfoPpK);

		JLabel LBL_DInfoS = new JLabel("Montante atual:");
		LBL_DInfoS.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_DInfoS.setForeground(Color.GREEN);
		LBL_DInfoS.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DInfoS.setBounds(185, 330, 305, 46);
		DrugsInfo.add(LBL_DInfoS);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/oie_transparent.png")));
		label.setBounds(0, 0, 846, 535);
		DrugsInfo.add(label);

		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_8.setBounds(0, 0, 846, 535);
		DrugsInfo.add(label_8);

		final JPanel BasicPleasureGiver = new JPanel();
		ClassPanel.add(BasicPleasureGiver, "name_78975624675952");
		BasicPleasureGiver.setLayout(null);

		TF_PleasureID = new JTextField();
		TF_PleasureID.setSelectionColor(Color.BLACK);
		TF_PleasureID.setSelectedTextColor(Color.GREEN);
		TF_PleasureID.setForeground(Color.GREEN);
		TF_PleasureID.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PleasureID.setBounds(490, 0, 305, 46);
		BasicPleasureGiver.add(TF_PleasureID);
		TF_PleasureID.setColumns(10);

		JLabel LBL_PGID = new JLabel("ID:");
		LBL_PGID.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PGID.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PGID.setForeground(Color.GREEN);
		LBL_PGID.setBounds(175, 0, 305, 46);
		BasicPleasureGiver.add(LBL_PGID);

		JLabel LBL_PGN = new JLabel("Nome:");
		LBL_PGN.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PGN.setForeground(Color.GREEN);
		LBL_PGN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PGN.setBounds(175, 83, 305, 46);
		BasicPleasureGiver.add(LBL_PGN);

		JLabel LBL_PGA = new JLabel("Idade:");
		LBL_PGA.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PGA.setForeground(Color.GREEN);
		LBL_PGA.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PGA.setBounds(175, 166, 305, 46);
		BasicPleasureGiver.add(LBL_PGA);

		JLabel LBL_PGWH = new JLabel("Horas de Trabalho:");
		LBL_PGWH.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PGWH.setForeground(Color.GREEN);
		LBL_PGWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PGWH.setBounds(175, 249, 305, 46);
		BasicPleasureGiver.add(LBL_PGWH);

		JLabel LBL_PGC = new JLabel("Custo:");
		LBL_PGC.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PGC.setForeground(Color.GREEN);
		LBL_PGC.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PGC.setBounds(175, 329, 305, 46);
		BasicPleasureGiver.add(LBL_PGC);

		JButton btnCadastrar_1 = new JButton("Cadastrar");
		btnCadastrar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TF_PleasureID.getText().equalsIgnoreCase("") || TF_PleasureN.getText().equalsIgnoreCase("")
						|| TF_PleasureA.getText().equalsIgnoreCase("") || TF_PleasureC.getText().equalsIgnoreCase("")
						|| TF_PleasureP.getText().equalsIgnoreCase("")
						|| TF_PleasureWH.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos para realizar o cadastro.");
				} else {
					insertPleasure();
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
				}
			}
		});
		btnCadastrar_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnCadastrar_1.setBackground(Color.WHITE);
		btnCadastrar_1.setBounds(36, 488, 125, 36);
		BasicPleasureGiver.add(btnCadastrar_1);

		JButton btnProcurar_1 = new JButton("Procurar");
		btnProcurar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				if(TF_PleasureID.getText().equalsIgnoreCase("")){
				JOptionPane.showMessageDialog(null, "Preencha o campo de ID para realizar a busca!");
				}else{
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(PleasureGiverInfo);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				searchPleasure();
				}
			}
		});
		btnProcurar_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnProcurar_1.setBackground(Color.WHITE);
		btnProcurar_1.setBounds(358, 488, 125, 36);
		BasicPleasureGiver.add(btnProcurar_1);

		JButton btnRelatorio_2 = new JButton("Relatorio");
		btnRelatorio_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				reportPleasure();
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(PleasureGiverReport);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				
			}
		});
		btnRelatorio_2.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnRelatorio_2.setBackground(Color.WHITE);
		btnRelatorio_2.setBounds(680, 488, 125, 36);
		BasicPleasureGiver.add(btnRelatorio_2);

		TF_PleasureN = new JTextField();
		TF_PleasureN.setSelectionColor(Color.BLACK);
		TF_PleasureN.setSelectedTextColor(Color.GREEN);
		TF_PleasureN.setForeground(Color.GREEN);
		TF_PleasureN.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PleasureN.setColumns(10);
		TF_PleasureN.setBounds(490, 83, 305, 46);
		BasicPleasureGiver.add(TF_PleasureN);

		TF_PleasureA = new JTextField();
		TF_PleasureA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureA.setSelectionColor(Color.BLACK);
		TF_PleasureA.setSelectedTextColor(Color.GREEN);
		TF_PleasureA.setForeground(Color.GREEN);
		TF_PleasureA.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PleasureA.setColumns(10);
		TF_PleasureA.setBounds(490, 166, 305, 46);
		BasicPleasureGiver.add(TF_PleasureA);

		TF_PleasureWH = new JTextField();
		TF_PleasureWH.setSelectionColor(Color.BLACK);
		TF_PleasureWH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		// TF_PleasureP.setSelectedTextColor(Color.GREEN);
		TF_PleasureWH.setForeground(Color.GREEN);
		TF_PleasureWH.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PleasureWH.setColumns(10);
		TF_PleasureWH.setBounds(490, 249, 305, 46);
		BasicPleasureGiver.add(TF_PleasureWH);

		TF_PleasureP = new JTextField();
		TF_PleasureP.setSelectionColor(Color.BLACK);
		TF_PleasureP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		// TF_PleasureC.setSelectedTextColor(Color.GREEN);
		TF_PleasureP.setForeground(Color.GREEN);
		TF_PleasureP.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PleasureP.setColumns(10);
		TF_PleasureP.setBounds(490, 415, 305, 46);
		BasicPleasureGiver.add(TF_PleasureP);

		TF_PleasureC = new JTextField();
		TF_PleasureC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		TF_PleasureC.setSelectionColor(Color.BLACK);
		TF_PleasureC.setSelectedTextColor(Color.GREEN);
		TF_PleasureC.setForeground(Color.GREEN);
		TF_PleasureC.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PleasureC.setColumns(10);
		TF_PleasureC.setBounds(490, 332, 305, 46);
		BasicPleasureGiver.add(TF_PleasureC);

		JLabel lblPreo = new JLabel("Pre\u00E7o:");
		lblPreo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPreo.setForeground(Color.GREEN);
		lblPreo.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblPreo.setBounds(175, 412, 305, 46);
		BasicPleasureGiver.add(lblPreo);

		JLabel LBL_PGWP1 = new JLabel("");
		LBL_PGWP1.setIcon(new ImageIcon(
				WarlordGUI.class.getResource("/images/vault_girl_vector_by_that_medic_is_a_spy-d98h39z.jpg.png")));
		LBL_PGWP1.setBounds(0, 0, 846, 535);
		BasicPleasureGiver.add(LBL_PGWP1);

		JLabel LBL_PGWP2 = new JLabel("");
		LBL_PGWP2.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_PGWP2.setBounds(0, 0, 846, 535);
		BasicPleasureGiver.add(LBL_PGWP2);

		JButton button_3 = new JButton("Voltar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicPleasureGiver);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		
		DefaultListModel modPleasure = new DefaultListModel();
		// PleasureGiverReport.add(List_PG);
		button_3.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(761, 16, 75, 25);
		PleasureGiverReport.add(button_3);
			label_17 = new JLabel("");
			label_17.setVerticalAlignment(SwingConstants.TOP);

		JScrollPane SP_PGR = new JScrollPane();
		SP_PGR.setBounds(0, 39, 846, 496);
		PleasureGiverReport.add(SP_PGR);
		SP_PGR.setViewportView(label_17);
		
		
		JLabel LBLPGRWP2 = new JLabel("Relat\u00F3rio das Senhoras");
		LBLPGRWP2.setHorizontalAlignment(SwingConstants.CENTER);
		LBLPGRWP2.setForeground(Color.GREEN);
		LBLPGRWP2.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBLPGRWP2.setBounds(0, 0, 844, 50);
		PleasureGiverReport.add(LBLPGRWP2);

		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_11.setBounds(0, 0, 844, 535);
		PleasureGiverReport.add(label_11);

		JButton button_4 = new JButton("Voltar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicDrugs);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		button_4.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(761, 16, 75, 25);
		DrugsReport.add(button_4);
		
		label_15 = new JLabel("");
		label_15.setVerticalAlignment(SwingConstants.TOP);
		
		JScrollPane SP_DR = new JScrollPane();
		SP_DR.setBounds(0, 40, 846, 495);
		DrugsReport.add(SP_DR);
		SP_DR.setViewportView(label_15);
		
		

		JLabel LBL_DR_AR = new JLabel("Relat\u00F3rio das Drogas");
		LBL_DR_AR.setHorizontalAlignment(SwingConstants.CENTER);
		LBL_DR_AR.setForeground(Color.GREEN);
		LBL_DR_AR.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_DR_AR.setBounds(0, 0, 844, 50);
		DrugsReport.add(LBL_DR_AR);

		JLabel LBL_DRWP1 = new JLabel("");
		LBL_DRWP1.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_DRWP1.setBounds(0, 0, 846, 535);
		DrugsReport.add(LBL_DRWP1);
		// scrollBar.setVerticalScrollBarPolicy(scrollBar.VERTICAL_SCROLLBAR_ALWAYS);

		final JPanel BasicArmy = new JPanel();
		ClassPanel.add(BasicArmy, "name_72988566623943");
		BasicArmy.setLayout(null);

		TF_SWH = new JTextField();
		TF_SWH.setForeground(Color.GREEN);
		TF_SWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SWH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SWH.setSelectionColor(Color.BLACK);
		TF_SWH.setSelectedTextColor(Color.GREEN);
		TF_SWH.setBounds(510, 289, 305, 35);
		BasicArmy.add(TF_SWH);
		TF_SWH.setColumns(10);

		TF_SC = new JTextField();
		TF_SC.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SC.setForeground(Color.GREEN);
		TF_SC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SC.setSelectionColor(Color.BLACK);
		TF_SC.setSelectedTextColor(Color.GREEN);
		TF_SC.setBounds(510, 360, 305, 35);
		BasicArmy.add(TF_SC);
		TF_SC.setColumns(10);

		TF_SID = new JTextField();
		TF_SID.setForeground(Color.GREEN);
		TF_SID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SID.setSelectedTextColor(Color.GREEN);
		TF_SID.setSelectionColor(Color.BLACK);
		TF_SID.setBounds(510, 5, 305, 35);
		BasicArmy.add(TF_SID);
		TF_SID.setColumns(10);

		// PAINEL DE RELATORIO DO EXERCITO
		final JPanel SoldierReport = new JPanel();
		SoldierReport.setBackground(Color.WHITE);
		ClassPanel.add(SoldierReport, "name_1664368280105");
		SoldierReport.setLayout(null);

		TF_SA = new JTextField();
		TF_SA.setForeground(Color.GREEN);
		TF_SA.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SA.setSelectionColor(Color.BLACK);
		TF_SA.setSelectedTextColor(Color.GREEN);
		TF_SA.setColumns(10);
		TF_SA.setBounds(510, 147, 305, 35);
		BasicArmy.add(TF_SA);

		TF_SN = new JTextField();
		TF_SN.setForeground(Color.GREEN);
		TF_SN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SN.setSelectionColor(Color.BLACK);
		TF_SN.setSelectedTextColor(Color.GREEN);
		TF_SN.setColumns(10);
		TF_SN.setBounds(510, 76, 305, 35);
		BasicArmy.add(TF_SN);

		final Choice TF_SWpn = new Choice();
		TF_SWpn.add(GR);
		TF_SWpn.add(FM);
		TF_SWpn.add(PA);
		TF_SWpn.add(FT);
		TF_SWpn.add(PR);
		TF_SWpn.add(MG);
		TF_SWpn.add(SG);
		TF_SWpn.add(PP);
		TF_SWpn.setBackground(Color.WHITE);
		TF_SWpn.setForeground(Color.GREEN);
		TF_SWpn.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SWpn.setBounds(510, 218, 305, 35);
		BasicArmy.add(TF_SWpn);

		JLabel LBL_SID = new JLabel("ID:");
		LBL_SID.setForeground(Color.GREEN);
		LBL_SID.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SID.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SID.setBounds(193, 5, 305, 46);
		BasicArmy.add(LBL_SID);

		JLabel LBL_SN = new JLabel("Nome:");
		LBL_SN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SN.setForeground(Color.GREEN);
		LBL_SN.setBounds(193, 77, 305, 46);
		BasicArmy.add(LBL_SN);
		LBL_SN.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel LBL_SA = new JLabel("Idade:");
		LBL_SA.setForeground(Color.GREEN);
		LBL_SA.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SA.setBounds(193, 149, 305, 46);
		BasicArmy.add(LBL_SA);
		LBL_SA.setHorizontalAlignment(SwingConstants.TRAILING);

		JLabel LBL_SW = new JLabel("Arma:");
		LBL_SW.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SW.setForeground(Color.GREEN);
		LBL_SW.setBounds(193, 221, 305, 46);
		BasicArmy.add(LBL_SW);
		LBL_SW.setHorizontalAlignment(SwingConstants.TRAILING);

		TF_PWH = new JTextField();
		TF_PWH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});

		JButton BTN_SInsert = new JButton("Cadastrar");

		BTN_SInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TF_SID.getText().equalsIgnoreCase("") || TF_SN.getText().equalsIgnoreCase("")
						|| TF_SA.getText().equalsIgnoreCase("") || TF_SC.getText().equalsIgnoreCase("")
						|| TF_SWH.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos para realizar o cadastro.");
				} else {
					String id = TF_SID.getText();
					String name = TF_SN.getText();
					int age = Integer.parseInt(TF_SA.getText());
					String weapon = TF_SWpn.getSelectedItem();
					double cost = Double.parseDouble(TF_SC.getText());
					int wh = Integer.parseInt(TF_SWH.getText());
					insertArmy(name, age, cost, wh, id, true, weapon);

					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
				}

			}
		});
		BTN_SInsert.setBackground(Color.WHITE);
		BTN_SInsert.setToolTipText("Cadastra um soldado.");
		BTN_SInsert.setFont(new Font("Consolas", Font.PLAIN, 14));
		BTN_SInsert.setBounds(117, 488, 125, 36);
		BasicArmy.add(BTN_SInsert);

		JButton BTN_SSearch = new JButton("Procurar");
		BTN_SSearch.setBackground(Color.WHITE);
		BTN_SSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TF_SID.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Campo ID vazio, preencha-o para poder procurar.");
				} else {
					searchArmy(TF_SID.getText());
					ClassPanel.removeAll();
					ClassPanel.repaint();
					ClassPanel.revalidate();
					ClassPanel.add(SoldierInfo);
					ClassPanel.repaint();
					ClassPanel.revalidate();
				}
			}
		});
		BTN_SSearch.setToolTipText("Procura um soldado pelo ID dele.");
		BTN_SSearch.setFont(new Font("Consolas", Font.PLAIN, 14));
		BTN_SSearch.setBounds(359, 488, 125, 36);
		BasicArmy.add(BTN_SSearch);

		DefaultListModel modArmy = new DefaultListModel();

		JButton BTN_SReport = new JButton("Relat\u00F3rio");
		BTN_SReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				String report = "hahahaha";
				reportArmy();
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();
				ClassPanel.add(SoldierReport);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		BTN_SReport.setToolTipText("Relatorio dos soldados");
		BTN_SReport.setFont(new Font("Consolas", Font.PLAIN, 14));
		BTN_SReport.setBackground(Color.WHITE);
		BTN_SReport.setBounds(601, 488, 125, 36);
		BasicArmy.add(BTN_SReport);

		JLabel lblHorasDeTrabalho_2 = new JLabel("Horas de trabalho:");
		lblHorasDeTrabalho_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHorasDeTrabalho_2.setForeground(Color.GREEN);
		lblHorasDeTrabalho_2.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblHorasDeTrabalho_2.setBounds(193, 293, 305, 46);
		BasicArmy.add(lblHorasDeTrabalho_2);

		JLabel lblCusto_2 = new JLabel("Custo:");
		lblCusto_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCusto_2.setForeground(Color.GREEN);
		lblCusto_2.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblCusto_2.setBounds(193, 365, 305, 46);
		BasicArmy.add(lblCusto_2);

		JLabel LBL_SWP2 = new JLabel("");
		LBL_SWP2.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/VaultBoy_SoldierInfo2.png")));
		LBL_SWP2.setBounds(0, 0, 846, 477);
		BasicArmy.add(LBL_SWP2);

		JLabel LBL_SWP = new JLabel("");
		LBL_SWP.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_SWP.setBounds(0, 0, 862, 535);
		BasicArmy.add(LBL_SWP);

		JButton BTN_Army = new JButton("Exercito");
		BTN_Army.setBackground(Color.WHITE);
		BTN_Army.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_Army.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicArmy);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				SoldierInfo.setVisible(false);
				BasicArmy.setVisible(true);
			}
		});

		// PAINEL PrisonerInfo
		final JPanel PrisonerInfo = new JPanel();
		ClassPanel.add(PrisonerInfo, "name_73019197572860");
		PrisonerInfo.setLayout(null);

		// PrisonerInfoStuff

		// TextFields

		TF_PInfoID = new JTextField();
		TF_PInfoID.setDisabledTextColor(Color.GREEN);
		TF_PInfoID.setSelectionColor(Color.BLACK);
		TF_PInfoID.setSelectedTextColor(Color.GREEN);
		TF_PInfoID.setForeground(Color.GREEN);
		TF_PInfoID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PInfoID.setEditable(false);
		TF_PInfoID.setBounds(490, 27, 305, 46);
		PrisonerInfo.add(TF_PInfoID);
		TF_PInfoID.setColumns(10);

		TF_PInfoN = new JTextField();
		TF_PInfoN.setSelectedTextColor(Color.GREEN);
		TF_PInfoN.setSelectionColor(Color.BLACK);
		TF_PInfoN.setForeground(Color.GREEN);
		TF_PInfoN.setFont(new Font("Consolas", Font.PLAIN, 26));
		TF_PInfoN.setBounds(490, 98, 305, 46);
		PrisonerInfo.add(TF_PInfoN);
		TF_PInfoN.setColumns(10);

		TF_PInfoA = new JTextField();
		TF_PInfoA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PInfoA.setSelectionColor(Color.BLACK);
		TF_PInfoA.setSelectedTextColor(Color.GREEN);
		TF_PInfoA.setForeground(Color.GREEN);
		TF_PInfoA.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PInfoA.setBounds(490, 170, 305, 46);
		PrisonerInfo.add(TF_PInfoA);
		TF_PInfoA.setColumns(10);

		TF_PInfoC = new JTextField();
		TF_PInfoC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PInfoC.setSelectedTextColor(Color.GREEN);
		TF_PInfoC.setSelectionColor(Color.BLACK);
		TF_PInfoC.setForeground(Color.GREEN);
		TF_PInfoC.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PInfoC.setBounds(490, 242, 305, 46);
		PrisonerInfo.add(TF_PInfoC);
		TF_PInfoC.setColumns(10);

		TF_PInfoDP = new JTextField();
		TF_PInfoDP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PInfoDP.setSelectionColor(Color.BLACK);
		TF_PInfoDP.setSelectedTextColor(Color.GREEN);
		TF_PInfoDP.setForeground(Color.GREEN);
		TF_PInfoDP.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PInfoDP.setBounds(490, 314, 305, 46);
		PrisonerInfo.add(TF_PInfoDP);
		TF_PInfoDP.setColumns(10);

		TF_PInfoWH = new JTextField();
		TF_PInfoWH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PInfoWH.setSelectedTextColor(Color.GREEN);
		TF_PInfoWH.setSelectionColor(Color.BLACK);
		TF_PInfoWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PInfoWH.setForeground(Color.GREEN);
		TF_PInfoWH.setBounds(490, 386, 305, 46);
		PrisonerInfo.add(TF_PInfoWH);
		TF_PInfoWH.setColumns(10);

		TF_PInfoS = new JTextField();
		TF_PInfoS.setSelectionColor(Color.BLACK);
		TF_PInfoS.setSelectedTextColor(Color.GREEN);
		TF_PInfoS.setForeground(Color.GREEN);
		TF_PInfoS.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PInfoS.setEditable(false);
		TF_PInfoS.setBounds(490, 458, 305, 46);
		PrisonerInfo.add(TF_PInfoS);
		TF_PInfoS.setColumns(10);

		// Labels
		JLabel LBL_PInfoN = new JLabel("Nome:");
		LBL_PInfoN.setForeground(Color.GREEN);
		LBL_PInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoN.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoN.setBounds(175, 98, 305, 46);
		PrisonerInfo.add(LBL_PInfoN);

		JLabel LBL_PInfoA = new JLabel("Idade:");
		LBL_PInfoA.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoA.setForeground(Color.GREEN);
		LBL_PInfoA.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoA.setBounds(175, 170, 305, 46);
		PrisonerInfo.add(LBL_PInfoA);

		JLabel LBL_PInfoID = new JLabel("ID:");
		LBL_PInfoID.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoID.setForeground(Color.GREEN);
		LBL_PInfoID.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoID.setBounds(175, 26, 305, 46);
		PrisonerInfo.add(LBL_PInfoID);

		JLabel LBL_PInfoC = new JLabel("Custo:");
		LBL_PInfoC.setForeground(Color.GREEN);
		LBL_PInfoC.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoC.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoC.setBounds(175, 242, 305, 46);
		PrisonerInfo.add(LBL_PInfoC);

		JLabel LBL_PInfoDP = new JLabel("Drogas produzidas:");
		LBL_PInfoDP.setForeground(Color.GREEN);
		LBL_PInfoDP.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoDP.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoDP.setBounds(175, 314, 305, 46);
		PrisonerInfo.add(LBL_PInfoDP);

		JLabel LBL_PInfoWH = new JLabel("Horas de trabalho:");
		LBL_PInfoWH.setForeground(Color.GREEN);
		LBL_PInfoWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoWH.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoWH.setBounds(175, 386, 305, 46);
		PrisonerInfo.add(LBL_PInfoWH);

		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePrisoner();
				JOptionPane.showMessageDialog(null, "Prisioneiro executado com sucesso");
			}
		});
		btnExecutar.setToolTipText("Executa o prisioneiro.");
		btnExecutar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnExecutar.setBackground(Color.WHITE);
		btnExecutar.setBounds(145, 466, 125, 36);
		PrisonerInfo.add(btnExecutar);

		JLabel LBL_PInfoS = new JLabel("Status:");
		LBL_PInfoS.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PInfoS.setForeground(Color.GREEN);
		LBL_PInfoS.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_PInfoS.setBounds(175, 458, 305, 46);
		PrisonerInfo.add(LBL_PInfoS);

		JButton BTN_PInfoBack = new JButton("Voltar");
		BTN_PInfoBack.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PInfoBack.setBackground(Color.WHITE);
		BTN_PInfoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BlankClass);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				PrisonerInfo.setVisible(false);
			}
		});
		BTN_PInfoBack.setBounds(10, 466, 125, 36);
		PrisonerInfo.add(BTN_PInfoBack);

		JButton btnCozinhar = new JButton("Cozinhar");
		btnCozinhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TF_PInfoWHA.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha a quantidade de horas trabalhadas");
				} else {
					String faction = CB_DFaction.getSelectedItem();
					String drug = CB_DInfo.getSelectedItem();
					letsCook(drug, faction);
					JOptionPane.showMessageDialog(null, "Drogas produzidas com sucesso");
				}
			}
		});
		btnCozinhar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnCozinhar.setBackground(Color.WHITE);
		btnCozinhar.setBounds(10, 343, 89, 36);
		PrisonerInfo.add(btnCozinhar);

		CB_DInfo = new Choice();
		CB_DInfo.add(PS);
		CB_DInfo.add(JT);
		CB_DInfo.add(MX);
		CB_DInfo.add(NC);
		CB_DInfo.add(BO);
		CB_DInfo.add(MT);
		CB_DInfo.add(RA);
		CB_DInfo.add(LO);
		CB_DInfo.setBackground(Color.WHITE);
		CB_DInfo.setForeground(Color.GREEN);
		CB_DInfo.setFont(new Font("Consolas", Font.PLAIN, 12));
		CB_DInfo.setBounds(10, 157, 89, 20);
		PrisonerInfo.add(CB_DInfo);

		TF_PInfoCook = new JTextField();
		TF_PInfoCook.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PInfoCook.setForeground(Color.GREEN);
		TF_PInfoCook.setFont(new Font("Consolas", Font.PLAIN, 13));
		TF_PInfoCook.setToolTipText("Quantidade a ser prduzida em Kg");
		TF_PInfoCook.setBounds(10, 188, 77, 28);
		PrisonerInfo.add(TF_PInfoCook);
		TF_PInfoCook.setColumns(10);

		CB_DFaction = new Choice();
		CB_DFaction.add(BS);
		CB_DFaction.add(RD);
		CB_DFaction.add(GN);
		CB_DFaction.add(IT);

		CB_DFaction.setForeground(Color.GREEN);
		CB_DFaction.setFont(new Font("Consolas", Font.PLAIN, 13));
		CB_DFaction.setBounds(10, 226, 153, 20);
		PrisonerInfo.add(CB_DFaction);

		TF_PInfoWHA = new JTextField();
		TF_PInfoWHA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PInfoWHA.setForeground(Color.GREEN);
		TF_PInfoWHA.setFont(new Font("Consolas", Font.PLAIN, 12));
		TF_PInfoWHA.setBounds(10, 255, 77, 28);
		PrisonerInfo.add(TF_PInfoWHA);
		TF_PInfoWHA.setColumns(10);

		JButton btnTrabalhar = new JButton("Trabalhar");
		btnTrabalhar.setBackground(Color.WHITE);
		btnTrabalhar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TF_PInfoWHA.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				} else {
					String faction = CB_DFaction.getSelectedItem();
					String drug = CB_DInfo.getSelectedItem();
					letsCook(drug, faction);
					JOptionPane.showMessageDialog(null, "Trabalho realizado com sucesso");
				}
			}
		});
		btnTrabalhar.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnTrabalhar.setBounds(10, 295, 89, 36);
		PrisonerInfo.add(btnTrabalhar);

		JLabel LBL_PInfoWP = new JLabel("");
		LBL_PInfoWP.setInheritsPopupMenu(false);
		LBL_PInfoWP.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_PInfoWP.setBounds(0, 0, 846, 535);
		PrisonerInfo.add(LBL_PInfoWP);

		// PAINEL PrisonerBasic
		final JPanel BasicPrisoner = new JPanel();
		ClassPanel.add(BasicPrisoner, "name_72993773493806");
		BasicPrisoner.setLayout(null);

		// PrisonerBasicStuff

		// TextFields
		TF_PID = new JTextField();
		TF_PID.setSelectionColor(Color.GREEN);
		TF_PID.setSelectedTextColor(Color.BLACK);
		TF_PID.setForeground(Color.GREEN);
		TF_PID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PID.setDisabledTextColor(Color.GREEN);
		TF_PID.setBounds(490, 50, 305, 46);
		TF_PID.setColumns(10);
		BasicPrisoner.add(TF_PID);

		// Labels
		JLabel LBL_PID = new JLabel("ID:");
		LBL_PID.setForeground(Color.GREEN);
		LBL_PID.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PID.setBounds(130, 50, 350, 46);
		LBL_PID.setHorizontalAlignment(SwingConstants.TRAILING);
		BasicPrisoner.add(LBL_PID);

		JLabel LBL_PN = new JLabel("Nome:");
		LBL_PN.setForeground(Color.GREEN);
		LBL_PN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_PN.setBounds(130, 146, 350, 46);
		LBL_PN.setHorizontalAlignment(SwingConstants.TRAILING);
		BasicPrisoner.add(LBL_PN);

		// Buttons
		// while()

		JButton BTN_PInsert = new JButton("Cadastrar");
		BTN_PInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((TF_PID.getText().equalsIgnoreCase("") || TF_PN.getText().equalsIgnoreCase("")
						|| TF_PA.getText().equalsIgnoreCase("") || TF_PC.getText().equalsIgnoreCase("")
						|| TF_PWH.getText().equalsIgnoreCase(""))) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos para realizar o cadastro.");
				} else {
					insertPrisoner();
					JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!");
				}
			}
		});
		BTN_PInsert.setBackground(Color.WHITE);
		BTN_PInsert.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PInsert.setBounds(36, 488, 125, 36);
		BasicPrisoner.add(BTN_PInsert);

		JButton BTN_PSearch = new JButton("Procurar");
		BTN_PSearch.setBackground(Color.WHITE);
		BTN_PSearch.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				searchPrisoner();
				if (TF_PID.getText().equalsIgnoreCase("")) {
				} else {
					ClassPanel.removeAll();
					ClassPanel.repaint();
					ClassPanel.revalidate();

					ClassPanel.add(PrisonerInfo);
					ClassPanel.repaint();
					ClassPanel.revalidate();
					PrisonerInfo.setVisible(true);
				}
			}
		});
		BTN_PSearch.setBounds(358, 488, 125, 36);
		BasicPrisoner.add(BTN_PSearch);

		JButton btnRelatorio_1 = new JButton("Relatorio");
		btnRelatorio_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * try ARQUIVO PRISIONEIRO CODIGO DO RELATORIO [AQUI]
				 * 
				 * ClassPanel.removeAll(); ClassPanel.repaint();
				 * ClassPanel.revalidate();
				 * 
				 * ClassPanel.add(PrisonerReport); ClassPanel.repaint();
				 * ClassPanel.revalidate();
				 * 
				 */
			}
		});
		btnRelatorio_1.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnRelatorio_1.setBackground(Color.WHITE);
		btnRelatorio_1.setBounds(680, 488, 125, 36);
		BasicPrisoner.add(btnRelatorio_1);

		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setForeground(Color.GREEN);
		lblIdade.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdade.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblIdade.setBounds(130, 242, 350, 46);
		BasicPrisoner.add(lblIdade);

		JLabel lblCusto = new JLabel("Custo:");
		lblCusto.setForeground(Color.GREEN);
		lblCusto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCusto.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblCusto.setBounds(130, 338, 350, 46);
		BasicPrisoner.add(lblCusto);

		JLabel lblHorasDeTrabalho = new JLabel("Horas de Trabalho:");
		lblHorasDeTrabalho.setForeground(Color.GREEN);
		lblHorasDeTrabalho.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHorasDeTrabalho.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblHorasDeTrabalho.setBounds(130, 434, 350, 46);
		BasicPrisoner.add(lblHorasDeTrabalho);

		TF_PN = new JTextField();
		TF_PN.setSelectionColor(Color.GREEN);
		TF_PN.setSelectedTextColor(Color.BLACK);
		TF_PN.setForeground(Color.GREEN);
		TF_PN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PN.setDisabledTextColor(Color.GREEN);
		TF_PN.setColumns(10);
		TF_PN.setBounds(490, 146, 305, 46);
		BasicPrisoner.add(TF_PN);

		TF_PA = new JTextField();
		TF_PA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PA.setSelectionColor(Color.GREEN);
		TF_PA.setSelectedTextColor(Color.BLACK);
		TF_PA.setForeground(Color.GREEN);
		TF_PA.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PA.setDisabledTextColor(Color.GREEN);
		TF_PA.setColumns(10);
		TF_PA.setBounds(490, 242, 305, 46);
		BasicPrisoner.add(TF_PA);

		TF_PC = new JTextField();
		TF_PC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PC.setSelectionColor(Color.GREEN);
		TF_PC.setSelectedTextColor(Color.BLACK);
		TF_PC.setForeground(Color.GREEN);
		TF_PC.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PC.setDisabledTextColor(Color.GREEN);
		TF_PC.setColumns(10);
		TF_PC.setBounds(490, 338, 305, 46);
		BasicPrisoner.add(TF_PC);

		TF_PWH.setSelectionColor(Color.GREEN);
		TF_PWH.setSelectedTextColor(Color.BLACK);
		TF_PWH.setForeground(Color.GREEN);
		TF_PWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PWH.setDisabledTextColor(Color.GREEN);
		TF_PWH.setColumns(10);
		TF_PWH.setBounds(490, 434, 305, 46);
		BasicPrisoner.add(TF_PWH);

		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_7.setBounds(0, 0, 846, 535);
		BasicPrisoner.add(label_7);

		JButton BTN_SInfoBack = new JButton("Voltar");
		BTN_SInfoBack.setToolTipText("Volta para o menu");
		BTN_SInfoBack.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_SInfoBack.setBackground(Color.WHITE);
		BTN_SInfoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicArmy);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				SoldierInfo.setVisible(false);
				BasicArmy.setVisible(true);
			}
		});
		BTN_SInfoBack.setBounds(63, 477, 125, 36);
		SoldierInfo.add(BTN_SInfoBack);

		// SoldierInfo Stuff

		// TextFields
		TF_SInfoID = new JTextField();
		TF_SInfoID.setToolTipText("ID do Soldado");
		TF_SInfoID.setSelectionColor(Color.BLACK);
		TF_SInfoID.setSelectedTextColor(Color.GREEN);
		TF_SInfoID.setForeground(Color.GREEN);
		TF_SInfoID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoID.setEditable(false);
		TF_SInfoID.setColumns(10);
		TF_SInfoID.setBounds(490, 11, 305, 35);
		SoldierInfo.add(TF_SInfoID);

		// Labels
		JLabel LBL_SInfoN = new JLabel("Nome:");
		LBL_SInfoN.setForeground(Color.GREEN);
		LBL_SInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SInfoN.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SInfoN.setBounds(175, 83, 305, 46);
		SoldierInfo.add(LBL_SInfoN);

		JLabel LBL_SInfoA = new JLabel("Idade:");
		LBL_SInfoA.setForeground(Color.GREEN);
		LBL_SInfoA.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SInfoA.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SInfoA.setBounds(175, 155, 305, 46);
		SoldierInfo.add(LBL_SInfoA);

		JLabel LBL_SInfoID = new JLabel("ID:");
		LBL_SInfoID.setForeground(Color.GREEN);
		LBL_SInfoID.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SInfoID.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SInfoID.setBounds(175, 11, 305, 46);
		SoldierInfo.add(LBL_SInfoID);

		JLabel LBL_SInfoC = new JLabel("Custo:");
		LBL_SInfoC.setForeground(Color.GREEN);
		LBL_SInfoC.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SInfoC.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SInfoC.setBounds(175, 227, 305, 46);
		SoldierInfo.add(LBL_SInfoC);

		JLabel LBL_SInfoW = new JLabel("Arma:");
		LBL_SInfoW.setForeground(Color.GREEN);
		LBL_SInfoW.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SInfoW.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SInfoW.setBounds(175, 299, 305, 46);
		SoldierInfo.add(LBL_SInfoW);

		JLabel LBL_SInfoWH = new JLabel("Horas de trabalho:");
		LBL_SInfoWH.setForeground(Color.GREEN);
		LBL_SInfoWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_SInfoWH.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_SInfoWH.setBounds(175, 371, 305, 46);
		SoldierInfo.add(LBL_SInfoWH);

		TF_SInfoN = new JTextField();
		TF_SInfoN.setEditable(false);
		TF_SInfoN.setToolTipText("Nome do soldado");
		TF_SInfoN.setSelectionColor(Color.BLACK);
		TF_SInfoN.setSelectedTextColor(Color.GREEN);
		TF_SInfoN.setForeground(Color.GREEN);
		TF_SInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoN.setColumns(10);
		TF_SInfoN.setBounds(490, 83, 305, 35);
		SoldierInfo.add(TF_SInfoN);

		TF_SInfoA = new JTextField();
		TF_SInfoA.setEditable(false);
		TF_SInfoA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SInfoA.setSelectionColor(Color.BLACK);
		TF_SInfoA.setSelectedTextColor(Color.GREEN);
		TF_SInfoA.setForeground(Color.GREEN);
		TF_SInfoA.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoA.setColumns(10);
		TF_SInfoA.setBounds(490, 155, 305, 35);
		SoldierInfo.add(TF_SInfoA);

		TF_SInfoC = new JTextField();
		TF_SInfoC.setEditable(false);
		TF_SInfoC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SInfoC.setSelectionColor(Color.BLACK);
		TF_SInfoC.setSelectedTextColor(Color.GREEN);
		TF_SInfoC.setForeground(Color.GREEN);
		TF_SInfoC.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoC.setColumns(10);
		TF_SInfoC.setBounds(490, 227, 305, 35);
		SoldierInfo.add(TF_SInfoC);

		TF_SInfoWH = new JTextField();
		TF_SInfoWH.setEditable(false);
		TF_SInfoWH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SInfoWH.setSelectionColor(Color.BLACK);
		TF_SInfoWH.setSelectedTextColor(Color.GREEN);
		TF_SInfoWH.setForeground(Color.GREEN);
		TF_SInfoWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoWH.setColumns(10);
		TF_SInfoWH.setBounds(490, 371, 305, 35);
		SoldierInfo.add(TF_SInfoWH);

		TF_SInfoDC = new JTextField();
		TF_SInfoDC.setEnabled(false);
		TF_SInfoDC.setSelectedTextColor(Color.GREEN);
		TF_SInfoDC.setSelectionColor(Color.BLACK);
		TF_SInfoDC.setToolTipText("Causa mortis");
		TF_SInfoDC.setBounds(36, 325, 178, 20);
		SoldierInfo.add(TF_SInfoDC);
		TF_SInfoDC.setColumns(10);

		TF_SInfoWHA = new JTextField();
		TF_SInfoWHA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_SInfoWHA.setToolTipText("Quantidade de horas que o soldado ir\u00E1 trabalhar");
		TF_SInfoWHA.setBounds(36, 124, 178, 20);
		SoldierInfo.add(TF_SInfoWHA);
		TF_SInfoWHA.setColumns(10);

		TF_SInfoWp2 = new JTextField();
		TF_SInfoWp2.setEditable(false);
		TF_SInfoWp2.setSelectionColor(Color.BLACK);
		TF_SInfoWp2.setSelectedTextColor(Color.GREEN);
		TF_SInfoWp2.setForeground(Color.GREEN);
		TF_SInfoWp2.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoWp2.setColumns(10);
		TF_SInfoWp2.setBounds(490, 309, 305, 35);
		SoldierInfo.add(TF_SInfoWp2);
		
		TF_SInfoS = new JTextField();
		TF_SInfoS.setEditable(false);
		TF_SInfoS.setSelectionColor(Color.BLACK);
		TF_SInfoS.setSelectedTextColor(Color.GREEN);
		TF_SInfoS.setForeground(Color.GREEN);
		TF_SInfoS.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_SInfoS.setColumns(10);
		TF_SInfoS.setBounds(490, 435, 305, 35);
		SoldierInfo.add(TF_SInfoS);
		
		JButton BTN_SInfoWork = new JButton("Trabalhar");
		BTN_SInfoWork.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TF_SInfoWHA.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Digite a quantidade de horas!");
				}else{
					workArmy();
				}
			}
		});
		BTN_SInfoWork.setToolTipText("Adiciona horas de trabalho para esse soldado");
		BTN_SInfoWork.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_SInfoWork.setBackground(Color.WHITE);
		BTN_SInfoWork.setBounds(63, 163, 125, 36);
		SoldierInfo.add(BTN_SInfoWork);
		final JButton BTN_SInfoOK = new JButton("Ok!");
		BTN_SInfoOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TF_SInfoDC.getText().equalsIgnoreCase("") || TF_SInfoDC.getText().equalsIgnoreCase("Ele morreu?")){
					JOptionPane.showMessageDialog(null, "Digite uma causa de morte valida!");
				}else{
					war();
					JOptionPane.showMessageDialog(null, "Informações atualizadas com sucesso!");
				}
			}
		});
		BTN_SInfoOK.setBackground(Color.WHITE);
		BTN_SInfoOK.setEnabled(false);
		BTN_SInfoOK.setBounds(95, 385, 60, 23);
		SoldierInfo.add(BTN_SInfoOK);
		final JButton BTN_SInfoYes = new JButton("Sim");
		BTN_SInfoYes.setBackground(Color.WHITE);
		BTN_SInfoYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TF_SInfoDC.setText("");
				BTN_SInfoOK.setEnabled(true);
				TF_SInfoDC.setEnabled(true);
				
			}
		});
		BTN_SInfoYes.setEnabled(false);
		BTN_SInfoYes.setBounds(36, 356, 60, 23);
		SoldierInfo.add(BTN_SInfoYes);

		final JButton BTN_SInfoNo = new JButton("N\u00E3o");
		BTN_SInfoNo.setBackground(Color.WHITE);
		BTN_SInfoNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BTN_SInfoNo.setEnabled(false);
		BTN_SInfoNo.setBounds(154, 356, 60, 23);
		SoldierInfo.add(BTN_SInfoNo);

		JButton BTN_SInfoWar = new JButton("Guerra");

		BTN_SInfoWar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BTN_SInfoYes.setEnabled(true);
				BTN_SInfoNo.setEnabled(true);
				TF_SInfoDC.setText("Ele morreu?");
			}
		});
		BTN_SInfoWar.setToolTipText("Manda o soldado para a\u00E7\u00F5es de campo");
		BTN_SInfoWar.setFont(new Font("Consolas", Font.PLAIN, 11));
		BTN_SInfoWar.setBackground(Color.WHITE);
		BTN_SInfoWar.setBounds(81, 284, 89, 36);
		SoldierInfo.add(BTN_SInfoWar);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setHorizontalAlignment(SwingConstants.TRAILING);
		lblStatus.setForeground(Color.GREEN);
		lblStatus.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblStatus.setBounds(175, 429, 305, 46);
		SoldierInfo.add(lblStatus);

		JLabel LBL_SInfoWP1 = new JLabel("");
		LBL_SInfoWP1.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/VaultBoy_SoldierInfo2.png")));
		LBL_SInfoWP1.setBounds(0, -1, 846, 535);
		SoldierInfo.add(LBL_SInfoWP1);

		JLabel LBL_SInfoWP = new JLabel("");
		LBL_SInfoWP.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_SInfoWP.setBounds(0, 0, 846, 535);
		SoldierInfo.add(LBL_SInfoWP);

		JLabel lblId = new JLabel("ID:");
		lblId.setHorizontalAlignment(SwingConstants.TRAILING);
		lblId.setForeground(Color.GREEN);
		lblId.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblId.setBounds(175, 37, 305, 46);
		PleasureGiverInfo.add(lblId);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNome.setForeground(Color.GREEN);
		lblNome.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblNome.setBounds(175, 120, 305, 46);
		PleasureGiverInfo.add(lblNome);

		JLabel lblIdade_1 = new JLabel("Idade:");
		lblIdade_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdade_1.setForeground(Color.GREEN);
		lblIdade_1.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblIdade_1.setBounds(175, 203, 305, 46);
		PleasureGiverInfo.add(lblIdade_1);

		JLabel lblCusto_1 = new JLabel("Custo:");
		lblCusto_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCusto_1.setForeground(Color.GREEN);
		lblCusto_1.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblCusto_1.setBounds(175, 286, 305, 46);
		PleasureGiverInfo.add(lblCusto_1);

		JLabel lblHorasDeTrabalho_1 = new JLabel("Horas de trabalho:");
		lblHorasDeTrabalho_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblHorasDeTrabalho_1.setForeground(Color.GREEN);
		lblHorasDeTrabalho_1.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblHorasDeTrabalho_1.setBounds(175, 369, 305, 46);
		PleasureGiverInfo.add(lblHorasDeTrabalho_1);

		JLabel lblLucroMensal = new JLabel("Lucro mensal:");
		lblLucroMensal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLucroMensal.setForeground(Color.GREEN);
		lblLucroMensal.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblLucroMensal.setBounds(175, 452, 305, 46);
		PleasureGiverInfo.add(lblLucroMensal);

		TF_PleasureInfoID = new JTextField();
		TF_PleasureInfoID.setSelectionColor(Color.BLACK);
		TF_PleasureInfoID.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoID.setForeground(Color.GREEN);
		TF_PleasureInfoID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PleasureInfoID.setBounds(490, 37, 305, 46);
		PleasureGiverInfo.add(TF_PleasureInfoID);
		TF_PleasureInfoID.setColumns(10);

		TF_PleasureInfoN = new JTextField();
		TF_PleasureInfoN.setSelectionColor(Color.BLACK);
		TF_PleasureInfoN.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoN.setForeground(Color.GREEN);
		TF_PleasureInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PleasureInfoN.setColumns(10);
		TF_PleasureInfoN.setBounds(490, 120, 305, 46);
		PleasureGiverInfo.add(TF_PleasureInfoN);

		TF_PleasureInfoA = new JTextField();
		TF_PleasureInfoA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureInfoA.setSelectionColor(Color.BLACK);
		TF_PleasureInfoA.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoA.setForeground(Color.GREEN);
		TF_PleasureInfoA.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PleasureInfoA.setColumns(10);
		TF_PleasureInfoA.setBounds(490, 203, 305, 46);
		PleasureGiverInfo.add(TF_PleasureInfoA);

		TF_PleasureInfoC = new JTextField();
		TF_PleasureInfoC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureInfoC.setSelectionColor(Color.BLACK);
		TF_PleasureInfoC.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoC.setForeground(Color.GREEN);
		TF_PleasureInfoC.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PleasureInfoC.setColumns(10);
		TF_PleasureInfoC.setBounds(490, 286, 305, 46);
		PleasureGiverInfo.add(TF_PleasureInfoC);

		TF_PleasureInfoWH = new JTextField();
		TF_PleasureInfoWH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureInfoWH.setSelectionColor(Color.BLACK);
		TF_PleasureInfoWH.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoWH.setForeground(Color.GREEN);
		TF_PleasureInfoWH.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PleasureInfoWH.setColumns(10);
		TF_PleasureInfoWH.setBounds(490, 369, 305, 46);
		PleasureGiverInfo.add(TF_PleasureInfoWH);

		TF_PleasureInfoME = new JTextField();
		TF_PleasureInfoME.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureInfoME.setSelectionColor(Color.BLACK);
		TF_PleasureInfoME.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoME.setForeground(Color.GREEN);
		TF_PleasureInfoME.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_PleasureInfoME.setColumns(10);
		TF_PleasureInfoME.setBounds(490, 452, 305, 46);
		PleasureGiverInfo.add(TF_PleasureInfoME);

		JButton button = new JButton("Voltar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicPleasureGiver);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		button.setFont(new Font("Consolas", Font.PLAIN, 13));
		button.setBackground(Color.WHITE);
		button.setBounds(0, 488, 125, 36);
		PleasureGiverInfo.add(button);

		JButton BTN_PleasureInfoDrugs = new JButton("Drogas");
		BTN_PleasureInfoDrugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TF_PleasureInfoDrugs.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos para relizar a ação.");
				} else {
					String id = TF_PleasureID.getText();
					String drug = CB_PleasureDrugs.getSelectedItem();
					double weight = Double.parseDouble(TF_PleasureInfoDrugs.getText());
					String faction = CB_PFaction.getSelectedItem();
					sellDrugsPleasure(drug, weight, id, faction);
					JOptionPane.showMessageDialog(null, "Drogas vendidas com sucesso");
				}
			}
		});
		BTN_PleasureInfoDrugs.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PleasureInfoDrugs.setBackground(Color.WHITE);
		BTN_PleasureInfoDrugs.setBounds(36, 383, 88, 25);
		PleasureGiverInfo.add(BTN_PleasureInfoDrugs);

		CB_PleasureDrugs = new Choice();
		CB_PleasureDrugs.add(PS);
		CB_PleasureDrugs.add(JT);
		CB_PleasureDrugs.add(MX);
		CB_PleasureDrugs.add(NC);
		CB_PleasureDrugs.add(BO);
		CB_PleasureDrugs.add(MT);
		CB_PleasureDrugs.add(RA);
		CB_PleasureDrugs.add(LO);
		CB_PleasureDrugs.setForeground(Color.GREEN);
		CB_PleasureDrugs.setFont(new Font("Consolas", Font.PLAIN, 11));
		CB_PleasureDrugs.setBounds(37, 286, 86, 20);
		PleasureGiverInfo.add(CB_PleasureDrugs);

		CB_PFaction = new Choice();
		CB_PFaction.addItem(BS);
		CB_PFaction.addItem(RD);
		CB_PFaction.addItem(GN);
		CB_PFaction.addItem(IT);
		CB_PFaction.setForeground(Color.GREEN);
		CB_PFaction.setFont(new Font("Consolas", Font.PLAIN, 11));
		CB_PFaction.setBounds(-4, 312, 169, 20);
		PleasureGiverInfo.add(CB_PFaction);

		TF_PleasureInfoDrugs = new JTextField();
		TF_PleasureInfoDrugs.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureInfoDrugs.setInheritsPopupMenu(true);
		TF_PleasureInfoDrugs.setToolTipText("Quantidade em quilos que foi vendida");
		TF_PleasureInfoDrugs.setSelectionColor(Color.BLACK);
		TF_PleasureInfoDrugs.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoDrugs.setBounds(37, 352, 86, 20);
		PleasureGiverInfo.add(TF_PleasureInfoDrugs);
		TF_PleasureInfoDrugs.setColumns(10);

		JButton BTN_PleasureVender = new JButton("Remover");
		BTN_PleasureVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removePleasure();
				JOptionPane.showMessageDialog(null, "Acompanhante removida com sucesso.");
			}
		});
		BTN_PleasureVender.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PleasureVender.setBackground(Color.WHITE);
		BTN_PleasureVender.setBounds(137, 488, 125, 36);
		PleasureGiverInfo.add(BTN_PleasureVender);

		TF_PleasureInfoWHA = new JTextField();
		TF_PleasureInfoWHA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_PleasureInfoWHA.setToolTipText("Quantidade em quilos que foi vendida");
		TF_PleasureInfoWHA.setSelectionColor(Color.BLACK);
		TF_PleasureInfoWHA.setSelectedTextColor(Color.GREEN);
		TF_PleasureInfoWHA.setInheritsPopupMenu(true);
		TF_PleasureInfoWHA.setColumns(10);
		TF_PleasureInfoWHA.setBounds(37, 194, 86, 20);
		PleasureGiverInfo.add(TF_PleasureInfoWHA);

		JButton BTN_PleasureInfoGM = new JButton("Massagem");
		BTN_PleasureInfoGM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (TF_PleasureInfoWHA.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Digite um valor valido.");
				} else {
					massage();
					JOptionPane.showMessageDialog(null, "Massagem realizada com sucesso.");
				}
			}
		});
		BTN_PleasureInfoGM.setForeground(Color.BLACK);
		BTN_PleasureInfoGM.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PleasureInfoGM.setBackground(Color.WHITE);
		BTN_PleasureInfoGM.setBounds(29, 224, 102, 25);
		PleasureGiverInfo.add(BTN_PleasureInfoGM);

		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_9.setBounds(0, 0, 846, 535);
		PleasureGiverInfo.add(label_9);

		JButton button_2 = new JButton("Voltar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicArmy);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		button_2.setBounds(761, 16, 75, 25);
		SoldierReport.add(button_2);
		button_2.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_2.setBackground(Color.WHITE);
		
		SimpleAttributeSet keyWord = new SimpleAttributeSet();
		StyleConstants.setForeground(keyWord, Color.RED);
		StyleConstants.setBackground(keyWord, Color.YELLOW);
		StyleConstants.setBold(keyWord, true);

		LBL_ReportSoldier = new JLabel("New label");
		LBL_ReportSoldier.setForeground(Color.GREEN);
		LBL_ReportSoldier.setFont(new Font("Consolas", Font.PLAIN, 13));
		LBL_ReportSoldier.setBackground(Color.WHITE);
		LBL_ReportSoldier.setVerticalAlignment(SwingConstants.TOP);
		LBL_ReportSoldier.setBounds(0, 0, 55, 16);
		//SoldierReport.add(LBL_ReportSoldier);
		
		JScrollPane SC_SR = new JScrollPane();
		SC_SR.setBounds(0, 39, 846, 496);
		SoldierReport.add(SC_SR);
		SC_SR.setViewportView(LBL_ReportSoldier);
		
		//JList list = new JList();
		//list.setVisibleRowCount(15);
		//SC_SR.setViewportView(list);
		
		// SoldierReport.add(List_SR);

		JLabel lblNewLabel_1 = new JLabel("Relat\u00F3rio do Exercito");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(0, 0, 844, 50);
		SoldierReport.add(lblNewLabel_1);

		JLabel LBL_SRWP1 = new JLabel("");
		LBL_SRWP1.setBackground(Color.WHITE);
		LBL_SRWP1.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_SRWP1.setBounds(0, 0, 846, 535);
		SoldierReport.add(LBL_SRWP1);

		final JPanel BasicWeapon = new JPanel();
		BasicWeapon.setLayout(null);
		ClassPanel.add(BasicWeapon, "name_148294337960937");

		TF_WID = new JTextField();
		TF_WID.setSelectionColor(Color.GREEN);
		TF_WID.setSelectedTextColor(Color.BLACK);
		TF_WID.setForeground(Color.GREEN);
		TF_WID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WID.setDisabledTextColor(Color.GREEN);
		TF_WID.setColumns(10);
		TF_WID.setBounds(492, 33, 305, 46);
		BasicWeapon.add(TF_WID);

		JLabel label_13 = new JLabel("ID:");
		label_13.setHorizontalAlignment(SwingConstants.TRAILING);
		label_13.setForeground(Color.GREEN);
		label_13.setFont(new Font("Consolas", Font.PLAIN, 25));
		label_13.setBounds(130, 33, 350, 46);
		BasicWeapon.add(label_13);

		JLabel label_14 = new JLabel("Nome:");
		label_14.setHorizontalAlignment(SwingConstants.TRAILING);
		label_14.setForeground(Color.GREEN);
		label_14.setFont(new Font("Consolas", Font.PLAIN, 25));
		label_14.setBounds(130, 149, 350, 46);
		BasicWeapon.add(label_14);

		JButton button_5 = new JButton("Cadastrar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TF_WID.getText().equalsIgnoreCase("") || TF_WMagazine.getText().equalsIgnoreCase("")
						|| TF_WTAmmo.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os espaços para realizar o cadastro.");
				} else {
					String name = TF_WN.getSelectedItem();
					insertWeapon(name);
					JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				}
			}
		});
		button_5.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(36, 488, 125, 36);
		BasicWeapon.add(button_5);

		final JPanel WeaponInfo = new JPanel();// PAINEL DE INFO DE ARMA
		WeaponInfo.setLayout(null);
		ClassPanel.add(WeaponInfo, "name_286396976794498");

		JButton button_6 = new JButton("Procurar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (TF_WID.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo de ID para procurar uma arma.");
				} else {
					searchWeapon();
					ClassPanel.removeAll();
					ClassPanel.repaint();
					ClassPanel.revalidate();

					ClassPanel.add(WeaponInfo);
					ClassPanel.repaint();
					ClassPanel.revalidate();
				}

			}
		});
		button_6.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(358, 488, 125, 36);
		BasicWeapon.add(button_6);

		JLabel lblMunio = new JLabel("Muni\u00E7\u00E3o:");
		lblMunio.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMunio.setForeground(Color.GREEN);
		lblMunio.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblMunio.setBounds(130, 265, 350, 46);
		BasicWeapon.add(lblMunio);

		TF_WName = new Choice();
		TF_WName.setForeground(Color.GREEN);
		TF_WName.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WName.setBounds(492, 151, 305, 46);
		BasicWeapon.add(TF_WName);

		TF_WMagazine = new JTextField();
		TF_WMagazine.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		TF_WMagazine.setSelectionColor(Color.GREEN);
		TF_WMagazine.setSelectedTextColor(Color.BLACK);
		TF_WMagazine.setForeground(Color.GREEN);
		TF_WMagazine.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WMagazine.setDisabledTextColor(Color.GREEN);
		TF_WMagazine.setColumns(10);
		TF_WMagazine.setBounds(492, 259, 305, 46);
		BasicWeapon.add(TF_WMagazine);

		TF_WTAmmo = new JTextField();
		TF_WTAmmo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		TF_WTAmmo.setSelectionColor(Color.GREEN);
		TF_WTAmmo.setSelectedTextColor(Color.BLACK);
		TF_WTAmmo.setForeground(Color.GREEN);
		TF_WTAmmo.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WTAmmo.setDisabledTextColor(Color.GREEN);
		TF_WTAmmo.setColumns(10);
		TF_WTAmmo.setBounds(492, 377, 305, 46);
		BasicWeapon.add(TF_WTAmmo);

		JLabel LBL_WTAmmo = new JLabel("Muni\u00E7\u00E3o total:");
		LBL_WTAmmo.setHorizontalAlignment(SwingConstants.TRAILING);
		LBL_WTAmmo.setForeground(Color.GREEN);
		LBL_WTAmmo.setFont(new Font("Consolas", Font.PLAIN, 25));
		LBL_WTAmmo.setBounds(130, 381, 350, 46);
		BasicWeapon.add(LBL_WTAmmo);

		JLabel label_18 = new JLabel("");
		label_18.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_18.setBounds(0, 0, 846, 535);
		BasicWeapon.add(label_18);

		JLabel label_10 = new JLabel("ID:");
		label_10.setHorizontalAlignment(SwingConstants.TRAILING);
		label_10.setForeground(Color.GREEN);
		label_10.setFont(new Font("Consolas", Font.PLAIN, 25));
		label_10.setBounds(174, 24, 305, 46);
		WeaponInfo.add(label_10);

		JLabel label_12 = new JLabel("Nome:");
		label_12.setHorizontalAlignment(SwingConstants.TRAILING);
		label_12.setForeground(Color.GREEN);
		label_12.setFont(new Font("Consolas", Font.PLAIN, 25));
		label_12.setBounds(174, 122, 305, 46);
		WeaponInfo.add(label_12);

		JLabel lblMunio_1 = new JLabel("Muni\u00E7\u00E3o:");
		lblMunio_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMunio_1.setForeground(Color.GREEN);
		lblMunio_1.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblMunio_1.setBounds(174, 220, 305, 46);
		WeaponInfo.add(lblMunio_1);

		JLabel lblMunioTotal = new JLabel("Muni\u00E7\u00E3o total:");
		lblMunioTotal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMunioTotal.setForeground(Color.GREEN);
		lblMunioTotal.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblMunioTotal.setBounds(174, 318, 305, 46);
		WeaponInfo.add(lblMunioTotal);

		TF_WInfoID = new JTextField();
		TF_WInfoID.setForeground(Color.GREEN);
		TF_WInfoID.setSelectionColor(Color.BLACK);
		TF_WInfoID.setSelectedTextColor(Color.GREEN);
		TF_WInfoID.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WInfoID.setEditable(false);
		TF_WInfoID.setColumns(10);
		TF_WInfoID.setBounds(489, 22, 305, 46);
		WeaponInfo.add(TF_WInfoID);

		TF_WInfoN = new JTextField();
		TF_WInfoN.setForeground(Color.GREEN);
		TF_WInfoN.setSelectionColor(Color.BLACK);
		TF_WInfoN.setSelectedTextColor(Color.GREEN);
		TF_WInfoN.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WInfoN.setEditable(false);
		TF_WInfoN.setColumns(10);
		TF_WInfoN.setBounds(489, 118, 305, 46);
		WeaponInfo.add(TF_WInfoN);

		TF_WInfoM = new JTextField();
		TF_WInfoM.setForeground(Color.GREEN);
		TF_WInfoM.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		TF_WInfoM.setSelectionColor(Color.BLACK);
		TF_WInfoM.setSelectedTextColor(Color.GREEN);
		TF_WInfoM.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WInfoM.setEditable(false);
		TF_WInfoM.setColumns(10);
		TF_WInfoM.setBounds(489, 214, 305, 46);
		WeaponInfo.add(TF_WInfoM);

		TF_WInfoTA = new JTextField();
		TF_WInfoTA.setForeground(Color.GREEN);
		TF_WInfoTA.setSelectionColor(Color.BLACK);
		TF_WInfoTA.setSelectedTextColor(Color.GREEN);
		TF_WInfoTA.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WInfoTA.setEditable(false);
		TF_WInfoTA.setColumns(10);
		TF_WInfoTA.setBounds(489, 310, 305, 46);
		WeaponInfo.add(TF_WInfoTA);

		JButton button_8 = new JButton("Voltar");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicWeapon);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		
		TF_WInfoADD = new JTextField();
		TF_WInfoADD.setFont(new Font("Consolas", Font.PLAIN, 25));
		TF_WInfoADD.setForeground(Color.GREEN);
		TF_WInfoADD.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar();
				if (!(Character.isDigit(c)) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		TF_WInfoADD.setBounds(489, 406, 305, 46);
		WeaponInfo.add(TF_WInfoADD);
		TF_WInfoADD.setColumns(10);
		button_8.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(64, 464, 125, 36);
		WeaponInfo.add(button_8);

		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeWeapon();
				JOptionPane.showMessageDialog(null, "Arma descartada com sucesso.");
			}
		});
		btnRemover.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(199, 464, 125, 36);
		WeaponInfo.add(btnRemover);
		
		JButton btnAdicionarMunio = new JButton("Adicionar Muni\u00E7\u00E3o");
		btnAdicionarMunio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(TF_WInfoADD.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Preencha o campo com um numero valido!");
				}else{
					addBullets();
					JOptionPane.showMessageDialog(null, "Munição adicionada com sucesso!");
				}
			}
		});
		btnAdicionarMunio.setBackground(Color.WHITE);
		btnAdicionarMunio.setFont(new Font("Consolas", Font.PLAIN, 11));
		btnAdicionarMunio.setBounds(305, 416, 149, 36);
		WeaponInfo.add(btnAdicionarMunio);

		JLabel label_19 = new JLabel("");
		label_19.setBounds(0, 0, 846, 535);
		WeaponInfo.add(label_19);

		JLabel label_20 = new JLabel("");
		label_20.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_20.setBounds(0, 0, 846, 535);
		WeaponInfo.add(label_20);
		
		final JPanel ProfitReport = new JPanel();
		ClassPanel.add(ProfitReport, "name_54847098672670");
		ProfitReport.setLayout(null);
		
		JButton button_9 = new JButton("Voltar");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();
				ClassPanel.add(BlankClass);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		button_9.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_9.setBackground(Color.WHITE);
		button_9.setBounds(765, 17, 75, 25);
		ProfitReport.add(button_9);
		
		DefaultListModel modPro = new DefaultListModel();
		//ProfitReport.add(List_Profit);
		
		JScrollPane SP_Profit = new JScrollPane();
		SP_Profit.setBounds(6, 43, 834, 486);
		ProfitReport.add(SP_Profit);
		
		label_21 = new JLabel("");
		label_21.setVerticalAlignment(SwingConstants.TOP);
		SP_Profit.setViewportView(label_21);
		
		JLabel lblNewLabel_2 = new JLabel("Relatorio geral");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 26));
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setBounds(6, 0, 834, 33);
		ProfitReport.add(lblNewLabel_2);
		
		JLabel LBL_PWP1 = new JLabel("");
		LBL_PWP1.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_PWP1.setBounds(0, 0, 846, 535);
		ProfitReport.add(LBL_PWP1);
		
		JPanel PrisonerReport = new JPanel();
		PrisonerReport.setLayout(null);
		ClassPanel.add(PrisonerReport, "name_62453793316579");
		
		JButton button_10 = new JButton("Voltar");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicPrisoner);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		button_10.setFont(new Font("Consolas", Font.PLAIN, 13));
		button_10.setBackground(Color.WHITE);
		button_10.setBounds(761, 16, 75, 25);
		PrisonerReport.add(button_10);
		
		DefaultListModel modPrisoner = new DefaultListModel();
		
		JScrollPane SP_PR = new JScrollPane();
		SP_PR.setBounds(0, 39, 846, 496);
		PrisonerReport.add(SP_PR);
		
		LBL_PR = new JLabel("New label");
		LBL_PR.setVerticalAlignment(SwingConstants.TOP);
		SP_PR.setViewportView(LBL_PR);
		
		JLabel lblRelatrioDosPrisioneiros = new JLabel("Relat\u00F3rio dos Prisioneiros");
		lblRelatrioDosPrisioneiros.setHorizontalAlignment(SwingConstants.CENTER);
		lblRelatrioDosPrisioneiros.setForeground(Color.GREEN);
		lblRelatrioDosPrisioneiros.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblRelatrioDosPrisioneiros.setBounds(0, 0, 844, 50);
		PrisonerReport.add(lblRelatrioDosPrisioneiros);
		
		JLabel label_16 = new JLabel("");
		label_16.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		label_16.setBounds(0, 0, 846, 535);
		PrisonerReport.add(label_16);
		BTN_Army.setBounds(40, 550, 125, 36);
		PanelMS.add(BTN_Army);

		JButton BTN_Prisoners = new JButton("Prisioneiros");// BOTAO Prsioneiro
		BTN_Prisoners.setBackground(Color.WHITE);
		BTN_Prisoners.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_Prisoners.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicPrisoner);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				PrisonerInfo.setVisible(false);
				BasicPrisoner.setVisible(true);
			}
		});
		BTN_Prisoners.setBounds(205, 550, 125, 36);
		PanelMS.add(BTN_Prisoners);

		JButton BTN_Drugs = new JButton("Drogas");
		BTN_Drugs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicDrugs);
				ClassPanel.repaint();
				ClassPanel.revalidate();
			}
		});
		BTN_Drugs.setBackground(Color.WHITE);
		BTN_Drugs.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_Drugs.setBounds(535, 550, 125, 36);
		PanelMS.add(BTN_Drugs);

		JButton BTN_PleasureGiver = new JButton("Senhoras");
		BTN_PleasureGiver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();

				ClassPanel.add(BasicPleasureGiver);
				ClassPanel.repaint();
				ClassPanel.revalidate();
				// PleasureGiverInfo.setVisible(false);
			}
		});
		BTN_PleasureGiver.setBackground(Color.WHITE);
		BTN_PleasureGiver.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_PleasureGiver.setBounds(370, 550, 125, 36);
		PanelMS.add(BTN_PleasureGiver);

		textFieldName = new JTextField();
		textFieldName.setDisabledTextColor(Color.GREEN);
		textFieldName.setEditable(false);
		textFieldName.setEnabled(false);
		textFieldName.setSelectedTextColor(Color.GREEN);
		textFieldName.setSelectionColor(Color.BLACK);
		textFieldName.setCaretColor(Color.WHITE);
		textFieldName.setForeground(Color.GREEN);
		textFieldName.setFont(new Font("Consolas", Font.PLAIN, 17));
		textFieldName.setBounds(319, 135, 207, 29);
		PanelB1.add(textFieldName);
		textFieldName.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.setToolTipText("Cadastra o seu nome, meio obvio n\u00E3o?");
		btnCadastrar.setFont(new Font("Consolas", Font.PLAIN, 14));
		btnCadastrar.setBounds(334, 175, 178, 29);
		PanelB1.add(btnCadastrar);

		txtDigiteSeuNome = new JTextField();
		txtDigiteSeuNome.setBackground(Color.LIGHT_GRAY);
		txtDigiteSeuNome.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtDigiteSeuNome.setCaretColor(Color.WHITE);
		txtDigiteSeuNome.setDisabledTextColor(Color.GREEN);
		txtDigiteSeuNome.setEditable(false);
		txtDigiteSeuNome.setEnabled(false);
		txtDigiteSeuNome.setText("Digite seu nome");
		txtDigiteSeuNome.setForeground(Color.GREEN);
		txtDigiteSeuNome.setFont(new Font("Consolas", Font.PLAIN, 23));
		txtDigiteSeuNome.setBounds(313, 98, 233, 29);
		PanelB1.add(txtDigiteSeuNome);
		txtDigiteSeuNome.setColumns(10);

		JLabel LBL_B1PSB = new JLabel("");
		LBL_B1PSB.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/WS_WP.jpg")));
		LBL_B1PSB.setBounds(-10, -341, 866, 597);
		PanelB1.add(LBL_B1PSB);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelB.removeAll();
				PanelB.repaint();
				PanelB.revalidate();

				PanelB.add(PanelB2);
				PanelB.repaint();
				PanelB.revalidate();
			}
		});

		JLabel lblVocDisseBerg = new JLabel("Seu nome \u00E9 Berg?");
		lblVocDisseBerg.setForeground(Color.GREEN);
		lblVocDisseBerg.setFont(new Font("Consolas", Font.PLAIN, 23));
		lblVocDisseBerg.setHorizontalAlignment(SwingConstants.CENTER);
		lblVocDisseBerg.setBounds(309, 29, 215, 51);
		PanelB2.add(lblVocDisseBerg);

		JLabel lblBemvindoWarlord = new JLabel("Bem-Vindo \u00E0 Warlord Utility Tool");
		lblBemvindoWarlord.setForeground(Color.GREEN);
		lblBemvindoWarlord.setBounds(10, 11, 846, 76);
		PanelWS.add(lblBemvindoWarlord);
		lblBemvindoWarlord.setFont(new Font("Consolas", Font.PLAIN, 28));
		lblBemvindoWarlord.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton BTN_Report = new JButton("Relatorio");
		BTN_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				reportProfit();
				
				ClassPanel.removeAll();
				ClassPanel.repaint();
				ClassPanel.revalidate();
				ClassPanel.add(ProfitReport);
			}
		});
		BTN_Report.setFont(new Font("Consolas", Font.PLAIN, 13));
		BTN_Report.setBackground(Color.WHITE);
		BTN_Report.setBounds(700, 550, 125, 36);
		PanelMS.add(BTN_Report);

		JLabel LBL_MS_WP = new JLabel("");
		LBL_MS_WP.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/MS_WP.png")));
		LBL_MS_WP.setInheritsPopupMenu(false);
		LBL_MS_WP.setBounds(0, 0, 866, 597);
		PanelMS.add(LBL_MS_WP);

		JLabel lblSejaBemvindoBerg = new JLabel("Seja bem-vindo");
		lblSejaBemvindoBerg.setForeground(Color.GREEN);
		lblSejaBemvindoBerg.setFont(new Font("Consolas", Font.PLAIN, 23));
		lblSejaBemvindoBerg.setHorizontalAlignment(SwingConstants.CENTER);
		lblSejaBemvindoBerg.setBounds(323, 11, 200, 56);
		PanelB3.add(lblSejaBemvindoBerg);

		JLabel lblBergOSenhor = new JLabel("Berg, o Senhor da Guerra");
		lblBergOSenhor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBergOSenhor.setBackground(Color.WHITE);
		lblBergOSenhor.setForeground(Color.GREEN);
		lblBergOSenhor.setFont(new Font("Consolas", Font.PLAIN, 25));
		lblBergOSenhor.setToolTipText("Estupendo nome!");
		lblBergOSenhor.setHorizontalAlignment(SwingConstants.CENTER);
		lblBergOSenhor.setBounds(190, 47, 466, 66);
		PanelB3.add(lblBergOSenhor);

		JButton btnOk = new JButton("Ok!");
		btnOk.setBackground(Color.WHITE);
		btnOk.setForeground(Color.BLACK);
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainPanel.removeAll();
				MainPanel.repaint();
				MainPanel.revalidate();

				MainPanel.add(PanelMS);
				MainPanel.repaint();
				MainPanel.revalidate();
			}
		});
		btnOk.setBounds(377, 118, 89, 23);
		PanelB3.add(btnOk);

		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/WS_WP.jpg")));
		label_2.setBounds(-10, -340, 866, 597);
		PanelB3.add(label_2);

		JButton btnSim = new JButton("Sim");
		btnSim.setBackground(Color.WHITE);
		btnSim.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelB.removeAll();
				PanelB.repaint();
				PanelB.revalidate();

				PanelB.add(PanelB3);
				PanelB.repaint();
				PanelB.revalidate();
			}
		});
		btnSim.setToolTipText("Lindo nome");
		btnSim.setBounds(321, 91, 60, 23);
		PanelB2.add(btnSim);

		JButton btnNewButton = new JButton("N\u00E3o");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnNewButton.setToolTipText("Certeza que n\u00E3o \u00E9 Berg?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PanelB.removeAll();
				PanelB.repaint();
				PanelB.revalidate();

				PanelB.add(PanelB1);
				PanelB.repaint();
				PanelB.revalidate();
			}
		});
		btnNewButton.setBounds(464, 91, 60, 23);
		PanelB2.add(btnNewButton);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/WS_WP.jpg")));
		label_1.setBounds(-10, -341, 866, 597);
		PanelB2.add(label_1);

		JLabel lblNewLabel = new JLabel("By Vault-Tec");
		lblNewLabel.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(579, 55, 110, 51);
		PanelWS.add(lblNewLabel);

		JLabel LBL_BPSB = new JLabel("");
		LBL_BPSB.setIcon(new ImageIcon(WarlordGUI.class.getResource("/images/WS_WP.jpg")));
		LBL_BPSB.setBounds(0, 0, 866, 597);
		PanelWS.add(LBL_BPSB);

		try {
			this.fachada = new TheEmpireBusiness();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	private void insertArmy(String name, int age, double cost, int wh, String id, boolean k, String weapon) {// INSERIR
																												// SOLDADO
		try {
			Army guy = new Army(name, age, cost, wh, id, true, weapon);
			guy.setStatus(true);
			this.fachada.insertPeople(guy);
		} catch (PersonAlreadyExistsException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}

	}

	private void insertDrugs(double w, double PpK, String id) {// INSERIR
																			// DROGAS
		try {
			Drugs magic = new Drugs(id, w, PpK);
			this.fachada.insertIncome(magic);
		} catch (IdAlreadyExistsException | IOException | IdNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void insertPrisoner() {// INSERIR PRISIONEIRO
		try {
			String id = TF_PID.getText();
			String name = TF_PN.getText();
			int age = Integer.parseInt(TF_PA.getText());
			int wh = Integer.parseInt(TF_PWH.getText());
			double cost = Double.parseDouble(TF_PC.getText());
			Prisoner otherGuy = new Prisoner(name, age, cost, wh, id, true);
			this.fachada.insertPeople(otherGuy);
		} catch (PersonAlreadyExistsException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void insertPleasure() {// INSERIR ACOMPANHANTE
		try {
			String id = TF_PleasureID.getText();
			String name = TF_PleasureN.getText();
			int age = Integer.parseInt(TF_PleasureA.getText());
			double cost = Double.parseDouble(TF_PleasureC.getText());
			int wh = Integer.parseInt(TF_PleasureWH.getText());
			double sc = Double.parseDouble(TF_PleasureP.getText());
			Companion momo = new Companion(id, name, age, cost, wh, sc);
			this.fachada.insertIncome(momo);
		} catch (IdAlreadyExistsException | IOException | IdNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void insertWeapon(String name) {// INSERIR ARMA
		try {
			String id = TF_WID.getText();
			int ammo = Integer.parseInt(TF_WMagazine.getText());
			int Tammo = Integer.parseInt(TF_WTAmmo.getText());
			Weapon gun = new Weapon(id, name, ammo, Tammo);
			this.fachada.insertWeapon(gun);
		} catch (SerialAlreadyExistsException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void workArmy() {// COLOCA O SOLDADO PRA TRABALHAR
		try {
			String id = TF_SInfoID.getText();
			int time = Integer.parseInt(TF_SInfoWHA.getText());
			this.fachada.workArmy(id, time);
		} catch (PersonNotFoundException | InvalidUpdateException | MissingUpdateException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch (PrisonerArmyException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	/*
	 * private void workPrisoner(){ try{ double time =
	 * Double.parseDouble(TF_PInfoWHA.getText()); String id =
	 * TF_PInfoID.getText(); this.fachada.workPrisoner(); (METODO PRA TRABALHO
	 * NORMAL, SEM COZINHAR DROGAS) }catch( //exceções separadas por | ex){
	 * JOptionPane.showMessageDialog(this, ex.getMessage()); } }
	 */

	private void letsCook(String drug, String faction) {// COZINHAR DROGAS
		try {
			String id = TF_PInfoID.getText();
			double w = Double.parseDouble(TF_PInfoCook.getText());
			int h = Integer.parseInt(TF_PInfoWHA.getText());
			this.fachada.workPrisonerCookDrugs(id, drug, w, faction, h);
		} catch (PersonNotFoundException | ArmyCantCookException | IdNotFoundException | JessieUsedTheDrugsException
				| IOException | InvalidUpdateException | MissingUpdateException | CompanionDrugFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void war() {// MANDA O SOLDADO PRA GUERRA
		try {
			this.fachada.workArmy(TF_SInfoID.getText(), 0);
			if (morreu = true) {
				String CM = TF_SInfoDC.getText();
				TF_SInfoS.setText(CM);
				TF_SInfoDC.setEnabled(false);
			}
		} catch (PersonNotFoundException | InvalidUpdateException | MissingUpdateException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
		// getKilled;
		catch (PrisonerArmyException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void sellDrugsPleasure(String drug, double weight, String id, String faction) {// ACOMPANHANTE
																							// VENDE
																							// DROGAS
		try {
			this.fachada.workCompanionSellDrugs(drug, weight, id, faction);
		} catch (IdNotFoundException | DrugsCompanionFoundException | CompanionDrugFoundException | IOException
				| InvalidUpdateException | MissingUpdateException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void searchArmy(String id) {// PROCURA POR UM SOLDADO NO EXERCITO
		try {
			Army guy = (Army) this.fachada.searchPerson(id);
			TF_SInfoID.setText(guy.getDogtag());
			TF_SInfoN.setText(guy.getName());
			TF_SInfoA.setText(guy.getAge() + "");
			TF_SInfoC.setText(guy.getFoodCost() + " Caps");
			TF_SInfoWp2.setText(guy.getWeapon());
			if (guy.getStatus() == true) {
				TF_SInfoS.setText("Vivo");
			} else {
				TF_SInfoS.setText(guy.getCauseDeath());
			}
			TF_SInfoWH.setText(guy.getWorkHours() + " h(s)");
			

		} catch (PersonNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void searchPrisoner() {// PROCURA POR UM PRISIONEIRO
		try {
			String id = TF_PID.getText();
			Prisoner justGuy = (Prisoner) this.fachada.searchPerson(id);
			TF_PInfoID.setText(justGuy.getDogtag());
			TF_PInfoN.setText(justGuy.getName());
			TF_PInfoA.setText(justGuy.getAge() + "");
			TF_PInfoC.setText(justGuy.getFoodCost() + "");
			TF_PInfoWH.setText(justGuy.getWorkHours() + "");
			TF_PInfoDP.setText(justGuy.getDrugsCooked() + "Kg");
			String s = "Vivo";
			if (justGuy.getStatus() == false) {
				s = justGuy.getCauseDeath();
			}
			TF_PInfoS.setText(s);
		} catch (PersonNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void searchPleasure() {
		try {
			Companion girl = (Companion) this.fachada.searchIncome(TF_PleasureID.getText());
			TF_PleasureInfoID.setText(girl.getID());
			TF_PleasureInfoN.setText(girl.getName());
			TF_PleasureInfoA.setText(girl.getAge() + "");
			TF_PleasureInfoC.setText(girl.getFoodCost() + "");
			TF_PleasureInfoWH.setText(girl.getShiftHours() + "");
			TF_PleasureInfoME.setText(girl.getLifetimeEarnings() + "");
		} catch (IdNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void searchWeapon() {
		try {
			Weapon gun = this.fachada.searchGun(TF_WID.getText());
			TF_WInfoID.setText(gun.getSerial());
			TF_WInfoN.setText(getName());
			TF_WInfoM.setText(gun.getBullets() + "");
			TF_WInfoTA.setText(gun.getMaxRounds() + "");
		} catch (WeaponNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void removePrisoner() {
		try {
			String id = TF_PInfoID.getText();
			this.fachada.removePerson(id);
		} catch (PersonNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void removeSoldier() {
		try {
			String id = TF_SInfoID.getText();
			this.fachada.removePerson(id);
		} catch (PersonNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void removePleasure() {
		try {
			String id = TF_PleasureInfoID.getText();
			this.fachada.removeIncome(id);
		} catch (IdNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void removeDrugs(String id) {
		try {
			this.fachada.removeIncome(id);
		} catch (IdNotFoundException | IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void removeWeapon() {
		try {
			String id = TF_WInfoID.getText();
			this.fachada.removeGun(id);
		} catch (WeaponNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void massage() {
		try {
			int h = Integer.parseInt(TF_PleasureInfoWHA.getText());
			String id = TF_PleasureInfoID.getText();
			this.fachada.workCompanionGiveMassage(h, id);
		} catch (InvalidUpdateException | IOException | MissingUpdateException | DrugsCompanionFoundException | IdNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void sellDrugs(String faction) {
		try {
			String id = TF_DInfoN.getText();
			double w = Double.parseDouble(TF_DInfoSell.getText());
			this.fachada.sellDrugs(id, w, faction);
		} catch (IdNotFoundException | CompanionDrugFoundException | IOException | InvalidUpdateException
				| MissingUpdateException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}

	private void searchDrugs(String id) {
		try {
			Drugs blue = (Drugs) this.fachada.searchIncome(id);
			TF_DInfoN.setText(blue.getID());
			TF_DInfoW.setText(blue.getWeight() + " KG");
			TF_DInfoPpK.setText(blue.getPriceQuilo() + " Caps");
		} catch (IdNotFoundException ex) {
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	public void reportArmy(){
		try{
			String report ="<html><body>" + this.fachada.reportArmy().replaceAll("\n", "<br>") + "</body></html>";
			LBL_ReportSoldier.setText(report);
		}catch(IOException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	public void reportPrisoner(){
		String report = "";
		try{
			report = "<html><body>" + this.fachada.reportPrisoner().replaceAll("\n", "<br>") + "</body></html>";
			LBL_PR.setText(report);
		}catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(this, ex);
		}
	}
	
	public void reportProfit(){
		String report = "";
		try{
			report = "<html><body>" + this.fachada.reportArmy().replaceAll("\n", "<br>")+ this.fachada.endYearCompanion().replaceAll("\n", "<br>")+ this.fachada.endYearDrugs().replaceAll("\n", "<br>")+ this.fachada.reportPrisoner().replaceAll("\n", "<br>")+ this.fachada.reportProfit().replaceAll("\n", "<br>") + "</body></html>";
			label_21.setText(report);
		}catch(IOException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	public void reportDrugs(){
		String report = "";
		try{
			report = "<html><body>" + this.fachada.endYearDrugs().replaceAll("\n", "<br>") + "</body></html>";
			label_15.setText(report);
		}catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	public void reportPleasure(){
		String report = "";
		try{
			report = "<html><body>" + this.fachada.endYearCompanion().replaceAll("\n", "<br>") + "</body></html>";
			label_17.setText(report);
		}catch(FileNotFoundException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
	
	public void addBullets(){
		try{
			String serial = TF_WInfoID.getText();
			int bullets = Integer.parseInt(TF_WInfoADD.getText());
			this.fachada.addBullets(serial, bullets);
		}catch(WeaponNotFoundException | MissingUpdateException | IOException ex){
			JOptionPane.showMessageDialog(this, ex.getMessage());
		}
	}
}
