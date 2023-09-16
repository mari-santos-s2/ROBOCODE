package mari_robo;
import robocode.*;
import java.awt.Color;

/**
 * Mari - a class by (Mari_robo)
 */
public class Mari_robo extends Robot{

public void run() {
        // Defina as cores do robô
        setColors(Color.yellow, Color.white, Color.green);

        // Loop principal do robô
        while (true) {
            ahead(100); // Avança 100 pixels
            turnRight(90); // Gira 90 graus à direita
        }
    }

    public void onScannedRobot(ScannedRobotEvent event) {
        // Quando um robô é detectado, miramos nele
        turnGunRight(getHeading() - getGunHeading() + event.getBearing());

        // Atiramos com potência máxima
        fire(3);
    }

    public void onHitByBullet(HitByBulletEvent event) {
        // Quando atingido por uma bala, tentamos escapar
        turnLeft(90 - event.getBearing());
    }
    
    public void onHitWall(HitWallEvent event) {
        // Quando atingimos uma parede, giramos 180 graus para tentar sair
        turnRight(180);
    }
}