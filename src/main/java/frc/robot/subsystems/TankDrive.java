package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TankDrive extends SubsystemBase {
  private final WPI_VictorSPX leftFront;
  private final WPI_TalonSRX leftBack;
  private final WPI_VictorSPX rightFront;
  private final WPI_VictorSPX rightBack;
  private final DifferentialDrive drive;

  public TankDrive() {
    leftFront = new WPI_VictorSPX(Constants.LEFT_FRONT_ID);
    leftBack = new WPI_TalonSRX(Constants.LEFT_BACK_ID);
    rightFront = new WPI_VictorSPX(Constants.RIGHT_FRONT_ID);
    rightBack = new WPI_VictorSPX(Constants.RIGHT_BACK_ID);

    rightFront.setInverted(true);
    rightBack.setInverted(true);

    @SuppressWarnings("removal")
    MotorControllerGroup leftMotors = new MotorControllerGroup(leftFront, leftBack);
    @SuppressWarnings("removal")
    MotorControllerGroup rightMotors = new MotorControllerGroup(rightFront, rightBack);

    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void stop() {
    drive.tankDrive(0, 0);
  }

  @Override
  public void periodic() {}
}