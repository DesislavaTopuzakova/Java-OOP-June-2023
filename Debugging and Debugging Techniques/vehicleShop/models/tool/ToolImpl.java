package vehicleShop.models.tool;

import vehicleShop.common.ExceptionMessages;

public class ToolImpl implements Tool {
    //описание на инструмент
    private int power;

    public ToolImpl(int power) {
        //нов празен
        this.setPower(power);
    }

    @Override
    public int getPower() {
        return power;
    }

    @Override
    public void decreasesPower() {
        int currentPower = getPower();
        int decreasedPower = currentPower - 5;
        if (decreasedPower < 0) {
            decreasedPower = 0;
        }
        this.setPower(decreasedPower);
    }

    @Override
    public boolean isUnfit() {
        return this.getPower() > 0;
    }

    public void setPower(int power) {
        if (power < 0) {
            throw new IllegalArgumentException(ExceptionMessages.TOOL_POWER_LESS_THAN_ZERO);
        }
        this.power = power;
    }
}
