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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
     public abstract String toSave();

}
