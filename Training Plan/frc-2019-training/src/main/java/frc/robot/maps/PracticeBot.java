package frc.robot.maps;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotMap;

public class PracticeBot implements RobotMap {

    @Override
    public DriveMap getDriveMap() {
        return new DriveMap() {
            public SpeedController left() {
                return new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_TalonSRX(1));
            }

            @Override
            public SpeedController right() {
                return new SpeedControllerGroup(new WPI_TalonSRX(2), new WPI_TalonSRX(3));
            }
        };
    }

}