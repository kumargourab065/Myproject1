import java.util.*;
import java.sql.*;

public class Crudd1 {
    public static void main(String... args) {


        Connection cn = null;
        Statement st = null;
        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";
            String username = "root";
            String password = "system";
            cn = DriverManager.getConnection(url, username, password);
            st = cn.createStatement();

        } catch (
                Exception e) {
            System.out.println("Sql Exception");
        }

        Scanner s = new Scanner(System.in);
        int ch;
        do {
            System.out.println("1.INSERT");
            System.out.println("2.DISPLAY");
            System.out.println("3.SEARCH");
            System.out.println("4.DELETE");
            System.out.println("5.UPDATE");
            System.out.println("Enter Your Choice : ");
            ch = s.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Student Id no: ");
                    int studentId = s.nextInt();
                    System.out.print("Enter Classname : ");
                    String classname = s.next();
                    System.out.print("Enter RollNo: ");
                    int rollNo = s.nextInt();
                    System.out.print("Enter Student name: ");
                    String studentName = s.next();
                    System.out.print("Enter the parents name: ");
                    String parentsName = s.next();


//                   String query1 = "INSERT INTO `studentmanagementsystem`.`student` (`student_id`, `classname`, `rollno`, `studentname`, `parentsname`) VALUES ('" + studentId + "','" + classname + "','" + rollNo + "','" + studentName + "','" + parentsName + "')";
//                    try {
//                        st.executeUpdate(query1);
//
//                    } catch (SQLException se) {
//
//                        se.printStackTrace();
//                    }
                  try {
                 PreparedStatement pst = cn.prepareStatement("INSERT INTO `studentmanagementsystem`.`student` (`student_id`, `classname`, `rollno`, `studentname`, `parentsname`) VALUES (?,?,?,?,?)");

                 pst.setInt(1, studentId);
                 pst.setString(2, classname);
                 pst.setInt(3, rollNo);
                 pst.setString(4, studentName);
                 pst.setString(5, parentsName);

                      int i=pst.executeUpdate();
                      System.out.println(i+" records inserted");

                  }catch(Exception e){
                     System.out.println();
                    }
                    break;
                case 2:

                    try {
                         rs = st.executeQuery("select * from student");
                        while (rs.next())
                            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3) + "  " + "  " + rs.getString(4) + " " + " " + rs.getString(5));
                    } catch (Exception e) {
                    }

                    break;
                case 3:
                    try {

                        System.out.println("Enter the StudentId No to Search: ");
                        int id = s.nextInt();


                    rs = st.executeQuery("select * from student where student_id='" +id+ "'");
                    if(rs.next()==false) {
                        System.out.println("Record not Found");
                    }
                        else {
                            System.out.println(rs.getInt(1) + "  " + rs.getString(2) + " " + rs.getInt(3) + "  " + "  " + rs.getString(4) + " " + " " + rs.getString(5));
                        }
                    } catch (Exception e) {

                    }
                    break;
                case 4:
                     System.out.println("Enter the StudentId No to Delete : ");
                  int id = s.nextInt();

                    try {
                        int k=st.executeUpdate("delete from student where student_id='" + id + "'");
                        if(k!=0){
                            System.out.println("Record is Deleted Successfully...!");

                        }else {
                            System.out.println("Record is Not Found");
                        }
                    }catch(Exception e) {
                    }
                    break;
                case 5:
                    System.out.println("Enter the StudentId No to update : ");
                    int id1 = s.nextInt();


                    System.out.print("Enter new Classname : ");
                            classname = s.next();
                            System.out.print("Enter  new RollNo: ");
                            rollNo = s.nextInt();
                            System.out.print("Enter Student new  name: ");
                            studentName = s.next();
                            System.out.print("Enter the new  parents name: ");
                            parentsName = s.next();

                    try {
                       st.executeUpdate("update student set classname='"+classname+"',rollno='"+rollNo+"',studentname='"+studentName+"',parentsname='"+parentsName+"'where  student_id='" + id1 + "'");

                       System.out.println("Record is Updated Successfully...!");

                    }catch(Exception e) {
                    }
                    }

        } while (ch != 0) ;
    }
}


