package model;

public class Client extends Person {
    private int vechimeAni;

    public Client(int id, String name, int age, String email, String password, int vechimeAni) {
        super(id, name, age, email, password, "client");
        this.vechimeAni = vechimeAni;
    }

    public Client(String text) {
        super(text);
        this.vechimeAni = Integer.parseInt(text.split(",")[6]);
    }

    public int getVechimeAni() {
        return vechimeAni;
    }

    public void setVechimeAni(int vechimeAni) {
        this.vechimeAni = vechimeAni;
    }

    @Override
    public String toString() {
        String text = super.toString() + '\n';
        text += "Ani Vechime: " + this.vechimeAni + "\n";
        return text;
    }

    @Override
    public String toSave() {
        String text = super.getId() + "," + super.getAge() + "," + super.getName() + "," + super.getPassword() + "," + this.vechimeAni;
        return text;
    }


}
