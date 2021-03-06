/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Drive extends SubsystemBase {

    private final SpeedControllerGroup rightMotorGroup;
    private final SpeedControllerGroup leftMotorGroup;
    private final DifferentialDrive driveTrain;

    public Drive() {
        super();
        rightMotorGroup = new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(1));
        leftMotorGroup = new SpeedControllerGroup(new WPI_TalonSRX(2), new WPI_TalonSRX(3));
        driveTrain = new DifferentialDrive(leftMotorGroup, rightMotorGroup);

        setDefaultCommand(drive());
    }

    public CommandBase drive() {
        return new RunCommand(() -> {
        }, this);
    }
}
