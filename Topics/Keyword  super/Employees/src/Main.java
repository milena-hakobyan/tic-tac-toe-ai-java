class Employee {
    String name;
    String email;
    int experience;
    // write fields

    // write constructor
    Employee(String name, String email, int experience){
        this.name = name;
        this.email = email;
        this.experience = experience;
    }
    // write getters
    public String getName(){ return this.name;}
    public String getEmail(){ return this.email;}
    public int getExperience(){ return this.experience;}
}

class Developer extends Employee {
    String mainLang;
    String[] skills;
    // write fields
    Developer(String name, String email, int experience,
              String mainLang, String[] skills){
        super(name, email, experience);
        this.mainLang = mainLang;
        this.skills = skills;
    }
    // write constructor

    public String getMainLanguage(){return this.mainLang;}
    public String[] getSkills(){return this.skills;}
}

class DataAnalyst extends Employee {
    boolean isPhd;
    String[] methods;

    DataAnalyst(String name, String email, int experience,
                boolean isPhd, String[] methods) {
        super(name, email, experience);
        this.isPhd = isPhd;
        this.methods = methods;
    }
    // write fields

    // write constructor
    public boolean isPhd(){return this.isPhd;}
    public String[] getMethods(){return this.methods;}
    // write getters
}