
package fractal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;


class Fractal extends JPanel {

    
    double xp1 = 200, yp1 = 50;  
    double xp2 = 50, yp2 = 300;   
    double xp3 = 350, yp3 = 300;  

    double sin60 = Math.sin(Math.PI / 3);

    int nivel_de_recursividad = 5;
