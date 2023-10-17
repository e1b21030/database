package oit.is.lec04.team6.database.model;

public class Chamber {
    int id;
    String userName;
    String chamberName; 

    public String getUserName() {
        return userName;
      }
    
      public void setUserName(String userName) {
        this.userName = userName;
      }
    
      public String getChamberName() {
        return chamberName;
      }
    
      public void setChamberName(String chamberName) {
        this.chamberName = chamberName;
      }
    
      public int getId() {
        return id;
      }
    
      public void setId(int id) {
        this.id = id;
      }
}
