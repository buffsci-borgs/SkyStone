
        driveLeft(1,2500);
        sleep(1000);
        foundationMotor.setPower(-1);
        sleep(500);
        driveRight(1, 3000);

        foundationMotor.setPower(1);
        sleep(500);

        driveForward(1,2000);
        turnLeft(1, 1000);


//Auto Red
driveBackward(1, 5000);
        driveLeft(1, 3000);
        driveForward(1, 2600);
        driveRight(1, 4000);


//Auto Blue
        driveBackward(1, 5000);
        driveRight(1, 3000);
        driveForward(1, 2600);
        driveLeft(1, 4000);
