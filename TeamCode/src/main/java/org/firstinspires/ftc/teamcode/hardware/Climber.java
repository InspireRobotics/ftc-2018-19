package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Climber extends Hardware {

    private final DcMotor motor;

    public Climber(HardwareMap map, Telemetry telemetry) {
        super(telemetry, map);

        motor = loadMotor("climb", DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setPower(double amount){
        telemetry.addLine("Climber: " + amount);
        motor.setPower(amount);
    }

}
