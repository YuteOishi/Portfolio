import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sql {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {

			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/employees?allowPublicKeyRetrieval=true&useSSL=false", "root", "1324");

			String sql = "select * from employees where emp_no > ? AND emp_no < ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, 15000);
			ps.setInt(2, 15500);
			rs = ps.executeQuery();

			int colCount = rs.getMetaData().getColumnCount();
			System.out.println("取得したカラム数:" + colCount);

			while (rs.next()) {
				System.out.print(rs.getInt("emp_no") + "    ");
				System.out.printf("%-14s", rs.getString("first_name"));
				System.out.println(rs.getString("last_name"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
