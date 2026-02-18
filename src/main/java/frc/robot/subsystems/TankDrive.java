package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {
  private final WPI_VictorSPX  leftFront;
  private final WPI_TalonSRX leftBack;
  private final WPI_VictorSPX rightFront;
  private final WPI_VictorSPX rightBack;

  
  private final DifferentialDrive drive;

  public TankDrive() {
    // CAN IDs - change these numbers to match your robot's actual IDs
    leftFront = new WPI_VictorSPX(1);
    leftBack = new WPI_TalonSRX(6);
    rightFront = new WPI_VictorSPX(4);
    rightBack = new WPI_VictorSPX(2);
    
    // Invert right side so both sides drive forward together
    rightFront.setInverted(true);
    rightBack.setInverted(true);
    
    // Group the motors
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
}