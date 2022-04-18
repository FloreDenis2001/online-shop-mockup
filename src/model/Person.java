package model;

public abstract class Person {
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
    private String type;



    public Person(int id,String name, int age, String email,String password,String type) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.password=password;
        this.type=type;

    }

    public Person(String text){
        String [] path = text.split(",");
        this.id=Integer.parseInt(path[0]);
        this.name=path[1];
        this.age=Integer.parseInt(path[2]);
        this.email=path[3];
        this.password=path[4];
        this.type=path[5];
    }
    public String toString(){
        String text="ID: "+this.id+"\n";
        text+="Name : "+this.name+"\n";
        text+="Varsta : "+this.age+"\n";
        text+="Email : "+this.email+"\n";
        text+="Password : "+this.password+"\n";
        text+="Type : "+this.type+"\n";
        return text;
    }


}
