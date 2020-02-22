package JunctionX.HealthX;

public class Project {
    int id;
    String name;

    public Project(String safeString) {
        String[] inp = safeString.split(",");
        id = Integer.parseInt(inp[0]);
        name = inp[1];
    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getSafeString() {
        return id + "," + name + ";";
    }
}
