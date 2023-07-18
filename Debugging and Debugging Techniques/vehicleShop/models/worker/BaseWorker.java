package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseWorker implements Worker {
    //описание на всеки един работник
    private String name; //име на работник
    private int strength; //сила на работник
    private Collection<Tool> tools; //списък с инструменти на работника

    //конструктор
    public BaseWorker(String name, int strength) {
        //нов празен обект
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }
    @Override
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return tools;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }

    @Override
    public void working() {
        int currentStrength = getStrength(); //текущата сила на рабоника
        int decreasedStrength = currentStrength - 10;
        if (decreasedStrength < 0) {
            decreasedStrength = 0;
        }
        setStrength(decreasedStrength);
    }

    @Override
    public void addTool(Tool tool) {
        this.getTools().add(tool);
    }

    @Override
    public boolean canWork() {
        return this.getStrength() > 0;
    }

    @Override
    public String toString() {
        long leftTools = this.tools.stream().filter(tool -> tool.getPower() > 0).count();
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + ", Strength: " + strength).append(System.lineSeparator());
        sb.append("Tools: " + leftTools + " fit left").append(System.lineSeparator());
        return sb.toString().trim();
    }
}
