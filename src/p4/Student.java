package p4 ;

public class Student {

    public int id ;
    public String name ;
    public double mark ;

    public Student (int id,String name,double mark) {
        this.id=id ;
        this.name=name ;
        this.mark= mark ;
    }

    public void display () {

        System.out.println("Name : "+name+"Id : "+id+"Mark : "+mark) ;
    }
}