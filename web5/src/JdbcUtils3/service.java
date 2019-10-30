package JdbcUtils3;

import java.sql.SQLException;

public class service {
    private dao d=new dao();
    public void service() throws SQLException {
        try{
            JdbcUtils3.beginTransaction();
            d.update("树凯",200);
            d.update("郭太",-200);
            JdbcUtils3.commitTransaction();
        }catch (Exception e){
            try {
                JdbcUtils3.rollbackTransaction();
            } catch (SQLException e1) {
            }
            throw e;
        }
    }
}
