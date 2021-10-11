public class Project {
    private static String defaultDesc = "Default";
    private String name;
    private String  description;
    private static String defaultName = "Default Name";

public String elevatorPitch(){
    return String.format("%s", name, description);
}
    public Project(){
        this.description = defaultDesc;
        this.name = defaultName;
    }

    public Project(String name){
        this.name = name;
        this.description = defaultDesc;
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }
}
