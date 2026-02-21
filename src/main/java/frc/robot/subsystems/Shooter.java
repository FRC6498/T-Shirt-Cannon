package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  private final WPI_VictorSPX valve;
  private final WPI_TalonSRX armMotor;

  public Shooter() {
    valve = new WPI_VictorSPX(Constants.VALVE_PWM_PORT);
    armMotor = new WPI_TalonSRX(Constants.ARMMOTOR_PWM_PORT);
    armMotor.setNeutralMode(NeutralMode.Brake);

  }

  public Command up(double speed) {
    return runEnd(() -> armMotor.set(speed),
    ()-> armMotor.set(0));
  }

  public Command fire(double outputVolts) {
   return startEnd(() -> valve.setVoltage(outputVolts), ()-> valve.setVoltage(0));  // full open
  }

  public Command closeValve() {
    return runOnce(() -> valve.setVoltage(0.0));  // closed
  }

  public boolean isValveOpen() {
    return valve.get() > 0;
  }

  @Override
  public void periodic() {}
}