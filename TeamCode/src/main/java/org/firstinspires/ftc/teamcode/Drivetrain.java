package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain extends Hardware{

    private final DcMotor center;
    private final DcMotor backRight;
    private final DcMotor backLeft;

    public Drivetrain(HardwareMap map, Telemetry telemetry) {
        super(telemetry, map);

        center = loadMotor("center", DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight = loadMotor("back_right", DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft = loadMotor("back_left", DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void powerDriveTrain(double centerPower, double backRightPower, double backLeftPower){
        this.center.setPower(centerPower);
        this.backRight.setPower(backRightPower);
        this.backLeft.setPower(backLeftPower);

        telemetry.addLine("Drive Power: ");
        telemetry.addLine(String.format("[left=%f,right=%f,center=%f]",
                backLeftPower, backRightPower, centerPower));
    }


}
