/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * The RobotMap is an interface that contains the instructions on how to make a
 * particular robot. This is useful for situations of practice robot vs real
 * robot, where port numbers might differ.
 */
public interface RobotMap {

    public interface DriveMap {
        public SpeedController left();
        public SpeedController right();
    }

    public DriveMap getDriveMap();
}
