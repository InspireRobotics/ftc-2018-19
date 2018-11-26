package org.firstinspires.ftc.teamcode.hardware;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.GyroBoi;

@Autonomous(name = "11-16-18 Gyro Test")
public class PrintGyro extends LinearOpMode {

    private GyroBoi gyro;

    public void runOpMode()  {
        initRobot();
        waitForStart();
        runMainLoop();
    }

    public void initRobot(){
        gyro = new GyroBoi(hardwareMap, telemetry);
        telemetry.update();
    }

    public void runMainLoop(){
        while (opModeIsActive()) {
            gyro.update();
            telemetry.addLine("Gyro Angle: " + gyro.getAngle());
            telemetry.update();
        }
    }
}
