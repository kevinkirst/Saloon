package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            String STR_DRIVER = "org.gjt.mm.mysql.Driver";
            String STR_CONEX = "jdbc:mysql://localhost:3306/dbtccteste";
            String USER = "root";
            String PASSWORD = "";
//            String STR_CONEX = "jdbc:mysql://mysql07.redehost.com.br:41890/dbBancoIdeias";
//            String USER = "bancoideia";
//            String PASSWORD = "#123456A";

            try {
                Class.forName(STR_DRIVER);
                conn = DriverManager.getConnection(STR_CONEX, USER, PASSWORD);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return conn;
    }
}

