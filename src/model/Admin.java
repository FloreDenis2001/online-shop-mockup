package model;

public class Admin extends Person {
    private String roles;

    public Admin (int id,String name, int age, String email,String password,String roles) {

        super(id,name,age,email,password,"admin");

        this.roles=roles;
    }


    public Admin(String text){

        super(text);

        this.roles=text.split(",")[6];
    }
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        String text = super.toString()+'\n';
        text+="Role : "+this.roles+"\n";
        return text;
    }

    public String toSave() {
        String text = super.getId() + "," + super.getAge() + "," + super.getName() + "," + super.getPassword() + "," +super.getType()+","+this.roles;
        return text;
    }
}
