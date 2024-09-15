
package test;
import java.sql.*;

public class LoginDAO {
    public UserBean ub = null;

    public UserBean login(String uN, String pW) {
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("select * from UserReg59 where uname=? and pword=?");
            ps.setString(1, uN);
            ps.setString(2, pW);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ub = new UserBean();
                ub.setuName(rs.getString(1));
                ub.setpWord(rs.getString(2));
                ub.setfName(rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ub;
    }
}