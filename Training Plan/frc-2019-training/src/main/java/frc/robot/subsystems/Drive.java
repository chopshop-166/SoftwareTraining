/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drive extends SubsystemBase {

    private final SpeedController rightMotorGroup;
    private final SpeedController leftMotorGroup;
    private final DifferentialDrive driveTrain;
    final static int NUM_SAMPLES = 10;
    double speedInput[] = new double[NUM_SAMPLES];
    int i = 0;

    public Drive(RobotMap.DriveMap map) {
        super();
        rightMotorGroup = map.right();
        leftMotorGroup = map.left();
        driveTrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

        setDefaultCommand(demoDrive());
    }

    double deadband(double input) {
        if (0.2 > input && input > -0.2) {
            input = 0;
        }
        return input;
    }

    double calcAvg(double input[]) {
        double sum = 0;
        for (double j : input) {
            sum += j;
        }
        return sum / input.length;
    }

    // demoDrive() 
    // Should take the same input from the driver
    // Scale the input by 1/2 

    public CommandBase demoDrive() {
        return new RunCommand(() -> {
            double yAxis = Robot.driveController.getTriggerAxis(Hand.kRight)
                    - Robot.driveController.getTriggerAxis(Hand.kLeft);
            double xAxis = Robot.driveController.getX(Hand.kLeft);
            yAxis /= 2;
            xAxis /= 2;
            driveTrain.arcadeDrive(yAxis, xAxis);
        }, this);
    }

    public CommandBase drive() {
        return new RunCommand(() -> {

            // This code gets the value from the two triggers and a joystick
            // The right trigger controls forward speed, the left trigger controls backward
            // speed
            // The left trigger is subtracted from the right to allow us to move backwards
            double yAxis = Robot.driveController.getTriggerAxis(Hand.kRight)
                    - Robot.driveController.getTriggerAxis(Hand.kLeft);
            if (i == NUM_SAMPLES) {
                i = 0;
            }

            // initialize()
            // execute()
            // isFinished()
            // end()

            speedInput[i] = yAxis;

            double sum = 0;
            for (double j : speedInput) {
                sum += j;
            }
            double avg = sum / NUM_SAMPLES;

            avg = deadband(avg);
            double x = deadband(Robot.driveController.getX(Hand.kLeft));
            i++;
            driveTrain.arcadeDrive(avg, x);
        }, this);
    }
}
