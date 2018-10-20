package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Drive Test 10-20-18")
public class DriveTest extends LinearOpMode {

    private Drivetrain drivetrain;

    @Override
    public void runOpMode()  {
        initRobot();
        waitForStart();

        runLoop();
    }

    public void initRobot(){
        drivetrain = new Drivetrain(hardwareMap, telemetry);
        telemetry.addLine("Robot initialized!");
        telemetry.addLine("Waiting for start!");
        telemetry.update();
    }

    public void runLoop(){
        while(opModeIsActive()){
            double left = gamepad1.left_stick_y;
            double right = gamepad1.right_stick_y;

            if((Math.signum(left) == Math.signum(right) )|| left == 0.0 || right == 0.0){
                drivetrain.powerDriveTrain((left + right) / 2, right, left);
            }else{
                drivetrain.powerDriveTrain(0, right, left);
            }

            telemetry.update();
        }
    }

    // [public] [return] [name](){
    //
    // }


}

