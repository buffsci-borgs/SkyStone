package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@Autonomous(name="AutoRight", group = "Red Player")
public class AutonomousDrive extends LinearOpMode {

    Servo armServo,
            capstoneServo;

    public DcMotor lfMotor,
            lbMotor,
            rfMotor,
            rbMotor,
            gearTrackMotor,
            leadScrewMotor,
            capstoneMotor,
            foundationMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        lfMotor = hardwareMap.get(DcMotor.class, "frontLeft"); //0
        lbMotor = hardwareMap.get(DcMotor.class, "backLeft");  // 2
        rfMotor = hardwareMap.get(DcMotor.class, "frontRight");  //1
        rbMotor = hardwareMap.get(DcMotor.class, "backRight");  // 3

        rfMotor.setDirection(DcMotor.Direction.FORWARD);
        rbMotor.setDirection(DcMotor.Direction.FORWARD);
        lfMotor.setDirection(DcMotor.Direction.REVERSE);
        lbMotor.setDirection(DcMotor.Direction.REVERSE);

        gearTrackMotor = hardwareMap.get(DcMotor.class, "gearTrackMotor");
        leadScrewMotor = hardwareMap.get(DcMotor.class, "leadScrewMotor");
        capstoneMotor = hardwareMap.get(DcMotor.class, "capstoneMotor");
        foundationMotor = hardwareMap.get(DcMotor.class, "foundationMotor");


        armServo = hardwareMap.servo.get("arm_servo");
        capstoneServo = hardwareMap.servo.get("capstoneServo");

        armServo.setPosition(1);
        capstoneServo.setPosition(0);

        //wait until play button is pressed
        waitForStart();


        driveRight(1, 2500);

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
