package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Hardware {

    protected final Telemetry telemetry;
    private final HardwareMap hardware;

    public Hardware(Telemetry telemetry, HardwareMap hardware) {
        this.telemetry = telemetry;
        this.hardware = hardware;
    }

    protected DcMotor loadMotor(String name, DcMotor.RunMode mode){
        DcMotor motor = hardware.get(DcMotor.class, name);

        if(motor == null){
            telemetry.addLine("Error: Failed to load motor with name " + name);
            return null;
        }

        motor.setMode(mode);

        return motor;
    }

}
