
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        paintRecursivo(g, nivel_de_recursividad, xp1, yp1, xp2, yp2); // Lado 1
        paintRecursivo(g, nivel_de_recursividad, xp2, yp2, xp3, yp3); // Lado 2
        paintRecursivo(g, nivel_de_recursividad, xp3, yp3, xp1, yp1); // Lado 3
    }

    private void paintRecursivo(Graphics g, int i, double xp12, double yp12, double xp22, double yp22) {
     
        double dx = (xp22 - xp12) / 3.0;
        double dy = (yp22 - yp12) / 3.0;

        double xx = xp12 + 1.5 * dx - dy * sin60;
        double yy = yp12 + 1.5 * dy + dx * sin60;

        if (i <= 0) {
        
            g.drawLine((int) xp12, (int) yp12, (int) xp22, (int) yp22);
        } else {
         
            paintRecursivo(g, i - 1, xp12, yp12, xp12 + dx, yp12 + dy);  
            paintRecursivo(g, i - 1, xp12 + dx, yp12 + dy, xx, yy);      
            paintRecursivo(g, i - 1, xx, yy, xp22 - dx, yp22 - dy);      
            paintRecursivo(g, i - 1, xp22 - dx, yp22 - dy, xp22, yp22);  
        }
    }

    
    public static void main(String[] args) {
       
        JFrame frame = new JFrame("Copo de Nieve de Koch");
        Fractal panel = new Fractal();

       
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); 
        frame.setVisible(true); 
    }
}
