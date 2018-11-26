package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Drivetrain extends Hardware{

    private final DcMotor right;
    private final DcMotor left;

    public Drivetrain(HardwareMap map, Telemetry telemetry) {
        super(telemetry, map);

        right = loadMotor("left", DcMotor.RunMode.RUN_USING_ENCODER);
        left = loadMotor("right", DcMotor.RunMode.RUN_USING_ENCODER);
        right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public int getLeftEncoderPosition(){
        return this.left.getCurrentPosition();
    }

    public int getRightEncoderPosition(){
        return this.right.getCurrentPosition();
    }

    public void powerDriveTrain(double left, double right){
        this.left.setPower(left);
        this.right.setPower(right);

        telemetry.addLine("Drive Power: " +
                String.format("[left=%1.2f,right=%1.2f]", left, right));
        telemetry.addLine("LeftPos=" + this.left.getCurrentPosition());
        telemetry.addLine("RightPos=" + this.right.getCurrentPosition());
    }
}
