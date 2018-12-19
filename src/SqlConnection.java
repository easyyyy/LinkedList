
import java.sql.*;
public class SqlConnection {
    public static void main(String[] args) {
        // 驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        // URL指向要访问的数据库名world
        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        // MySQL配置时的用户名
        String user = "root";
        // MySQL配置时的密码
        String password = "glgjssyqyhfbqz";
        String name;
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 连续数据库
            Connection conn = DriverManager.getConnection(url, user, password);
            if (!conn.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();
            // 要执行的SQL语句
            String sql = "select * from taobao";
            // 结果集
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                // 选择Name这列数据
                name = rs.getString("title");
                // 输出结果
                System.out.println(rs.getString("price") + "\t" + name);
            }
            rs.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


