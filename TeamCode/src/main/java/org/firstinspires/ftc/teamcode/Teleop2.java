package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Drive OP", group="Iterative OpMode")
public class Teleop2 extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();

    Servo capstoneServo, armServo, hookServoLeft, hookServoRight;
    public DcMotor lfMotor, lbMotor, rfMotor, rbMotor, gearTrackMotor, leadScrewMotor,
                            capstoneMotor;


    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        lfMotor = hardwareMap.get(DcMotor.class, "frontLeft"); //0
        rfMotor = hardwareMap.get(DcMotor.class, "frontRight");  //1
        lbMotor = hardwareMap.get(DcMotor.class, "backLeft");  // 2
        rbMotor = hardwareMap.get(DcMotor.class, "backRight");  // 3

        gearTrackMotor = hardwareMap.get(DcMotor.class, "gearTrackMotor");
        leadScrewMotor = hardwareMap.get(DcMotor.class, "leadScrewMotor");
        capstoneMotor = hardwareMap.get(DcMotor.class, "capstoneMotor");


        leadScrewMotor.setDirection(DcMotor.Direction.REVERSE);

        rfMotor.setDirection(DcMotor.Direction.REVERSE);
        rbMotor.setDirection(DcMotor.Direction.REVERSE);


        //Initializing servos       names are from Controller app
        armServo = hardwareMap.servo.get("arm_servo");
        capstoneServo = hardwareMap.servo.get("capstoneServo");
        hookServoLeft = hardwareMap.servo.get("hookServoLeft");
        hookServoRight = hardwareMap.servo.get("hookServoRight");


        armServo.setPosition(1);
        capstoneServo.setPosition(0);
        hookServoLeft.setPosition(0);
        hookServoRight.setPosition(.40);
    }

    @Override
    public void start() {
        runtime.reset();
    }


    @Override
    public void loop() {

        telemetry.addData("Right Trigger", gamepad1.right_trigger);
        telemetry.addData("Left Trigger", gamepad1.left_trigger);
        telemetry.addData("Status", "Run Time: " + runtime.toString());
        telemetry.update();

      //  foundationMotor.setPower(gamepad2.right_trigger);
       // foundationMotor.setPower(-gamepad2.left_trigger);

        if(gamepad1.a) {
            hookServoRight.setPosition(0);  //0--> close .40-->open
            hookServoLeft.setPosition(1);   //1-->close 0-->open
        }
        if(gamepad1.b){
            hookServoRight.setPosition(.40);
            hookServoLeft.setPosition(0);
        }

        //Setting powers for leadScrewMotor, gearTrackMotor
        leadScrewMotor.setPower(gamepad2.right_stick_y);

        gearTrackMotor.setPower(0.75*gamepad2.left_stick_y);
        //capstone motor
        if(gamepad2.dpad_up) capstoneMotor.setPower(0.35);
        else if(gamepad2.dpad_down) capstoneMotor.setPower(-.35);
        else capstoneMotor.setPower(0);

        if(gamepad2.a){
            capstoneServo.setPosition(0);
        }
        //This is release point
        if(gamepad2.x){
            capstoneServo.setPosition(0.75);
        }

        if(gamepad2.right_bumper){
            armServo.setPosition(1);
        }
        //This is release point
        if(gamepad2.left_bumper){
            armServo.setPosition(.25);
        }




        if(gamepad1.left_trigger>0){
            lbMotor.setPower(gamepad1.left_trigger);
            rfMotor.setPower(gamepad1.left_trigger);
            lfMotor.setPower(-gamepad1.left_trigger);
            rbMotor.setPower(-gamepad1.left_trigger);
        } else if(gamepad1.right_trigger>0){
            lfMotor.setPower(gamepad1.right_trigger);
            rbMotor.setPower(gamepad1.right_trigger);
            lbMotor.setPower(-gamepad1.right_trigger);
            rfMotor.setPower(-gamepad1.right_trigger);
        } else{
            lfMotor.setPower(-gamepad1.left_stick_y);
            lbMotor.setPower(-gamepad1.left_stick_y);
            rfMotor.setPower(-gamepad1.right_stick_y);
            rbMotor.setPower(-gamepad1.right_stick_y);
        }



    }

    /*
     * Code to run ONCE after the driver hits STOP
     */

    @Override
    public void stop(){
        lfMotor.setPower(0);
        lbMotor.setPower(0);
        rbMotor.setPower(0);
        rfMotor.setPower(0);
    }
}
