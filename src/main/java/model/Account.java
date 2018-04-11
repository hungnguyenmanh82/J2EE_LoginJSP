package model;

public class Account {
		String userName;
		String pass;
		String name;
		public Account(String userName, String pass, String name) {
			super();
			this.userName = userName;
			this.pass = pass;
			this.name = name;
		}
		
		public Account() {
			super();
		}

		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "Account [user=" + userName + ", pass=" + pass + ", name=" + name + "]";
		}
		
}
