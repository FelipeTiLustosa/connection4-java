package src.applicantion;

import src.db.DB;
import src.db.DbException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "UPDATE  seller "
                    + "SET BaseSalary = BaseSalary + ? "
                    + "WHERE "
                    + "(DepartmentId = ?)");

            st.setDouble(1,200.0);
            st.setInt(2,2);

            int rowsAffected = st.executeUpdate();
            System.out.println("Done! Rows affected: " + rowsAffected);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
