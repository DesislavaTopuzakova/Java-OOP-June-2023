package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle {
    //описание на превозно средство
    private String name; //име на превозното средство
    private int strengthRequired; //нужна сила от работника

    //конструктор

    public VehicleImpl(String name, int strengthRequired) {
        //нов празен обект
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getStrengthRequired() {
        return strengthRequired;
    }

    public void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.getStrengthRequired() == 0;
    }

    @Override
    public void making() {
        int currentNeedStrength = getStrengthRequired();
        currentNeedStrength -= 5;
        if (currentNeedStrength < 0) {
            currentNeedStrength = 0;
        }
        this.setStrengthRequired(currentNeedStrength);
    }
}
