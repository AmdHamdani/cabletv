import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.builder.style.Styles;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.constant.VerticalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class Executor {

	private Connection connection;
	private Statement sql;
	private ResultSet result;
	private JasperReportBuilder report;

	private String custID = "C-";
	private String register = "R-";
	private String payment = "P-";
	private String query;
	private int totalMem;
	private int totalReg;
	private int totalPay;

	public Executor(String username, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:"
					+ username + "/" + password + "@localhost");
			sql = connection.createStatement();
			report = DynamicReports.report();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		counter();
	}

	private void counter() {
		try {
			query = "select count(id_pelanggan) from pelanggan";
			result = sql.executeQuery(query);
			while (result.next())
				totalMem = result.getInt(1);

			query = "select count(id_transaksi) from transaksi where id_transaksi like 'R%'";
			result = sql.executeQuery(query);
			while (result.next())
				totalReg = result.getInt(1);

			query = "select count(id_transaksi), count(id_transaksi) from transaksi where id_transaksi like 'P%'";
			result = sql.executeQuery(query);
			while (result.next())
				totalPay = result.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String generateID() {
		if (totalMem < 10)
			custID += "0" + (totalMem + 1);
		else
			custID += (totalMem + 1);

		totalMem++;
		return custID;
	}

	public String generateReg() {
		if (totalReg < 10)
			register += "0" + (totalReg + 1);
		else
			register += (totalReg + 1);

		totalReg++;
		return register;
	}

	public String generatePay() {
		if (totalPay < 10)
			payment += "0" + (totalPay + 1);
		else
			payment += (totalPay + 1);

		totalPay++;
		return payment;
	}

	public void customer(String id, String name, String noktp, String address,
			long number, String code) {
		try {
			query = "insert into pelanggan values('" + id + "', '" + name
					+ "', '" + noktp + "', '" + address + "', " + number + ", '" + code+"')";
			result = sql.executeQuery(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList getName() {
		ArrayList temp = new ArrayList();
		try {
			query = "select nama_pelanggan from pelanggan";
			result = sql.executeQuery(query);
			while (result.next())
				temp.add(result.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public String getID(String name) {
		String res = "";
		try {
			query = "select id_pelanggan from pelanggan where nama_pelanggan = '"
					+ name + "'";
			result = sql.executeQuery(query);

			while (result.next())
				res = result.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList getDate(String name) {
		ArrayList temp = new ArrayList();
		temp.clear();
		try {
			query = "select t.tanggal_transaksi from transaksi t join pelanggan p on t.id_pelanggan = p.id_pelanggan where p.nama_pelanggan = '"
					+ name + "'";
			result = sql.executeQuery(query);
			while (result.next())
				temp.add(result.getString(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public String getEmployeeID(String name) {
		String res = "";
		try {
			query = "select id_pegawai from pegawai where nama_pegawai = '"
					+ name + "'";
			result = sql.executeQuery(query);

			while (result.next())
				res = result.getString(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public ArrayList getEmployeeName() {
		ArrayList temp = new ArrayList();
		try {
			query = "select nama_pegawai from pegawai";
			result = sql.executeQuery(query);
			while (result.next())
				temp.add(result.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public ArrayList getEmployeePass() {
		ArrayList temp = new ArrayList();
		try {
			query = "select password from pegawai";
			result = sql.executeQuery(query);
			while (result.next())
				temp.add(result.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	public String packagePrice(int paket) {
		ArrayList temp = new ArrayList();
		try {
			result = sql.executeQuery("select harga_paket from paket");

			while (result.next())
				temp.add(result.getString(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) temp.get(paket);
	}

	public void transaction(String code, String employee, String customer, String date) {
		try {
			query = "insert into transaksi values('" + code + "', '"
					+ employee + "', '" + customer + "','" + date + "')";
			result = sql.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void transactionDetail(String code, String transaction) {
		// TODO : how I can get the code from the user?
	}

	public void registerReport(String id) {
		// create a new report
		report.columns(
				// columns to show
				Columns.column("ID", "id_pelanggan", DataTypes.stringType()),
				Columns.column("Nama", "nama_pelanggan", DataTypes.stringType()),
				Columns.column("No. KTP", "no_ktp_pelanggan", DataTypes.stringType()),
				Columns.column("Alamat", "alamat_pelanggan", DataTypes.stringType()),
				Columns.column("No. Telp", "no_telpon_pelanggan", DataTypes.longType()),
				Columns.column("Nama Paket ", "nama_paket", DataTypes.stringType()),
				Columns.column("Harga", "harga_paket", DataTypes.stringType())
				)
				.title(
				// title of the report
				Components.text("Register Data").setStyle(
						Styles.style().setAlignment(HorizontalAlignment.CENTER,
								VerticalAlignment.MIDDLE)))
				// show page number on the page footer
				.pageFooter(Components.pageXofY())
				.setDataSource(
						"select p.* , k.nama_paket, k.harga_paket from pelanggan p join paket k on p.kode_paket = k.kode_paket and p.id_pelanggan = '" + id +"'",
						connection);

		try {
			report.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	public void registerReport() {
		// create a new report
		report.columns(
				// columns to show
				Columns.column("ID", "id_pelanggan", DataTypes.stringType()),
				Columns.column("Nama", "nama_pelanggan", DataTypes.stringType()),
				Columns.column("No. KTP", "no_ktp_pelanggan", DataTypes.stringType()),
				Columns.column("Alamat", "alamat_pelanggan", DataTypes.stringType()),
				Columns.column("No. Telp", "no_telpon_pelanggan", DataTypes.longType()),
				Columns.column("Nama Paket ", "nama_paket", DataTypes.stringType()),
				Columns.column("Harga", "harga_paket", DataTypes.stringType())
				)
				.title(
				// title of the report
				Components.text("Register Data").setStyle(
						Styles.style().setAlignment(HorizontalAlignment.CENTER,
								VerticalAlignment.MIDDLE)))
				// show page number on the page footer
				.pageFooter(Components.pageXofY())
				.setDataSource(
						"select p.* , k.nama_paket, k.harga_paket from pelanggan p join paket k on p.kode_paket = k.kode_paket",
						connection);

		try {
			report.show();
		} catch (DRException e) {
			e.printStackTrace();
		}
	}

	
	public void close() {
		try {
			result.close();
			sql.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		Executor exe = new Executor("tv", "tvpass");
		exe.counter();
		exe.registerReport("C-01");
	}
}