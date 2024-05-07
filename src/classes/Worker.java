package classes;

public class Worker {
    private String name;
    private TypeWorker type;

    public Worker(String name, TypeWorker type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public TypeWorker getType() {
        return type;
    }
    
    
}