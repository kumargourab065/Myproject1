import p2.Principal ;
        import p3.Faculty ;
        import p4.Student ;

public class CollegeData {

    public static void main(String args[]) {

        Principal pp=new Principal() ;
        pp.time() ;
        pp.manage() ;

        Faculty ff=new Faculty() ;
        System.out.println("list of Faculty.") ;
        ff.showFacultyDetails(1211,"Kaustuv mallik") ;

        System.out.println("list of students .") ;
        Student ss=new Student(101,"gourav",564) ;
        ss.display() ;

    }
}