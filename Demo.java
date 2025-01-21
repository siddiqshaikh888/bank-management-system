class Student{
    String name;
    int id;

    public void Print(){
        System.out.println(this.id);
        System.out.println(this.name);
    }
    Student(String name, int id){
        this.name=name;
        this.id=id;
    }
}
class Demo{
    public static void main(String[] args) {
       Student s1 = new Student("Siddiq",274);
       s1.Print();
    }
}