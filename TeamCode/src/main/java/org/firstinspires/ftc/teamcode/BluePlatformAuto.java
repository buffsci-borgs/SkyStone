package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="Blue Platform Auto", group = "Blue Player")
public class BluePlatformAuto extends LinearOpMode {

    Servo capstoneServo, armServo, hookServoLeft, hookServoRight;

    public DcMotor lfMotor,
            lbMotor,
            rfMotor,
            rbMotor,
            gearTrackMotor,
            leadScrewMotor,
            capstoneMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        lfMotor = hardwareMap.get(DcMotor.class, "frontLeft"); //0
        lbMotor = hardwareMap.get(DcMotor.class, "backLeft");  // 2
        rfMotor = hardwareMap.get(DcMotor.class, "frontRight");  //1
        rbMotor = hardwareMap.get(DcMotor.class, "backRight");  // 3

        rfMotor.setDirection(DcMotor.Direction.REVERSE);
        rbMotor.setDirection(DcMotor.Direction.REVERSE);
        lfMotor.setDirection(DcMotor.Direction.FORWARD);
        lbMotor.setDirection(DcMotor.Direction.FORWARD);

        gearTrackMotor = hardwareMap.get(DcMotor.class, "gearTrackMotor");
        leadScrewMotor = hardwareMap.get(DcMotor.class, "leadScrewMotor");
        capstoneMotor = hardwareMap.get(DcMotor.class, "capstoneMotor");


        armServo = hardwareMap.servo.get("arm_servo");
        capstoneServo = hardwareMap.servo.get("capstoneServo");
        hookServoLeft = hardwareMap.servo.get("hookServoLeft");
        hookServoRight = hardwareMap.servo.get("hookServoRight");

        armServo.setPosition(1);
        capstoneServo.setPosition(0);
        hookServoLeft.setPosition(0);
        hookServoRight.setPosition(.40);

        //wait until play button is pressed
        waitForStart();


        driveForward(.75, 500);
        driveLeft(.75, 750);
        driveForward(.50, 500);
        sleep(1000);
        hookClose();
        driveBackward(.5, 2750);
        hookOpen();
        driveRight(.8, 3500);
    }

    public void hookClose(){
        hookServoRight.setPosition(0);  //0--> close .40-->open
        hookServoLeft.setPosition(1);   //1-->close 0-->open
        sleep(1000);
    }
    public void hookOpen(){
        hookServoRight.setPosition(0.40);  //0--> close .40-->open
        hookServoLeft.setPosition(0);   //1-->close 0-->open
        sleep(1000);
    }
    //base drive
    public void driveForward(double power, int milliseconds){
        lfMotor.setPower(power);
        rfMotor.setPower(power);
        lbMotor.setPower(power);
        rbMotor.setPower(power);
        sleep(milliseconds);
    }

    //base drive
    public void driveBackward(double power, int milliseconds){
        lfMotor.setPower(-power);
        rfMotor.setPower(-power);
        lbMotor.setPower(-power);
        rbMotor.setPower(-power);
        sleep(milliseconds);
    }

    //base drive
    public void turnLeft(double power, int milliseconds){
        lfMotor.setPower(-power);
        rfMotor.setPower(power);
        lbMotor.setPower(-power);
        rbMotor.setPower(power);
        sleep(milliseconds);
        stopDriving();
    }

    //base drive
    public void turnRight(double power, int milliseconds){
        lfMotor.setPower(power);
        rfMotor.setPower(-power);
        lbMotor.setPower(power);
        rbMotor.setPower(-power);
        sleep(milliseconds);
        stopDriving();
    }

    //base drive
    public void driveLeft(double power, int milliseconds){
        lbMotor.setPower(power);
        rfMotor.setPower(power);
        lfMotor.setPower(-power);
        rbMotor.setPower(-power);
        sleep(milliseconds);
        stopDriving();
    }

    //base drive
    public void driveRight(double power, int milliseconds){
        lbMotor.setPower(-power);
        rfMotor.setPower(-power);
        lfMotor.setPower(power);
        rbMotor.setPower(power);
        sleep(milliseconds);
        stopDriving();
    }

    //base drive
    public void stopDriving(){
        lfMotor.setPower(0);
        rfMotor.setPower(0);
        lbMotor.setPower(0);
        rbMotor.setPower(0);
    }


}
