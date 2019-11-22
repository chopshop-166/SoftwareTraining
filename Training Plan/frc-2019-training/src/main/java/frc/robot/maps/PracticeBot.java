package frc.robot.maps;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import frc.robot.RobotMap;

public class PracticeBot implements RobotMap {

    @Override
    public DriveMap getDriveMap() {
        return new DriveMap() {
            @Override
            public SpeedController left() {
                return new SpeedControllerGroup(new WPI_TalonSRX(4), new WPI_VictorSPX(1));
            }

            @Override
            public SpeedController right() {
                return new SpeedControllerGroup(new WPI_TalonSRX(2), new WPI_TalonSRX(3));
            }
        };
    }

}