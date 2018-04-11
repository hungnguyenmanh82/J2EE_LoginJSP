package dao;

import java.sql.ResultSet;

import model.Account;

public class UserDAO {
	

	/**
			CREATE TABLE IF NOT EXISTS `logindb`.`logintb` (
			  `id` INT(11) NOT NULL AUTO_INCREMENT,
			  `user` VARCHAR(45) NOT NULL,
			  `pass` VARCHAR(45) NOT NULL,
			  `name` VARCHAR(45) NOT NULL,
			  `create_time` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
			  PRIMARY KEY (`id`),
			  INDEX `user` (`user` ASC))
			ENGINE = InnoDB
			DEFAULT CHARACTER SET = utf8;
	 */
	/**
		INSERT INTO TABLE_NAME (column1, column2, column3,...columnN)
		VALUES (value1, value2, value3,...valueN);

	 */
	public boolean addNewAccount(Account account) {
		try {
			MyConnectDB.getNewInstance().insertSql("INSERT INTO  logintb(user,pass,name) VALUES('"+account.getUserName()+"','"+account.getPass()+"','"+account.getName()+"')");
			System.out.println("****register successful");
			System.out.println(account);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Account getAccountInfo(String username){
		try {
			ResultSet  rs = MyConnectDB.getNewInstance().selectSql("SELECT * FROM logintb WHERE user='"+username+"'");
			while(rs.next()){
				String user = rs.getString("user"); //nick name to login
				String pass = rs.getString("pass");
				String name = rs.getString("name"); //full name
				return new Account(user,pass,name);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;

	}


	public boolean validateAccountPass(String username,String pass) {

		try {
			ResultSet  rs = MyConnectDB.getNewInstance().selectSql("SELECT * FROM logintb WHERE user='"+username+"'");
			while(rs.next()){
				if( rs.getString("pass").equals(pass)){
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}


		return false;
	}
	public static void main(String[] args) {
		Account kh = new Account("lephong", "abcd", "Phong");
		//		System.out.println(new KhachHangDAO().themTaiKhoan(kh));
		System.out.println(new UserDAO().validateAccountPass("lephong", "abcd"));
	}
}
