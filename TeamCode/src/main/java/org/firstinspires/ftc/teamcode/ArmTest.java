package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.hardware.Arm;

@TeleOp(name = "Servo Test 10-26-18")
public class ArmTest extends LinearOpMode {

    private Arm arm;

    @Override
    public void runOpMode() {
        initRobot();
        telemetry.addLine("Done initializing...");
        telemetry.update();
        waitForStart();
        runLoop();
    }

    private void runLoop(){
        arm.setArmServoPosition(.38);

        while (opModeIsActive()){
            double left = gamepad1.left_stick_y;
            double right = gamepad1.right_stick_y;
            arm.setIntakeSpeed(left, right);

            if(gamepad1.dpad_up)
                arm.changePosition(.01);
            else if(gamepad1.dpad_down)
                arm.changePosition(-.01);

            telemetry.addLine("Servo Pos: " + arm.getArmServoPosition());
            telemetry.addLine("Drive Left: " + left);
            telemetry.addLine("Drive Right: " + right);
            telemetry.update();
        }
    }

    private void initRobot() {
        arm = new Arm(telemetry, hardwareMap);
    }
}
