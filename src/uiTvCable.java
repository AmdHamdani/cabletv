import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class uiTvCable {
	/*
	 * KETERANGAN huruf belakang variable menunjukkan di digunakan pada panel
	 * apa. *Mm / *mm digunakan pada mainMenu atau hompage *D digunakan pada
	 * panel Daftar, setelah mengklik tombol Daftar di mainMenu / homepage *L
	 * digunakan pada panel login
	 */

	JFrame frame = new JFrame();
	Executor execute;
	// Main Menu
	JPanel mm = new JPanel(), m2 = new JPanel();
	JButton loginMm = new JButton("Login");
	JLabel Title = new JLabel("TV KABEL"), loginLabelMm = new JLabel(
			"Login Admin");
	JTextField namaLogin = new JTextField();
	JPasswordField passwordLogin = new JPasswordField();

	// Daftar
	JPanel daftar = new JPanel(), form = new JPanel();
	JLabel Title2 = new JLabel("TV KABEL"), idLD = new JLabel("ID"),
			namaLD = new JLabel("Nama"), passwordLD = new JLabel("Password"),
			ktpLD = new JLabel("No. KTP"), alamatLD = new JLabel("Alamat"),
			nomorLD = new JLabel("Nomor Telephone"), paketLD = new JLabel(
					"Paket"), hargaLD = new JLabel("Harga"),
			hargaLD2 = new JLabel("/ bulan");
	JTextField idD = new JTextField(), namaD = new JTextField(),
			ktpD = new JTextField(), alamatD = new JTextField(),
			nomorD = new JTextField(), hargaD = new JTextField();
	JPasswordField passwordD = new JPasswordField();
	JComboBox paketD = new JComboBox();
	JButton daftarD = new JButton("daftar"), kembaliD = new JButton("kembali");
	DefaultTableModel data = new DefaultTableModel();

	// login
	JPanel login = new JPanel(), pilihan = new JPanel(),
			dataPanel = new JPanel();
	String admin = "admin", passAdmin = "admin", akun[] = new String[100],
			passAkun[] = new String[100];
	JLabel Title3 = new JLabel("TV KABEL"), namaLL = new JLabel("Nama :"),
			tgl_pembayaranLL = new JLabel("Tanggal Pembayaran"),
			TDLL = new JLabel("Daftar :"), idPelangganLL = new JLabel(
					"Masukkan ID pelanggan : ");
	JButton pembayaranL = new JButton("Bayar"), logOut = new JButton("LogOut"),
			daftarL = new JButton("daftar user"),
			bayarL = new JButton("bayar"), cekPembayaranL = new JButton(
					"Cek Bayar");
	JScrollPane scroll = new JScrollPane();
	JTable table = new JTable();
	JTextArea namaL = new JTextArea(), tglDaftarL = new JTextArea();
	JTextField idPelangganL = new JTextField(),
			tgl_pembayaranL = new JTextField();
	JComboBox daftarUser = new JComboBox();

	public uiTvCable() {
		execute = new Executor("tv", "tvpass");

		for (int i = 0; i < akun.length; i++) {
			akun[i] = new String();
			passAkun[i] = new String();
		}
		akun[0] = "Khairul Anwar";
		passAkun[0] = "0";

		frame.setBounds(100, 100, 350, 500);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mainMenu();
		daftar();
		login();
		aksi();
	}

	void mainMenu() {
		frame.setContentPane(mm);
		mm.setBounds(0, 0, 350, 500);
		mm.setLayout(null);
		mm.add(m2);
		mm.add(Title);

		m2.setBounds(10, 105, 320, 216);
		m2.setLayout(null);
		m2.setBackground(Color.lightGray);
		m2.add(loginLabelMm);
		m2.add(namaLogin);
		m2.add(passwordLogin);
		m2.add(loginMm);

		Title.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		Title.setBounds(10, 15, 200, 60);
		loginLabelMm.setFont(new Font("Tekton Pro", Font.PLAIN, 15));
		loginLabelMm.setBounds(10, 11, 75, 14);
		namaLogin.setBounds(10, 59, 300, 20);
		namaLogin.setColumns(25);
		passwordLogin.setBounds(10, 115, 200, 20);
		passwordLogin.setColumns(10);

		loginMm.setBounds(220, 114, 89, 23);
	}

	void daftar() {
		JButton print = new JButton("Report");
		daftar.setBounds(0, 0, 350, 500);
		daftar.setLayout(null);
		daftar.add(form);
		daftar.add(Title2);
		form.setBounds(10, 120, 320, 300);
		form.setBackground(Color.white);
		form.setLayout(null);
		form.add(idLD);
		form.add(namaLD);
		form.add(passwordLD);
		form.add(ktpLD);
		form.add(alamatLD);
		form.add(nomorLD);
		form.add(paketLD);
		form.add(hargaLD);
		form.add(hargaLD2);
		form.add(idD);
		form.add(namaD);
		form.add(passwordD);
		form.add(ktpD);
		form.add(alamatD);
		form.add(nomorD);
		form.add(paketD);
		form.add(hargaD);
		form.add(daftarD);
		form.add(kembaliD);
		form.add(print);
		
		Title2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		Title2.setBounds(20, 25, 200, 60);
		idLD.setBounds(10, 11, 46, 15);
		namaLD.setBounds(10, 36, 46, 15);
		passwordLD.setBounds(10, 61, 70, 15);
		ktpLD.setBounds(10, 86, 56, 15);
		alamatLD.setBounds(10, 111, 56, 15);
		nomorLD.setBounds(10, 136, 130, 15);
		paketLD.setBounds(10, 183, 46, 15);
		hargaLD.setBounds(10, 208, 46, 15);
		hargaLD2.setBounds(235, 208, 48, 15);

		idD.setBounds(110, 8, 200, 20);
		namaD.setBounds(110, 33, 200, 20);
		passwordD.setBounds(110, 58, 200, 20);
		ktpD.setBounds(110, 83, 200, 20);
		alamatD.setBounds(110, 108, 200, 20);
		nomorD.setBounds(150, 133, 160, 20);
		paketD.setBounds(80, 180, 150, 20);
		hargaD.setBounds(80, 205, 150, 20);
		daftarD.setBounds(230, 260, 80, 20);
		print.setBounds(130, 260, 80, 20);
		kembaliD.setBounds(10, 260, 90, 20);

//		idD.setEditable(false);
		idD.setText("R-");

		paketD.addItem("Silver");
		paketD.addItem("Platinum");
		paketD.addItem("Gold");

		hargaD.setEditable(false);

		print.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				execute.registerReport();
			}
		});
		
		paketD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				hargaD.setText(execute.packagePrice(paketD.getSelectedIndex()));
			}
		});

		daftarD.addActionListener(new ActionListener() {

			// TODO : Need to add data to tranksaksi table

			@Override			
			public void actionPerformed(ActionEvent arg0) {
                                Date date = new Date();
                                String d = date.getDate() + date.getMonth() + date.getYear() + "";
				execute.customer(idD.getText(), namaD.getText(), ktpD.getText(), alamatD.getText(), Long.parseLong(nomorD.getText()), paketD.getSelectedIndex() + d);
				System.out.println("Success");
				execute.transaction(execute.generatePay(), execute.getEmployeeID(namaD.getText()), idD.getText(), "");
			}
		});
	}

	void login() {
		login.setBounds(0, 0, 350, 500);
		login.setLayout(null);
		login.add(Title3);
		login.add(pilihan);
		login.add(dataPanel);
		login.add(daftarL);
		login.add(pembayaranL);
		login.add(cekPembayaranL);

		Title3.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		Title3.setBounds(20, 25, 200, 60);
		pilihan.setBounds(10, 100, 320, 75);
		pilihan.setBackground(Color.white);
		pilihan.setLayout(null);
		pilihan.add(namaLL);
		pilihan.add(namaL);
		pilihan.add(logOut);
		pilihan.add(TDLL);
		pilihan.add(tglDaftarL);
		dataPanel.setBounds(10, 190, 320, 250);
		dataPanel.setBackground(Color.white);
		dataPanel.setLayout(null);

		scroll.setBounds(10, 30, 300, 210);
		scroll.setViewportView(table);
		data = new DefaultTableModel(null, new String[] { "Tgl Pembayaran",
				"status" }) {
			@Override
			public Class getColumnClass(int coloumn) {
				switch (coloumn) {
				default:
					return Object.class;
				}
			}
		};
		table.setModel(data);
		namaLL.setBounds(10, 10, 50, 15);
		namaL.setBounds(60, 10, 100, 20);
		namaL.setEditable(false);
		TDLL.setBounds(10, 40, 80, 15);
		tglDaftarL.setBounds(65, 40, 100, 20);

		daftarL.setBounds(10, 160, 100, 20);
		pembayaranL.setBounds(110, 160, 100, 20);
		idPelangganLL.setBounds(20, 90, 150, 20);
		idPelangganL.setBounds(20, 120, 200, 20);
		tgl_pembayaranLL.setBounds(20, 150, 150, 20);
		tgl_pembayaranL.setBounds(20, 180, 200, 20);
		bayarL.setBounds(220, 180, 80, 20);
		bayarL.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				execute.transactionDetail(execute.generatePay(), tgl_pembayaranL.getText());
			}
		});
		cekPembayaranL.setBounds(210, 160, 120, 20);
		daftarUser.setBounds(159, 10, 150, 20);

		logOut.setBounds(220, 10, 90, 20);
		inputData();
		inputUser();
	}

	void inputUser() {
		ArrayList temp = execute.getName();
		for (int i = 0; i < temp.size(); i++)
			daftarUser.addItem(temp.get(i) + "");
	}

	void inputData() {
		// TODO : need to update the table every time after choose the member
		daftarUser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList temp = execute.getDate(daftarUser.getSelectedItem()
						.toString());
				for (int i = 0; i < temp.size(); i++) {
					data.addRow(new Object[] { "" + temp.get(i), "lunas" });
				}
			}
		});
	}

	void admin() {
		namaLogin.setText(null);
		passwordLogin.setText(null);

		pilihan.remove(tglDaftarL);
		pilihan.remove(TDLL);
		pilihan.setSize(320, 40);
		dataPanel.removeAll();
	}

	void user() {
		namaLogin.setText(null);
		passwordLogin.setText(null);

		namaL.setText("Khairul Anwar");
		tglDaftarL.setText("1/juli/2014");

		pilihan.remove(pembayaranL);
		pilihan.remove(cekPembayaranL);
		pilihan.setSize(320, 75);
		dataPanel.removeAll();
		dataPanel.setBounds(10, 190, 320, 250);
		pilihan.add(TDLL);
		pilihan.add(tglDaftarL);
		dataPanel.add(scroll);
	}

	void aksi() {
		daftarL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dataPanel.removeAll();
				frame.setContentPane(daftar);
			}
		});
		daftarD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				if (namaD.getText().isEmpty() || passwordD.getText().isEmpty()
						|| ktpD.getText().isEmpty()
						|| alamatD.getText().isEmpty()
						|| nomorD.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Isi semua data");
				} else {
					inputUser();
					frame.setContentPane(mm);
				}
			}
		});
		kembaliD.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frame.setContentPane(login);
			}
		});
		loginMm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				ArrayList user = execute.getEmployeeName();
				ArrayList pass = execute.getEmployeePass();

				for (int i = 0; i < user.size(); i++) {
					String usr = user.get(i) + "";
					String pss = user.get(i) + "";
					if (namaLogin.getText().equals(usr)
							&& passwordLogin.getText().equals(pss)) {
						namaL.setText(usr);
						admin();
						frame.setContentPane(login);
						break;
					} else if (akun[0].equalsIgnoreCase(namaLogin.getText())
							&& passAkun[0].equalsIgnoreCase(passwordLogin
									.getText())) {
						user();
						frame.setContentPane(login);
					} else if(namaLogin.getText() == null || passwordLogin.getText() == null){
						JOptionPane.showMessageDialog(null, "Isi dulu datanya");
					} else 
                                            return;
				}
			}
		});
		pembayaranL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dataPanel.removeAll();
				dataPanel.add(idPelangganLL);
				dataPanel.add(idPelangganL);
				dataPanel.add(tgl_pembayaranLL);
				dataPanel.add(tgl_pembayaranL);
				dataPanel.add(bayarL);
				dataPanel.repaint();
			}
		});
		cekPembayaranL.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				dataPanel.removeAll();
				dataPanel.add(daftarUser);
				dataPanel.add(scroll);
				dataPanel.repaint();
			}
		});

		logOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				frame.setContentPane(mm);
			}
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new uiTvCable();
			}
		});
	}
}