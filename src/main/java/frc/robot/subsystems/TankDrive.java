package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {
  private final SparkMax  leftFront;
  private final SparkMax leftBack;
  private final SparkMax rightFront;
  private final SparkMax rightBack;
  
  private final DifferentialDrive drive;

  public TankDrive() {
    // CAN IDs - change these numbers to match your robot's actual IDs
    leftFront = new SparkMax(1, MotorType.kBrushed);
    leftBack = new SparkMax(2, MotorType.kBrushed);
    rightFront = new SparkMax(3, MotorType.kBrushed);
    rightBack = new SparkMax(4, MotorType.kBrushed);
    
    // Invert right side so both sides drive forward together
    rightFront.setInverted(true);
    rightBack.setInverted(true);
    
    // Group the motors
    edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup leftMotors = 
      new edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup(leftFront, leftBack);
    edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup rightMotors = 
      new edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup(rightFront, rightBack);
    
    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
  
  public void stop() {
    drive.tankDrive(0, 0);
  }
}